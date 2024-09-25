package online_store_project.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online_store_project.dao.UserDao;
import online_store_project.dto.CreateUserDto;
import online_store_project.dto.ReadUserDto;
import online_store_project.dto.UpdateUserDto;
import online_store_project.entity.User;
import online_store_project.exception.ValidationException;
import online_store_project.mapper.CreateUserDtoMapper;
import online_store_project.mapper.ReadUserDtoMapper;
import online_store_project.mapper.UpdateUserDtoMapper;
import online_store_project.validator.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService USER_SERVICE = new UserService();
    private static final CreateUserValidator CREATE_USER_VALIDATOR = CreateUserValidator.getINSTANCE();
    private static final CreateUserDtoMapper CREATE_USER_DTO_MAPPER = CreateUserDtoMapper.getUSER_DTO_MAPPER();
    private static final ReadUserDtoMapper READ_USER_DTO_MAPPER = ReadUserDtoMapper.getINSTANCE();
    private static final UpdateUserValidator UPDATE_USER_DTO_VALIDATOR = UpdateUserValidator.getUPDATE_USER_VALIDATOR();
    private static final UpdateUserDtoMapper UPDATE_USER_DTO_MAPPER = UpdateUserDtoMapper.getMAPPER();
    private static final UserDao USER_DAO = UserDao.getInstance();
    private static final OrderService ORDER_SERVICE = OrderService.getINSTANCE();
    private static final OrdersProductsService ORDERS_PRODUCTS_SERVICE = OrdersProductsService.getINSTANCE();
    private static final ProductService PRODUCT_SERVICE = ProductService.getINSTANCE();
    private static List<Integer> productIds = new ArrayList<>();

    public static UserService getInstance() {
        return USER_SERVICE;
    }

    public static void changeBlackList(int userId, boolean blacklisted) {
        USER_DAO.updateBlackList(userId, blacklisted);
    }

    public Integer createUser(CreateUserDto createUserDto){
        ValidatorResult validatorResult = CREATE_USER_VALIDATOR.isDataValid(createUserDto);
        if(!validatorResult.isValid()){
            throw new ValidationException(validatorResult.getErrors());
        }

        User userEntity = CREATE_USER_DTO_MAPPER.map(createUserDto);
        USER_DAO.save(userEntity);

        return userEntity.getId();
    }

    public Optional<ReadUserDto> findUser(String email, String password) {
        Optional<User> user = USER_DAO.findUserByEmailAndPassword(email, password);
        if(user.isPresent()){
           return user.map(READ_USER_DTO_MAPPER::map);
       }
        else{
            return Optional.empty();
        }

    }

    public Integer changeUserData(UpdateUserDto updateUserDto) {
        ValidatorResult validatorResult = UPDATE_USER_DTO_VALIDATOR.isDataValid(updateUserDto);
        if(!validatorResult.isValid()){
            throw new ValidationException(validatorResult.getErrors());
        }

        User userEntity = UPDATE_USER_DTO_MAPPER.map(updateUserDto);
        try {
            User user = USER_DAO.updateUser(userEntity);
            return user.getId();
        }
        catch (Exception ex){
            return 0;
        }
    }

    public Optional<ReadUserDto> paymentForTheOrder(String total, int usersId, Map<String,String[]> productMap) {
        Integer totalPrice = Integer.parseInt(total.replace(" ₽", ""));

        int checkBalance = USER_DAO.checkBalance(totalPrice, usersId);
        int checkStock = productCheckStock(productMap);

        if(checkBalance>0 && checkStock>0){

            int totalStock = productChangeStock(productMap);
            Optional<User> user = USER_DAO.payment(totalPrice, usersId);
            Integer orderId = ORDER_SERVICE.saveNewOrder(usersId,totalPrice,totalStock);

            productIds.stream().forEach((productId)->ORDERS_PRODUCTS_SERVICE.addOrdersProducts(productId,orderId));
            productIds.clear();

            return Optional.of(READ_USER_DTO_MAPPER.map(user.get()));
            }

            return Optional.empty();
    }

    private int productChangeStock(Map<String,String[]> productMap) {

        int totalStock = 0;
        for (Map.Entry<String, String[]> entry : productMap.entrySet()) {

            if(!entry.getKey().equals("totalPrice")){
                Integer productId = Integer.parseInt(entry.getKey().replace("count", ""));
                Integer quantity = Integer.parseInt(entry.getValue()[0]);

                totalStock += quantity;
                productIds.add(productId);
                PRODUCT_SERVICE.changeStock(productId, quantity);
            }
    }
        return totalStock;
    }

    private static int productCheckStock(Map<String, String[]> productMap) {
        for (Map.Entry<String, String[]> entry : productMap.entrySet()) {
            if (!entry.getKey().equals("totalPrice")) {
                Integer productId = Integer.parseInt(entry.getKey().replace("count", ""));
                Integer quantity = Integer.parseInt(entry.getValue()[0]);

                int result = PRODUCT_SERVICE.checkStock(productId, quantity);

                if(result == 0){
                    return 0;
                }
            }
        }
        return 1;
    }

    public Optional<ReadUserDto> replenishBalance(String amount, int userId) {
        return USER_DAO.replenishBalance(amount, userId).map(READ_USER_DTO_MAPPER::map);
    }

    public Optional<ReadUserDto> findUserById(int userId) {
        return USER_DAO.find(userId).map(READ_USER_DTO_MAPPER::map);
    }

    public List<ReadUserDto> findAllUsers() {
        return USER_DAO.findAll().stream().map(READ_USER_DTO_MAPPER::map).collect(Collectors.toList());
    }
}

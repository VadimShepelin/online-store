package online_store_project.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dao.OrderDao;
import online_store_project.dto.CreateOrderDto;
import online_store_project.dto.ReadOrderDto;
import online_store_project.entity.Order;
import online_store_project.mapper.CreateOrderDtoMapper;
import online_store_project.mapper.ReadOrderDtoMapper;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderService {

    @Getter
    private static final OrderService INSTANCE = new OrderService();
    private static final LocalDate ORDER_DATE = LocalDate.now();
    private static final CreateOrderDtoMapper CREATE_ORDER_DTO_MAPPER = CreateOrderDtoMapper.getINSTANCE();
    private static final ReadOrderDtoMapper READ_ORDER_DTO_MAPPER = ReadOrderDtoMapper.getINSTANCE();
    private static final OrderDao ORDER_DAO = OrderDao.getINSTANCE();

    public Integer saveNewOrder(int userId, int totalPrice, int totalStock){
        CreateOrderDto orderDto = createOrderDtoBuilder(userId,totalPrice,totalStock);
        Order entity = CREATE_ORDER_DTO_MAPPER.map(orderDto);

        Optional<Order> order = ORDER_DAO.addOrder(entity);
        return order.map(Order::getOrders_id).orElse(0);

    }


    public List<ReadOrderDto> findOrders(int userId) {
        List<Order> orders = ORDER_DAO.getOrders(userId);
        List<ReadOrderDto> readOrderDtos = new ArrayList<>();

        for (Order order : orders) {
            ReadOrderDto map = READ_ORDER_DTO_MAPPER.map(order);
            readOrderDtos.add(map);
        }

        return readOrderDtos;
    }

    public CreateOrderDto createOrderDtoBuilder(int userId, int totalPrice, int totalStock){
        return CreateOrderDto.builder()
                .order_date(ORDER_DATE)
                .user_id(userId)
                .price(totalPrice)
                .quantity(totalStock)
                .build();
    }
}

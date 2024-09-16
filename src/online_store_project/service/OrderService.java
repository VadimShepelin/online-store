package online_store_project.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dao.OrderDao;
import online_store_project.dto.CreateOrderDto;
import online_store_project.entity.Order;
import online_store_project.mapper.CreateOrderDtoMapper;

import java.util.Date;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderService {

    @Getter
    private static final OrderService INSTANCE = new OrderService();
    private static Integer ORDER_NUMBER = 100;
    private static final CreateOrderDtoMapper CREATE_ORDER_DTO_MAPPER = new CreateOrderDtoMapper();
    private static final OrderDao ORDER_DAO = OrderDao.getINSTANCE();

    public Integer saveNewOrder(int userId, int totalPrice, int totalStock){
        CreateOrderDto orderDto = createOrderDtoBuilder(userId,totalPrice,totalStock);
        Order entity = CREATE_ORDER_DTO_MAPPER.map(orderDto);

        Optional<Order> order = ORDER_DAO.addOrder(entity);
        return order.map(Order::getOrders_id).orElse(0);

    }


    public CreateOrderDto createOrderDtoBuilder(int userId, int totalPrice, int totalStock){
        return CreateOrderDto.builder()
                .order_date(new Date()+"")
                .user_id(userId)
                .price(totalPrice)
                .quantity(totalStock)
                .order_number(ORDER_NUMBER++)
                .build();
    }
}

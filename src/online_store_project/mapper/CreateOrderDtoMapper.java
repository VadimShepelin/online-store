package online_store_project.mapper;

import online_store_project.dto.CreateOrderDto;
import online_store_project.entity.Order;

public class CreateOrderDtoMapper implements Mapper<Order, CreateOrderDto>{

    @Override
    public Order map(CreateOrderDto object) {
        return Order.builder()
                .order_number(object.getOrder_number())
                .date_of_the_order(object.getOrder_date())
                .user_id(object.getUser_id())
                .price(object.getPrice())
                .quantity(object.getQuantity())
                .build();
    }
}

package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.CreateOrderDto;
import online_store_project.entity.Order;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderDtoMapper implements Mapper<Order, CreateOrderDto>{

    @Getter
    private static final CreateOrderDtoMapper  INSTANCE = new CreateOrderDtoMapper();

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

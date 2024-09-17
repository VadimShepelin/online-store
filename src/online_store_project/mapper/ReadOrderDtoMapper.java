package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.ReadOrderDto;
import online_store_project.entity.Order;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadOrderDtoMapper implements Mapper<ReadOrderDto,Order>{

    @Getter
    private static final ReadOrderDtoMapper INSTANCE = new ReadOrderDtoMapper();


    @Override
    public ReadOrderDto map(Order object) {
        return ReadOrderDto.builder()
                .orders_id(object.getOrders_id())
                .price(object.getPrice())
                .order_date(object.getDate_of_the_order())
                .quantity(object.getQuantity())
                .order_number(object.getOrder_number())
                .user_id(object.getUser_id())
                .build();
    }
}

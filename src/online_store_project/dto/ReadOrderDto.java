package online_store_project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadOrderDto {
    int orders_id;
    int order_number;
    String order_date;
    int user_id;
    int quantity;
    double price;
}

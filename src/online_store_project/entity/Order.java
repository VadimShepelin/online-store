package online_store_project.entity;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Order {
    int orders_id;
    int order_number;
    String date_of_the_order;
    int user_id;
    int quantity;
    double price;
}

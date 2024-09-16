package online_store_project.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ReadProductDto {
    int product_id;
    String product_name;
    String description;
    int stock;
    int old_price;
    int new_price;
    String image;
    int categoryId;
    int discount;
}

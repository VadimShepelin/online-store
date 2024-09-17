package online_store_project.dto;

import lombok.Builder;
import lombok.Value;
import javax.servlet.http.Part;

@Builder
@Value
public class UpdateProductDto {
    int productId;
    String product_name;
    String description;
    int stock;
    String old_price;
    String new_price;
    String discount;
    Part image;
    int categoryId;
}

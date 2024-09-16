package online_store_project.entity;

import lombok.*;

@Builder
@Value
public class Product {
    int products_id;
    String product_name;
    String description;
    int new_price;
    int old_price;
    int stock;
    int category_id;
    int discount;
    String image;
}


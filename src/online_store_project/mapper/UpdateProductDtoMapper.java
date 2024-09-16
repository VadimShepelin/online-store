package online_store_project.mapper;

import lombok.Getter;
import online_store_project.dto.UpdateProductDto;
import online_store_project.entity.Product;

public class UpdateProductDtoMapper implements Mapper<Product, UpdateProductDto> {

    @Getter
    private static final UpdateProductDtoMapper INSTANCE = new UpdateProductDtoMapper();
    private static final String IMAGE_FOLDER = "\\products_images\\";

    @Override
    public Product map(UpdateProductDto object) {
        int oldPrice = Integer.parseInt(object.getOld_price());
        int discount = Integer.parseInt(object.getDiscount());

        return Product.builder()
                .old_price(oldPrice)
                .new_price(discountPriceCalculation(oldPrice,discount))
                .discount(discount)
                .stock(object.getStock())
                .product_name(object.getProduct_name())
                .image(IMAGE_FOLDER+object.getImage().getSubmittedFileName())
                .description(object.getDescription())
                .category_id(object.getCategoryId())
                .build();
    }

    private int discountPriceCalculation(int oldPrice,int discount){
        if(discount!=0){
            return oldPrice-(oldPrice/100*discount);
        }
        else{
            return oldPrice;
        }
    }
}

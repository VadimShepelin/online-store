package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.ReadProductDto;
import online_store_project.entity.Product;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadProductDtoMapper implements Mapper<ReadProductDto, Product> {
    @Getter
    private static final ReadProductDtoMapper INSTANCE = new ReadProductDtoMapper();

    @Override
    public ReadProductDto map(Product object) {
        return ReadProductDto.builder()
                .product_id(object.getProducts_id())
                .old_price(object.getOld_price())
                .new_price(object.getNew_price())
                .stock(object.getStock())
                .description(object.getDescription())
                .categoryId(object.getCategory_id())
                .product_name(object.getProduct_name())
                .image(object.getImage())
                .discount(object.getDiscount())
                .build();
    }
}

package online_store_project.service;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import online_store_project.dao.ProductDao;
import online_store_project.dto.ReadProductDto;
import online_store_project.dto.UpdateProductDto;
import online_store_project.entity.Product;
import online_store_project.mapper.ReadProductDtoMapper;
import online_store_project.mapper.UpdateProductDtoMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductService {
    @Getter
    private static ProductService INSTANCE = new ProductService();
    private static final UpdateProductDtoMapper UPDATE_PRODUCT_DTO_MAPPER = UpdateProductDtoMapper.getINSTANCE();
    private static final ProductDao PRODUCT_DAO = ProductDao.getINSTANCE();
    private static final ImageService IMAGE_SERVICE = ImageService.getInstance();
    private static final ReadProductDtoMapper READ_PRODUCT_DTO_MAPPER = ReadProductDtoMapper.getINSTANCE();

    @SneakyThrows
    public Integer saveProduct(UpdateProductDto updateProductDto) {
        Product entity = UPDATE_PRODUCT_DTO_MAPPER.map(updateProductDto);
        IMAGE_SERVICE.saveProductImage(entity.getImage(),updateProductDto.getImage().getInputStream());

        try {
            Product save = PRODUCT_DAO.save(entity);
            return save.getProducts_id();
        }
        catch (Exception e) {
            return 0;
        }


    }

    public List<ReadProductDto> getProducts(String categoryIdParameter) {
        List<Product> productList = PRODUCT_DAO.findByCategory(Integer.parseInt(categoryIdParameter));
        List<ReadProductDto> readProductDtoList = new ArrayList<>();

        for (Product product : productList) {
            ReadProductDto readProductDto = READ_PRODUCT_DTO_MAPPER.map(product);
            readProductDtoList.add(readProductDto);
        }

        return readProductDtoList;
    }

    public static int checkStock(Integer productId, Integer quantity) {
        Integer stock = PRODUCT_DAO.checkStock(productId, quantity);
        return stock;
    }

    public Optional<ReadProductDto> getProduct(String productIdParameter) {
        Optional<Product> product = PRODUCT_DAO.findByProductId(Integer.parseInt(productIdParameter));

        if(product.isPresent()) {
            ReadProductDto readProductDto = READ_PRODUCT_DTO_MAPPER.map(product.get());
            return Optional.of(readProductDto);
        }
        else {
            return Optional.empty();
        }
    }


    public void changeStock(Integer productId, Integer quantity) {
         PRODUCT_DAO.updateStock(productId,quantity);
    }
}

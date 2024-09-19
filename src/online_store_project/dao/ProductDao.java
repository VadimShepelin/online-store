package online_store_project.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import online_store_project.entity.Product;
import online_store_project.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDao implements Dao<Integer,Product> {
    @Getter
    private static final ProductDao INSTANCE = new ProductDao();
    private static final String SAVE_PRODUCT = """
           INSERT INTO products(product_name, description, old_price,new_price, stock, category_id,image,discount) VALUES(?,?,?,?,?,?,?,?) RETURNING *;
           """;
    private static final String GET_PRODUCTS = """
           SELECT product_name,products_id, description, old_price,new_price,image,stock,category_id,discount FROM products WHERE products.category_id = ? and products.stock>0;          
           """;

    private static final String GET_PRODUCT = """
           SELECT product_name,products_id, description, old_price,new_price,image,stock,category_id,discount FROM products WHERE products.products_id = ?;          
            """;
    private static final String UPDATE_STOCK = """ 
            UPDATE public.products
            SET stock = stock-?
            WHERE products_id = ?
            """;



    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Product> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product entity) {
        try(Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_PRODUCT);
            preparedStatement.setString(1, entity.getProduct_name());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getOld_price());
            preparedStatement.setInt(4, entity.getNew_price());
            preparedStatement.setInt(5, entity.getStock());
            preparedStatement.setInt(6, entity.getCategory_id());
            preparedStatement.setString(7, entity.getImage());
            preparedStatement.setInt(8, entity.getDiscount());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Product product = createProduct(resultSet);
                return product;
            }
            return null;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> findByCategory(Integer category_id) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCTS);
            statement.setInt(1, category_id);

            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = createProduct(resultSet);
                products.add(product);
            }
            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Product> findByProductId(Integer product_id) {
        try (Connection connection = ConnectionManager.get()){
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
            preparedStatement.setInt(1, product_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return Optional.of(createProduct(resultSet));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Integer checkStock(int productId, int quantity) {
        Optional<Product> product = findByProductId(productId);

        if(product.isPresent()) {
        if(product.get().getStock()<quantity) {
            return 0;
        }
        }

        return 1;
    }

    public void updateStock(Integer productId, Integer quantity) {
        try(Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK);

            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2,productId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private Product createProduct(ResultSet resultSet){
        return Product.builder()
                .category_id(resultSet.getInt("category_id"))
                .description(resultSet.getString("description"))
                .old_price(resultSet.getInt("old_price"))
                .new_price(resultSet.getInt("new_price"))
                .stock(resultSet.getInt("stock"))
                .image(resultSet.getString("image"))
                .product_name(resultSet.getString("product_name"))
                .products_id(resultSet.getInt("products_id"))
                .discount(resultSet.getInt("discount"))
                .build();
    }
}

package online_store_project.dao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersProductsDao implements Dao<Integer,Integer> {

    @Getter
    private static final OrdersProductsDao INSTANCE = new OrdersProductsDao();
    private static final String ADD_ORDERS_PRODUCTS = "INSERT INTO orders_products(order_id, product_id) VALUES (?,?)";



    public void addOrdersProducts(Integer orderId, Integer productId) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDERS_PRODUCTS);

            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, productId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(Integer integer) {
    }

    @Override
    public List<Integer> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Integer> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public Integer save(Integer entity) {
        return 0;
    }

}

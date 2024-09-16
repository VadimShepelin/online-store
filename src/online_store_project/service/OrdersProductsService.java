package online_store_project.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dao.OrdersProductsDao;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersProductsService {
    @Getter
    private static final OrdersProductsService INSTANCE = new OrdersProductsService();
    private static final OrdersProductsDao ORDERS_PRODUCTS_DAO = OrdersProductsDao.getINSTANCE();

    public void addOrdersProducts(int productId, int order_id){
        ORDERS_PRODUCTS_DAO.addOrdersProducts(order_id,productId);
    }

}

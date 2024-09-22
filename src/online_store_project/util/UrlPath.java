package online_store_project.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlPath {
    public static final String REGISTRATION = "/registration";
    public static final String LOGIN = "/login";
    public static final String LOCALE = "/locale";
    public static final String MAIN = "/main";
    public static final String LOGOUT = "/logout";
    public static final String PROFILE = "/profile";
    public static final String ADMIN = "/admin";
    public static final String ADMIN_LOGIN = "/adminLogin";
    public static final String ADMIN_LOGOUT = "/adminLogout";
    public static final String ADD_PRODUCT = "/addProduct";
    public static final String USERS_LIST = "/usersList";
    public static final String CATEGORY = "/category";
    public static final String PRODUCT_DETAILS = "/productDetails";
    public static final String BASKET = "/basket";
    public static final String DELETE_BASKET = "/deleteBasket";
    public static final String REPLENISHMENT = "/replenishment";
    public static final String ORDERS_HISTORY = "/ordersHistory";
    public static final String ORDERS_HISTORY_ADMIN = "/ordersHistoryAdmin";
}

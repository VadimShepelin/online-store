package online_store_project.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;

@UtilityClass
public class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String PASSWORD_KEY = "db.password";
    private static final String NAME_KEY = "db.name";

    static{
        loadDriver();
    }

    private static void loadDriver() {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public static Connection get(){
       return DriverManager.getConnection(PropertiesHelper.getInstance().getProperty(URL_KEY),
               PropertiesHelper.getInstance().getProperty(NAME_KEY),PropertiesHelper.getInstance().getProperty(PASSWORD_KEY));
    }
}

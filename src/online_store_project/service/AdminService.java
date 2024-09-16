package online_store_project.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminService {
    @Getter
    private static AdminService INSTANCE = new AdminService();
    private static final String ADMIN_PASSWORD = "somePassword";
    private static final String ADMIN_NAME = "admin";

    public boolean checkAdmin(String name, String password) {
        return name.equals(ADMIN_NAME) && password.equals(ADMIN_PASSWORD);
    }

}

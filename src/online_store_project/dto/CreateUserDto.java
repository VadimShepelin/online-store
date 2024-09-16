package online_store_project.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateUserDto {
    int users_id;
    String user_name;
    String surname;
    String user_password;
    String email;
    String address;
    String phone;
    boolean is_blacklisted;
    double balance;
    String gender;
    String birthday;
}

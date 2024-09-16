package online_store_project.dto;

import lombok.Builder;
import lombok.Setter;
import lombok.Value;

@Builder
@Value
public class UpdateUserDto {
    int users_id;
    String user_name;
    String surname;
    String user_password;
    String email;
    String address;
    String phone;
    String gender;
    String birthday;
    String balance;
}

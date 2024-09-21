package online_store_project.dto;

import lombok.Builder;
import lombok.Value;
import online_store_project.entity.BlackList;

@Builder
@Value
public class ReadUserDto {
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
    BlackList is_blacklisted;
}

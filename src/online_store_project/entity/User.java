package online_store_project.entity;

import lombok.*;

@Builder
@Data
public class User {
    int id;
    String user_name;
    String surname;
    String user_password;
    String email;
    double balance;
    String address;
    String phone;
    boolean is_blacklisted;
    Gender gender;
    String birthday;

}

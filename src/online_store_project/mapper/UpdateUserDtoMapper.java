package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.UpdateUserDto;
import online_store_project.entity.Gender;
import online_store_project.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateUserDtoMapper implements Mapper<User, UpdateUserDto> {

    @Getter
    private static final UpdateUserDtoMapper MAPPER = new UpdateUserDtoMapper();


    @Override
    public User map(UpdateUserDto object) {
        return User.builder()
                .email(object.getEmail())
                .user_password(object.getUser_password())
                .id(object.getUsers_id())
                .user_name(object.getUser_name())
                .surname(object.getSurname())
                .birthday(object.getBirthday())
                .phone(object.getPhone())
                .address(object.getAddress())
                .gender(Gender.valueOf(object.getGender()))
                .balance(Double.valueOf(object.getBalance()))
                .build();
    }
}

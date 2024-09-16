package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.ReadUserDto;
import online_store_project.entity.User;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadUserDtoMapper implements Mapper<ReadUserDto,User> {

    @Getter
    private static final ReadUserDtoMapper INSTANCE = new ReadUserDtoMapper();


    @Override
    public ReadUserDto map(User object) {
        return ReadUserDto.builder()
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .user_name(object.getUser_name())
                .user_password(object.getUser_password())
                .surname(object.getSurname())
                .address(object.getAddress())
                .phone(object.getPhone())
                .users_id(object.getId())
                .balance(String.valueOf(object.getBalance()))
                .build();
    }
}

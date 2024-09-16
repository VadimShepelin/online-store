package online_store_project.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.CreateUserDto;
import online_store_project.entity.Gender;
import online_store_project.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserDtoMapper implements Mapper<User, CreateUserDto> {
    @Getter
    private static final CreateUserDtoMapper USER_DTO_MAPPER = new CreateUserDtoMapper();

    @Override
    public User map(CreateUserDto createUserDto) {
        return User.builder()
                .email(createUserDto.getEmail())
                .gender(Gender.valueOf(createUserDto.getGender()))
                .birthday(createUserDto.getBirthday())
                .user_name(createUserDto.getUser_name())
                .user_password(createUserDto.getUser_password())
                .build();

    }
}

package online_store_project.validator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.CreateUserDto;
import online_store_project.entity.Gender;
import online_store_project.util.LocalDateFormatter;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    @Getter
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidatorResult isDataValid(CreateUserDto object) {
        ValidatorResult validatorResult = new ValidatorResult();
        if(object.getUser_password().length()<8){
            validatorResult.addError(new Errors("the password is too short"));
        }

        if(!LocalDateFormatter.isFormatValid(object.getBirthday())){
            validatorResult.addError(new Errors("the birthday is not correct"));
        }

        if(!Gender.findGender(object.getGender()).isPresent()){
            validatorResult.addError(new Errors("the gender is not correct"));
        }

        return validatorResult;

    }
}

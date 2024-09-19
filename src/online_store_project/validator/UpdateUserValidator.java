package online_store_project.validator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online_store_project.dto.UpdateUserDto;
import online_store_project.entity.Gender;
import online_store_project.util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateUserValidator implements Validator<UpdateUserDto> {

    @Getter
    private static final UpdateUserValidator UPDATE_USER_VALIDATOR = new UpdateUserValidator();
    private static final String PATTERN = "^\\+?\\d{11,12}$";

    @Override
    public ValidatorResult isDataValid(UpdateUserDto object) {
        ValidatorResult validatorResult = new ValidatorResult();
        if(object.getUser_password().length()<8){
            validatorResult.addError(new Errors("the password is too short"));
        }

        if(!isPhoneValid(object.getPhone())&&!object.getPhone().equals("no phone")){
            validatorResult.addError(new Errors("the phone number is not valid"));
        }

        return validatorResult;
    }

    private boolean isPhoneValid(String phone) {
        return phone.matches(PATTERN);
    }

}

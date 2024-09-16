package online_store_project.validator;

public interface Validator<T>{
    ValidatorResult isDataValid(T object);
}

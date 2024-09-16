package online_store_project.exception;

import lombok.Getter;
import online_store_project.validator.Errors;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Errors> errors;

    public ValidationException(List<Errors> errors) {
        this.errors = errors;
    }
}

package online_store_project.validator;

public class Errors  {
    private static final String ERROR_BASE = "Error:";
    private final String error;

    public Errors(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return ERROR_BASE+error;
    }
}

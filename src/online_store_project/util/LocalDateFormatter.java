package online_store_project.util;

import lombok.experimental.UtilityClass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class LocalDateFormatter {

    private static final String PATTERN = "yyyy-MM-dd";

    public static boolean isFormatValid(String birthday){
        try {
            LocalDate.parse(birthday,DateTimeFormatter.ofPattern(PATTERN));
            return true;
        }
        catch (Exception e){
           return false;
        }
    }
}

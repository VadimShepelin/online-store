package online_store_project.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    Male,Female;

    public static Optional<Gender> findGender(String gender) {
        return Arrays.stream(Gender.values()).filter(g -> g.name().equals(gender)).findFirst();
    }
}

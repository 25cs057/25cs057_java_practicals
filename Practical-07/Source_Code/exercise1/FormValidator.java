package exercise1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Reflection-based generic form validation checker.
 */
public class FormValidator {

    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        if (obj == null) {
            errors.add("Target validation object is null.");
            return errors;
        }

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                // 1. Check @NotBlank
                if (field.isAnnotationPresent(NotBlank.class)) {
                    NotBlank nb = field.getAnnotation(NotBlank.class);
                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(String.format("Field '%s': %s", field.getName(), nb.message()));
                    }
                }

                // 2. Check @MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength ml = field.getAnnotation(MaxLength.class);
                    if (value != null && value.toString().length() > ml.value()) {
                        errors.add(String.format("Field '%s': %s (limit: %d, actual: %d)",
                                field.getName(), ml.message(), ml.value(), value.toString().length()));
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Unable to access field: " + field.getName());
            }
        }

        return errors;
    }
}


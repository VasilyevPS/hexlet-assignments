package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && (field.get(address) == null)) {
                    result.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            List<String> errors = new ArrayList<>();
            try {
                if (field.isAnnotationPresent(NotNull.class) && (field.get(address) == null)) {
                    errors.add("can not be null");
                }
                if (errors.isEmpty() && field.isAnnotationPresent(MinLength.class)
                        && (field.get(address).toString().length()
                        < field.getAnnotation(MinLength.class).minLength())) {
                    errors.add("length less than 4");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (!errors.isEmpty()) {
                result.put(field.getName(), errors);
            }
        }
        return result;
    }
}
// END

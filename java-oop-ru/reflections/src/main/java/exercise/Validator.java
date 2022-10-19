package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> list = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(object) == null) {
                    list.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(object) == null) {
                    result.put(field.getName(), List.of("can not be null"));
                }
                if (field.isAnnotationPresent(MinLength.class) && String.valueOf(field.get(object)).length() < field.getAnnotation(MinLength.class).minLength()) {
                    if (result.containsKey(field.getName())) {
                        result.put(field.getName(), List.of("can not be null", "length less than " + field.getAnnotation(MinLength.class).minLength()));
                    } else {
                        result.put(field.getName(), List.of("length less than " + field.getAnnotation(MinLength.class).minLength()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
// END

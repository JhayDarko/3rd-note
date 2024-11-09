package juice.jigsaw;

import java.util.HashMap;
import java.util.Map;

public class Jhayson {
    private final Map<String, Object> map;

    public Jhayson(String jsonString) {
        map = parseJson(jsonString);
    }

    private Map<String, Object> parseJson(String jsonString) {
        Map<String, Object> result = new HashMap<>();

        jsonString = jsonString.trim().substring(1, jsonString.length() - 1);
        String[] pairs = jsonString.split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim();

            if (value.startsWith("\"")) {
                result.put(key, value.replace("\"", ""));
            } else if (value.contains(".")) {
                result.put(key, Double.valueOf(value));
            } else {
                try {
                    result.put(key, Integer.valueOf(value));
                } catch (NumberFormatException e) {
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    public double getDouble(String key) {
        Object value = map.get(key);
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        throw new IllegalArgumentException("El valor no es un número.");
    }

    public String getString(String key) {
        Object value = map.get(key);
        if (value instanceof String string) {
            return string;
        }
        throw new IllegalArgumentException("El valor no es un String.");
    }
}

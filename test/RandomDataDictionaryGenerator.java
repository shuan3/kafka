import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * RandomDataDictionaryGenerator is a utility class that generates a random dictionary with the given keys and types.
 * The values are generated randomly based on the given types and a value dictionary.
 */
public class RandomDataDictionaryGenerator {

    private static final Random random = new Random();

    public static Map<String, Object> generateRandomDictionary(String[] keys, Class<?>[] types, Map<Class<?>, Object[]> valueDictionary) {
        if (keys.length != types.length) {
            throw new IllegalArgumentException("Keys and types arrays must have the same length.");
        }

        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            Class<?> type = types[i];
            result.put(key, generateRandomValue(type, valueDictionary));
        }

        return result;
    }

    private static Object generateRandomValue(Class<?> type, Map<Class<?>, Object[]> valueDictionary) {
        if (valueDictionary != null && valueDictionary.containsKey(type)) {
            Object[] values = valueDictionary.get(type);
            return values[random.nextInt(values.length)];
        } else if (type == Integer.class || type == int.class) {
            return random.nextInt();
        } else if (type == Double.class || type == double.class) {
            return random.nextDouble();
        } else if (type == Boolean.class || type == boolean.class) {
            return random.nextBoolean();
        } else if (type == String.class) {
            return generateRandomString(10); // Example string length
        } else if (type == Long.class || type == long.class) {
            return random.nextLong();
        } else if (type == Float.class || type == float.class) {
            return random.nextFloat();
        } else {
            return null; // Handle unsupported types as needed
        }
    }

    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }



    private static ArrayList<Map<String, Object>> generateRandomData(int data_length, Map<Class<?>, Object[]> valueDictionary, String[] keys, Class<?>[] types) {
        ArrayList<Map<String, Object>> raw_data = new ArrayList<>();

        for (int i = 0; i < data_length; i++) {
            Map<String, Object> randomDictionary3 = generateRandomDictionary(keys, types, valueDictionary);
            raw_data.add(randomDictionary3);
        }
        return raw_data;
    }

    public static void main(String[] args) {
        //example 1
        // String[] keys = {"id", "name", "isActive", "price"};
        // Class<?>[] types = {Integer.class, String.class, Boolean.class, Double.class};

        // Map<Class<?>, Object[]> valueDictionary = new HashMap<>();
        // valueDictionary.put(String.class, new String[]{"apple", "banana", "cherry", "date"});
        // valueDictionary.put(Boolean.class, new Boolean[]{true, false, true});

        // Map<String, Object> randomDictionary = generateRandomDictionary(keys, types, valueDictionary);

        // System.out.println(randomDictionary);
        //example 2
        // String[] keys2 = {"id", "name", "isActive", "price", "count", "weight"};
        // Class<?>[] types2 = {Integer.class, String.class, Boolean.class, Double.class, Long.class, Float.class};

        // Map<String, Object> randomDictionary2 = generateRandomDictionary(keys2, types2, null);

        // System.out.println(randomDictionary2);
        //example 3

        // Map<Class<?>, Object[]> valueDictionary = new HashMap<>();
        // valueDictionary.put(String.class, new String[]{"apple", "banana", "cherry", "date"});
        // valueDictionary.put(Boolean.class, new Boolean[]{true, false, true});        
        // ArrayList<Map<String, Object>> data = new ArrayList<>();

        // // Generate 100 random dictionaries with the given keys and types
        // String[] keys3 = {"id", "name", "isActive", "price", "count", "weight"};
        // Class<?>[] types3 = {Integer.class, String.class, Boolean.class, Double.class, Long.class, Float.class};
        // for (int i = 0; i < 100; i++) {
        //     Map<String, Object> randomDictionary3 = generateRandomDictionary(keys3, types3, valueDictionary);
        //     data.add(randomDictionary3);
        // }


        // System.out.println(data);

        //example 5
        // String[] keys5 = {"id", "name", "isActive", "price", "count", "weight"};
        // Class<?>[] types5 = {Integer.class, String.class, Boolean.class, Double.class, Long.class, Float.class};
        // Map<Class<?>, Object[]> valueDictionary = new HashMap<>(); 
        // valueDictionary.put(String.class, new String[]{"apple", "banana", "cherry", "date"});
        // valueDictionary.put(Boolean.class, new Boolean[]{true, false, true});    
        // ArrayList<Map<String, Object>> data1 = generateRandomData(100000, valueDictionary, keys5, types5);

        // System.out.println(data1);

        //example 
 
        ArrayList<Map<String, Object>> data1 = generateRandomData(10, Parameter.valueDictionary, Parameter.keys6, Parameter.types6);

        System.out.println(data1);

    }
}


//cd "d:\Github\kafka\test\" && javac RandomDataDictionaryGenerator.java && java RandomDataDictionaryGenerator




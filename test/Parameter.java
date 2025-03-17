// public class parameter(){
//         String[] keys6 = {"id", "name", "isActive", "price", "count", "weight"};
//         Class<?>[] types6 = {Integer.class, String.class, Boolean.class, Double.class, Long.class, Float.class};
//         Map<Class<?>, Object[]> valueDictionary1 = new HashMap<>(); 
//         valueDictionary1.put(String.class, new String[]{"apple", "banana", "cherry", "date"});
//         valueDictionary1.put(Boolean.class, new Boolean[]{true, false, true});   
// }


import java.util.HashMap;
import java.util.Map;

public class Parameter {
    public static final String[] keys6 = {"id", "name", "isActive", "price", "count", "weight"};
    public static final Class<?>[] types6 = {Integer.class, String.class, Boolean.class, Double.class, Long.class, Float.class};
    public static final Map<Class<?>, Object[]> valueDictionary = new HashMap<>(); 

    static {
        valueDictionary.put(String.class, new String[]{"apple", "banana", "cherry", "date"});
        valueDictionary.put(Boolean.class, new Boolean[]{true, false, true});
    }
}
import java.util.HashMap;
import java.util.Map;

public class Iteration {
    public static void main(String[] args) {
        // Array
        int[] intArray = {48, 21, 77, 15};
    //   for (int i = 0; i < intArray.length; i++) {
    //     System.out.println(intArray[i]);
    //   } 
    //   System.out.println(intArray);
        for (int number: intArray) {
            System.out.println(number);
        }
        // HashMap
        Map<String, Double> TeaPrices = new HashMap<>();
        TeaPrices.put("Black Tea", 6.99);
        TeaPrices.put("White Tea", 4.56);
        TeaPrices.put("Jasmine Tea", 2.95);
        System.out.println(TeaPrices);

        for (Map.Entry<String, Double> e : TeaPrices.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            
        }

    }
};
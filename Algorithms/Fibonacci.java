
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static  Map<Integer, Integer> fibonacciGenerator(int n) {
        int count = 0;
        Map<Integer, Integer> fibMap = new HashMap<>();
        fibMap.put(0, 0);
        fibMap.put(1,1);

        for (int i = 2; i < n; i++) {
            count = fibMap.get(i - 1) + fibMap.get(i - 2);
            fibMap.put(i,count);
        }
       
        return fibMap;
    }

    public static int findNumberInFibonacci(int n) {
        Map<Integer, Integer> fibMap = new HashMap<>(fibonacciGenerator(n));
        if (n < 2) {
            return fibMap.get(n);
        } else {
            return fibMap.get(n - 1) + fibMap.get(n - 2);
        } 
    }

    public static void main(String[] args) {
        System.out.println(findNumberInFibonacci(1));
    }

}

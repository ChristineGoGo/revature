import java.util.Arrays;

public class ArrayAbsoluteValue {
    public static  int[] getArrayAbs(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n];
        int current;

        for (int i = 0; i < n; i++) 
        {
            if (nums[i] < 0) {
                current = nums[i] * -1;
                newNums[i] = current;
            } else {
                newNums[i] =nums[i];
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] test = {1, -3, 5, -6 };

        System.out.println(Arrays.toString(getArrayAbs(test)));
        
    }

}

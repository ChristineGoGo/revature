import java.util.Arrays;

public class IsThereSum {
    public static boolean searchArray(int[] nums, int val) {
        for (int num: nums) {
            if (num == val) {
                return true;
            }
        }
        return false;
    }
    public static boolean check(int[] arr, int target){
        int num;
        // return false;
        int difference;
        for (int i = 0; i < arr.length - 1; i++) {
            num = arr[i];
            difference = target > num ? target - num : num - target;
            System.out.println("i:" + i);
            System.out.println("Difference: " + difference);
            System.out.println("i + 1: " + (i + 1));
            System.out.println("arr.length - 1 " + (arr.length - 1));
            int[] slice = Arrays.copyOfRange(arr, (i + 1), (arr.length - 1));
            if (searchArray(slice, difference) == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4, 5};
        System.out.println(check(nums, 10));
    }

}

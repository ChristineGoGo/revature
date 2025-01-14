
public class LinearSearch {
    public static Boolean search(int target, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 9, 0, 4, 5};
        int target = 9;
        Boolean result = search(target, nums);
        System.out.println(result);
    }

}

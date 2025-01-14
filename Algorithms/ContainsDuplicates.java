import java.util.HashSet;

public class ContainsDuplicates {
    public static boolean containsDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        return !(set.size() == nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2,  3, 4, 5};
        System.out.println(containsDuplicates(nums));
    }

}

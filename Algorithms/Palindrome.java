public class Palindrome {
    public static boolean getPalindrome(String str) {
        return getReversed(str).equals(str);
    }
    public static String getReversed(String str) {
        String reversed = "";
        int stringIndex = str.length() - 1;

        for (int i = stringIndex; i >= 0; i--) {
            char current = str.charAt(i);
            reversed += current;
        }
        return reversed;
    }

    public static void main(String[] args) {
        String test = "racecar";
        System.out.println(getPalindrome(test));
    }

}

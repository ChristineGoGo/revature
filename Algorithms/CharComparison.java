package Algorithms;

public class CharComparison {
    public static int compare(char[] a, char[] b) {
        String currenta = "";
        String currentb = "";
        int result;

        for (int i = 0; i < a.length; i++) {
            currenta += a[i];
            currentb += b[i];
            result = currenta.compareTo(currentb);
            // System.out.println(result + currenta + currentb);
            if (result < 0) {
                return  -1;
            } else if (result > 0) {
                return 1;
            }
            currenta = "";
            currentb = "";
        }
        return 0;
    }

    public static void main(String[] args) {
        char[] a = {'d', 'o', 'g'};
        char[] b = {'d', 'o', 't'};
        System.err.println(compare(a, b));
    }
}

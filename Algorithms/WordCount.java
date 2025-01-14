public class WordCount {
    public static int countStringWords(String str) {
        String[] splittedSting = str.split(" ");
        return splittedSting.length;
    } 

    public static void main(String[] args) {
        System.out.println(countStringWords("The cat is cute"));
    }
}

public class PigLatin {
    public static String transformWord(String in) {
        String result = in.substring(1);
        char firstLetter = in.charAt(0);
        return result + firstLetter + "ay";
    }
    public static void main(String[] args) {
        System.out.println(transformWord("word"));
        System.out.println(transformWord("pig"));
        System.out.println(transformWord("latin"));
    }
}
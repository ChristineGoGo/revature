import java.util.HashMap;
import java.util.Map;

public class Isogram {
    public static Map<String, Integer> createAlphabetMap() {
        Map<String, Integer> myAlphabets = new HashMap<>();
        String currString = "";
        char myLetter = 97;

        for (int i = 0; i < 26; i++) {
            currString += myLetter;
            myAlphabets.put(currString, 0);

            myLetter += 1;
            currString = "";

        }
        return myAlphabets;
            
    }

    public static boolean isIsogram(String str) {
        Map <String, Integer> AlphabetCount = new HashMap<>(createAlphabetMap());
        char currenChar;
        int currentCount;
        String currentString = "";


        for (int i = 0; i < str.length(); i++) {
            currenChar = str.charAt(i);
            currentString += currenChar;
            currentCount = AlphabetCount.get(currentString);
            currentCount += 1;
            AlphabetCount.put(currentString, currentCount);
            if (currentCount > 1) {
                return false;
            }
            currentString = "";
        }
        System.out.println(AlphabetCount);
        return true;
    }


    public static void main(String[] args) {
        // Map<String, Integer> myMap = new HashMap<>(createAlphabetMap());
        System.out.println(isIsogram("cat"));
   
    }
    
}

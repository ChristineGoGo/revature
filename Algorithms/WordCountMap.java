import java.util.HashMap;
import java.util.Map;

public class WordCountMap {
    public static Map wordMap(String words) {
        Map <String, Integer> frequency = new HashMap<>();
        String[] wordList = words.split(" ");
        int count;
        for (String word: wordList) {
            if (frequency.containsKey(word)){
                count = frequency.get(word);
                count++;
                frequency.put(word, count);
            } else {
                count = 1;
                frequency.put(word, count);
            }
        }
        return frequency;
    }
    public static void main(String[] args) {
        System.out.println(wordMap("there goes a cat and a dog the dog goes when the cat goes"));
    }

}

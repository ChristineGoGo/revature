

public class RemoveAllCharacters {
    public static String removeAll(String str, String ch){
        int IndexToRemove = str.indexOf(ch);
        String CurrentCharacter = "";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            CurrentCharacter += str.charAt(i);
            if (!(i == IndexToRemove)) {
                result += CurrentCharacter;
            }
            CurrentCharacter = "";
        }
        return result;

    }


}

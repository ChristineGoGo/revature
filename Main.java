import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[][] input = {
            {0, 1, 2},
            {2, 3, 4},
            {5, 6, 7}
        };
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input[j].length; i++) {
                System.out.println(input[j][i]);
            }
        }
    }


}

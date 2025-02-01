
public class Main {
    public static void main(String[] args){
        String str = "enchanted";
        String substring = "ant";
        String[] parts = str.split("ant");

        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
        System.out.println(str.substring(1));
    }


}

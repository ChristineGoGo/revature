public class ArraysAreEqual {

    
    public boolean equal(int[] array1, int[] array2) {
        if (array1.length != array2.length){
            return false;
        }
            
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }            
        }

        return true;
    }

    public static void main(String[] args) {
        ArraysAreEqual c = new ArraysAreEqual();
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        c.equal(a, b);
    }
}

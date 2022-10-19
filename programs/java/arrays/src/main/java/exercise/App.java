package exercise;

class App {
    // BEGIN
    public static int[] reverse(int[] array) {
        int[] result = new int[array.length];
        int count = 0;
        for(int i = array.length-1; i >= 0; i--) {
            result[count] = array[i];
            count++;
        }
        return  result;
    }

    public static int mult(int[] array) {
        int result = 1;
        for(int i = 0; i < array.length; i++) {
            result *= array[i];
        }
        return  result;
    }
    // END
}

package exercise;

class App {

    // BEGIN
    // Сортировка пузырьком
    public static int[] sort(int[] array) {
        for (int i = array.length-1; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                int change = 0;
                if(array[k] > array[k+1]) {
                    change = array[k];
                    array[k] = array[k+1];
                    array[k+1] = change;
                }
            }
        }
        return array;
    }
        // Сортировка выбором
//    public static int[] sort(int[] array) {
//        for(int i = 0; i < array.length-1; i++) {
//            for(int k = i + 1; k < array.length; k++) {
//                if(array[i] > array[k]) {
//                    int temp = array[i];
//                    array[i] = array[k];
//                    array[k] = temp;
//                }
//            }
//        }
//        return array;
//    }
    // END
}

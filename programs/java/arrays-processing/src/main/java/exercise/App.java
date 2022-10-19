package exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

class App {
    // BEGIN
    public static int getIndexOfMaxNegative(int[] array) {
        int result = -1;
        int maxNegative = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maxNegative && array[i] < 0) {
                maxNegative = array[i];
                result = i;
            }
        }
        return result;
    }

    public static int[] getElementsLessAverage(int[] array) {
        int[] middleElements = new int[0];
        if(array.length == 0) return middleElements;
        int middleElementsCount = 0;
        int sum = 0;
        for(int a : array) {
            sum += a;
        }
        double midElement = (double) sum / array.length;
        for(int b : array) {
            if(b < midElement) {
                middleElements = Arrays.copyOf(middleElements, middleElements.length + 1);
                middleElements[middleElementsCount] = b;
                middleElementsCount++;
            }
        }
        return middleElements;
    }

    public static int getSumBeforeMinAndMax(int[] array) {
        int result = 0;
        int max = array[0];
        int maxIndex = 0;
        int min = array[0];
        int minIndex = 0;
        for(int a = 0; a < array.length; a++) {
            if (max < array[a]) { max = array[a]; maxIndex = a; }
            if (min > array[a]) { min = array[a]; minIndex = a; }
        }
        if (minIndex < maxIndex) {
            for (int i = minIndex + 1; i < maxIndex; i++) { result += array[i]; }
        }
        else if (minIndex > maxIndex) {
            for (int i = maxIndex + 1; i < minIndex; i++) { result += array[i]; }
        }
        return result;
    }
    // END
}

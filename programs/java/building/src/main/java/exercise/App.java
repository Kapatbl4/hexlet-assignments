// BEGIN
package exercise;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    public static String toJson(String[] array) {
        Gson gson = new Gson();
        return gson.toJson(array);
    }
}
// END

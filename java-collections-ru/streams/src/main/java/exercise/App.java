package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream().filter(s -> s.endsWith("gmail.com") || s.endsWith("yandex.ru") || s.endsWith("hotmail.com")).count();
    }
}
// END

package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List findWhere(List<Map<String, String>> bookList, Map<String, String> book) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> iterationBook : bookList) {
            if (containsAll(iterationBook, book)) {
                result.add(iterationBook);
            }
        }
        return result;
    }

    private static boolean containsAll(Map<String, String> book, Map<String, String> neededBook) {
        boolean result = false;
        int size = neededBook.size();
        int count = 0;
        for (Map.Entry<String, String> bookPair : book.entrySet()) {
            for (Map.Entry<String, String> neededBookPair : neededBook.entrySet()) {
                if (bookPair.equals(neededBookPair)) {
                    count++;
                }
            }
        }
        if (count == size) result = true;
        return result;
    }
}
//END

package exercise;

import java.time.LocalDate;
import java.util.Arrays;


class App {
    // BEGIN
    public static String buildList(String[] array) {
        StringBuilder sb = new StringBuilder();

        if(array.length == 0) {return "";}
        sb.append("<ul>");
        for(int i = 0; i < array.length; i++) {
            sb.append("\n  <li>").append(array[i]).append("</li>");
        }
        sb.append("\n</ul>");

        return String.valueOf(sb);
    }

//    public static String getUsersByYear(String[][] users, int year) {
//        StringBuilder sb = new StringBuilder();
//        StringBuilder result = new StringBuilder();
//        if(users.length == 0) {return "";}
//
//        sb.append("<ul>");
//        for(String[] user : users) {
//            StringBuilder yearOfBirth = new StringBuilder();
//            for (int i = 0; i < 4; i++) { yearOfBirth.append(user[1].charAt(i)); }
//
//            if(year == Integer.parseInt(String.valueOf(yearOfBirth))) {
//                sb.append("\n  <li>").append(user[0]).append("</li>");
//            }
//        }
//        if(sb.length() > 4) result.append(sb).append("\n</ul>");
//
//
//        return String.valueOf(result);
//    }

    public static String getUsersByYear(String[][] users, int year) {
        if(users.length == 0) { return ""; }

        String[] demoNeededUsers = new String[users.length];
        int demoCount = 0;
        for(String[] user : users) {
            LocalDate date = LocalDate.parse(user[1]);
             if(year == date.getYear()) {
                demoNeededUsers[demoCount] = user[0];
                demoCount++;
            }
        }
        // Если передать demoNeededUsers метод buildList, тесты не пройдут, т.к. buildList обрабатывает null так же,
        // как не пустые элементы. Поэтому создаю новый массив и переписываю в него все не-null значения.

        return buildList(Arrays.copyOfRange(demoNeededUsers, 0, demoCount));
    }
    
    // END

    // Это дополнительная задача, которая выполняется по желанию.
    public static String getYoungestUser(String[][] users, String date) throws Exception {
        // BEGIN
        LocalDate checkDate = LocalDate.parse(date);
        LocalDate result = LocalDate.MIN;
        StringBuilder sb = new StringBuilder();
        for(String[] user : users) {
            LocalDate birthDate = LocalDate.parse(user[1]);
            if(checkDate.isAfter(birthDate) && result.isBefore(birthDate)) {
                result = birthDate;
                sb.replace(0, sb.length(), user[0]);
            }
        }
        return String.valueOf(sb);
        // END

    }
}

package exercise;

class App {
    // BEGIN
    public static String getAbbreviation(String input) {
        StringBuilder abbreviation = new StringBuilder();
        char[] inputArr = input.toCharArray();
        if (inputArr[0] != ' ') {
            abbreviation = new StringBuilder(String.valueOf(inputArr[0]).toUpperCase());
        }
        for (int i = 0; i < inputArr.length-1; i++) {
            if (inputArr[i] == ' ' && inputArr[i + 1] != ' ') {
                abbreviation.append(String.valueOf(inputArr[i + 1]).toUpperCase());
            }
        }
        return abbreviation.toString();
    }
    // END
}

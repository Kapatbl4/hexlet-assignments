package exercise;

class Card {
    public static void printHiddenCard(String cardNumber, int starsCount) {
        // BEGIN
        System.out.println("*".repeat(starsCount) + cardNumber.substring(12));
        // END
    }
}

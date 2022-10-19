package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final char[] chars;
    public ReversedSequence(String input) {
        this.chars = new StringBuilder(input).reverse().toString().toCharArray();
    }

    @Override
    public int length() {
        return this.chars.length;
    }

    @Override
    public char charAt(int index) {
        return this.chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(this.chars[i]);
        }
        return sb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char aChar : this.chars) {
            sb.append(aChar);
        }
        return String.valueOf(sb);
    }
}
// END

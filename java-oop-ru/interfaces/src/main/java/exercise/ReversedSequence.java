package exercise;

// BEGIN
public class ReversedSequence implements CharSequence  {
    private String sequence;

    public ReversedSequence(String sequence) {
        this.sequence = reverse(sequence);

    }

    @Override
    public int length() {
        return sequence.length();
    }

    @Override
    public char charAt(int i) {
        int count = -1;
        for (char symbol: sequence.toCharArray()) {
            if (++count == i) {
                return symbol;
            }
        }
        return 0;
    }


    @Override
    public CharSequence subSequence(int i, int i1) {
        if (length() == 0) {
            return "";
        }
        return toString().substring(i, i1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (char symbol: sequence.toCharArray()) {
            result.append(symbol);
        }
        return result.toString();
    }

    private String reverse(String str) {
        StringBuilder result = new StringBuilder();
        for (char symbol: str.toCharArray()) {
            result.insert(0, symbol);
        }
        return result.toString();
    }

}
// END

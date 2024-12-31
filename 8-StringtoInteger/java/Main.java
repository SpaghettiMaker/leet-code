import java.util.HashMap;

public class Main {

    private static final int minus = 45;
    private static final int whitespace = 32;
    private static final int plus = 43;

    public static void main(String[] args) {
        System.out.println(myAtoi("  +  413"));
    }

    public static int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false;
        boolean hasSign = false;
        boolean isParsing = false;

        for (char c : s.toCharArray()) {
            // Ignora gli spazi iniziali
            if (c == ' ') {
                if (isParsing)
                    break;
                continue;
            }

            // Gestione dei segni '+' e '-'
            if (c == '+' || c == '-') {
                if (isParsing || hasSign)
                    break; // Segno duplicato o trovato dopo i numeri
                isNegative = (c == '-');
                hasSign = true;
                isParsing = true;
                continue;
            }

            // Gestione dei numeri
            if (c >= '0' && c <= '9') {
                isParsing = true;
                int digit = c - '0';
                result = result * 10 + digit;

                // Controllo overflow
                if (result > Integer.MAX_VALUE)
                    break;

                continue;
            }

            // Qualsiasi altro carattere interrompe il parsing
            break;
        }

        // Applica il segno
        if (isNegative)
            result = -result;

        // Controlla i limiti di un intero
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;

    }
}

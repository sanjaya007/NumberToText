package com.example.numbertotext;

public class NumToWord {

    public static final String[] units = { "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };

    public static final String[] tens = {"", "", "Twenty", 	"Thirty", "Forty", 	"Fifty", "Sixty", "Seventy","Eighty", "Ninety" 	// 9
    };

    public static String toWord(final int n) {
        if (n < 0) {
            return "Minus " + toWord(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + toWord(n % 100);
        }

        if ( n > 999 ){
            return "only for 3 digits number.";
        }
        return "???";
    }
}

package org.hbrs.se1.ss24.uebung1.businesslogic;

public class RomanNumberTransformer implements NumberTransformer{
    @Override
    public String transformNumber(int number) {
        if (NumberTransformer.checkNumber(number) != null)
            return NumberTransformer.checkNumber(number);

        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC",
                "C", "CD", "D", "CM", "M"};
        int[] romanValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900,
                1000};
        //int number = 1234; // z.B.
        StringBuilder romanNumeral = new StringBuilder();
        for (int i = romanValues.length - 1; i >= 0; i--) {
            while (number >= romanValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                number -= romanValues[i];
            }
        }
        String result = romanNumeral.toString();
        return result;
    }

    @Override
    public String getTransformerType() {
        return "Transformer für römische Zahlen";
    }
}

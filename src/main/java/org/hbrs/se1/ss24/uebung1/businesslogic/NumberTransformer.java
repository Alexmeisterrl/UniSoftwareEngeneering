package org.hbrs.se1.ss24.uebung1.businesslogic;

public interface NumberTransformer

{
    String transformNumber(int number);

    String getTransformerType();

    static String checkNumber(int input) {
        if ((input > 3000) || (input < 1)) {
            return "Keine gueltige Eingabe";
        } else
            return null;
    }
}
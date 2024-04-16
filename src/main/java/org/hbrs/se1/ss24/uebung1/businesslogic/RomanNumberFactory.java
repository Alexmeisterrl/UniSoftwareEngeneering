package org.hbrs.se1.ss24.uebung1.businesslogic;

public abstract class RomanNumberFactory {
    public static RomanNumberTransformer createRomanNumberTransformer() {
        return new RomanNumberTransformer();
    }
}

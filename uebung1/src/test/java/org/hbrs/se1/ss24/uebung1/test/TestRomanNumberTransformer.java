package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestRomanNumberTransformer {

    private static RomanNumberTransformer romanNumberTransformer = new RomanNumberTransformer();
    @Test
    public void TestRomanNumbers1() {
        Assertions.assertEquals("Keine gueltige Eingabe", romanNumberTransformer.transformNumber(0));
    }

    @Test
    public void TestRomanNumbers2() {
        Assertions.assertEquals("MCCXXXIV", romanNumberTransformer.transformNumber(1234));
    }

    @Test
    public void TestRomanNumbers3() {
        Assertions.assertEquals("Keine gueltige Eingabe", romanNumberTransformer.transformNumber(5000));
    }

}

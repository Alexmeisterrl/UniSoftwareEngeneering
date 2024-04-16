package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.text.DecimalFormat;

public class GermanFormatNumberTransformer implements NumberTransformer{
    @Override
    public String transformNumber(int number) {
        if (NumberTransformer.checkNumber(number) != null)
            return NumberTransformer.checkNumber(number);

        String result = new DecimalFormat("#.###").format(number);
        return result;
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}

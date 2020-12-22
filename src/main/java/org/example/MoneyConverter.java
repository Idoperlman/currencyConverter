package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoneyConverter {
    public static List<Double> convertNumbers(double exchangeRate, IDataHandler dataHandler) throws IOException, InterruptedException {
        List<Double> convertedNumbers = new ArrayList<>();
        double currNumber;
        while (dataHandler.hasData()) {
            currNumber  = dataHandler.getQuantity();
//            System.out.println("OG Number: " + currNumber);
//            System.out.println("Converted Number: " + (exchangeRate * currNumber));
            convertedNumbers.add((exchangeRate * currNumber));
        }
        return convertedNumbers;
    }
}

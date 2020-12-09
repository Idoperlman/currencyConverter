package org.example;

import java.io.IOException;

public class MoneyConverter {
    public static void convertNumbers(double exchangeRate, IDataHandler dataHandler) throws IOException, InterruptedException {
        double currNumber;
        while (dataHandler.hasData()) {
            currNumber  = dataHandler.readQuantity();
            System.out.println("OG Number: " + currNumber);
            System.out.println("Converted Number: " + (exchangeRate * currNumber));
        }
    }
}

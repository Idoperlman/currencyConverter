package org.example;


import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws Exception{
        ApiHandler api = new ApiHandler("https://currency-exchange.p.rapidapi.com",
                                            "b665056d09mshcad4d96d7b1f346p1b68a2jsn09ad49ece951");
        IDataHandler dataHandler = new FileHandler();
        List<Double> convertedNumbers;
        dataHandler.open(args[0]);
        double exchangeRate = api.exchangeRateCalc(dataHandler.getCurrencyName(), dataHandler.getCurrencyName());
        convertedNumbers = MoneyConverter.convertNumbers(exchangeRate, dataHandler);
        dataHandler.close();
        for (double currNum:
             convertedNumbers) {
            System.out.println("Converted Number: " + currNum);
        }
    }
}

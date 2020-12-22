package org.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.IOException;

public class AppTest{
    @Test
    public void checkApiReturnsExchangeRate(){
        ApiHandler api = new ApiHandler("https://currency-exchange.p.rapidapi.com",
                "b665056d09mshcad4d96d7b1f346p1b68a2jsn09ad49ece951");
        assertTrue(api.exchangeRateCalc("USD","ILS") > 0);
    }

    @Test
    public void checkFileOpening(){
        IDataHandler dataHandler = new FileHandler();
        dataHandler.open("C:\\Users\\idope\\Desktop\\work\\Idf2Tech\\converter\\test.txt");
        assertTrue(dataHandler.hasData());
        dataHandler.close();


    }

    @Test
    public void checkNumberConversion() throws IOException, InterruptedException {
        IDataHandler dataHandler = new FileHandler();
        double exchangeRate = 2.5;
        dataHandler.open("C:\\Users\\idope\\Desktop\\work\\Idf2Tech\\converter\\test.txt");
        Object[] actualValues = MoneyConverter.convertNumbers(exchangeRate,dataHandler).toArray();
        Object[] expectedValues = {5.0,10.0,25.0};
        assertArrayEquals(expectedValues,actualValues);
        dataHandler.close();
    }
}

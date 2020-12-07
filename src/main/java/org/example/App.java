package org.example;


import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws Exception{
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        String firstCurrency = input.next();
        String secondCurrency = input.next();
        String url = "https://currency-exchange.p.rapidapi.com/exchange?from="+firstCurrency+"&to="+secondCurrency+"&q=1.0";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-rapidapi-key", "b665056d09mshcad4d96d7b1f346p1b68a2jsn09ad49ece951")
                .header("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        double exchangeRate = Double.parseDouble(response.body());
        double currNumber;
        while (input.hasNext()) {
            currNumber  = Double.parseDouble(input.next());
            System.out.println("OG Number: "+ currNumber);
            System.out.println("Converted Number: "+ (exchangeRate * currNumber));
        }
        input.close();
    }
}

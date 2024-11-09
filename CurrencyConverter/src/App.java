package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import juice.jigsaw.Jhayson;

public class App {
    private static final String API_KEY = "1ec108a0e5d48f5691d9a796";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese la moneda de origen (ej. USD): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la moneda de destino (ej. EUR): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            try {
                double rate = getConversionRate(fromCurrency, toCurrency);
                double convertedAmount = amount * rate;
                System.out.printf("%.2f %s son %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        String urlStr = API_URL + fromCurrency + "/" + toCurrency;
        @SuppressWarnings("deprecation")
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Jhayson json = new Jhayson(response.toString());
            if (json.getString("result").equals("success")) {
                return json.getDouble("conversion_rate");
            } else {
                throw new Exception("No se pudo obtener la tasa de cambio");
            }
        }
    }
}
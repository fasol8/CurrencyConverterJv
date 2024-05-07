import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {

        Boolean running = true;

        do {
            HashMap<Integer, String> currencyCode = new HashMap<Integer, String>();

//        Currency Codes
            currencyCode.put(1, "MXN");
            currencyCode.put(2, "USD");
            currencyCode.put(3, "EUR");
            currencyCode.put(4, "BRL");
            currencyCode.put(5, "COP");
            currencyCode.put(6, "PEN");

            String fromCode, toCode;
            Integer to = 1, from = 1;
            double amount;

            Scanner sc = new Scanner(System.in);

            System.out.println("\nBienvenido al convertidor de divisas");
            do {
                System.out.println("\n1:MXN(Peso Mexicano)\t 2:USD(US Dollar)\t 3:EUR(Euro)\t 4:BRL(Real Brasilenio)\t 5:COL(Peso colombiano)\t 6:PEN(Sol Peruano)");
                System.out.print("Conversion de divisas DESDE: ");
                from = sc.nextInt();
            } while (from < 1 || from > 6);
            fromCode = currencyCode.get(from);

            do {
                System.out.println("\n1:MXN(Peso Mexicano)\t 2:USD(US Dollar)\t 3:EUR(Euro)\t 4:BRL(Real Brasilenio)\t 5:COL(Peso colombiano)\t 6:PEN(Sol Peruano)");
                System.out.print("Conversion de divisas A: ");
                to = sc.nextInt();
            } while (to < 1 || to > 6);
            toCode = currencyCode.get(to);

            System.out.print("\nCantidad a convertir: ");
            amount = sc.nextFloat();

            sendHttpGETRequest(fromCode, toCode, amount);

            System.out.println("Quieres otra conversion? \n1:SI \t2:NO ");
            if (sc.nextInt() != 1) {
                running = false;
            } else {
                running = true;
            }

        } while (running);

        System.out.println("Gracias por utilizar esto!!");
    }

    public static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {

        String API_KEY = "";
        String GET_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + fromCode + "/" + toCode + "/" + amount;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
//            System.out.println(obj.getDouble("conversion_result"));
            Double exchange = obj.getDouble("conversion_result");
            System.out.println("\n" + amount + " " + fromCode + " => " + exchange + " " + toCode + "\n");
        } else {
            System.out.println("ERROR");
        }

    }
}

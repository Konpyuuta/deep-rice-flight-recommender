package org.example.deeprice.commands.api;

import org.apache.hc.core5.http.NameValuePair;
import org.example.deeprice.commands.Command;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maurice Amon
 */
public class AmadeusFlightsAPICommand implements Command {

    private final String API_KEY = "zQXct7a3rkmZAQPmtvOOkwEA6TEyaJKA";

    private final String API_SECRET = "nnuYhl0VtBZatK1S";

    private String URI = "https://test.api.amadeus.com/v2/shopping/flight-offers?";

    private final String AUTH_URL = "https://test.api.amadeus.com/v1/security/oauth2/token";

    private URL urlRequest;
    private final String CHAR_SET = "utf-8";

    private final List<NameValuePair> PARAMETERS = new ArrayList<NameValuePair>(5);

    private Map<String, String> parameterMap = new HashMap<>();

    private final String REQUEST_METHOD = "GET";

    private final String REQUEST_METHOD_TOKEN_ACCESS = "POST";

    private final String COUNTRY_ABBREVIATION = "ch";

    private final String LANGUAGE_ABBREVIATION = "de";

    private final String CURRENCY_ABBREVIATION = "CHF";

    private final String AMOUNT_OF_ADULTS = "1";

    private String response;

    public AmadeusFlightsAPICommand() {
        //initializeParameters();
    }

    public String requestAccessToken() {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(AUTH_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(REQUEST_METHOD_TOKEN_ACCESS);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String message = "grant_type=client_credentials"
                    + "&client_id=" + API_KEY
                    + "&client_secret=" + API_SECRET;

            try (OutputStream os = connection.getOutputStream()) {
                os.write(message.getBytes());
                os.flush();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JSONObject tokenJson = new JSONObject(response.toString());
        return tokenJson.getString("access_token");
    }

    public void searchFlights() {

        try {
            String accessToken = requestAccessToken();
            String URL = "https://test.api.amadeus.com/v2/shopping/flight-offers?";
            URL url = new URL(setParameters(URL));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();
            response = content.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void execute() {
        //searchFlights("ZRH", "DBX", "2025-06-01");
        searchFlights();
    }


    private void initializeParameters() {
        parameterMap.put("departure_id", "ZRH");
        parameterMap.put("arrival_id", "AUS");
        parameterMap.put("gl", COUNTRY_ABBREVIATION);
        parameterMap.put("hl", LANGUAGE_ABBREVIATION);
        parameterMap.put("currency", CURRENCY_ABBREVIATION);
    }

    public void initializeParameter(String key, String value) {
        parameterMap.put(key, value);
    }

    private String setParameters(String URI) {
        for (String key : parameterMap.keySet()) {
            URI += "&" + key + "=" + parameterMap.get(key);
        }
        return URI;
    }

    public String getResponse() {
        return response;
    }
}

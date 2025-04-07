package org.example.deeprice.commands;


import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleFlightsApiRequest implements Command {

    private final String API_KEY = "";

    private String URI = "https://serpapi.com/playground?engine=google_flights";

    private URL urlRequest;
    private final String CHAR_SET = "utf-8";

    private final List<NameValuePair> PARAMETERS = new ArrayList<NameValuePair>(5);

    private HttpURLConnection connection;

    private Map<String, String> parameterMap = new HashMap<>();

    private final String REQUEST_METHOD = "GET";

    private final String COUNTRY_ABBREVIATION = "ch";

    private final String LANGUAGE_ABBREVIATION = "de";

    private final String CURRENCY_ABBREVIATION = "CHF";

    private final String AMOUNT_OF_ADULTS = "1";

    public GoogleFlightsApiRequest() {
        initializeParameters();
        setParameters();
    }

    @Override
    public void execute() {
        try {
            urlRequest = new URL(URI);
            connection = (HttpURLConnection) urlRequest.openConnection();
            connection.setRequestMethod(REQUEST_METHOD);
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("GET request failed.");
            }
            connection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void initializeParameters() {
        parameterMap.put("departure_id", "ZRH");
        parameterMap.put("arrival_id", "AUS");
        parameterMap.put("gl", COUNTRY_ABBREVIATION);
        parameterMap.put("hl", LANGUAGE_ABBREVIATION);
        parameterMap.put("currency", CURRENCY_ABBREVIATION);
    }

    private void setParameters() {
        for (String key : parameterMap.keySet()) {
            URI += "&" + key + "=" + parameterMap.get(key);
        }
    }
}

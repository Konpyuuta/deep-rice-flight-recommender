package org.example.deeprice.commands;


import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class SkyScannerApiRequest implements Command {

    private final String API_KEY = "";

    private final String URI = "https://partners.api.skyscanner.net/apiservices/v3/flights/live/search/create";

    private final String CHAR_SET = "UTF-8";

    private final List<NameValuePair> PARAMETERS = new ArrayList<NameValuePair>(5);

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private HttpPost httpPost;

    private final String COUNTRY_ABBREVIATION = "CH";

    private final String LANGUAGE_ABBREVIATION = "de-CH";

    private final String CURRENCY_ABBREVIATION = "CHF";

    private final String AMOUNT_OF_ADULTS = "1";

    public SkyScannerApiRequest() {
        this.httpPost = new HttpPost(URI);
    }

    @Override
    public void execute() {
        setParameters();
        httpPost.setEntity(new UrlEncodedFormEntity(PARAMETERS, Charset.forName(CHAR_SET)));
        try {
            ClassicHttpResponse response = (ClassicHttpResponse) httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println(entity.getContent().toString());
            String httpBody = StreamUtils.copyToString(entity.getContent(), Charset.defaultCharset());
            System.out.println(httpBody);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setParameters() {
        PARAMETERS.add(new BasicNameValuePair("market", COUNTRY_ABBREVIATION));
        PARAMETERS.add(new BasicNameValuePair("locale", LANGUAGE_ABBREVIATION));
        PARAMETERS.add(new BasicNameValuePair("currency", CURRENCY_ABBREVIATION));
        //PARAMETERS.add(new BasicNameValuePair("queryLegs", "..."));
        PARAMETERS.add(new BasicNameValuePair("adults", AMOUNT_OF_ADULTS));
        PARAMETERS.add(new BasicNameValuePair("origin", "ZRH"));
        PARAMETERS.add(new BasicNameValuePair("destination", "DBX"));
        PARAMETERS.add(new BasicNameValuePair("departureDate ", "2025-06-06"));
    }
}

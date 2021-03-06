package org.ubicomp.tests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SupportHTTPClient {
    private static Log log = LogFactory.getLog(SupportHTTPClient.class);

    private HttpClient httpclient;

    public SupportHTTPClient() {
        httpclient = new DefaultHttpClient();
    }

    public void request(int port, String document, String... params) throws Exception {
        String uri = "http://localhost:" + port + "/" + document;
        URI requestURI = withQuery(new URI(uri), params);
        log.info("Requesting from URI " + requestURI);
        HttpGet httpget = new HttpGet(requestURI);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = null;
        try {
            responseBody = httpclient.execute(httpget, responseHandler);
        } catch (IOException e) {
            throw new RuntimeException("Error executing request:" + e.getMessage());
        }
    }

    public static URI withQuery(URI uri, String... params) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (int i = 0; i < params.length; i += 2) {
            String key = params[i];
            String val = i + 1 < params.length ? params[i + 1] : "";
            map.put(key, val);
        }
        return withQuery(uri, map);
    }

    public static URI withQuery(URI uri, Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        char separator = '?';
        for (Map.Entry<String, String> param : params.entrySet()) {
            query.append(separator);
            separator = '&';
            try {
                query.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                if (param.getValue().length() != 0) {
                    query.append('=');
                    query.append(URLEncoder.encode(param.getValue(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return URI.create(uri.toString() + query.toString());
    }

    public static void main(String args[]) throws Exception {
    	BasicConfigurator.configure();
    	SupportHTTPClient client = new SupportHTTPClient();

    	client.request(8085, "sendevent", "stream", "HumidityEvent", "humidity", "0.50");
    	client.request(8085, "sendevent", "stream", "HumidityEvent", "humidity", "0.40");
    	client.request(8085, "sendevent", "stream", "HumidityEvent", "humidity", "0.30");
    	client.request(8085, "sendevent", "stream", "HumidityEvent", "humidity", "0.20");
    	client.request(8085, "sendevent", "stream", "HumidityEvent", "humidity", "0.10");
    	client.request(8085, "sendevent", "stream", "LuminosityEvent", "luminosity", "0.50");
    	client.request(8085, "sendevent", "stream", "LuminosityEvent", "luminosity", "0.60");
    	client.request(8085, "sendevent", "stream", "LuminosityEvent", "luminosity", "0.70");
    	client.request(8085, "sendevent", "stream", "LuminosityEvent", "luminosity", "0.80");
    	client.request(8085, "sendevent", "stream", "LuminosityEvent", "luminosity", "0.90");
    	client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "50");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "60");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "70");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "80");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "90");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "100");
        client.request(8085, "sendevent", "stream", "TemperatureEvent", "temperature", "110");
    }


}

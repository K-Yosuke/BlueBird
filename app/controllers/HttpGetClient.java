package controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class HttpGetClient {
    public static void executeGet() {
        try {
            URL url = new URL("http://www.yahoo.co.jp/");


            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try {
                        InputStreamReader isr = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
                        BufferedReader reader = new BufferedReader(isr);
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        Map m = connection.getHeaderFields();
                        for (Object key : m.keySet()) {
                            List l = (List) m.get(key);
                            System.out.println(key + "=" + l.toString());
                        }
                    } finally {
                        if (connection != null) {
                            connection.disconnect();
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

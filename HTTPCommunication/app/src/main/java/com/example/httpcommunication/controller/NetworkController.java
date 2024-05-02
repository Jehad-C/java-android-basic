package com.example.httpcommunication.controller;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class NetworkController{
    private final Activity activity;
    private final URL mUrl;

    public NetworkController(Activity activity, URL url) {
        this.activity = activity;
        this.mUrl = url;
    }

    public void execute(NetworkService service) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            String response = fetch(this.mUrl);
            activity.runOnUiThread(() -> service.onResponseReceived(response));
        });

        executorService.shutdown();
    }

    private String fetch(URL url) {
        try {
            HttpURLConnection connection = this.getConnection(url);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readResponse(connection);
            } else {
                throw new IOException("Failed to retrieve data from URL: " + url +
                        ". Server returned HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to connect to URL: " + url +
                    ". Reason: " + e.getMessage());
        }
    }

    private HttpURLConnection getConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.connect();
        return connection;
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        return reader.lines().collect(Collectors.joining());
    }
}

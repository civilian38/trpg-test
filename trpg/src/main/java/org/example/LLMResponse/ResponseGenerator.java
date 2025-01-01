package org.example.LLMResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class ResponseGenerator {
    public String TestContext() {
        JSONObject context = new JSONObject();
        context.put("model", "claude-3-5-haiku-latest");
        context.put("max_tokens", 50);

        JSONArray messages = new JSONArray();

        JSONObject singleMessage = new JSONObject();
        singleMessage.put("role", "user");
        singleMessage.put("content", "What is What is latin for Ant? (A) Apoidea, (B) Rhopalocera, (C) Formicidae. Explain very shortly");

        messages.put(singleMessage);
        context.put("messages", messages);

        return context.toString();
    }
    public String ResponseTest() {
        try {
            // setting URL
            String urlString = "https://api.anthropic.com/v1/messages";
            URL url = new URL(urlString);

            // setting HttpURLConnection Object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("x-api-key", new APIKeyGetter().getAPIKeyByDotenv());
            connection.setRequestProperty("anthropic-version", "2023-06-01");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // getting context
            String context = TestContext();

            // send request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = context.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                // get response in String
                StringBuilder responseString = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    responseString.append(responseLine.trim());
                }

                br.close();
                connection.disconnect();

                JSONObject response = new JSONObject(responseString.toString());
                JSONArray messages = response.getJSONArray("content");
                JSONObject message = messages.getJSONObject(0);
                return message.getString("text");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

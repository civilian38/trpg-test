package org.example.LLMResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseGenerator {
    private HttpURLConnection createConnection() throws IOException {
        URL url = new URL(ResponseSettings.API_URL.getValue());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("x-api-key", new APIKeyGetter().getAPIKeyByDotenv());
        connection.setRequestProperty("anthropic-version", ResponseSettings.API_VERSION.getValue());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        return connection;
    }

    private void sendRequest(HttpURLConnection connection, String context) throws IOException {
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = context.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
    }

    private String parseResponse(HttpURLConnection connection) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseString = br.lines().reduce("", String::concat);
            JSONObject response = new JSONObject(responseString);
            JSONArray messages = response.getJSONArray("content");
            return messages.getJSONObject(0).getString("text");
        } finally {
            connection.disconnect();
        }
    }

    private String buildTestContext() {
        JSONObject context = new JSONObject();
        context.put("model", ResponseSettings.MODEL_NAME.getValue());
        context.put("max_tokens", 150);
        context.put("system", buildTestSystemMessage());
        context.put("temperature", 0.2);

        JSONArray messages = new JSONArray();
        JSONObject singleMessage = new JSONObject();
        singleMessage.put("role", "user");
        singleMessage.put("content", "누나, 햄버거 사주세요!");
        messages.put(singleMessage);

        context.put("messages", messages);
        return context.toString();
    }

    private String buildTestSystemMessage() {
        /*
            JSONArray systemMessages = new JSONArray();
            JSONObject systemMessage = new JSONObject();

            systemMessage.put("role", "system");
            systemMessage.put("content", "당신은 이제부터 한 소녀를 연기합니다. 당신은 봉사활동에 참여하고 있습니다. 다만 원해서 참여한건 아니고, 경범죄를 저지르고 사회봉사활동 처분을 받았네요. 딱히 열심히 하고싶은 마음은 없습니다.");
            systemMessages.put(systemMessage);
        */
        return "당신은 이제부터 한 소녀를 연기합니다. 당신은 봉사활동에 참여하고 있습니다. 다만 원해서 참여한건 아니고, 경범죄를 저지르고 사회봉사활동 처분을 받았네요. 딱히 열심히 하고싶은 마음은 없습니다.";
    }

    public String ResponseTest() {
        try {
            String context = buildTestContext();
            HttpURLConnection connection = createConnection();
            sendRequest(connection, context);
            return parseResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
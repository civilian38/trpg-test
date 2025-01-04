package org.example.LLMResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.example.GameAssets.Character.BaseHuman;
import org.example.GameAssets.GameHandler.Player;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseGenerator {
    private static HttpURLConnection createConnection() throws IOException {
        URL url = new URL(ResponseSettings.API_URL.getValue());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("x-api-key", new APIKeyGetter().getAPIKeyByDotenv());
        connection.setRequestProperty("anthropic-version", ResponseSettings.API_VERSION.getValue());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        return connection;
    }

    private static void sendRequest(HttpURLConnection connection, String context) throws IOException {
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = context.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
    }

    private static String parseResponse(HttpURLConnection connection) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseString = br.lines().reduce("", String::concat);
            JSONObject response = new JSONObject(responseString);
            JSONArray messages = response.getJSONArray("content");
            return messages.getJSONObject(0).getString("text");
        } finally {
            connection.disconnect();
        }
    }

    public static String buildTestContext() {
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

    private static String buildTestSystemMessage() {
        /*
            JSONArray systemMessages = new JSONArray();
            JSONObject systemMessage = new JSONObject();

            systemMessage.put("role", "system");
            systemMessage.put("content", "당신은 이제부터 한 소녀를 연기합니다. 당신은 봉사활동에 참여하고 있습니다. 다만 원해서 참여한건 아니고, 경범죄를 저지르고 사회봉사활동 처분을 받았네요. 딱히 열심히 하고싶은 마음은 없습니다.");
            systemMessages.put(systemMessage);
        */
        return "당신은 이제부터 한 소녀를 연기합니다. 당신은 봉사활동에 참여하고 있습니다. 다만 원해서 참여한건 아니고, 경범죄를 저지르고 사회봉사활동 처분을 받았네요. 딱히 열심히 하고싶은 마음은 없습니다.";
    }

    public static String ResponseTest() {
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

    public static String buildCharacterSystemMessage(BaseHuman speaker, BaseHuman player) {
        StringBuilder context = new StringBuilder();
        context.append(ResponseSettings.INITIAL_INSTRUCTION.getValue()).append('\n');
        context.append(ResponseSettings.GAME_BACKGROUND.getValue()).append('\n');
        context.append(ResponseSettings.CHARACTER_SCRIPT_DESCRIPTION.getValue()).append('\n');
        context.append(speaker.showStatus()).append('\n');
        context.append(ResponseSettings.CHARACTER_SCRIPT_USER_DESCRIPTION.getValue()).append('\n');
        context.append(player.showStatus()).append('\n');
        return context.toString();
    }

    public static String buildCharacterContext(BaseHuman speaker, BaseHuman player, String user_input) throws IOException {
        JSONObject context = new JSONObject();
        context.put("model", ResponseSettings.MODEL_NAME.getValue());
        context.put("max_tokens", 250);
        context.put("system", buildCharacterSystemMessage(speaker, player));
        context.put("temperature", 0.2);

        JSONArray messages = new JSONArray();
        JSONObject singleMessage = new JSONObject();
        singleMessage.put("role", "user");
        singleMessage.put("content", user_input);
        messages.put(singleMessage);

        context.put("messages", messages);
        return context.toString();
    }

    static public String characterResponseGenerator(BaseHuman speaker, BaseHuman player, String user_input) throws IOException {
        try {
            String context = buildCharacterContext(speaker, player, user_input);
            HttpURLConnection connection = createConnection();
            sendRequest(connection, context);
            return parseResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
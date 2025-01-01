package org.example.LLMResponse;

public enum ResponseSettings {
    API_URL("https://api.anthropic.com/v1/messages"),
    API_VERSION("2023-06-01"),
    MODEL_NAME("claude-3-5-haiku-latest");

    private final String value;

    ResponseSettings(String s) {
        value = s;
    }

    String getValue() {
        return value;
    }
}

package org.example.LLMResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class APIKeyGetter {
    String getAPIKeyByDotenv(){
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("CLAUDE_API_KEY");
    }
}

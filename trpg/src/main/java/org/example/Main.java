package org.example;
import org.example.GameAssets.GameHandler.Manager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Manager gameManager = new Manager();
        gameManager.initPlayer();
        System.out.println(gameManager.getAllCharacterStatusForTest());
    }
}
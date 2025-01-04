package org.example;
import org.example.GameAssets.Character.BaseHuman;
import org.example.GameAssets.Character.CharacterInformation;
import org.example.GameAssets.GameHandler.Player;
import org.example.LLMResponse.ResponseGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseHuman Lucy = new BaseHuman(CharacterInformation.LUCY_INFO);
        System.out.println("==========================");
        System.out.println(Lucy.showStatusForPlayer());
        System.out.println("==========================");

        BaseHuman player = Player.generator();
        System.out.println("==========================");
        System.out.println(player.showStatusForPlayer());
        System.out.println("==========================");

        Scanner scanner = new Scanner(System.in);
        System.out.println("루시에게 뭐라고 말하시겠습니까?");
        String user_input = scanner.nextLine();
        System.out.println(ResponseGenerator.characterResponseGenerator(Lucy, player, user_input));
    }
}
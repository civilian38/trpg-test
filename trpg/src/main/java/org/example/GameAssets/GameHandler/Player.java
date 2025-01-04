package org.example.GameAssets.GameHandler;

import org.example.GameAssets.Character.BaseHuman;
import java.util.Scanner;

public class Player {
    public static BaseHuman generator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력하세요");
        String name = scanner.nextLine();
        System.out.println("나이를 입력하세요");
        String ageString = scanner.nextLine();
        while( !ageString.matches("\\d+")){
            System.out.println("잘못된 입력입니다. 자연수를 입력해주세요");
            ageString = scanner.nextLine();
        }
        int age = Integer.parseInt(ageString);
        System.out.println("배경을 입력해주세요");
        String background = scanner.nextLine();
        return new BaseHuman(name, age, background);
    }
}

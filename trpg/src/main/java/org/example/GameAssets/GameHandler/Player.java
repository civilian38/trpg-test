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
        System.out.println("남성이면 m, 여성이면 f를 입력하세요");
        String gender = String.valueOf(scanner.nextLine().charAt(0));
        while(!("mMfF".contains(gender))){
            System.out.println("잘못된 입력입니다. m 또는 f를 입력해주세요");
            gender = String.valueOf(scanner.nextLine().charAt(0));
        }
        int age = Integer.parseInt(ageString);
        System.out.println("배경을 입력해주세요");
        String background = scanner.nextLine();
        boolean isMale = gender.equals("m") || gender.equals("M");
        return new BaseHuman(name, age, isMale, background);
    }
}

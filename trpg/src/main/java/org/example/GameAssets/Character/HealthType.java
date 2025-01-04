package org.example.GameAssets.Character;

public enum HealthType {
    DEAD("사망"),
    VULNERABLE("빈사"),
    INJURED("부상"),
    NORMAL("정상"),
    OVERHEAT("과열");

    private String message;
    HealthType(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}

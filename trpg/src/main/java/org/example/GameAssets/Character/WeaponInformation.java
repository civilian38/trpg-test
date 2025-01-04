package org.example.GameAssets.Character;

public enum WeaponInformation {
    Libereator(
            "리버레이터",
            120,
            "끝내주는 저격총입니다.",
            true
    ), Queen (
            "여왕폐하",
            80,
            "암살에 특화된 권총입니다. 최고급 소음기가 장착되어 있습니다",
            true
    ), Lexington (
            "렉싱턴",
            20,
            "평범한 권총입니다",
            true
    );

    private String name;
    private int damage;
    private String description;
    private boolean isLongRange;
    WeaponInformation(String wName, int wDamage, String wDescription, boolean wIsLongRange){
        name = wName;
        damage = wDamage;
        description = wDescription;
        isLongRange = wIsLongRange;
    }
    public String getName(){
        return name;
    }
    public int getDamage(){
        return damage;
    }
    public String getDescription(){
        return description;
    }
    public boolean isLongRange(){
        return isLongRange;
    }
}

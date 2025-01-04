package org.example.GameAssets.Character;

public enum WeaponInformation {
    WEAPON_LIBERATOR(
            "리버레이터",
            120,
            "끝내주는 저격총입니다.",
            true
    ), WEAPON_HER_MAJESTY (
            "여왕폐하",
            40,
            "소음기가 장착된 암살에 특화된 권총",
            true
    ), WEAPON_LEXINGTON (
            "렉싱턴",
            20,
            "평범한 권총입니다",
            true
    ), WEAPON_KONGOU (
            "콩고",
            35,
            "세련된 디자인의 준수한 권총",
            true
    ), WEAPON_STINGER (
            "스팅어",
            30,
            "가볍고 치명적인 한손검",
            false
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

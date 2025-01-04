package org.example.GameAssets.Character;

public class Weapon {
    boolean isNull;
    String name;
    int damage;
    String description;
    boolean isLongRange;

    Weapon(WeaponInformation wi){
        if(wi == null){
            isNull = true;
            return;
        }
        isNull = false;
        name = wi.getName();
        damage = wi.getDamage();
        description = wi.getDescription();
        isLongRange = wi.isLongRange();
    }

    String getInfo() {
        if(isNull){
            return "없음";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("(피해: ").append(damage).append("/").append(isLongRange ? "원거리": "근거리").append(") - ").append(description);
        return sb.toString();
    }
}

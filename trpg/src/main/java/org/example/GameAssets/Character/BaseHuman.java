package org.example.GameAssets.Character;

public class BaseHuman {
    final String name;
    final String background;
    int age;
    int credits;
    int reputation;
    CharacterEquipmentSlot equipments;
    Weapon primaryWeapon;
    Weapon secondaryWeapon;

    public BaseHuman(CharacterInformation info){
        this.name = info.getName();
        this.background = info.getBackground();
        this.age = info.getAge();
        this.credits = info.getInitialCredits();
        this.reputation = info.getReputation();
        this.equipments = new CharacterEquipmentSlot();
        this.primaryWeapon = new Weapon(info.getPrimary());
        this.secondaryWeapon = new Weapon(info.getSecondary());
    }

    public BaseHuman(String cName, int cAge, String cBackground){
        this.name = cName;
        this.background = cBackground;
        this.age = cAge;
        this.credits = 0;
        this.reputation = 0;
        this.equipments = new CharacterEquipmentSlot();
        this.primaryWeapon = new Weapon(null);
        this.secondaryWeapon = new Weapon(null);
    }

    public String getReputationStatus() {
        return (reputation < -100) ? "길거리의 재앙" :
               (reputation < -50) ? "뒷골목의 황태자" :
               (reputation < 0) ? "양아치" :
               (reputation < 20) ? "그저그런 용병":
               (reputation < 50) ? "유망주":
               (reputation < 80) ? "베테랑":
               (reputation < 100) ? "거물":
               "나이트 시티의 전설";
    }

    public String showStatus(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("이름: ").append(name).append("\n");
        stringBuilder.append("나이: ").append(age).append("\t | \t").append("자금: ").append(credits).append("\t | \t").append("명성: ").append(getReputationStatus()).append("\n");
        stringBuilder.append("주무장: ").append(primaryWeapon.getInfo()).append("\n");
        stringBuilder.append("부무장: ").append(secondaryWeapon.getInfo()).append("\n");
        stringBuilder.append("- - - - - - - - - - - - - - - -\n");
        stringBuilder.append(background);
        return stringBuilder.toString();
    }
}

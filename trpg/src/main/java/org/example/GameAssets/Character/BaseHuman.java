package org.example.GameAssets.Character;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BaseHuman {
    final int characterId;
    final String name;
    final String background;
    final String accentInstruction;
    final GenderType gender;
    int age;
    int credits;
    int reputation;
    HashMap<Integer, CharacterRelationship> relationships;  // key: characterID, value: this character's opinion for ID.
    CharacterEquipmentSlot equipments;
    Weapon primaryWeapon;
    Weapon secondaryWeapon;
    HealthType health;

    public BaseHuman(CharacterInformation info){   // npc constructor
        this.characterId = info.getId();
        this.name = info.getName();
        this.background = info.getBackground();
        this.age = info.getAge();
        this.credits = info.getInitialCredits();
        this.reputation = info.getReputation();
        this.gender = info.getGender();
        this.equipments = new CharacterEquipmentSlot(info.getEquipments());
        this.primaryWeapon = new Weapon(info.getPrimary());
        this.secondaryWeapon = new Weapon(info.getSecondary());
        this.health = info.getHealth();
        accentInstruction = info.getAccentInstruction();
        relationships = new HashMap<>();
        for(CharacterRelationship relationship: info.getRelationships()){
            this.relationships.put(relationship.getTargetID(), relationship);
        }
    }

    public BaseHuman(String cName, int cAge, boolean isMale, String cBackground){   // player constructor
        this.characterId = CharacterSettings.PlayerId;
        this.name = cName;
        this.background = cBackground;
        this.age = cAge;
        this.credits = 0;
        this.reputation = 0;
        this.gender = (isMale) ? GenderType.MALE : GenderType.FEMALE;
        this.equipments = new CharacterEquipmentSlot(new EquipmentInformation[]{null, null, null});
        this.primaryWeapon = new Weapon(null);
        this.secondaryWeapon = new Weapon(null);
        this.health = HealthType.NORMAL;
        accentInstruction = "";
        this.relationships = new HashMap<>();
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

    public void initRelationship(Set<Integer> characters){
        for(int id: characters){
            if(!relationships.containsKey(id) && id != characterId){
                relationships.put(id, new CharacterRelationship(id));
            }
        }
    }

    public String getName(){
        return name;
    }

    public String showStatus(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("이름: ").append(name).append("/").append(
                "건강상태: ").append(health.getMessage()).append("/").append(
                age).append("세/").append(
                (gender == GenderType.MALE) ? "남성/" : "여성/").append(
                "자금: ").append(credits).append("/").append(
                "명성: ").append(getReputationStatus()).append("\n");
        if(primaryWeapon.isNull){
            stringBuilder.append("무장 없음").append("\n");
        } else {
            stringBuilder.append("주무장: ").append(primaryWeapon.getInfo()).append("\n");
            if(!secondaryWeapon.isNull){
                stringBuilder.append("부무장: ").append(secondaryWeapon.getInfo()).append("\n");
            }
        }
        stringBuilder.append(equipments.equipmentsDescription());

        stringBuilder.append("배경: ").append(background);
        stringBuilder.append("다음과 같은 말투를 구사해봐: ").append(accentInstruction).append('\n');
        stringBuilder.append("단, 위의 말투는 참고만 하고, 실제 대화에 사용은 자제해.").append('\n');
        return stringBuilder.toString();
    }

    public String showStatusForPlayer(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("이름: ").append(name).append("\t | \t").append(
                age).append("세 (").append((gender == GenderType.MALE) ? "남성)" : "여성)").append("\n");
        stringBuilder.append("건강상태: ").append(health.getMessage()).append("\t | \t").append(
                "자금: ").append(credits).append("\t | \t").append(
                "명성: ").append(getReputationStatus()).append("\n");
        if(primaryWeapon.isNull){
            stringBuilder.append("무장 없음").append("\n");
        } else {
            stringBuilder.append("주무장: ").append(primaryWeapon.getInfo()).append("\n");
            if(!secondaryWeapon.isNull){
                stringBuilder.append("부무장: ").append(secondaryWeapon.getInfo()).append("\n");

            }
        }
        stringBuilder.append(equipments.equipmentsDescription()).append("\n");
        stringBuilder.append("- - - - - - - - - - - - - - - -\n");
        stringBuilder.append(background);
        return stringBuilder.toString();
    }

    public String showStatusForTest(HashMap<Integer, BaseHuman> characterData){
        String baseStatus = showStatusForPlayer();
        StringBuilder stringBuilder = new StringBuilder();
        for(CharacterRelationship relation: relationships.values()){
            if(relation.isKnowingTarget()){
                stringBuilder.append(characterData.get(relation.getTargetID()).getName()).append(" : ").append(relation.showData()).append('\n');
            } else {
                stringBuilder.append(characterData.get(relation.getTargetID()).getName()).append(" : ").append("모름").append('\n');
            }
        }
        return baseStatus + '\n' + stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n")).toString();
    }
}

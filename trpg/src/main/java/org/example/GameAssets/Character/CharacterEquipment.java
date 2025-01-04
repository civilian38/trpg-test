package org.example.GameAssets.Character;

public class CharacterEquipment {
    private String equipmentName;
    private String equipmentDescription;
    private int equipmentDurability;

    CharacterEquipment(String name, String description, int durability){
        this.equipmentName = name;
        this.equipmentDescription = description;
        this.equipmentDurability = durability;
    }
    CharacterEquipment(String name, String description) {
        this(name, description, CharacterSettings.MAX_EQUIPMENT_DURABILITY);
    }

    public String getEquipmentName() {
        return equipmentName;
    }
}

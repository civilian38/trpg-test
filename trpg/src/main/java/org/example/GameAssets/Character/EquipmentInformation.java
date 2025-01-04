package org.example.GameAssets.Character;

public enum EquipmentInformation {
    EQUIPMENT_ARASAKA_CYBERDECK(
            "아라사카 사이버덱",
            "은신과 잠입에 특화된 해킹 툴"
    );

    private String equipmentName;
    private String equipmentDescription;
    EquipmentInformation(String name, String description){
        this.equipmentName = name;
        this.equipmentDescription = description;
    }

    public String getEquipmentName() {
        return equipmentName;
    }
    public String getEquipmentDescription() {
        return equipmentDescription;
    }
}

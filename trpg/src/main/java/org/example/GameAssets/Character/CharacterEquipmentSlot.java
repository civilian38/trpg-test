package org.example.GameAssets.Character;

import java.util.ArrayList;

public class CharacterEquipmentSlot {
    private ArrayList<CharacterEquipment> equipments = new ArrayList<>();

    public boolean addEquipment(CharacterEquipment equipment){
        if(equipments.size() < CharacterSettings.MAX_EQUIPMENT_SLOTS){
            equipments.add(equipment);
            return true;
        }
        return false;
    }

    public boolean removeEquipment(String equipmentName){
        for(CharacterEquipment ce: equipments){
            if(ce.getEquipmentName().equals(equipmentName)){
                equipments.remove(ce);
                return true;
            }
        }
        return false;
    }
}

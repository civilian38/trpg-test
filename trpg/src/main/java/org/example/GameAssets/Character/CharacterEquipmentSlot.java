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

    public String equipmentsDescription(){
        StringBuilder sb = new StringBuilder();
        if(equipments.size() == 0){
            sb.append("장착된 장비 없음");
        } else {
            int index = 1;
            for(CharacterEquipment ce: equipments){
                sb.append("장비 ").append(index++).append(": ").append(ce.getEquipmentDescription()).append("\n");
            }
        }
        return sb.toString();
    }
}

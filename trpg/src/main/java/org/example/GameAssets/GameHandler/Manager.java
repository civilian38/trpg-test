package org.example.GameAssets.GameHandler;

import org.example.GameAssets.Character.BaseHuman;
import org.example.GameAssets.Character.CharacterInformation;
import org.example.GameAssets.Character.CharacterSettings;

import java.util.HashMap;

public class Manager {
    public HashMap<Integer, BaseHuman> characterMap = new HashMap<>();
    Player player;
    public Manager(){
        int id = 1;
        for(CharacterInformation ci: CharacterInformation.values()){
            characterMap.put(id, new BaseHuman(ci, id));
            id++;
        }
    }

    public void initPlayer() {
        BaseHuman player = Player.generator();
        characterMap.put(CharacterSettings.PlayerId, player);
    }

    public String getAllCharacterStatus() {
        StringBuilder sb = new StringBuilder();
        for(BaseHuman bh: characterMap.values()){
            sb.append(bh.showStatusForPlayer()).append("\n");
            sb.append("==========================").append("\n");
        }
        return sb.toString();
    }
}

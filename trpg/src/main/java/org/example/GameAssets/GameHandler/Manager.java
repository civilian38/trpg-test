package org.example.GameAssets.GameHandler;

import org.example.GameAssets.Character.BaseHuman;
import org.example.GameAssets.Character.CharacterInformation;
import org.example.GameAssets.Character.CharacterSettings;

import java.util.HashMap;

public class Manager {
    public HashMap<Integer, BaseHuman> characterMap = new HashMap<>();
    Player player;
    public Manager(){
        for(CharacterInformation ci: CharacterInformation.values()){
            int id = ci.getId();
            characterMap.put(id, new BaseHuman(ci));
        }
    }

    public void initPlayer() {
        BaseHuman player = Player.generator();
        characterMap.put(CharacterSettings.PlayerId, player);

        // no more characters
        for(BaseHuman bh: characterMap.values()){
            bh.initRelationship(characterMap.keySet());
        }
    }

    public String getAllCharacterStatus() {
        StringBuilder sb = new StringBuilder();
        for(BaseHuman bh: characterMap.values()){
            sb.append(bh.showStatusForPlayer()).append("\n");
            sb.append("==========================").append("\n");
        }
        return sb.toString();
    }

    public String getAllCharacterStatusForTest() {
        StringBuilder sb = new StringBuilder();
        for(BaseHuman bh: characterMap.values()){
            sb.append(bh.showStatusForTest(characterMap)).append("\n");
            sb.append("==========================").append("\n");
        }
        return sb.toString();
    }
}

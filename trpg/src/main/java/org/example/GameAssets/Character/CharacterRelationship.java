package org.example.GameAssets.Character;

public class CharacterRelationship {
    int likeability;
    int targetID;
    CharacterRelationshipType relationshipType;
    String opinion;

    CharacterRelationship(int likeability, int targetID, CharacterRelationshipType relationshipType, String opinion) {
        this.likeability = likeability;
        this.targetID = targetID;
        this.relationshipType = relationshipType;
        this.opinion = opinion;
    }

    CharacterRelationship(int targetID){
        this.likeability = 0;
        this.relationshipType = CharacterRelationshipType.RELATIONSHIP_NEUTRAL;
        this.targetID = targetID;
        this.opinion = null;
    }

    boolean isKnowingTarget() {
        return this.opinion != null;
    }

    int getTargetID() {
        return this.targetID;
    }

    String showData() {
        return "호감도: " + likeability + "(" + relationshipType.getRelationshipName() + ") - " + opinion;
    }
}

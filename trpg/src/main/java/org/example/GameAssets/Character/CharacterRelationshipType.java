package org.example.GameAssets.Character;

public enum CharacterRelationshipType {
    RELATIONSHIP_NEMESIS("원수"),
    RELATIONSHIP_ENEMY("적"),
    RELATIONSHIP_RIVAL("적대"),
    RELATIONSHIP_TENSE("불화"),
    RELATIONSHIP_NEUTRAL("무관심"),
    RELATIONSHIP_ALLIANCE("협력"),
    RELATIONSHIP_PARTNER("동맹"),
    RELATIONSHIP_FRIEND("친구"),
    RELATIONSHIP_LOVER("연인");

    private final String relationshipName;
    CharacterRelationshipType(String message) {
        this.relationshipName = message;
    }

    public String getRelationshipName() {
        return relationshipName;
    }
}

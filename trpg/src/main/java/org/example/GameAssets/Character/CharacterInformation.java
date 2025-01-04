package org.example.GameAssets.Character;

public enum CharacterInformation {
    Lucy(
            "루시",
            "루시(Lucyna Kushinada)는 아라사카(Arasaka)의 비밀 프로젝트에서 훈련받은 넷러너(Netrunner)로, 어린 시절부터 혹독한 환경 속에서 해킹과 사이버 전투 기술을 익히며 성장했습니다. 그녀는 자유를 잃은 삶에서 벗어나고자 나이트 시티로 탈출했으며, 과거의 트라우마와 억압된 기억을 안고 살아가면서도 더 나은 미래를 꿈꾸는 인물입니다",
            20,
            2000,
            51,
            HealthType.NORMAL,
            WeaponInformation.Lexington,
            null,
            "처음 보는 얼굴이네. 꼬치꼬치 캐묻진 않을게, 여긴 나이트 시티잖아. 넌 진짜 빈틈 투성이야. 교육이 필요하겠어."
    );

    private String name;
    private String background;
    private int age;
    private int initialCredits;
    private int reputation;
    private HealthType health;
    private WeaponInformation primary;
    private WeaponInformation secondary;
    private String accentInstruction;
    CharacterInformation(String cName, String cBackground, int cAge, int cCredits, int cReputation, HealthType cHealthType, WeaponInformation wPrimary, WeaponInformation wSecondary, String accentInstruction){
        this.name = cName;
        this.background = cBackground;
        this.age = cAge;
        this.initialCredits = cCredits;
        this.reputation = cReputation;
        this.health = cHealthType;
        this.primary = wPrimary;
        this.secondary = wSecondary;
        this.accentInstruction = accentInstruction;
    }

    public String getName() {
        return name;
    }
    public String getBackground() {
        return background;
    }
    public int getAge() {
        return age;
    }
    public int getInitialCredits() {
        return initialCredits;
    }
    public int getReputation() {
        return reputation;
    }
    public WeaponInformation getPrimary() {
        return primary;
    }
    public WeaponInformation getSecondary() {
        return secondary;
    }
    public String getAccentInstruction() {
        return accentInstruction;
    }
}

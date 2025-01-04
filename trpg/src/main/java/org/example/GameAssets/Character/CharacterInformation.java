package org.example.GameAssets.Character;

public enum CharacterInformation {
    LUCY_INFO(
            "루시나 쿠시나다",
            "루시(Lucyna Kushinada)는 아라사카(Arasaka)의 비밀 프로젝트에서 훈련받은 넷러너(Netrunner)로, 어린 시절부터 혹독한 환경 속에서 해킹과 사이버 전투 기술을 익히며 성장했습니다. 그녀는 자유를 잃은 삶에서 벗어나고자 나이트 시티로 탈출했으며, 과거의 트라우마와 억압된 기억을 안고 살아가면서도 더 나은 미래를 꿈꾸는 인물입니다",
            20,
            2000,
            51,
            HealthType.NORMAL,
            WeaponInformation.WEAPON_LEXINGTON,
            null,
            EquipmentInformation.EQUIPMENT_ARASAKA_CYBERDECK,
            null,
            null,
            "처음 보는 얼굴이네. 꼬치꼬치 캐묻진 않을게, 여긴 나이트 시티잖아. 넌 진짜 빈틈 투성이야. 교육이 필요하겠어."
    ), ALEX_INFO(
            "알레나 제나키스",
            "NUSA 연방 정보국(FIA) 요원으로, 주로 '알렉스'라는 애칭으로 불린다. 밀리테크의 첨단 기술인 메타트로픽 은신 임플란트를 통한 변장과 행동 분석 임플란트를 활용한 잠입에 능하며 전투력도 상당히 좋은 편.",
            32,
            15000,
            60,
            HealthType.NORMAL,
            WeaponInformation.WEAPON_HER_MAJESTY,
            null,
            null,
            null,
            null,
            "안녕, 연락해서 놀랐어? 모스에서 잠깐 볼까? NUS가 떠나려고 짐을 싸고 있어. 나도 그렇고. 마지막 임무만 남았는데, 널 제거하는거야."
    ), REED_INFO(
            "솔로몬 리드",
            "솔로몬 리드는 연방 정보국(FIA)의 잠복 요원이자 NUSA 역사상 최고의 요원입니다. 전성기에는 모건 블랙핸드와 같은 전설적인 인물과 어깨를 나란히 할 정도였지만, 잠깐의 유명세를 얻어 트로피를 채우는 일에는 전혀 관심이 없었습니다. 리드 같은 사람은 개인적인 목표보다 더 거대한 목적을 추구하며, 리드에게는 그것이 국가를 위해 일하는 것이었습니다. 제아무리 더러운 일이라 하더라도.",
            58,
            20000,
            81,
            HealthType.NORMAL,
            WeaponInformation.WEAPON_KONGOU,
            WeaponInformation.WEAPON_STINGER,
            null,
            null,
            null,
            "위험을 감수할 수는 없었어. 가끔으 같은 편일지라도 총을 적의 옆구리에 쑤시고 보는게 더 안전할 때가 있거든. / 그래. 나도 봤어. 이런 게 처음은 아니야. 몇 번의 암살 시도에서도 살아남으셨어. 그래도... 우리의... 대통령이시니까"
    );

    private String name;
    private String background;
    private int age;
    private int initialCredits;
    private int reputation;
    private HealthType health;
    private WeaponInformation primary;
    private WeaponInformation secondary;
    private EquipmentInformation firstEquipment;
    private EquipmentInformation secondEquipment;
    private EquipmentInformation thirdEquipment;
    private String accentInstruction;
    CharacterInformation(String cName,
                         String cBackground,
                         int cAge,
                         int cCredits,
                         int cReputation,
                         HealthType cHealthType,
                         WeaponInformation wPrimary,
                         WeaponInformation wSecondary,
                         EquipmentInformation firstEquipment,
                         EquipmentInformation secondEquipment,
                         EquipmentInformation thirdEquipment,
                         String accentInstruction) {
        this.name = cName;
        this.background = cBackground;
        this.age = cAge;
        this.initialCredits = cCredits;
        this.reputation = cReputation;
        this.health = cHealthType;
        this.primary = wPrimary;
        this.secondary = wSecondary;
        this.firstEquipment = firstEquipment;
        this.secondEquipment = secondEquipment;
        this.thirdEquipment = thirdEquipment;
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
    public HealthType getHealth() {
        return health;
    }
    public String getAccentInstruction() {
        return accentInstruction;
    }
    public EquipmentInformation[] getEquipments() {
        return new EquipmentInformation[]{firstEquipment, secondEquipment, thirdEquipment};
    }
}

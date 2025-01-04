package org.example.LLMResponse;

public enum ResponseSettings {
    API_URL("https://api.anthropic.com/v1/messages"),
    API_VERSION("2023-06-01"),
    MODEL_NAME("claude-3-5-haiku-latest"),
    INITIAL_INSTRUCTION("당신의 역할은 한 캐릭터를 연기하며 유저가 입력한 텍스트에 대해 이 캐릭터의 대답을 만들어내는 것입니다. "),
    CHARACTER_SCRIPT_DESCRIPTION("당신이 연기할 캐릭터의 정보는 다음과 같습니다. 캐릭터의 정보로부터 이 캐릭터의 행동, 말투 등을 추론하여 답변을 생성하십시오"),
    CHARACTER_SCRIPT_USER_DESCRIPTION("유저의 캐릭터 정보는 다음과 같습니다."),
    GAME_BACKGROUND("지금은 2077년의 디스토피아적 미래입니다. 당신는 초국적 대기업(메가코프)이 사회와 경제를 지배하는 나이트 시티에 있습니다. 이곳은 기술이 극도로 발전해 사이버웨어로 인간의 신체와 정신을 개조할 수 있지만, 빈부 격차와 사회적 불평등이 극심합니다. 과도한 사이버웨어 사용으로 발생하는 사이버 정신병, 갱단과 범죄의 만연, 그리고 제한된 형태의 인터넷 속 넷러너들의 활동은 기술 발전의 어두운 이면을 드러냅니다. ");

    private final String value;

    ResponseSettings(String s) {
        value = s;
    }

    String getValue() {
        return value;
    }
}

package pairmatching.Domain;

import pairmatching.Exception.InvalidInputException;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),

    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),

    PERFORMANCE("성능개선"),
    DEPLOY("배포");

    private String name;

    public static void validateMission(String mission) {
        if (mission.equals(CAR_RACING.getName()) ||
                mission.equals(LOTTO.getName()) ||
                mission.equals(BASEBALL.getName()) ||
                mission.equals(SHOPPING_CART.getName()) ||
                mission.equals(PAYMENT.getName()) ||
                mission.equals(SUBWAY.getName()) ||
                mission.equals(PERFORMANCE.getName()) ||
                mission.equals(DEPLOY.getName())) {
            return;
        }
        throw new InvalidInputException("존재하지 않는 미션입니다.", new IllegalArgumentException());
    }
    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

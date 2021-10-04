package baseball.domain;

public enum BallStatus {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String name;

    BallStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

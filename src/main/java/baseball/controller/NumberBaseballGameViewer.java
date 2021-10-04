package baseball.controller;

import baseball.enums.BallStatus;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import java.text.MessageFormat;
import java.util.StringJoiner;

public class NumberBaseballGameViewer {
    private static final int DEFAULT_COUNT = 0;

    public void printGameMessage(GameStatus gameStatus) {
        System.out.println(gameStatus.getMessage());
    }

    public void render(final BallStatuses ballStatuses) {
        if (BallStatus.NOTHING_BALL_STATUES.containsAll(ballStatuses.get())) {
            System.out.println(BallStatus.NOTHING.getName());
            return;
        }

        System.out.println(collectAll(ballStatuses));
    }

    private String collect(final BallStatus ballStatus, final BallStatuses ballStatuses) {
        int count = DEFAULT_COUNT;

        for (BallStatus status : ballStatuses.get()) {
            count = increase(ballStatus, status, count);
        }

        if (isEmptyBallStatus(count)) {
            return "";
        }

        return MessageFormat.format("{0}{1}", count, ballStatus.getName());
    }

    private String collectAll(BallStatuses ballStatuses) {
        final StringJoiner result = new StringJoiner(" ");

        final String strikeResult = collect(BallStatus.STRIKE, ballStatuses);
        if (isNotBlank(strikeResult)) {
            result.add(strikeResult);
        }

        final String ballResult = collect(BallStatus.BALL, ballStatuses);
        if (isNotBlank(ballResult)) {
            result.add(ballResult);
        }

        return result.toString();
    }

    private int increase(BallStatus source, BallStatus target, int count) {
        return source.match(target) ? count + 1 : count;
    }

    private boolean isEmptyBallStatus(int count) {
        return count == DEFAULT_COUNT;
    }

    private boolean isNotBlank(String result) {
        return !result.trim().isEmpty();
    }
}

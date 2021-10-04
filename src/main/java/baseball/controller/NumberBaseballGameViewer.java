package baseball.controller;

import baseball.enums.BallStatus;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import baseball.exception.BaseballRuntimeException;

import java.text.MessageFormat;
import java.util.StringJoiner;

public class NumberBaseballGameViewer {
    private static final int DEFAULT_COUNT = 0;

    public void printErrorMessage(BaseballRuntimeException e) {
        System.out.println(e.getMessage());
    }

    public void printGameMessage(final GameStatus gameStatus) {
        System.out.println(gameStatus.getMessage());
    }

    public void printGameResult(final BallStatuses ballStatuses) {
        if (ballStatuses.isAllNothing()) {
            System.out.println(BallStatus.NOTHING.getName());
            return;
        }

        System.out.println(collectAll(ballStatuses));
    }

    private String collect(final BallStatus ballStatus, final BallStatuses ballStatuses) {
        int count = DEFAULT_COUNT;

        for (BallStatus status : ballStatuses.get()) {
            count = increaseCount(ballStatus, status, count);
        }

        if (isNotChangeCount(count)) {
            return "";
        }

        return MessageFormat.format("{0}{1}", count, ballStatus.getName());
    }

    private String collectAll(final BallStatuses ballStatuses) {
        final StringJoiner result = new StringJoiner(" ");

        joinWith(result, collect(BallStatus.STRIKE, ballStatuses));
        joinWith(result, collect(BallStatus.BALL, ballStatuses));

        return result.toString();
    }

    private void joinWith(final StringJoiner result, final String ballStatusResult) {
        if (!isNotBlank(ballStatusResult)) {
            return;
        }

        result.add(ballStatusResult);
    }

    private int increaseCount(final BallStatus source, final BallStatus target, final int count) {
        if (!source.match(target)) {
            return count;
        }

        return count + 1;
    }

    private boolean isNotChangeCount(final int count) {
        return count == DEFAULT_COUNT;
    }

    private boolean isNotBlank(final String result) {
        return !result.trim().isEmpty();
    }
}

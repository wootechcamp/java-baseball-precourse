package baseball.controller;

import baseball.enums.BallStatus;
import baseball.enums.BallStatuses;
import baseball.enums.GameStatus;
import java.text.MessageFormat;
import java.util.StringJoiner;

public class NumberBaseballGameViewer {
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

    private String collectAll(BallStatuses ballStatuses) {
        final StringJoiner result = new StringJoiner(" ");

        final String strikeResult = collect(BallStatus.STRIKE, ballStatuses);
        if (!strikeResult.trim().isEmpty()) {
            result.add(strikeResult);
        }

        final String ballResult = collect(BallStatus.BALL, ballStatuses);
        if (!ballResult.trim().isEmpty()) {
            result.add(ballResult);
        }

        return result.toString();
    }

    private String collect(final BallStatus ballStatus, final BallStatuses ballStatuses) {
        int count = 0;

        for (BallStatus status : ballStatuses.get()) {
            count = increase(ballStatus, status, count);
        }

        if (count == 0) {
            return "";
        }

        return MessageFormat.format("{0}{1}", count, ballStatus.getName());
    }

    private int increase(BallStatus source, BallStatus target, int count) {
        return source.match(target) ? count + 1 : count;
    }
}

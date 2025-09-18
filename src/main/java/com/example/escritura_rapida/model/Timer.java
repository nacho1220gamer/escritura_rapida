package com.example.escritura_rapida.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * A simple countdown timer used in the Fast Typing game.
 * <p>
 * The {@code Timer} counts down from a given number of seconds
 * and provides callback hooks for:
 * <ul>
 *     <li>{@code onSecond} — executed every second as time decreases.</li>
 *     <li>{@code onTimeUp} — executed when the countdown reaches zero.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Internally, the timer uses a {@link Timeline} from JavaFX to
 * schedule periodic updates.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class Timer {
    private int timeLeft;
    private Timeline timeline;
    private Runnable onTimeUp;
    private Runnable onSecond;

    /**
     * Constructs a new {@code Timer}.
     *
     * @param timeleft the initial countdown time in seconds.
     * @param timeUp   the callback to run when the timer reaches zero.
     * @param timeDown the callback to run every second as time decreases.
     */
    public Timer(int timeleft, Runnable timeUp, Runnable timeDown) {
        this.timeLeft = timeleft;
        this.onTimeUp = timeUp;
        this.onSecond = timeDown;
    }

    /**
     * Starts the countdown timer.
     * <p>
     * Decreases {@code timeLeft} every second, runs {@code onSecond},
     * and when time reaches zero, stops the timer and runs {@code onTimeUp}.
     * </p>
     */
    public void start() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            if (onSecond != null) onSecond.run();
            if (timeLeft <= 0) {
                timeline.stop();
                if (onTimeUp != null) onTimeUp.run();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Stops the countdown timer if it is currently running.
     */
    public void stop() {
        if (timeline != null) timeline.stop();
    }

    /**
     * Returns the remaining time.
     *
     * @return the number of seconds left in the countdown.
     */
    public int getTimeLeft() {
        return timeLeft;
    }
}

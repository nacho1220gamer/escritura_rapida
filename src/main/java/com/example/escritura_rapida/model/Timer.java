package com.example.escritura_rapida.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {
    private int timeLeft;
    private Timeline timeline;
    private Runnable onTimeUp;
    private Runnable onSecond;

    public Timer(int timeleft, Runnable timeUp, Runnable timeDown) {
        this.timeLeft = timeleft;
        this.onTimeUp = timeUp;
        this.onSecond = timeDown;
    }

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

    public void stop() {
        if (timeline != null) timeline.stop();
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}

package com.example.escritura_rapida.view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StatisticsView {
    private Label successLabel;
    private Label timeleftLabel;
    private Label scoreLabel;
    private Label closeLabel;

    public StatisticsView(Label startButton, Label exitButton, Label titleLabel, Label scoreLabel) {
        this.successLabel = startButton;
        this.timeleftLabel = exitButton;
        this.scoreLabel = scoreLabel;
        this.closeLabel = titleLabel;
    }

    public Label getSuccessLabel() { return successLabel; }
    public Label getTimeleftLabel() { return timeleftLabel; }
    public Label getScoreLabel() { return scoreLabel; }
    public Label getCloseLabel() { return closeLabel; }
}

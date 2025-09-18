package com.example.escritura_rapida.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GameView {

    private Label wordLabel;
    private TextField inputField;
    private Label timerLabel;
    private Label levelLabel;
    private Label feedbackLabel;
    private Label scoreLabel;
    private Label validateButton;
    private Label restartButton;
    private ImageView returnButton;

    public GameView(Label wordLabel, TextField inputField,
                    Label timerLabel, Label levelLabel, Label feedbackLabel,
                    Label scoreLabel, Label validateButton, Label restartButton,
                    ImageView returnButton) {
        this.wordLabel = wordLabel;
        this.inputField = inputField;
        this.timerLabel = timerLabel;
        this.levelLabel = levelLabel;
        this.feedbackLabel = feedbackLabel;
        this.scoreLabel = scoreLabel;
        this.validateButton = validateButton;
        this.restartButton = restartButton;
        this.returnButton = returnButton;
    }

    public Label getWordLabel() { return wordLabel; }
    public TextField getInputField() { return inputField; }
    public Label getTimerLabel() { return timerLabel; }
    public Label getLevelLabel() { return levelLabel; }
    public Label getFeedbackLabel() { return feedbackLabel; }
    public Label getScoreLabel() { return scoreLabel; }
    public Label getValidateButton() { return validateButton; }
    public Label getRestartButton() { return restartButton; }
    public ImageView getReturnButton() { return returnButton; }
}

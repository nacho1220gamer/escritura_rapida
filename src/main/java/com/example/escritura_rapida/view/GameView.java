package com.example.escritura_rapida.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * Represents the view layer of the game screen in the Fast Typing application.
 * <p>
 * The {@code GameView} class acts as a wrapper for all UI components
 * used during gameplay, such as labels, input fields, and buttons.
 * It provides accessors for these components so that the controller
 * can update and manage the user interface.
 * </p>
 *
 * <p>
 * This class follows the MVC pattern by keeping all UI elements
 * grouped together in the {@code view} package, separated from
 * the game logic ({@code model}) and event handling ({@code controller}).
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
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

    /**
     * Constructs a new {@code GameView}.
     *
     * @param wordLabel      the label showing the word to type
     * @param inputField     the text field for user input
     * @param timerLabel     the label showing the remaining time
     * @param levelLabel     the label showing the current level
     * @param feedbackLabel  the label displaying feedback messages
     * @param scoreLabel     the label showing the score
     * @param validateButton the label acting as the validate button
     * @param restartButton  the label acting as the restart button
     * @param returnButton   the image view acting as the return-to-menu button
     */
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

    /** @return the label displaying the word to type. */
    public Label getWordLabel() { return wordLabel; }

    /** @return the text field for user input. */
    public TextField getInputField() { return inputField; }

    /** @return the label showing the remaining time. */
    public Label getTimerLabel() { return timerLabel; }

    /** @return the label showing the current level. */
    public Label getLevelLabel() { return levelLabel; }

    /** @return the label displaying feedback messages. */
    public Label getFeedbackLabel() { return feedbackLabel; }

    /** @return the label showing the score. */
    public Label getScoreLabel() { return scoreLabel; }

    /** @return the label acting as the validate button. */
    public Label getValidateButton() { return validateButton; }

    /** @return the label acting as the restart button. */
    public Label getRestartButton() { return restartButton; }

    /** @return the image view acting as the return-to-menu button. */
    public ImageView getReturnButton() { return returnButton; }
}

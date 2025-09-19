package com.example.escritura_rapida.controllers;

import com.example.escritura_rapida.SceneManager;
import com.example.escritura_rapida.model.GameManager;
import com.example.escritura_rapida.model.Timer;
import com.example.escritura_rapida.view.GameView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Controller class for the game screen of the Fast Typing application.
 * <p>
 * Handles user interactions during the game, such as validating words,
 * updating the timer, changing levels, and transitioning to the statistics
 * or menu views.
 * </p>
 *
 * <p>
 * This controller is connected to the {@code game-view.fxml} file
 * through FXML annotations.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class GameController  {

    @FXML private Label wordLabel;
    @FXML private TextField inputField;
    @FXML private Label timerLabel;
    @FXML private Label levelLabel;
    @FXML private Label feedbackLabel;
    @FXML private Label scoreLabel;
    @FXML private Label validateButton;
    @FXML private Label restartButton;
    @FXML private ImageView returnButton;

    private GameManager gameManager;
    private Timer gameTimer;
    private GameView gameView;
    private String currentWord;

    /**
     * Initializes the game controller.
     * <p>
     * Sets up the {@link GameManager}, {@link GameView}, event handlers
     * for validation and return buttons, and prepares the initial
     * instructions ("Press Space!").
     * </p>
     */
    @FXML
    private void initialize(){
        gameManager = new GameManager();
        gameView = new GameView(wordLabel, inputField, timerLabel, levelLabel, feedbackLabel,
                scoreLabel, validateButton, restartButton, returnButton);

        gameView.getValidateButton().setOnMouseClicked(event -> validateWord());
        gameView.getInputField().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) { validateWord();}
        });
        gameView.getRestartButton().setOnMouseClicked(event -> restartGame());
        gameView.getReturnButton().setOnMouseClicked(event -> returnMenu());

        gameView.getInputField().setDisable(true);
        gameView.getValidateButton().setDisable(true);
        gameView.getRestartButton().setVisible(false);
        gameView.getWordLabel().setText("Press Space!");

        wordLabel.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
            }
        });
    }

    /**
     * Starts a new game.
     * <p>
     * Enables input and buttons, resets the game state in {@link GameManager},
     * and calls {@link #startLevel()} to begin the first round.
     * </p>
     */
    private void startGame(){
        gameView.getInputField().setDisable(false);
        gameView.getValidateButton().setDisable(false);
        gameView.getRestartButton().setVisible(true);
        gameView.getFeedbackLabel().setText("Press Space!");

        gameManager.resetGame();
        startLevel();
    }

    /**
     * Starts a new level.
     * <p>
     * Retrieves a new word, updates labels, resets the timer,
     * and handles the case where no more words are available.
     * </p>
     */
    private void startLevel(){
        currentWord = gameManager.newWord();

        if (currentWord == null) {
            statisticsMenu();
            return;
        }

        gameView.getWordLabel().setText(currentWord);

        // Enable the validate button
        gameView.getValidateButton().setDisable(false);

        inputField.clear();
        timerLabel.setText("TIME: " + gameManager.getTimePerLevel());
        levelLabel.setText("LEVEL: " + gameManager.getLevel());
        scoreLabel.setText("SCORE: " + gameManager.getScore());

        if (gameTimer != null) gameTimer.stop();

        gameTimer = new Timer(
                gameManager.getTimePerLevel(),
                this::handleTimeUp,
                this::updateTimerLabel
        );
        gameTimer.start();

    }

    /**
     * Validates the word entered by the player.
     * <p>
     * If correct, increases level and score, updates feedback,
     * and starts the next level. If wrong, updates feedback
     * and does not advance.
     * </p>
     */
    private void validateWord() {
        String word = gameView.getInputField().getText();
        if (Objects.equals(word, gameView.getWordLabel().getText())) {
            gameView.getFeedbackLabel().setText("Correct word!");
            gameView.getFeedbackLabel().setTextFill(Color.GREEN);

            gameView.getValidateButton().setDisable(true);

            // Update the score and level
            gameManager.increaseLevel();

            // New level
            startLevel();
        } else {
            gameView.getFeedbackLabel().setTextFill(Color.RED);
            gameView.getFeedbackLabel().setText("Wrong word!");
            gameView.getInputField().clear();
        }
    }

    /**
     * Ends the game and transitions to the statistics menu.
     */
    private void gameOver() {
        statisticsMenu();
    }

    /**
     * Restarts the game to its initial state.
     * <p>
     * This method calls {@link GameManager#resetGame()} to reset
     * the level, score, and timer. It should be invoked when the
     * player chooses to restart the game from the beginning.
     * </p>
     */
    private void restartGame() {
        gameManager.resetGame();
        startGame();
    }

    /**
     * Loads and displays the statistics screen after the game ends.
     */
    private void statisticsMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escritura_rapida/statistics-view.fxml"));
            Parent root = loader.load();
            StatisticsController controller = loader.getController();
            controller.setStats(String.valueOf(Integer.parseInt(gameView.getLevelLabel().getText().split(" ")[1])-1),
                    Integer.toString(gameManager.getTimePerLevel()),
                    gameView.getScoreLabel().getText().split(" ")[1]);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getVisualBounds().getWidth();
            double screenHeight = screen.getVisualBounds().getHeight();

            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Statistics");

            double x = (screenWidth - scene.getWidth()) / 2;
            double y = (screenHeight - scene.getHeight()) / 2;

            stage.setX(x);
            stage.setY(y);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the user to the start menu screen.
     */
    private void returnMenu(){
        SceneManager sceneManager = new SceneManager();
        Stage stage = (Stage) returnButton.getScene().getWindow();
        String title = "Start Menu";
        String fxmlPath = "menu_view.fxml";

        sceneManager.changeScene(stage, fxmlPath, title);
    }

    /**
     * Updates the timer label with the remaining time.
     */
    private void updateTimerLabel() {
        timerLabel.setText("TIME: " + gameTimer.getTimeLeft());
    }

    /**
     * Handles the case when the timer runs out.
     * <p>
     * Displays a "Time's up!" message and ends the game.
     * </p>
     */
    private void handleTimeUp() {
        feedbackLabel.setText("\u23F0 Time's up!");
        gameOver();
    }

    private class KeyHandler implements javafx.event.EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.SPACE) {
                startGame();
            } else if (event.getCode() == KeyCode.ESCAPE) {
                returnMenu();
            }
        }
    }
}

package com.example.escritura_rapida;

import com.example.escritura_rapida.model.GameManager;
import com.example.escritura_rapida.model.Timer;
import com.example.escritura_rapida.view.GameView;
import com.example.escritura_rapida.view.StatisticsView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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

    @FXML
    private void initialize(){
        gameManager = new GameManager();
        gameView = new GameView(wordLabel, inputField, timerLabel, levelLabel, feedbackLabel,
                scoreLabel, validateButton, restartButton, returnButton);

        gameView.getValidateButton().setOnMouseClicked(event -> validateWord());
        gameView.getReturnButton().setOnMouseClicked(event -> returnMenu());

        gameView.getInputField().setDisable(true);
        gameView.getValidateButton().setDisable(true);
        gameView.getRestartButton().setVisible(false);
        gameView.getWordLabel().setText("Press Space!");


        wordLabel.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, event -> {
                    switch (event.getCode()) {
                        case SPACE:
                            startGame();
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    }

    private void startGame(){
        gameView.getInputField().setDisable(false);
        gameView.getValidateButton().setDisable(false);
        gameView.getRestartButton().setVisible(true);
        gameView.getFeedbackLabel().setText("Press Space!");

        gameManager.resetGame();
        startLevel();
    }

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

    private void validateWord() {
        String word = gameView.getInputField().getText();
        if (Objects.equals(word, gameView.getWordLabel().getText())) {
            gameView.getFeedbackLabel().setText("Correct word!");
            gameView.getFeedbackLabel().setTextFill(Color.GREEN);
            System.out.println("Correct word!");

            gameView.getValidateButton().setDisable(true);

            // Update the score and level
            gameManager.increaseLevel();

            // New level
            startLevel();
        } else {
            gameView.getFeedbackLabel().setTextFill(Color.RED);
            gameView.getFeedbackLabel().setText("Wrong word!");
        }
    }

    private void gameOver() {
        statisticsMenu();
    }

    private void statisticsMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("statistics-view.fxml"));
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

    private void returnMenu(){
        SceneManager sceneManager = new SceneManager();
        Stage stage = (Stage) returnButton.getScene().getWindow();
        String title = "Start Menu";
        String fxmlPath = "menu_view.fxml";

        sceneManager.changeScene(stage, fxmlPath, title);
    }

    private void updateTimerLabel() {
        timerLabel.setText("TIME: " + gameTimer.getTimeLeft());
    }

    private void handleTimeUp() {
        feedbackLabel.setText("⏰ Time's up!");
        gameOver();
    }
}

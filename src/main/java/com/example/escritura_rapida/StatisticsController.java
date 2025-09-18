package com.example.escritura_rapida;

import com.example.escritura_rapida.view.GameView;
import com.example.escritura_rapida.view.StatisticsView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller class for the statistics screen of the Fast Typing application.
 * <p>
 * Handles the display of the player's performance at the end of the game,
 * including successful words, remaining time, and final score. It also
 * manages the close button to exit the statistics screen.
 * </p>
 *
 * <p>
 * This controller is linked to {@code statistics-view.fxml} via FXML.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class StatisticsController {

    @FXML private Label successLabel;
    @FXML private Label timeleftLabel;
    @FXML private Label scoreLabel;
    @FXML private Label closeButton;

    /**
     * Initializes the statistics controller.
     * <p>
     * Sets up the close button to exit the statistics window
     * when clicked.
     * </p>
     */
    @FXML
    private void initialize() {
        closeButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });
    }

    /**
     * Updates the statistics screen with the player's results.
     *
     * @param success       the number of successful words typed.
     * @param remainingTime the remaining time when the game ended.
     * @param score         the final score achieved by the player.
     */
    public void setStats(String success, String remainingTime, String score) {
        successLabel.setText(success);
        timeleftLabel.setText(remainingTime);
        scoreLabel.setText(score);
    }
}

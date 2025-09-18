package com.example.escritura_rapida;

import com.example.escritura_rapida.view.GameView;
import com.example.escritura_rapida.view.StatisticsView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StatisticsController {

    @FXML private Label successLabel;
    @FXML private Label timeleftLabel;
    @FXML private Label scoreLabel;
    @FXML private Label closeButton;

    @FXML
    private void initialize() {
        closeButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });
    }

    public void setStats(String success, String remainingTime, String score) {
        successLabel.setText(success);
        timeleftLabel.setText(remainingTime);
        scoreLabel.setText(score);
    }
}

package com.example.escritura_rapida;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private Label start_button;

    @FXML
    private Label exit_button;

    @FXML
    private void initialize() {
        start_button.setOnMouseClicked(event -> iniciarJuego());
        exit_button.setOnMouseClicked(e -> {
            Stage stage = (Stage) exit_button.getScene().getWindow();
            stage.close();
        });
    }

    private void iniciarJuego() {
        SceneManager sceneManager = new SceneManager();
        System.out.println("Iniciar juego!");
        Stage stage = (Stage) start_button.getScene().getWindow();
        String fxmlPath = "game_view.fxml";
        String title = "Game Menu";

        sceneManager.changeScene(stage, fxmlPath, title);
    }
}



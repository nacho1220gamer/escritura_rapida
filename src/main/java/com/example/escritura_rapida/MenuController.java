package com.example.escritura_rapida;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller class for the main menu of the Fast Typing application.
 * <p>
 * Handles user interactions in the menu screen, such as starting
 * the game or exiting the application.
 * </p>
 *
 * <p>
 * This controller is linked to {@code menu_view.fxml} via FXML.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class MenuController {
    @FXML
    private Label start_button;

    @FXML
    private Label exit_button;

    /**
     * Initializes the menu controller.
     * <p>
     * Sets up mouse click handlers for the start and exit buttons.
     * </p>
     */
    @FXML
    private void initialize() {
        start_button.setOnMouseClicked(event -> iniciarJuego());
        exit_button.setOnMouseClicked(e -> {
            Stage stage = (Stage) exit_button.getScene().getWindow();
            stage.close();
        });
    }

    /**
     * Starts the game by changing the current scene to the game view.
     * <p>
     * Uses {@link SceneManager} to load {@code game_view.fxml}
     * and sets the window title to "Game Menu".
     * </p>
     */
    private void iniciarJuego() {
        SceneManager sceneManager = new SceneManager();
        System.out.println("Iniciar juego!");
        Stage stage = (Stage) start_button.getScene().getWindow();
        String fxmlPath = "game_view.fxml";
        String title = "Game Menu";

        sceneManager.changeScene(stage, fxmlPath, title);
    }
}



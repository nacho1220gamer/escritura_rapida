package com.example.escritura_rapida.controllers;

import com.example.escritura_rapida.SceneManager;
import com.example.escritura_rapida.view.MenuView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
    @FXML private Label startButton;
    @FXML private Label exitButton;
    @FXML private ImageView titleLabel;

    private MenuView menuView;

    /**
     * Initializes the menu controller.
     * <p>
     * Sets up mouse click handlers for the start and exit buttons.
     * </p>
     */
    @FXML
    private void initialize() {
        menuView = new MenuView(startButton, exitButton, titleLabel);

        menuView.getStartButton().setOnMouseClicked(event -> iniciarJuego());
        menuView.getExitButton().setOnMouseClicked(e -> {
            Stage stage = (Stage) menuView.getExitButton().getScene().getWindow();
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
        Stage stage = (Stage) menuView.getStartButton().getScene().getWindow();
        String fxmlPath = "game_view.fxml";
        String title = "Game Menu";

        sceneManager.changeScene(stage, fxmlPath, title);
    }
}



package com.example.escritura_rapida;

import javafx.stage.Stage;

/**
 * Interface for handling scene changes in the application.
 */
public interface SceneHandler {
    void changeScene(Stage stage, String fxmlPath, String title);
}
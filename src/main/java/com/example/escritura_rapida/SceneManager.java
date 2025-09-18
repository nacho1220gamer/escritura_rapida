package com.example.escritura_rapida;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Utility class responsible for managing scene transitions
 * in the Fast Typing application.
 * <p>
 * This class provides a method to change the current scene
 * of a given {@link Stage}, load a new FXML file, center the
 * window on the screen, and optionally update the stage title.
 * </p>
 *
 * <p>
 * It also ensures the scene background is set to transparent.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class SceneManager {

    /**
     * Changes the current scene of the specified stage.
     * <p>
     * Loads the provided FXML file, creates a new {@link Scene},
     * sets its background transparency, and centers the window
     * on the primary screen. The stage title is updated if one
     * is provided.
     * </p>
     *
     * @param stage    the {@link Stage} whose scene will be changed.
     * @param fxmlPath the relative path to the FXML file to load.
     * @param title    the new window title, or {@code null} to leave it unchanged.
     */
    public void changeScene(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            scene.setFill(Color.TRANSPARENT);

            Screen screen = Screen.getPrimary();
            double screenWidth = screen.getVisualBounds().getWidth();
            double screenHeight = screen.getVisualBounds().getHeight();

            stage.setScene(scene);
            if (title != null) {
                stage.setTitle(title);
            }

            double x = (screenWidth - scene.getWidth()) / 2;
            double y = (screenHeight - scene.getHeight()) / 2;

            stage.setX(x);
            stage.setY(y);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

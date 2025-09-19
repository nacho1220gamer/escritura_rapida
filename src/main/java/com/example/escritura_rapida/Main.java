package com.example.escritura_rapida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Main class of the "Escritura Rápida" (Fast Typing) application.
 * <p>
 * This class serves as the entry point of the JavaFX application.
 * It loads the main menu view from the FXML file and configures
 * the primary application window (Stage).
 * </p>
 *
 * <p>
 * The primary window is initialized as borderless (TRANSPARENT),
 * not resizable, and sets {@code menu_view.fxml} as the initial view.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Main method of the application.
     * <p>
     * Calls {@link Application#launch(String...)} to start the JavaFX
     * application lifecycle.
     * </p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starting point of the JavaFX application.
     * <p>
     * Loads the FXML file corresponding to the main menu,
     * creates a scene with an initial size of 320x240 pixels,
     * applies transparency, and configures the main {@link Stage}.
     * </p>
     *
     * @param primaryStage the primary stage provided by the JavaFX runtime.
     * @throws IOException if an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("Menú");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

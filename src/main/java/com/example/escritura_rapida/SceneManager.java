package com.example.escritura_rapida;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SceneManager {

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

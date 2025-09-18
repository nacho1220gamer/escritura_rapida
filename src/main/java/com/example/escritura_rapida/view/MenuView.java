package com.example.escritura_rapida.view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MenuView {
    private Label startButton;
    private Label exitButton;
    private ImageView titleLabel;

    public MenuView(Label startButton, Label exitButton, ImageView titleLabel) {
        this.startButton = startButton;
        this.exitButton = exitButton;
        this.titleLabel = titleLabel;
    }

    public Label getStartButton() { return startButton; }
    public Label getExitButton() { return exitButton; }
    public ImageView getTitleLabel() { return titleLabel; }
}

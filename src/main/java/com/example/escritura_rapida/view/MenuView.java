package com.example.escritura_rapida.view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Represents the view layer of the main menu in the Fast Typing application.
 * <p>
 * The {@code MenuView} class groups together all UI components
 * from the menu screen, such as the start button, exit button,
 * and the game title image. It provides accessors for these
 * components so that controllers can attach behavior and manage
 * the user interface.
 * </p>
 *
 * <p>
 * This class follows the MVC pattern by keeping menu-related UI
 * elements in the {@code view} package, separated from the logic
 * in controllers and models.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class MenuView {
    private Label startButton;
    private Label exitButton;
    private ImageView titleLabel;

    /**
     * Constructs a new {@code MenuView}.
     *
     * @param startButton the label that acts as the start button
     * @param exitButton  the label that acts as the exit button
     * @param titleLabel  the image view showing the game title or logo
     */
    public MenuView(Label startButton, Label exitButton, ImageView titleLabel) {
        this.startButton = startButton;
        this.exitButton = exitButton;
        this.titleLabel = titleLabel;
    }

    /** @return the label acting as the start button. */
    public Label getStartButton() { return startButton; }

    /** @return the label acting as the exit button. */
    public Label getExitButton() { return exitButton; }

    /** @return the image view showing the game title/logo. */
    public ImageView getTitleLabel() { return titleLabel; }
}

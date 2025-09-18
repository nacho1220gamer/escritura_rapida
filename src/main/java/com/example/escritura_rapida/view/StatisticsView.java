package com.example.escritura_rapida.view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Represents the view layer of the statistics screen in the Fast Typing application.
 * <p>
 * The {@code StatisticsView} class groups together all UI components
 * from the statistics screen, such as labels for successful words,
 * remaining time, final score, and the close button. It provides
 * accessors for these components so that controllers can display
 * results and manage interactions.
 * </p>
 *
 * <p>
 * This class follows the MVC pattern by keeping statistics-related UI
 * elements in the {@code view} package, separated from logic in controllers.
 * </p>
 *
 * @author Ignacio Henao Henao
 * @version 1.0
 */
public class StatisticsView {
    private Label successLabel;
    private Label timeleftLabel;
    private Label scoreLabel;
    private Label closeLabel;

    /**
     * Constructs a new {@code StatisticsView}.
     *
     * @param successLabel  the label showing the number of successful words
     * @param timeleftLabel the label showing the remaining time
     * @param closeLabel    the label acting as the close button
     * @param scoreLabel    the label showing the final score
     */
    public StatisticsView(Label successLabel, Label timeleftLabel, Label closeLabel, Label scoreLabel) {
        this.successLabel = successLabel;
        this.timeleftLabel = timeleftLabel;
        this.scoreLabel = scoreLabel;
        this.closeLabel = closeLabel;
    }

    /** @return the label showing successful words. */
    public Label getSuccessLabel() { return successLabel; }

    /** @return the label showing remaining time. */
    public Label getTimeleftLabel() { return timeleftLabel; }

    /** @return the label showing the final score. */
    public Label getScoreLabel() { return scoreLabel; }

    /** @return the label acting as the close button. */
    public Label getCloseLabel() { return closeLabel; }
}

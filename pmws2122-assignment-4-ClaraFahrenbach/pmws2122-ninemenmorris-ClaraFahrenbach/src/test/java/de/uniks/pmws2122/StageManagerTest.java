package de.uniks.pmws2122;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StageManagerTest extends ApplicationTest {
    private Stage stage;
    private StageManager app;

    @Override
    public void start(Stage stage) {
        // start application
        this.stage = stage;
        app = new StageManager();
        app.start(stage);
    }

    @Test
    public void changeViewTest() {
        // implement test

        FxRobot bot = new FxRobot();

        clickOn("#playerNameBlackInput");
        write("Bob");
        clickOn("#createGameButton");
        assertThat(stage.getTitle()).isEqualTo(Constants.SETUP_SCREEN_TITLE);
        clickOn("#playerNameWhiteInput");
        write("Caro");
        clickOn("#createGameButton");
        bot.clickOn("Bob black ");
        bot.clickOn("Caro white ");
        bot.clickOn("OK");

        assertThat(stage.getTitle()).isEqualTo(Constants.INGAME_SCREEN_TITLE);

        Label currentPlayerNameLabel = lookup("#currentPlayerNameLabel").query();
        assertThat(currentPlayerNameLabel.getText()).isEqualTo("Caro");

        clickOn("#giveUpButton");
        bot.clickOn("OK");
        assertThat(stage.getTitle()).isEqualTo(Constants.SETUP_SCREEN_TITLE);

        TextField playerNameBlackInput = lookup("#playerNameBlackInput").query();
        assertThat(playerNameBlackInput.getText()).isEqualTo("");

    }
}
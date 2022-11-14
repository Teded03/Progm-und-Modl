package de.uniks.pmws2122;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FullTest extends ApplicationTest {
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
    public void fullGameTest() {

        FxRobot bot = new FxRobot();

        clickOn("#playerNameBlackInput");
        write("Player2");
        clickOn("#createGameButton");
        assertThat(stage.getTitle()).isEqualTo(Constants.SETUP_SCREEN_TITLE);
        clickOn("#playerNameWhiteInput");
        write("Player1");
        clickOn("#createGameButton");
        bot.clickOn("Player2 black ");
        bot.clickOn("Player1 white ");
        bot.clickOn("OK");

        assertThat(stage.getTitle()).isEqualTo(Constants.INGAME_SCREEN_TITLE);

        Label currentPlayerNameLabel = lookup("#currentPlayerNameLabel").query();
        assertThat(currentPlayerNameLabel.getText()).isEqualTo("Player1");

        // Player 1 placed on G7
        clickOn("#g7FieldDisplay");
        // Player 2 placed on A7
        clickOn("#a7FieldDisplay");
        // Player 1 placed on G4
        clickOn("#g4FieldDisplay");
        // Player 2 placed on D7
        clickOn("#d7FieldDisplay");
        // Player 1 placed on G1 and took on D7
        clickOn("#g1FieldDisplay");
        clickOn("#d7FieldDisplay");
        // Player 2 placed on B6
        clickOn("#b6FieldDisplay");
        // Player 1 placed on F6
        clickOn("#f6FieldDisplay");
        // Player 2 placed on B4
        clickOn("#b4FieldDisplay");
        // Player 1 placed on F4
        clickOn("#f4FieldDisplay");
        // Player 2 placed on D7
        clickOn("#d7FieldDisplay");
        // Player 1 placed on F2 and took on D7
        clickOn("#f2FieldDisplay");
        clickOn("#d7FieldDisplay");
        // Player 2 placed on D7
        clickOn("#d7FieldDisplay");
        // Player 1 placed on D1
        clickOn("#d1FieldDisplay");
        // Player 2 placed on C4
        clickOn("#c4FieldDisplay");
        // Player 1 placed on A1 and took on B4
        clickOn("#a1FieldDisplay");
        clickOn("#b4FieldDisplay");
        // Player 2 placed on B4
        clickOn("#b4FieldDisplay");
        // Player 1 placed on B2
        clickOn("#b2FieldDisplay");
        // Player 2 placed on C5
        clickOn("#c5FieldDisplay");
        // Player 1 moved from F4 to E4
        Label currentPlayerActionLabel = lookup("#currentPlayerActionLabel").query();
        assertThat(currentPlayerActionLabel.getText()).isEqualTo("moving");
        clickOn("#f4FieldDisplay");
        clickOn("#e4FieldDisplay");
        // Player 2 moved from C5 to D5
        clickOn("#c5FieldDisplay");
        clickOn("#d5FieldDisplay");
        // Player 1 moved from G4 to F4 and took on D5
        clickOn("#g4FieldDisplay");
        clickOn("#f4FieldDisplay");
        assertThat(currentPlayerActionLabel.getText()).isEqualTo("remove");
        clickOn("#d5FieldDisplay");
        // Player 2 moved from C4 to C5
        clickOn("#c4FieldDisplay");
        clickOn("#c5FieldDisplay");
        // Player 1 moved from F4 to G4 and took on C5
        clickOn("#f4FieldDisplay");
        clickOn("#g4FieldDisplay");
        clickOn("#c5FieldDisplay");
        // Player 2 moved from B4 to C4
        clickOn("#b4FieldDisplay");
        clickOn("#c4FieldDisplay");
        // Player 1 moved from G4 to F4 and took on C4
        clickOn("#g4FieldDisplay");
        clickOn("#f4FieldDisplay");
        clickOn("#c4FieldDisplay");
        // Player 2 moved from B6 to D6
        assertThat(currentPlayerActionLabel.getText()).isEqualTo("flying");
        clickOn("#b6FieldDisplay");
        clickOn("#d6FieldDisplay");
        // Player 1 moved from F4 to G4 and took on D6
        clickOn("#f4FieldDisplay");
        clickOn("#g4FieldDisplay");
        clickOn("#d6FieldDisplay");
        bot.clickOn("OK");
        assertThat(stage.getTitle()).isEqualTo(Constants.SETUP_SCREEN_TITLE);
        TextField playerNameBlackInput = lookup("#playerNameBlackInput").query();
        assertThat(playerNameBlackInput.getText()).isEqualTo("");

    }
}
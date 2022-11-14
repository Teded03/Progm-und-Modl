package de.uniks.pmws2122.controller;

import de.uniks.pmws2122.StageManager;
import de.uniks.pmws2122.model.ModelService;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static de.uniks.pmws2122.Constants.*;

public class SetupScreenController {
    private final ModelService modelService;
    private Parent view;


    private TextField playerBlackTextField;
    private TextField playerWhiteTextField;
    private Button createGameButton;
    private Button createGameAIButton;

    public SetupScreenController(ModelService modelService, Parent view) {
        this.modelService = modelService;
        this.view = view;
    }
    

    public void init() {
        // Load view references
        this.playerBlackTextField = (TextField) this.view.lookup("#playerNameBlackInput");
        this.playerWhiteTextField = (TextField) this.view.lookup("#playerNameWhiteInput");
        this.createGameButton = (Button) this.view.lookup("#createGameButton");
        this.createGameAIButton = (Button) this.view.lookup("#AIButton");
        // Add action listeners
        this.createGameButton.setOnAction(this::onCreateGameButtonPressed);
        this.createGameAIButton.setOnAction(this::onCreateGameAIButtonPressed);
    }

    public void stop() {
    }

    // action listener create Game
    private void onCreateGameButtonPressed(ActionEvent event) {
        // Check if both text fields are filled
        if (this.playerBlackTextField.getText().isEmpty() || this.playerWhiteTextField.getText().isEmpty()) {
            return;
        } // Build the game
        this.modelService.gamemode = PLAYER_VS_PLAYER;
        this.modelService.buildGame(this.playerBlackTextField.getText(), this.playerWhiteTextField.getText(), PLAYER_VS_PLAYER);
        
        // Change the view
        StageManager.showIngameScreen();
    }

    // action listener create Game againts AI
    private void onCreateGameAIButtonPressed(ActionEvent event) {
        if (this.playerBlackTextField.getText().isEmpty()|| !this.playerWhiteTextField.getText().isEmpty()) {
            return;
        } // Build the game
        this.modelService.gamemode = PLAYER_VS_AI;
        this.modelService.buildGame(this.playerBlackTextField.getText(), NAME_AI, PLAYER_VS_AI); //set playertwo to name computer
        // Change the view
        StageManager.showIngameScreen();

    }
}

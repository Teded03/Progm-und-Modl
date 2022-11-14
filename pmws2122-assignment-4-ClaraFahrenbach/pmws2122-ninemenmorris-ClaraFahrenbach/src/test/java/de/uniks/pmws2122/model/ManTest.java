package de.uniks.pmws2122.model;

import static org.assertj.core.api.Assertions.*;
import static de.uniks.pmws2122.Constants.*;

import org.junit.Test;

public class ManTest {
    @Test 
    public void testManPlacedEmptyField() {
        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_PLACING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_PLACING);
        game.getPlayers().get(1).setAction(PLAYER_ACTION_PLACING);


        Field field1 = modelService.getGame().getFields().get(0);
        modelService.placeMan(field1);

        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition()).isEqualTo(game.getFields().get(0));
        assertThat(game.getPlayers().get(0).getInitialPlacedMen()).isEqualTo(1);
        assertThat(game.getPlayers().get(1).getInitialPlacedMen()).isEqualTo(0);


    }

    @Test 
    public void testManMoveEmptyField() {
        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_MOVING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_MOVING);
        game.getPlayers().get(1).setAction(PLAYER_ACTION_MOVING);

        Man WhiteZero = new Man()
                .setGame(modelService.getGame())
                .setColor(COLOR_WHITE)
                .setOwner(modelService.getGame().getPlayers().get(0))
                .setPosition(modelService.getGame().getFields().get(1));

        modelService.setCurrentSelectedMan(WhiteZero);
        modelService.setCurrentSelectedField(modelService.getGame().getFields().get(2));

        modelService.moveMan();

        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition()).isEqualTo(game.getFields().get(2));
        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition()).isNotEqualTo(game.getFields().get(1));

    }

    @Test 
    public void testManRemove() {
        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_MOVING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_REMOVE);
        game.getPlayers().get(1).setAction(PLAYER_ACTION_MOVING);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(1))
        .setPosition(modelService.getGame().getFields().get(0));

        assertThat(game.getPlayers().get(1).getMen().get(0).getPosition()).isEqualTo(game.getFields().get(0));

        modelService.removeMan(WhiteZero); 
        
        assertThat(WhiteZero.getPosition()).isEqualTo(null);
      
    }

    @Test
    public void testManPlacedOccupiedField() {

        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_PLACING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_PLACING);
        game.getPlayers().get(1).setAction(PLAYER_ACTION_PLACING);

        Man WhiteZero = new Man()
                .setGame(modelService.getGame())
                .setColor(COLOR_WHITE)
                .setOwner(modelService.getGame().getPlayers().get(0))
                .setPosition(modelService.getGame().getFields().get(0));

        modelService.placeMan(game.getFields().get(1));

        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition()).isEqualTo(game.getFields().get(0));
        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition()).isNotEqualTo(game.getFields().get(1));
        assertThat(game.getPlayers().get(0).getInitialPlacedMen()).isEqualTo(1);
        assertThat(game.getPlayers().get(0).getInitialPlacedMen()).isNotEqualTo(2);
    }

    @Test // 
    public void testManMoveOccupiedField() {
        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_MOVING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_MOVING);

        Man WhiteZero = new Man()
                .setGame(modelService.getGame())
                .setColor(COLOR_WHITE)
                .setOwner(modelService.getGame().getPlayers().get(0))
                .setPosition(modelService.getGame().getFields().get(1));

        Man BlackZero = new Man()
                .setGame(modelService.getGame())
                .setColor(COLOR_BLACK)
                .setOwner(modelService.getGame().getPlayers().get(1))
                .setPosition(modelService.getGame().getFields().get(2));

        modelService.setCurrentSelectedMan(WhiteZero);
        modelService.setCurrentSelectedField(modelService.getGame().getFields().get(2));

        modelService.moveMan(); // move man needs a currentSelectedMan and currentSelectedField

        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition())
                .isEqualTo(modelService.getGame().getFields().get(1)); // did not move because field is occupied
        assertThat(game.getPlayers().get(0).getMen().get(0).getPosition())
                .isNotEqualTo(modelService.getGame().getFields().get(2));
    }

    @Test 
    public void testManRemoveNullMan() {
        ModelService modelService = new ModelService();
        modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);
        Game game = modelService.getGame();
        modelService.startGame(game.getPlayers().get(0));

        game.setPhase(GAME_PHASE_MOVING);
        game.getPlayers().get(0).setAction(PLAYER_ACTION_REMOVE);
        game.getPlayers().get(1).setAction(PLAYER_ACTION_MOVING);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(1))
        .setPosition(modelService.getGame().getFields().get(0));

        assertThat(game.getPlayers().get(1).getMen().get(0).getPosition()).isEqualTo(game.getFields().get(0));

        modelService.removeMan(null); 
        
        assertThat(WhiteZero.getPosition()).isEqualTo(game.getFields().get(0));

    }
}

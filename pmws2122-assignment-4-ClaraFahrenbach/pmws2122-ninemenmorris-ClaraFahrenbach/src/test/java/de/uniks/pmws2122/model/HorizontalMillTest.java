package de.uniks.pmws2122.model;

import org.junit.Test;
import static de.uniks.pmws2122.Constants.*; 
import static org.assertj.core.api.Assertions.*;


public class HorizontalMillTest {

    @Test
    public void testMillNoMill(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
        
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(5));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(1));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        Man WhiteFour = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(7));

        modelService.checkHorizontalMill(WhiteFour);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isNotEqualTo(PLAYER_ACTION_REMOVE);
        
    }

    @Test
    public void testMillOldMill(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
        
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(1));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        Man WhiteFour = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(4));

        Man WhiteFive = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(5));

        modelService.checkHorizontalMill(WhiteFive);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isNotEqualTo(PLAYER_ACTION_REMOVE);

    }   

    @Test
    public void testMillNewMillHorizontalFromMid(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
                
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(16));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(1));

        modelService.checkHorizontalMill(WhiteThree);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);
    }    
    
    @Test
    public void testMillNewMillHorizontalFromLeft(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
                
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(16));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(1));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        modelService.checkHorizontalMill(WhiteThree);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);

    }

    @Test
    public void testMillNewMillHorizontalFromRight(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
               
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(16));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(1));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        modelService.checkHorizontalMill(WhiteThree);
        
        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);
    }
}

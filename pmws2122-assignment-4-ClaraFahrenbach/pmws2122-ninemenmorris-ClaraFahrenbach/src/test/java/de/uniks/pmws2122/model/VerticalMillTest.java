package de.uniks.pmws2122.model;

import org.junit.Test;
import static de.uniks.pmws2122.Constants.*; 
import static org.assertj.core.api.Assertions.*;

public class VerticalMillTest {
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
        .setPosition(modelService.getGame().getFields().get(1));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(2));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(5));

        modelService.checkHorizontalMill(WhiteThree);

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
        .setPosition(modelService.getGame().getFields().get(9));

        Man WhiteThree = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(21));

        Man WhiteFour = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(4));

        modelService.checkHorizontalMill(WhiteFour);

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
        .setPosition(modelService.getGame().getFields().get(0));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(21));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(9));

        modelService.checkVerticalMill(WhiteTwo);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);
    }    
    
    @Test
    public void testMillNewMillHorizontalFromTop(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
                
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(9));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(21));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        modelService.checkVerticalMill(WhiteTwo);

        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);

    }

    @Test
    public void testMillNewMillHorizontalFromBottom(){
        ModelService modelService = new ModelService();
        modelService.buildGame("Bob","Alice", PLAYER_VS_PLAYER);
               
        Player PlayerWhite = modelService.getGame().getPlayers().get(0);
        modelService.startGame(PlayerWhite);

        Man WhiteZero = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(0));

        Man WhiteOne = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(9));

        Man WhiteTwo = new Man()
        .setGame(modelService.getGame())
        .setColor(COLOR_WHITE)
        .setOwner(modelService.getGame().getPlayers().get(0))
        .setPosition(modelService.getGame().getFields().get(21));

        modelService.checkVerticalMill(WhiteTwo);
        
        assertThat(modelService.getGame().getPlayers().get(0).getAction()).isEqualTo(PLAYER_ACTION_REMOVE);
    }
}

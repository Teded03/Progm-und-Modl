package de.uniks.pmws2122.model;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static de.uniks.pmws2122.Constants.*;

public class ScenarioTest{

   @Test
   public void nineMenMorris()
   {
   }
    
   @Test
   public void testBuildGame(){
      ModelService modelService = new ModelService();
      
      modelService.buildGame("Alice", "Bob", PLAYER_VS_PLAYER);

      Game game = modelService.getGame();

      assertThat(game.getName()).isEqualTo("Epic battle");

      assertThat(game.getPlayers().size()).isEqualTo(2);

      assertThat(game.getPlayers().get(0).getName()).isEqualTo("Alice");
      assertThat(game.getPlayers().get(1).getName()).isEqualTo("Bob");
      
      assertThat(game.getPlayers().get(0).getNext().getName()).isEqualTo("Bob");
      assertThat(game.getPlayers().get(1).getNext().getName()).isEqualTo("Alice");
      assertThat(game.getPlayers().get(0).getPrevious().getName()).isEqualTo("Bob");
      assertThat(game.getPlayers().get(1).getPrevious().getName()).isEqualTo("Alice");

      assertThat(game.getPlayers().get(0).getColor()).isEqualTo(COLOR_BLACK);
      assertThat(game.getPlayers().get(1).getColor()).isEqualTo(COLOR_WHITE);

      assertThat(game.getPlayers().get(0).getAction()).isEqualTo("");
      assertThat(game.getPlayers().get(1).getAction()).isEqualTo("");

      assertThat(game.getPlayers().get(0).getGame()).isEqualTo(game);

      assertThat(game.getFields().size()).isEqualTo(24);

      assertThat(game.getFields().get(0).getCoordinate()).isEqualTo("a7");
      assertThat(game.getFields().get(1).getCoordinate()).isEqualTo("d7");
      assertThat(game.getFields().get(2).getCoordinate()).isEqualTo("g7");
      assertThat(game.getFields().get(3).getCoordinate()).isEqualTo("b6");
      assertThat(game.getFields().get(4).getCoordinate()).isEqualTo("d6");
      assertThat(game.getFields().get(5).getCoordinate()).isEqualTo("f6");
      assertThat(game.getFields().get(6).getCoordinate()).isEqualTo("c5");
      assertThat(game.getFields().get(7).getCoordinate()).isEqualTo("d5");
      assertThat(game.getFields().get(8).getCoordinate()).isEqualTo("e5");
      assertThat(game.getFields().get(9).getCoordinate()).isEqualTo("a4");
      assertThat(game.getFields().get(10).getCoordinate()).isEqualTo("b4");
      assertThat(game.getFields().get(11).getCoordinate()).isEqualTo("c4");
      assertThat(game.getFields().get(12).getCoordinate()).isEqualTo("e4");
      assertThat(game.getFields().get(13).getCoordinate()).isEqualTo("f4");
      assertThat(game.getFields().get(14).getCoordinate()).isEqualTo("g4");
      assertThat(game.getFields().get(15).getCoordinate()).isEqualTo("c3");
      assertThat(game.getFields().get(16).getCoordinate()).isEqualTo("d3");
      assertThat(game.getFields().get(17).getCoordinate()).isEqualTo("e3");
      assertThat(game.getFields().get(18).getCoordinate()).isEqualTo("b2");
      assertThat(game.getFields().get(19).getCoordinate()).isEqualTo("d2");
      assertThat(game.getFields().get(20).getCoordinate()).isEqualTo("f2");
      assertThat(game.getFields().get(21).getCoordinate()).isEqualTo("a1");
      assertThat(game.getFields().get(22).getCoordinate()).isEqualTo("d1");
      assertThat(game.getFields().get(23).getCoordinate()).isEqualTo("g1");

      assertThat(game.getFields().get(0).getGame()).isEqualTo(game);
   
      assertThat(game.getFields().get(10).getRight().getCoordinate()).isEqualTo("c4");
      assertThat(game.getFields().get(10).getLeft().getCoordinate()).isEqualTo("a4");
      assertThat(game.getFields().get(10).getTop().getCoordinate()).isEqualTo("b6");
      assertThat(game.getFields().get(10).getBottom().getCoordinate()).isEqualTo("b2");

      assertThat(game.getFields().get(19).getTop()).isEqualTo(game.getFields().get(16));
      assertThat(game.getFields().get(19).getBottom()).isEqualTo(game.getFields().get(22));
      assertThat(game.getFields().get(19).getRight()).isEqualTo(game.getFields().get(20));
      assertThat(game.getFields().get(19).getLeft()).isEqualTo(game.getFields().get(18));

   }
}

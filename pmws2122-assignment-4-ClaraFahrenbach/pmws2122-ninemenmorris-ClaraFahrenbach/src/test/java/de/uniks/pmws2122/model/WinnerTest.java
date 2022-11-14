package de.uniks.pmws2122.model;

import org.junit.Test;
import static de.uniks.pmws2122.Constants.*;
import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

        @Test
        public void testWinPlacingPhaseNoMenPlaced() {
                ModelService modelService = new ModelService();
                modelService.buildGame("Bob", "Alice", PLAYER_VS_PLAYER);

                Player PlayerWhite = modelService.getGame().getPlayers().get(0);
                modelService.startGame(PlayerWhite);

                Player PlayerBlack = modelService.getGame().getPlayers().get(1);
                modelService.startGame(PlayerBlack);

                PlayerWhite.setInitialPlacedMen(0);
                PlayerBlack.setInitialPlacedMen(0);

                modelService.checkWinner();
                assertThat(modelService.getGame().getWinner()).isEqualTo(null);

        }

        @Test
        public void testWinPlacingPhasePlayerWithTwoMenPlaced() {
                ModelService modelService = new ModelService();
                modelService.buildGame("Bob", "Alice", PLAYER_VS_PLAYER);

                Player PlayerWhite = modelService.getGame().getPlayers().get(0);
                modelService.startGame(PlayerWhite); // switched from Game game=modelService.getGame to
                                                     // modelService.buildGame(..) just for uniformity

                Player PlayerBlack = modelService.getGame().getPlayers().get(1);
                modelService.startGame(PlayerBlack);

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

                Man BlackOne = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(6));

                Man BlackTwo = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(8));

                modelService.checkWinner();
                assertThat(modelService.getGame().getWinner()).isEqualTo(null);

        }

        @Test
        public void testWinMovingPhaseNoWin() {
                ModelService modelService = new ModelService();
                modelService.buildGame("Bob", "Alice", PLAYER_VS_PLAYER);

                Player PlayerWhite = modelService.getGame().getPlayers().get(0);
                modelService.startGame(PlayerWhite);

                Player PlayerBlack = modelService.getGame().getPlayers().get(1);
                modelService.startGame(PlayerBlack);

                PlayerWhite.setInitialPlacedMen(9);
                PlayerBlack.setInitialPlacedMen(9);

                modelService.getGame().setPhase(GAME_PHASE_MOVING);

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

                Man BlackOne = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(6));

                Man BlackTwo = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(8));

                Man BlackThree = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(0));

                modelService.checkWinner();
                assertThat(modelService.getGame().getWinner()).isEqualTo(null);

        }

        @Test
        public void testWinMovingPhaseWin() {

                ModelService modelService = new ModelService();
                modelService.buildGame("Bob", "Alice", PLAYER_VS_PLAYER);

                Player PlayerWhite = modelService.getGame().getPlayers().get(0);
                modelService.startGame(PlayerWhite);

                Player PlayerBlack = modelService.getGame().getPlayers().get(1);
                modelService.startGame(PlayerBlack);

                PlayerWhite.setInitialPlacedMen(9);
                PlayerBlack.setInitialPlacedMen(9);

                modelService.getGame().setPhase(GAME_PHASE_MOVING);

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

                Man BlackOne = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(6));

                Man BlackTwo = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(8));

                modelService.checkWinner();
                assertThat(modelService.getGame().getWinner()).isEqualTo(modelService.getGame().getPlayers().get(0));
        }

        /*@Test // Test-Klasse WinnerTest erweitern um die Methode public void
              // testWinNoMovingPossible()
        public void testWinNoMovingPossible() {
                ModelService modelService = new ModelService();
                modelService.buildGame("Bob", "Alice");

                Player PlayerWhite = modelService.getGame().getPlayers().get(0);
                modelService.startGame(PlayerWhite);

                Player PlayerBlack = modelService.getGame().getPlayers().get(1);
                modelService.startGame(PlayerBlack);

                PlayerWhite.setInitialPlacedMen(9);
                PlayerBlack.setInitialPlacedMen(9);

                modelService.getGame().setPhase(GAME_PHASE_MOVING);

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
                                .setPosition(modelService.getGame().getFields().get(9));

                Man BlackOne = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(4));

                Man BlackTwo = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(10));
                Man BlackThree = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(14));
                Man BlackFour = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(15));
                Man BlackFive = new Man()
                                .setGame(modelService.getGame())
                                .setColor(COLOR_WHITE)
                                .setOwner(modelService.getGame().getPlayers().get(1))
                                .setPosition(modelService.getGame().getFields().get(21));
                modelService.checkWinner();
                assertThat(modelService.getGame().getWinner()).isEqualTo(modelService.getGame().getPlayers().get(1));
        }*/

        }
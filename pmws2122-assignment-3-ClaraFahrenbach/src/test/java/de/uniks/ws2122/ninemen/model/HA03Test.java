package de.uniks.ws2122.ninemen.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HA03Test {
    @Test
    public void testSimpleClassWithAttributes() {
        // Create objects
        Game nineMenMorrisGame = new Game()
            .setName("NineMenMorris")
            .setPhase("placing");
        Player alice = new Player()
            .setName("Alice")
            .setColor("white")
            .setAction("placing");
        Player bob = new Player()
            .setName("Bob")
            .setColor("black")
            .setAction("placing");
        Field f1 = new Field().setCoordinate("a4");
        Field f2 = new Field().setCoordinate("d4"); //this field should not exist, there is no d4 in nine mens morris
        Field f3 = new Field().setCoordinate("g7");

        // Check that all attributes are set correctly
        assertThat(nineMenMorrisGame.getName()).isEqualTo("NineMenMorris");
        assertThat(nineMenMorrisGame.getPhase()).isEqualTo("placing");
        assertThat(alice.getName()).isEqualTo("Alice");
        assertThat(alice.getColor()).isEqualTo("white");
        assertThat(alice.getAction()).isEqualTo("placing");
        assertThat(bob.getName()).isEqualTo("Bob");
        assertThat(bob.getColor()).isEqualTo("black");
        assertThat(bob.getAction()).isEqualTo("placing");
        assertThat(f1.getCoordinate()).isEqualTo("a4");
        assertThat(f2.getCoordinate()).isEqualTo("d4");
        assertThat(f3.getCoordinate()).isEqualTo("g7");

        // Change an attribute
        nineMenMorrisGame.setPhase("moving");

        // Check that the change was successfully
        assertThat(nineMenMorrisGame.getPhase()).isEqualTo("moving");
    }

    @Test
    public void testAssociationGameToPlayer() {
        // Create objects
        Game nineMenMorrisGame = new Game()
            .setName("NineMenMorris")
            .setPhase("placing");
        Player alice = new Player()
            .setName("Alice")
            .setColor("white")
            .setAction("placing");
        Player bob = new Player()
            .setName("Bob")
            .setColor("black")
            .setAction("placing");

        // Add associations between game and player
        nineMenMorrisGame.withPlayers(alice);
        bob.setGame(nineMenMorrisGame);

        nineMenMorrisGame.setCurrentPlayer(alice);

        // Check that all attributes are set correctly
        assertThat(nineMenMorrisGame.getName()).isEqualTo("NineMenMorris");
        assertThat(nineMenMorrisGame.getPhase()).isEqualTo("placing");
        assertThat(alice.getName()).isEqualTo("Alice");
        assertThat(alice.getColor()).isEqualTo("white");
        assertThat(alice.getAction()).isEqualTo("placing");
        assertThat(bob.getName()).isEqualTo("Bob");
        assertThat(bob.getColor()).isEqualTo("black");
        assertThat(bob.getAction()).isEqualTo("placing");

        // Check the associations
        assertThat(nineMenMorrisGame.getPlayers()).contains(alice, bob);
        assertThat(nineMenMorrisGame.getCurrentPlayer()).isEqualTo(alice);
        assertThat(alice.getGame()).isEqualTo(nineMenMorrisGame);
        assertThat(bob.getGame()).isEqualTo(nineMenMorrisGame);
        assertThat(alice.getCurrentGame()).isEqualTo(nineMenMorrisGame);

        // Set alice as winner
        nineMenMorrisGame.setWinner(alice);

        // Check the new associations
        assertThat(nineMenMorrisGame.getWinner()).isEqualTo(alice);
        assertThat(alice.getWonGame()).isEqualTo(nineMenMorrisGame);

        // Change the winner to bob
        bob.setWonGame(nineMenMorrisGame);
        assertThat(nineMenMorrisGame.getWinner()).isEqualTo(bob);
        assertThat(bob.getWonGame()).isEqualTo(nineMenMorrisGame);

        // Remove bob from the game
        bob.setGame(null);

        // check that bob is removed
        assertThat(nineMenMorrisGame.getPlayers()).contains(alice);
        assertThat(bob.getGame()).isNull();

        // Set the next and previous player
        alice.setNext(bob);
        alice.setPrevious(bob);

        // Check the new associations
        assertThat(alice.getNext()).isEqualTo(bob);
        assertThat(alice.getPrevious()).isEqualTo(bob);
        assertThat(bob.getNext()).isEqualTo(alice);
        assertThat(bob.getPrevious()).isEqualTo(alice);
    }

    @Test
    public void testAssociationGameToField() {
        // Create objects
        Game nineMenMorrisGame = new Game()
        .setName("NineMenMorris")
        .setPhase("placing");
         
        Field f1 = new Field().setCoordinate("e4");
        Field f2 = new Field().setCoordinate("f4");
        Field f3 = new Field().setCoordinate("d2");

        assertThat(nineMenMorrisGame.getName()).isEqualTo("NineMenMorris");
        assertThat(nineMenMorrisGame.getPhase()).isEqualTo("placing");
        assertThat(f1.getCoordinate()).isEqualTo("e4");
        assertThat(f2.getCoordinate()).isEqualTo("f4");
        assertThat(f3.getCoordinate()).isEqualTo("d2");

        nineMenMorrisGame.withFields(f1);
        nineMenMorrisGame.withFields(f2);
        nineMenMorrisGame.withFields(f3);
        f1.setGame(nineMenMorrisGame);
        f2.setGame(nineMenMorrisGame);
        f3.setGame(nineMenMorrisGame);
    
        assertThat(nineMenMorrisGame.getFields()).contains(f1,f2,f3);
        assertThat(f1.getGame()).isEqualTo(nineMenMorrisGame);
        assertThat(f2.getGame()).isEqualTo(nineMenMorrisGame);
        assertThat(f2.getGame()).isEqualTo(nineMenMorrisGame);

        //delete f3
        nineMenMorrisGame.withoutFields(f3);

        //check that f3 is deleted
        assertThat(nineMenMorrisGame.getFields()).contains(f1,f2);
        assertThat(nineMenMorrisGame.getFields()).doesNotContain(f3);
        assertThat(f3.getGame()).isNull();

        //delete f2
        f2.setGame(null);

        //check that f2 is deleted
        assertThat(nineMenMorrisGame.getFields()).contains(f1);
        assertThat(nineMenMorrisGame.getFields()).doesNotContain(f2, f3);
        assertThat(f2.getGame()).isNull();
        assertThat(f3.getGame()).isNull();

        //delete f1
        f1.setGame(null);
        
        //check that all fields are empty
        assertThat(nineMenMorrisGame.getFields()).isEmpty();
    }

}

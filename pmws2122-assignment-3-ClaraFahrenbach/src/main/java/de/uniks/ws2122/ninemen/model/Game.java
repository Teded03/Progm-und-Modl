package de.uniks.ws2122.ninemen.model;

import java.util.ArrayList;

public class Game {
    private String name;
    private String phase;
    private Player currentPlayer;
    private Player winner;
    private ArrayList<Field> fields = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public Game setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Game setPhase(String phase) {
        this.phase = phase;
        return this;
    }

    public String getPhase() {
        return phase;
    }
//Aufgaebteil 3
    public Game setCurrentPlayer(Player currentPlayer) { 
        if (this.currentPlayer == currentPlayer) {
            return this;
        }
        this.currentPlayer = currentPlayer;
        currentPlayer.setCurrentGame(this);
        return this;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Game withPlayers(Player player) {
       if (this.players.contains(player)) {
           return this;
        }
        this.players.add(player);
        player.setGame(this); 
        return this;
    }

    public Game setWinner(Player winner) { 
        if (this.winner == winner) {
            return this;
        }
        this.winner = winner;
        winner.setWonGame(this);
        return this;
    }

    public Player getWinner() {
        return winner;
    }

    public ArrayList<Field> getFields(){
        return fields;
    }

    public Game withFields(Field field) {
        if (this.fields.contains(field)){
            return this;
        }
        this.fields.add(field);
        field.setGame(this); 
        return this;
    }

    public Game withoutFields(Field field) {
        if(this.fields.contains(field)) {
            this.fields.remove(field);
            field.setGame(null);
        }return this;
    }

    public Player withoutPlayers(Player player) {
        return player;
    }

  
 
}
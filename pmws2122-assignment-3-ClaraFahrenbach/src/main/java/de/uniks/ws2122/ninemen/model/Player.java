package de.uniks.ws2122.ninemen.model;


public class Player {
    private String name;
    private String color;
    private String action;
    private Game game;
    private Player next;
    private Player previous;
    private Game currentGame;
    private Game wonGame; 

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Player setColor(String color) {
        this.color = color;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Player setAction(String action) {
        this.action = action;
        return this;
    }

    public String getAction() {
        return action;
    }
//Aufgaebteil 3 end
    public Player setGame(Game game) {
        if (this.game != null){
            if (this.game == game) {
                return this;
            }this.game.withoutPlayers(this);
        }
        this.game = game;
        if (game != null){
            game.withPlayers(this);
        }return this;
    }

    public Game getGame() { //0..1
        return game;
    }

    public Player setCurrentGame(Game currentGame){
        if (this.currentGame == currentGame){
            return this;
        }
        this.currentGame = currentGame;
        currentGame.setCurrentPlayer(this);
        return this;
    }

    public Game getCurrentGame() { //0..1
        return currentGame;
    }

    public Player setWonGame(Game wonGame) {
        if (this.wonGame == wonGame){
            return this;
        }
        this.wonGame = wonGame; 
        wonGame.setWinner(this);
        return this;
    }

    public Game getWonGame() { //0..1
        return wonGame;
    }

    public Player setNext(Player next) {
        if (this.next == next) {
            return this;
        }
        this.next = next;
        next.setPrevious(this);
        return this;
    }
    public Player getNext(){
        return next;
    }

    public Player setPrevious(Player previous) {
        if (this.previous == previous) {
            return this;
        }
        this.previous = previous;
        previous.setNext(this);
        return this;
    }
    public Player getPrevious(){
        return previous;
    }
}

package de.uniks.ws2122.ninemen.model;

public class Field {
    private String coordinate;
    private Game game;

    public Field setCoordinate(String coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public String getCoordinate() {
        return coordinate;
    }
//Aufgaebteil 3 
    public Game getGame(){
        return game;
    }

    public Field setGame(Game game) {
        if (this.game != null){
            if (this.game == game) {
                return this;
            }this.game.withoutFields(this);
        }
        this.game = game;
        if (game != null){
            game.withFields(this);
        }return this;
    }
}

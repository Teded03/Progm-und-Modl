package de.uniks.pmws2122.model;

import java.util.List;

import org.fulib.builder.ClassModelDecorator;
import org.fulib.builder.ClassModelManager;
import org.fulib.builder.reflect.Link;

public class GenModel implements ClassModelDecorator{

    class Game{
        String name;
        String phase;
        
        @Link("game")
        List<Player> players;

        @Link("currentGame")
        Player currentPlayer;

        @Link("wonGame")
        Player winner;

        @Link ("game")
        List<Man> men;

        @Link ("game")
        List<Field> fields;

    }

    class Player{
        String name;
        String color;
        String action;
        int initialPlacedMen;

        @Link("players")
        Game game;

        @Link("currentPlayer")
        Game currentGame;

        @Link("winner")
        Game wonGame;

        @Link("next")
        Player previous;

        @Link("previous")
        Player next;

        @Link ("owner")
        List<Man> men;
        
    }

    class Man{
        String color;

        @Link("men")
        Player owner;

        @Link("men")
        Game game;

        @Link("men")
        Field position;

    }

    class Field{
        String coordinate;

        @Link("position")
        Man men;

        @Link("left")
        Field right;

        @Link("right")
        Field left;

        @Link("top")
        Field bottom;

        @Link("bottom")
        Field top;

        @Link("fields")
        Game game;
    }

    @Override
    public void decorate(ClassModelManager mm){
        mm.haveNestedClasses(GenModel.class);
    }
}


package de.uniks.pmws2122.ai;

import static de.uniks.pmws2122.Constants.*;

import de.uniks.pmws2122.model.Field;
import de.uniks.pmws2122.model.Man;
import de.uniks.pmws2122.model.ModelService;
import de.uniks.pmws2122.model.Player;
import java.util.ArrayList;

public class Brain {
    ModelService ms;
    Player computerPlayer;

    public Brain(Player computerPlayer, ModelService ms) {
        this.computerPlayer = computerPlayer;
        this.ms = ms;
    }

    // ----------------------------------------------------------------------
    // TURN METHOD
    // ----------------------------------------------------------------------

    public void turn() {

        // first part of the move

        Man lastPutMan = null;
        if (this.computerPlayer.getAction().equals(PLAYER_ACTION_PLACING)) {
            lastPutMan = this.place();
        } else if (this.computerPlayer.getAction().equals(PLAYER_ACTION_MOVING)) {
            lastPutMan = this.move();
        } else if (this.computerPlayer.getAction().equals(PLAYER_ACTION_FLYING)) {
            lastPutMan = this.fly();
        }

        this.ms.checkMill(lastPutMan);

        // second part: player's action might be changed by now

        if (this.computerPlayer.getAction().equals(PLAYER_ACTION_REMOVE)) {
            this.remove();
        }

        this.ms.checkWinner();
        this.ms.nextTurn();
    }

    // ----------------------------------------------------------------------
    // HELPER METHODS FOR TURNING
    // ----------------------------------------------------------------------

    private int getRandom(int lenght) {
        int random = (int) (Math.random() * lenght);
        return random;
    }

    private Man place() {
        // set up some more helper variables if needed
        Field chosenField = null;

        // choose a field where I can place my man
        // try to block mills for enemy

        int enemyMenSize;
        Man enemyMan;
        Field computerMan;
        int i = 0;
        int j = 0;
        Player enemyPlayer;
        Player computerPlayer;

        enemyPlayer = ms.getGame().getPlayers().get(0);
        computerPlayer = ms.getGame().getPlayers().get(1);
        enemyMenSize = enemyPlayer.getMen().size();

        while (i < enemyMenSize && enemyMenSize != 0) {
            enemyMan = enemyPlayer.getMen().get(i);
            if (enemyMan.getPosition().getBottom() != null &&
                    enemyMan.getPosition().getBottom().getMen() != null &&
                    enemyMan.getPosition().getBottom().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getTop() != null &&
                    enemyMan.getPosition().getTop().getMen() == null) {
                chosenField = enemyMan.getPosition().getTop();
                break;
            }
            if (enemyMan.getPosition().getBottom() != null &&
                    enemyMan.getPosition().getBottom().getBottom() != null &&
                    enemyMan.getPosition().getBottom().getBottom().getMen() != null &&
                    enemyMan.getPosition().getBottom().getBottom().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getBottom() != null &&
                    enemyMan.getPosition().getBottom().getMen() == null) {
                chosenField = enemyMan.getPosition().getBottom();
                break;
            }
            if (enemyMan.getPosition().getTop() != null &&
                    enemyMan.getPosition().getTop().getMen() != null &&
                    enemyMan.getPosition().getTop().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getBottom() != null &&
                    enemyMan.getPosition().getBottom().getMen() == null) {
                chosenField = enemyMan.getPosition().getBottom();
                break;
            }
            if (enemyMan.getPosition().getTop() != null &&
                    enemyMan.getPosition().getTop().getTop() != null &&
                    enemyMan.getPosition().getTop().getTop().getMen() != null &&
                    enemyMan.getPosition().getTop().getTop().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getTop() != null &&
                    enemyMan.getPosition().getTop().getMen() == null) {
                chosenField = enemyMan.getPosition().getTop();
                break;
            }
            if (enemyMan.getPosition().getLeft() != null &&
                    enemyMan.getPosition().getLeft().getMen() != null &&
                    enemyMan.getPosition().getLeft().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getRight() != null &&
                    enemyMan.getPosition().getRight().getMen() == null) {
                chosenField = enemyMan.getPosition().getRight();
                break;
            }
            if (enemyMan.getPosition().getLeft() != null &&
                    enemyMan.getPosition().getLeft().getLeft() != null &&
                    enemyMan.getPosition().getLeft().getLeft().getMen() != null &&
                    enemyMan.getPosition().getLeft().getLeft().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getLeft() != null &&
                    enemyMan.getPosition().getLeft().getMen() == null) {
                chosenField = enemyMan.getPosition().getLeft();
                break;
            }
            if (enemyMan.getPosition().getRight() != null &&
                    enemyMan.getPosition().getRight().getMen() != null &&
                    enemyMan.getPosition().getRight().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getLeft() != null &&
                    enemyMan.getPosition().getLeft().getMen() == null) {
                chosenField = enemyMan.getPosition().getLeft();
                break;
            }
            if (enemyMan.getPosition().getRight() != null &&
                    enemyMan.getPosition().getRight().getRight() != null &&
                    enemyMan.getPosition().getRight().getRight().getMen() != null &&
                    enemyMan.getPosition().getRight().getRight().getMen().getOwner().equals(enemyPlayer) &&
                    enemyMan.getPosition().getRight() != null &&
                    enemyMan.getPosition().getRight().getMen() == null) {
                chosenField = enemyMan.getPosition().getRight();
                break;
            }
            i++;
        }

        // if two man from the computer are already in a row fill the mill
        Field checkedField;
        if (chosenField == null
                && (computerPlayer.getInitialPlacedMen() != 0 && computerPlayer.getInitialPlacedMen() != 1)) {
            while (j <= 23) {
                checkedField = ms.getGame().getFields().get(j);
                if (checkedField.getMen() != null && checkedField.getMen().getOwner().equals(computerPlayer)) {
                    computerMan = checkedField.getMen().getPosition();
                    if (computerMan.getBottom() != null &&
                            computerMan.getBottom().getMen() != null &&
                            computerMan.getBottom().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getTop() != null &&
                            computerMan.getTop().getMen() == null) {
                        chosenField = computerMan.getTop();
                        break;
                    }
                    if (computerMan.getTop() != null &&
                            computerMan.getTop().getMen() != null &&
                            computerMan.getTop().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getBottom() != null &&
                            computerMan.getBottom().getMen() == null) {
                        chosenField = computerMan.getBottom();
                        break;
                    }
                    if (computerMan.getTop() != null &&
                            computerMan.getTop().getMen() != null &&
                            computerMan.getTop().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getTop().getTop() != null &&
                            computerMan.getTop().getTop().getMen() == null) {
                        chosenField = computerMan.getTop().getTop();
                        break;
                    }
                    if (computerMan.getTop() != null &&
                            computerMan.getTop().getMen() == null &&
                            computerMan.getTop().getTop() != null &&
                            computerMan.getTop().getTop().getMen() != null &&
                            computerMan.getTop().getTop().getMen().getOwner().equals(computerPlayer)) {
                        chosenField = computerMan.getTop();
                        break;
                    }
                    if (computerMan.getBottom() != null &&
                            computerMan.getBottom().getMen() != null &&
                            computerMan.getBottom().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getBottom().getBottom() != null
                            && computerMan.getBottom().getBottom().getMen() == null) {
                        chosenField = computerMan.getBottom().getBottom();
                        break;
                    }
                    if (computerMan.getBottom() != null &&
                            computerMan.getBottom().getBottom() == null &&
                            computerMan.getBottom().getBottom() != null &&
                            computerMan.getBottom().getBottom().getMen() != null &&
                            computerMan.getBottom().getBottom().getMen().getOwner().equals(computerPlayer)) {
                        chosenField = computerMan.getBottom();
                        break;
                    }
                    if (computerMan.getLeft() != null &&
                            computerMan.getLeft().getMen() != null &&
                            computerMan.getLeft().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getLeft().getLeft() != null
                            && computerMan.getLeft().getLeft().getMen() == null) {
                        chosenField = computerMan.getLeft().getLeft();
                        break;
                    }
                    if (computerMan.getLeft() != null &&
                            computerMan.getLeft().getLeft() == null &&
                            computerMan.getLeft().getLeft() != null &&
                            computerMan.getLeft().getLeft().getMen() != null &&
                            computerMan.getLeft().getLeft().getMen().getOwner().equals(computerPlayer)) {
                        chosenField = computerMan.getLeft();
                        break;
                    }
                    if (computerMan.getRight() != null &&
                            computerMan.getRight().getMen() != null &&
                            computerMan.getRight().getMen().getOwner().equals(computerPlayer) &&
                            computerMan.getRight().getRight() != null
                            && computerMan.getRight().getRight().getMen() == null) {
                        chosenField = computerMan.getRight().getRight();
                        break;
                    }
                    if (computerMan.getRight() != null &&
                            computerMan.getRight().getRight() == null &&
                            computerMan.getRight().getRight() != null &&
                            computerMan.getRight().getRight().getMen() != null &&
                            computerMan.getRight().getRight().getMen().getOwner().equals(computerPlayer)) {
                        chosenField = computerMan.getRight();
                        break;
                    }
                }
                j++;
            }
        }

        // random choose when there is no mill to block or no mill to finish
        if (chosenField == null) {
            chosenField = ms.getGame().getFields().get(getRandom(24));
            while (chosenField.getMen() != null) {

                chosenField = ms.getGame().getFields().get(getRandom(24));
            }
        }
        // print turn
        printPlacing(chosenField);

        // execute my move
        this.ms.placeMan(chosenField);

        return chosenField.getMen();

    }

    private Man move() {
        // set up some more helper variables if needed
        Man chosenMan = null;
        Field fieldToMoveTo = null;
        ArrayList<Field> posPosToMove = new ArrayList<Field>();
        int posInArray;

        // select a man and a field to move to

        while (posPosToMove.size() == 0) {
            chosenMan = ms.getGame().getPlayers().get(1).getMen()
                    .get(getRandom(ms.getGame().getPlayers().get(1).getMen().size()));
            if (chosenMan.getPosition().getBottom() != null
                    && chosenMan.getPosition().getBottom().getMen() == null) {

                posPosToMove.add(chosenMan.getPosition().getBottom());
            }
            if (chosenMan.getPosition().getTop() != null && chosenMan.getPosition().getTop().getMen() == null) {

                posPosToMove.add(chosenMan.getPosition().getTop());
            }
            if (chosenMan.getPosition().getLeft() != null && chosenMan.getPosition().getLeft().getMen() == null) {

                posPosToMove.add(chosenMan.getPosition().getLeft());
            }
            if (chosenMan.getPosition().getRight() != null
                    && chosenMan.getPosition().getRight().getMen() == null) {

                posPosToMove.add(chosenMan.getPosition().getRight());
            }

        }

        posInArray = getRandom(posPosToMove.size());
        fieldToMoveTo = posPosToMove.get(posInArray);
        // change selected man and selected field in model service
        ms.setCurrentSelectedMan(chosenMan);
        ms.setCurrentSelectedField(fieldToMoveTo);
        // print turn
        printMoving(chosenMan, fieldToMoveTo);

        // execute my move
        this.ms.moveMan();

        return chosenMan;
    }

    private Man fly() {
        // set up some more helper variables if needed
        Man chosenMan = null;
        Field fieldToMoveTo = null;
        int ownMen;
        // select a man and a field to fly to
        ownMen = ms.getGame().getPlayers().get(1).getMen().size();
        chosenMan = ms.getGame().getPlayers().get(1).getMen().get(getRandom(ownMen));

        fieldToMoveTo = ms.getGame().getFields().get(getRandom(24));
        while (fieldToMoveTo.getMen() != null) {

            fieldToMoveTo = ms.getGame().getFields().get(getRandom(24));
        }
        // change selected man and selected field in model service
        ms.setCurrentSelectedMan(chosenMan);
        ms.setCurrentSelectedField(fieldToMoveTo);
        // print turn
        printFlying(chosenMan, fieldToMoveTo);

        // execute my move
        this.ms.moveMan();

        return chosenMan;
    }

    private void remove() {
        // set up some more helper variables if needed
        Man chosenMan = null;
        int enemyMen;
    

        // choose a man to remove
        enemyMen = ms.getGame().getPlayers().get(0).getMen().size();

        chosenMan = ms.getGame().getPlayers().get(0).getMen().get(getRandom(enemyMen));

        // print turn
        printRemoving(chosenMan);

        // execute my move
        this.ms.removeMan(chosenMan);
    }

    // ----------------------------------------------------------------------
    // HELPER METHODS FOR ...
    // ----------------------------------------------------------------------

    // some helper methods may be implemented here

    // ----------------------------------------------------------------------
    // PRINTING METHODS
    // ----------------------------------------------------------------------

    private void printPlacing(Field field) {
        String coordinate = field == null ? "null" : field.getCoordinate();

        System.out.println(computerPlayer.getName()
                + " placing on Field [ "
                + coordinate
                + " ]");
    }

    private void printMoving(Man man, Field destination) {
        printChangePos(man, destination, "moving");
    }

    private void printFlying(Man man, Field destination) {
        printChangePos(man, destination, "flying");
    }

    private void printChangePos(Man man, Field destination, String action) {
        String manColor = man == null ? "null" : man.getColor();
        String manOldPos = (man == null || man.getPosition() == null) ? "null" : man.getPosition().getCoordinate();
        String destCoord = destination == null ? "null" : destination.getCoordinate();

        System.out.println(computerPlayer.getName()
                + " " + action
                + " Man [ "
                + manColor
                + " ] from Field [ "
                + manOldPos
                + " ] to Field [ "
                + destCoord
                + " ]");
    }

    private void printRemoving(Man man) {
        String coordinate = "null";
        String manColor = "null";

        if (man != null) {
            manColor = man.getColor();
            if (man.getPosition() != null) {
                coordinate = man.getPosition().getCoordinate();
            }
        }

        System.out.println(computerPlayer.getName()
                + " removing [ "
                + manColor
                + " ] man from Field [ "
                + coordinate
                + " ]");
    }
}

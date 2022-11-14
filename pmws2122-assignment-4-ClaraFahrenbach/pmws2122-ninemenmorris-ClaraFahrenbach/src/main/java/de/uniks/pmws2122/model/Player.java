package de.uniks.pmws2122.model;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Collection;

public class Player
{
   public static final String PROPERTY_NAME = "name";
   public static final String PROPERTY_COLOR = "color";
   public static final String PROPERTY_ACTION = "action";
   public static final String PROPERTY_GAME = "game";
   public static final String PROPERTY_CURRENT_GAME = "currentGame";
   public static final String PROPERTY_WON_GAME = "wonGame";
   public static final String PROPERTY_PREVIOUS = "previous";
   public static final String PROPERTY_NEXT = "next";
   public static final String PROPERTY_MEN = "men";
   public static final String PROPERTY_INITIAL_PLACED_MEN = "initialPlacedMen";
   private String name;
   private String color;
   private String action;
   private Game game;
   protected PropertyChangeSupport listeners;
   private Game currentGame;
   private Game wonGame;
   private Player previous;
   private Player next;
   private List<Man> men;
   private int initialPlacedMen;

   public String getName()
   {
      return this.name;
   }

   public Player setName(String value)
   {
      if (Objects.equals(value, this.name))
      {
         return this;
      }

      final String oldValue = this.name;
      this.name = value;
      this.firePropertyChange(PROPERTY_NAME, oldValue, value);
      return this;
   }

   public String getColor()
   {
      return this.color;
   }

   public Player setColor(String value)
   {
      if (Objects.equals(value, this.color))
      {
         return this;
      }

      final String oldValue = this.color;
      this.color = value;
      this.firePropertyChange(PROPERTY_COLOR, oldValue, value);
      return this;
   }

   public String getAction()
   {
      return this.action;
   }

   public Player setAction(String value)
   {
      if (Objects.equals(value, this.action))
      {
         return this;
      }

      final String oldValue = this.action;
      this.action = value;
      this.firePropertyChange(PROPERTY_ACTION, oldValue, value);
      return this;
   }

   public Game getGame()
   {
      return this.game;
   }

   public Player setGame(Game value)
   {
      if (this.game == value)
      {
         return this;
      }

      final Game oldValue = this.game;
      if (this.game != null)
      {
         this.game = null;
         oldValue.withoutPlayers(this);
      }
      this.game = value;
      if (value != null)
      {
         value.withPlayers(this);
      }
      this.firePropertyChange(PROPERTY_GAME, oldValue, value);
      return this;
   }

   public Game getCurrentGame()
   {
      return this.currentGame;
   }

   public Player setCurrentGame(Game value)
   {
      if (this.currentGame == value)
      {
         return this;
      }

      final Game oldValue = this.currentGame;
      if (this.currentGame != null)
      {
         this.currentGame = null;
         oldValue.setCurrentPlayer(null);
      }
      this.currentGame = value;
      if (value != null)
      {
         value.setCurrentPlayer(this);
      }
      this.firePropertyChange(PROPERTY_CURRENT_GAME, oldValue, value);
      return this;
   }

   public Game getWonGame()
   {
      return this.wonGame;
   }

   public Player setWonGame(Game value)
   {
      if (this.wonGame == value)
      {
         return this;
      }

      final Game oldValue = this.wonGame;
      if (this.wonGame != null)
      {
         this.wonGame = null;
         oldValue.setWinner(null);
      }
      this.wonGame = value;
      if (value != null)
      {
         value.setWinner(this);
      }
      this.firePropertyChange(PROPERTY_WON_GAME, oldValue, value);
      return this;
   }

   public Player getPrevious()
   {
      return this.previous;
   }

   public Player setPrevious(Player value)
   {
      if (this.previous == value)
      {
         return this;
      }

      final Player oldValue = this.previous;
      if (this.previous != null)
      {
         this.previous = null;
         oldValue.setNext(null);
      }
      this.previous = value;
      if (value != null)
      {
         value.setNext(this);
      }
      this.firePropertyChange(PROPERTY_PREVIOUS, oldValue, value);
      return this;
   }

   public Player getNext()
   {
      return this.next;
   }

   public Player setNext(Player value)
   {
      if (this.next == value)
      {
         return this;
      }

      final Player oldValue = this.next;
      if (this.next != null)
      {
         this.next = null;
         oldValue.setPrevious(null);
      }
      this.next = value;
      if (value != null)
      {
         value.setPrevious(this);
      }
      this.firePropertyChange(PROPERTY_NEXT, oldValue, value);
      return this;
   }

   public List<Man> getMen()
   {
      return this.men != null ? Collections.unmodifiableList(this.men) : Collections.emptyList();
   }

   public Player withMen(Man value)
   {
      if (this.men == null)
      {
         this.men = new ArrayList<>();
      }
      if (!this.men.contains(value))
      {
         this.men.add(value);
         value.setOwner(this);
         this.firePropertyChange(PROPERTY_MEN, null, value);
      }
      return this;
   }

   public Player withMen(Man... value)
   {
      for (final Man item : value)
      {
         this.withMen(item);
      }
      return this;
   }

   public Player withMen(Collection<? extends Man> value)
   {
      for (final Man item : value)
      {
         this.withMen(item);
      }
      return this;
   }

   public Player withoutMen(Man value)
   {
      if (this.men != null && this.men.remove(value))
      {
         value.setOwner(null);
         this.firePropertyChange(PROPERTY_MEN, value, null);
      }
      return this;
   }

   public Player withoutMen(Man... value)
   {
      for (final Man item : value)
      {
         this.withoutMen(item);
      }
      return this;
   }

   public Player withoutMen(Collection<? extends Man> value)
   {
      for (final Man item : value)
      {
         this.withoutMen(item);
      }
      return this;
   }

   public Player setInitialPlacedMen(int value)
   {
      if (value == this.initialPlacedMen)
      {
         return this;
      }

      final int oldValue = this.initialPlacedMen;
      this.initialPlacedMen = value;
      this.firePropertyChange(PROPERTY_INITIAL_PLACED_MEN, oldValue, value);
      return this;
   }

   public int getInitialPlacedMen()
   {
      return this.initialPlacedMen;
   }

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (this.listeners != null)
      {
         this.listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public PropertyChangeSupport listeners()
   {
      if (this.listeners == null)
      {
         this.listeners = new PropertyChangeSupport(this);
      }
      return this.listeners;
   }

   @Override
   public String toString()
   {
      final StringBuilder result = new StringBuilder();
      result.append(' ').append(this.getName());
      result.append(' ').append(this.getColor());
      result.append(' ').append(this.getAction());
      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutMen(new ArrayList<>(this.getMen()));
      this.setGame(null);
      this.setCurrentGame(null);
      this.setWonGame(null);
      this.setPrevious(null);
      this.setNext(null);
   }

   public IntPredicate gameWon() {
      return null;
   }
}

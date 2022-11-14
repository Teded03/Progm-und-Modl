package de.uniks.pmws2122.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
import java.util.Collection;
import java.beans.PropertyChangeSupport;

public class Game
{
   public static final String PROPERTY_NAME = "name";
   public static final String PROPERTY_PHASE = "phase";
   public static final String PROPERTY_PLAYERS = "players";
   public static final String PROPERTY_CURRENT_PLAYER = "currentPlayer";
   public static final String PROPERTY_WINNER = "winner";
   public static final String PROPERTY_MEN = "men";
   public static final String PROPERTY_FIELDS = "fields";
   private String name;
   private String phase;
   private List<Player> players;
   protected PropertyChangeSupport listeners;
   private Player currentPlayer;
   private Player winner;
   private List<Man> men;
   private List<Field> fields;

   public String getName()
   {
      return this.name;
   }

   public Game setName(String value)
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

   public String getPhase()
   {
      return this.phase;
   }

   public Game setPhase(String value)
   {
      if (Objects.equals(value, this.phase))
      {
         return this;
      }

      final String oldValue = this.phase;
      this.phase = value;
      this.firePropertyChange(PROPERTY_PHASE, oldValue, value);
      return this;
   }

   public List<Player> getPlayers()
   {
      return this.players != null ? Collections.unmodifiableList(this.players) : Collections.emptyList();
   }

   public Game withPlayers(Player value)
   {
      if (this.players == null)
      {
         this.players = new ArrayList<>();
      }
      if (!this.players.contains(value))
      {
         this.players.add(value);
         value.setGame(this);
         this.firePropertyChange(PROPERTY_PLAYERS, null, value);
      }
      return this;
   }

   public Game withPlayers(Player... value)
   {
      for (final Player item : value)
      {
         this.withPlayers(item);
      }
      return this;
   }

   public Game withPlayers(Collection<? extends Player> value)
   {
      for (final Player item : value)
      {
         this.withPlayers(item);
      }
      return this;
   }

   public Game withoutPlayers(Player value)
   {
      if (this.players != null && this.players.remove(value))
      {
         value.setGame(null);
         this.firePropertyChange(PROPERTY_PLAYERS, value, null);
      }
      return this;
   }

   public Game withoutPlayers(Player... value)
   {
      for (final Player item : value)
      {
         this.withoutPlayers(item);
      }
      return this;
   }

   public Game withoutPlayers(Collection<? extends Player> value)
   {
      for (final Player item : value)
      {
         this.withoutPlayers(item);
      }
      return this;
   }

   public Player getCurrentPlayer()
   {
      return this.currentPlayer;
   }

   public Game setCurrentPlayer(Player value)
   {
      if (this.currentPlayer == value)
      {
         return this;
      }

      final Player oldValue = this.currentPlayer;
      if (this.currentPlayer != null)
      {
         this.currentPlayer = null;
         oldValue.setCurrentGame(null);
      }
      this.currentPlayer = value;
      if (value != null)
      {
         value.setCurrentGame(this);
      }
      this.firePropertyChange(PROPERTY_CURRENT_PLAYER, oldValue, value);
      return this;
   }

   public Player getWinner()
   {
      return this.winner;
   }

   public Game setWinner(Player value)
   {
      if (this.winner == value)
      {
         return this;
      }

      final Player oldValue = this.winner;
      if (this.winner != null)
      {
         this.winner = null;
         oldValue.setWonGame(null);
      }
      this.winner = value;
      if (value != null)
      {
         value.setWonGame(this);
      }
      this.firePropertyChange(PROPERTY_WINNER, oldValue, value);
      return this;
   }

   public List<Man> getMen()
   {
      return this.men != null ? Collections.unmodifiableList(this.men) : Collections.emptyList();
   }

   public Game withMen(Man value)
   {
      if (this.men == null)
      {
         this.men = new ArrayList<>();
      }
      if (!this.men.contains(value))
      {
         this.men.add(value);
         value.setGame(this);
         this.firePropertyChange(PROPERTY_MEN, null, value);
      }
      return this;
   }

   public Game withMen(Man... value)
   {
      for (final Man item : value)
      {
         this.withMen(item);
      }
      return this;
   }

   public Game withMen(Collection<? extends Man> value)
   {
      for (final Man item : value)
      {
         this.withMen(item);
      }
      return this;
   }

   public Game withoutMen(Man value)
   {
      if (this.men != null && this.men.remove(value))
      {
         value.setGame(null);
         this.firePropertyChange(PROPERTY_MEN, value, null);
      }
      return this;
   }

   public Game withoutMen(Man... value)
   {
      for (final Man item : value)
      {
         this.withoutMen(item);
      }
      return this;
   }

   public Game withoutMen(Collection<? extends Man> value)
   {
      for (final Man item : value)
      {
         this.withoutMen(item);
      }
      return this;
   }

   public List<Field> getFields()
   {
      return this.fields != null ? Collections.unmodifiableList(this.fields) : Collections.emptyList();
   }

   public Game withFields(Field value)
   {
      if (this.fields == null)
      {
         this.fields = new ArrayList<>();
      }
      if (!this.fields.contains(value))
      {
         this.fields.add(value);
         value.setGame(this);
         this.firePropertyChange(PROPERTY_FIELDS, null, value);
      }
      return this;
   }

   public Game withFields(Field... value)
   {
      for (final Field item : value)
      {
         this.withFields(item);
      }
      return this;
   }

   public Game withFields(Collection<? extends Field> value)
   {
      for (final Field item : value)
      {
         this.withFields(item);
      }
      return this;
   }

   public Game withoutFields(Field value)
   {
      if (this.fields != null && this.fields.remove(value))
      {
         value.setGame(null);
         this.firePropertyChange(PROPERTY_FIELDS, value, null);
      }
      return this;
   }

   public Game withoutFields(Field... value)
   {
      for (final Field item : value)
      {
         this.withoutFields(item);
      }
      return this;
   }

   public Game withoutFields(Collection<? extends Field> value)
   {
      for (final Field item : value)
      {
         this.withoutFields(item);
      }
      return this;
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
      result.append(' ').append(this.getPhase());
      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutFields(new ArrayList<>(this.getFields()));
      this.withoutMen(new ArrayList<>(this.getMen()));
      this.withoutPlayers(new ArrayList<>(this.getPlayers()));
      this.setCurrentPlayer(null);
      this.setWinner(null);
   }
}

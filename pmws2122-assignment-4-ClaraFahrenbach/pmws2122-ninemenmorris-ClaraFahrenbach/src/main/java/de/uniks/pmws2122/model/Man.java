package de.uniks.pmws2122.model;
import java.util.Objects;
import java.beans.PropertyChangeSupport;

public class Man
{
   public static final String PROPERTY_COLOR = "color";
   public static final String PROPERTY_POSITION = "position";
   public static final String PROPERTY_GAME = "game";
   public static final String PROPERTY_OWNER = "owner";
   private String color;
   protected PropertyChangeSupport listeners;
   private Field position;
   private Game game;
   private Player owner;

   public String getColor()
   {
      return this.color;
   }

   public Man setColor(String value)
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

   public Field getPosition()
   {
      return this.position;
   }

   public Man setPosition(Field value)
   {
      if (this.position == value)
      {
         return this;
      }

      final Field oldValue = this.position;
      if (this.position != null)
      {
         this.position = null;
         oldValue.setMen(null);
      }
      this.position = value;
      if (value != null)
      {
         value.setMen(this);
      }
      this.firePropertyChange(PROPERTY_POSITION, oldValue, value);
      return this;
   }

   public Game getGame()
   {
      return this.game;
   }

   public Man setGame(Game value)
   {
      if (this.game == value)
      {
         return this;
      }

      final Game oldValue = this.game;
      if (this.game != null)
      {
         this.game = null;
         oldValue.withoutMen(this);
      }
      this.game = value;
      if (value != null)
      {
         value.withMen(this);
      }
      this.firePropertyChange(PROPERTY_GAME, oldValue, value);
      return this;
   }

   public Player getOwner()
   {
      return this.owner;
   }

   public Man setOwner(Player value)
   {
      if (this.owner == value)
      {
         return this;
      }

      final Player oldValue = this.owner;
      if (this.owner != null)
      {
         this.owner = null;
         oldValue.withoutMen(this);
      }
      this.owner = value;
      if (value != null)
      {
         value.withMen(this);
      }
      this.firePropertyChange(PROPERTY_OWNER, oldValue, value);
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
      result.append(' ').append(this.getColor());
      return result.substring(1);
   }

   public void removeYou()
   {
      this.setPosition(null);
      this.setOwner(null);
      this.setGame(null);
   }
}

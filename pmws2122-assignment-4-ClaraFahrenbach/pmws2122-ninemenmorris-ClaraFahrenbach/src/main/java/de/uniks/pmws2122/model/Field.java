package de.uniks.pmws2122.model;
import java.util.Objects;
import java.beans.PropertyChangeSupport;

public class Field
{
   public static final String PROPERTY_COORDINATE = "coordinate";
   public static final String PROPERTY_MEN = "men";
   public static final String PROPERTY_GAME = "game";
   public static final String PROPERTY_BOTTOM = "bottom";
   public static final String PROPERTY_TOP = "top";
   public static final String PROPERTY_LEFT = "left";
   public static final String PROPERTY_RIGHT = "right";
   private String coordinate;
   protected PropertyChangeSupport listeners;
   private Man men;
   private Game game;
   private Field bottom;
   private Field top;
   private Field left;
   private Field right;

   public String getCoordinate()
   {
      return this.coordinate;
   }

   public Field setCoordinate(String value)
   {
      if (Objects.equals(value, this.coordinate))
      {
         return this;
      }

      final String oldValue = this.coordinate;
      this.coordinate = value;
      this.firePropertyChange(PROPERTY_COORDINATE, oldValue, value);
      return this;
   }

   public Man getMen()
   {
      return this.men;
   }

   public Field setMen(Man value)
   {
      if (this.men == value)
      {
         return this;
      }

      final Man oldValue = this.men;
      if (this.men != null)
      {
         this.men = null;
         oldValue.setPosition(null);
      }
      this.men = value;
      if (value != null)
      {
         value.setPosition(this);
      }
      this.firePropertyChange(PROPERTY_MEN, oldValue, value);
      return this;
   }

   public Game getGame()
   {
      return this.game;
   }

   public Field setGame(Game value)
   {
      if (this.game == value)
      {
         return this;
      }

      final Game oldValue = this.game;
      if (this.game != null)
      {
         this.game = null;
         oldValue.withoutFields(this);
      }
      this.game = value;
      if (value != null)
      {
         value.withFields(this);
      }
      this.firePropertyChange(PROPERTY_GAME, oldValue, value);
      return this;
   }

   public Field getBottom()
   {
      return this.bottom;
   }

   public Field setBottom(Field value)
   {
      if (this.bottom == value)
      {
         return this;
      }

      final Field oldValue = this.bottom;
      if (this.bottom != null)
      {
         this.bottom = null;
         oldValue.setTop(null);
      }
      this.bottom = value;
      if (value != null)
      {
         value.setTop(this);
      }
      this.firePropertyChange(PROPERTY_BOTTOM, oldValue, value);
      return this;
   }

   public Field getTop()
   {
      return this.top;
   }

   public Field setTop(Field value)
   {
      if (this.top == value)
      {
         return this;
      }

      final Field oldValue = this.top;
      if (this.top != null)
      {
         this.top = null;
         oldValue.setBottom(null);
      }
      this.top = value;
      if (value != null)
      {
         value.setBottom(this);
      }
      this.firePropertyChange(PROPERTY_TOP, oldValue, value);
      return this;
   }

   public Field getLeft()
   {
      return this.left;
   }

   public Field setLeft(Field value)
   {
      if (this.left == value)
      {
         return this;
      }

      final Field oldValue = this.left;
      if (this.left != null)
      {
         this.left = null;
         oldValue.setRight(null);
      }
      this.left = value;
      if (value != null)
      {
         value.setRight(this);
      }
      this.firePropertyChange(PROPERTY_LEFT, oldValue, value);
      return this;
   }

   public Field getRight()
   {
      return this.right;
   }

   public Field setRight(Field value)
   {
      if (this.right == value)
      {
         return this;
      }

      final Field oldValue = this.right;
      if (this.right != null)
      {
         this.right = null;
         oldValue.setLeft(null);
      }
      this.right = value;
      if (value != null)
      {
         value.setLeft(this);
      }
      this.firePropertyChange(PROPERTY_RIGHT, oldValue, value);
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
      result.append(' ').append(this.getCoordinate());
      return result.substring(1);
   }

   public void removeYou()
   {
      this.setMen(null);
      this.setRight(null);
      this.setLeft(null);
      this.setBottom(null);
      this.setTop(null);
      this.setGame(null);
   }
}

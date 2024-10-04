package tv.laptopgaming.Entity;

import java.util.Comparator;

public interface Tile {
  
  public Suit getSuit();
  
  public int compareTo(Object o);
  
}

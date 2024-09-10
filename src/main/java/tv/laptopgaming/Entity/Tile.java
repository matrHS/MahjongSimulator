package tv.laptopgaming.Entity;

import java.util.Comparator;

public class Tile {
  private Suit suit;

  /**
   * Constructor for Tile
   * 
   * @param suit of the tile.
   */
  public Tile(Suit suit) {
    this.setSuit(suit);
  }
  
  private void setSuit(Suit suit) {
    this.suit = suit;
  }
  
  public Suit getSuit() {
    return this.suit;
  }


  
}

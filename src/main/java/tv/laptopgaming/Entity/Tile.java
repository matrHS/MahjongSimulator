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

  /**
   * Compares the suit of the tile.
   *
   * @param o Tile to compare to.
   * @return 0 if the suits are the same, -1 if the suit is "lower", 1 if the suit is "higher".
   */
  public int compareTo(Tile o) {
    return Comparator.comparing(Tile::getSuit).compare(this, o);
  }

  
}

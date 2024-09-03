package tv.laptopgaming.Entity;

public class NumberTile extends Tile{
  
  private int number;
      
  /**
   * Constructor for Tile
   *
   * @param suit of the tile.
   */
  public NumberTile(Suit suit) {
    super(suit);
    this.setNumber(number);
  }
  
  private void setNumber(int number) {
    this.number = number;
  }
}

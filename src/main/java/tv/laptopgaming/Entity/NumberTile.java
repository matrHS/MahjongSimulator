package tv.laptopgaming.Entity;

public class NumberTile implements Tile {
  
  private Suit suit;
  private int number;
      
  /**
   * Constructor for Tile
   *
   * @param suit of the tile.
   */
  public NumberTile(Suit suit, int number) {
    this.setSuit(suit);
    this.setNumber(number);
  }
  
  public NumberTile(NumberTile numberTile) {
    this.setSuit(numberTile.getSuit());
    this.setNumber(numberTile.getNumber());
  }

  

  private void setNumber(int number) {
    this.number = number;
  }
  
  public int getNumber() {
    return this.number;
  }

  
//  public int compareTo(NumberTile o) {
//    int comparisonValue = this.getSuit().compareTo(o.getSuit());
//    if (comparisonValue == 0) {
//      comparisonValue = Integer.compare(this.getNumber(), o.getNumber());
//    }
//    
//    return comparisonValue;
//  }

  @Override
  public int compareTo(Object o) {
    if (!(o instanceof NumberTile))
      throw new IllegalArgumentException("Comparison object not number tile");
    
    int comparisonValue = this.getSuit().compareTo(((NumberTile)o).getSuit());
    if (comparisonValue == 0) {
      comparisonValue = Integer.compare(this.getNumber(), ((NumberTile)o).getNumber());
    }

    return comparisonValue;
  }
  
  @Override
  public String toString() {
    return this.getSuit() + " " + this.getNumber();
  }
  
  private void setSuit(Suit suit) {
    this.suit = suit;
  }
  
  @Override
  public Suit getSuit() {
    return this.suit;
  }


}

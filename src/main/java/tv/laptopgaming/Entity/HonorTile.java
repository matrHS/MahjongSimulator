package tv.laptopgaming.Entity;

public class HonorTile implements Tile{
  
  private Honor honorSymbol;
  
  private Suit suit;
  
  /**
   * Constructor for Tile
   *
   * @param suit   of the tile.
   * @param honor of the tile.
   */
  public HonorTile(Suit suit, Honor honor) {
    this.setSuit(suit);
    this.setHonor(honor);
  }
  
  private void setHonor(Honor honor) {
    this.honorSymbol = honor;
  }
  
  public Honor getHonor() {
    return this.honorSymbol;
  }
  
  
  public int compareTo(Tile o) {
    return this.getHonor().compareTo(((HonorTile) o).getHonor());
  }

  @Override
  public int compareTo(Object o) {
    if (!(o instanceof HonorTile))
      throw new IllegalArgumentException("Compared tile not Honor tile");
    return this.getHonor().compareTo(((HonorTile) o).getHonor());
  }
  
  @Override
  public String toString() {
    return this.getSuit() + " " + this.getHonor();
  }
  
  public void setSuit(Suit suit) {
    this.suit = suit;
  }
  
  @Override
  public Suit getSuit() {
    return this.suit;
  }

  
}

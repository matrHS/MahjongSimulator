package tv.laptopgaming.Entity;

public class HonorTile extends Tile{
  
  private Honor honorSymbol;
  
  /**
   * Constructor for Tile
   *
   * @param suit   of the tile.
   * @param honor of the tile.
   */
  public HonorTile(Suit suit, Honor honor) {
    super(suit);
    this.setHonor(honor);
  }
  
  private void setHonor(Honor honor) {
    this.honorSymbol = honor;
  }
  
  public Honor getHonor() {
    return this.honorSymbol;
  }
  
  public int compareTo(HonorTile o) {
    return this.getHonor().compareTo(o.getHonor());
  }
  
  @Override
  public String toString() {
    return this.getSuit() + " " + this.getHonor();
  }
}

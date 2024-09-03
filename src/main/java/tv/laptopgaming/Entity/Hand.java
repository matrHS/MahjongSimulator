package tv.laptopgaming.Entity;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private List<Tile> hand;
  private String playerName;
  
  public Hand(String playerName) {
    hand = new ArrayList<Tile>();
    this.setPlayerName(playerName);
  }
  
  private void setPlayerName(String name) {
    this.playerName = name;
  }
  
  /**
   * Adds a tile to the hand.
   * 
   * @param tile to add
   */
  public void addTile(Tile tile) {
    hand.add(tile);
  }
  
  /**
   * Removes tile from hand.
   * 
   * @param tile to remove.
   */
  private void removeTile(Tile tile) {
    hand.remove(tile);
  }
  
  public List<Tile> getTiles() {
    return this.hand;
  }
  
  public String getPlayerName() {
    return this.playerName;
  }
  
  public void discardTile(Tile tile) {
    if (hand.contains(tile)) {
      this.removeTile(tile);
    }
  }
  
  public void sortHand() {
    
  }
  
  @Override
  public String toString() {
    StringBuilder sb;
    sb = new StringBuilder();
    for (Tile tile : hand) {
      sb.append(tile.toString());
      sb.append(", ");
    }
    return sb.toString();
  }
}

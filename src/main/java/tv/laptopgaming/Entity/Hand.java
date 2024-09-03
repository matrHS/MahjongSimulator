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
  public void removeTile(Tile tile) {
    hand.remove(tile);
  }
  
  public List<Tile> getTiles() {
    return this.hand;
  }
  
  public String getPlayerName() {
    return this.playerName;
  }
}

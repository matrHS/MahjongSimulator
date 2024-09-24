package tv.laptopgaming.Entity;

import java.util.ArrayList;
import java.util.List;

public class Hand {
  private ArrayList<Tile> hand;
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
    List<Tile> sortedHand;
    
    sortedHand = hand.stream().sorted(
        (tile1, tile2) -> {
          if (tile1.getSuit().compareTo(tile2.getSuit()) == 0) {
            if (tile1 instanceof NumberTile && tile2 instanceof NumberTile) {
              return ((NumberTile) tile1).compareTo((NumberTile) tile2);
            } else if (tile1 instanceof HonorTile && tile2 instanceof HonorTile) {
              return ((HonorTile) tile1).compareTo((HonorTile) tile2);
            } else if (tile1 instanceof NumberTile && tile2 instanceof HonorTile) {
              return -1;
            } else {
              return 1;
            }
          } else {
            return tile1.getSuit().compareTo(tile2.getSuit());
          }
        }
    ).toList();
    
    this.hand = new ArrayList<>(sortedHand);
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

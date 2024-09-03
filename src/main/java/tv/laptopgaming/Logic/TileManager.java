package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tv.laptopgaming.Entity.Tile;

public class TileManager {
  private List<Tile> tiles;
  private Random random;
  
  public TileManager() {
    this.random = new Random();
    this.tiles = new ArrayList<Tile>();
  }

  /**
   * Adds a tile to the tile manager.
   * 
   * @param tile to add
   */
  public void addTile(Tile tile) {
    tiles.add(tile);
  }

  /**
   * Removes tile from tile manager.
   * 
   * @param tile to remove.
   */
  public void removeTile(Tile tile) {
    tiles.remove(tile);
  }
  
  public List<Tile> getTiles() {
    return tiles;
  }
  
  public int getTilesSize() {
    return tiles.size();
  }
  
  public Tile dealTile() {
    Tile dealtTile;
    dealtTile = tiles.get(random.nextInt(this.getTilesSize()));
    this.tiles.remove(dealtTile);
    return dealtTile;
  }
  
}

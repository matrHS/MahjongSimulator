package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.List;
import tv.laptopgaming.Entity.Tile;

public class TileManager {
  private List<Tile> tiles;
  
  public TileManager() {
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
  
}

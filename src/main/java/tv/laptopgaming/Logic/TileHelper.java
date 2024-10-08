package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Tile;

public final class TileHelper {
  
  public boolean tileListContainsOnlySameType(List<Tile> tiles) {
    return tiles.stream().allMatch(t -> t.getClass().equals(tiles.getFirst().getClass()));
  }
  
  public boolean tileListOnlyNumberTiles(List<Tile> tiles) {
    return tiles.stream().allMatch(tile -> tile instanceof NumberTile);
  }
  
  public boolean tileListOnlyHonorTiles(List<Tile> tiles) {
    return tiles.stream().allMatch(tile -> tile instanceof HonorTile);
  }
  
  public boolean numberTileListContainsNext(List<Tile> numberTiles) {
    boolean state = false;
    if (tileListOnlyNumberTiles(numberTiles)) {
      state = numberTiles.stream().anyMatch(tile -> {
        return ((NumberTile) numberTiles.getFirst()).getNumber() +1 == ((NumberTile) tile).getNumber();
      });
    }

    return state;
  }
  
  public List<Tile> convertTreeToFlatSetNonSingle(List<TreeSet<Tile>> tileSets) {
    List<Tile> tiles = new ArrayList<>();
    for (TreeSet<Tile> tileSet : tileSets) {
      if (tileSet.size() > 1) {
        tiles.addAll(tileSet);
      }
    }
    
    return tiles;
  }
}

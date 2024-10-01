package tv.laptopgaming.Logic;

import java.util.List;
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
}

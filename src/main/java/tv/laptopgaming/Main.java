package tv.laptopgaming;

import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;
import tv.laptopgaming.Logic.TileManager;

public class Main {
  public static void main(String[] args) {
    TileManager tileManager;
    tileManager = new TileManager();
    
    tileSetup(tileManager);
    printTileManager(tileManager);
  }
  
  public static void tileSetup(TileManager tileManager) {
    for (Suit suit : Suit.values()) {
      switch (suit) {
        case Bamboo:
          addNumberTiles(tileManager,suit);
          break;
        case Dots:
          addNumberTiles(tileManager,suit);
          break;
        case Symbol:
          addNumberTiles(tileManager,suit);
          break;
        case Dragon:
          addHonorTiles(tileManager,suit);
          break;
        case Wind:
          addHonorTiles(tileManager,suit);
          break;
      }
    }
  }
  
  public static void addHonorTiles(TileManager tileManager,Suit suit) {
    for (Honor honor : Honor.values()) {
      if (suit == Suit.Dragon) {
        if (honor == Honor.Red || honor == Honor.Green || honor == Honor.White) {
          tileManager.addTile(new HonorTile(suit,honor));
          tileManager.addTile(new HonorTile(suit,honor));
          tileManager.addTile(new HonorTile(suit,honor));
          tileManager.addTile(new HonorTile(suit,honor));
        }
      } else if (suit == Suit.Wind) {
        if (honor == Honor.East || honor == Honor.South || honor == Honor.West ||
            honor == Honor.North) {
          tileManager.addTile(new HonorTile(suit, honor));
          tileManager.addTile(new HonorTile(suit, honor));
          tileManager.addTile(new HonorTile(suit, honor));
          tileManager.addTile(new HonorTile(suit, honor));
        }
      }
    }
  }
  
  public static void addNumberTiles(TileManager tileManager,Suit suit) {
    for (int i = 1; i <= 9; i++) {
      tileManager.addTile(new NumberTile(suit,i));
    }
  }
  
  public static void printTileManager(TileManager tileManager) {
    for (Tile tile : tileManager.getTiles()) {
      System.out.println(tile.toString());
    }
  }
}
package tv.laptopgaming;

import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;
import tv.laptopgaming.Logic.GameManager;
import tv.laptopgaming.Logic.TileManager;

public class Main {
  public static void main(String[] args) {
    GameManager gameManager;
    gameManager = new GameManager();
    
    gameManager.gameSetup();
    gameManager.startGame();
  }
  
  
}
package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;

public class GameManager {
  
  private TileManager tileManager; 
  private List<Hand> hands;
  private int currentPlayer;
  
  public GameManager() {
    
  }
  
  public void gameSetup() {
    tileManager = new TileManager();
    tileSetup(tileManager);
    System.out.println(tileManager.getTilesSize());
    
    hands = new ArrayList<Hand>();
    hands.add(new Hand("Player 1"));
    hands.add(new Hand("Player 2"));
    hands.add(new Hand("Player 3"));
    hands.add(new Hand("Player 4"));
    
    dealStartingHands();
    System.out.println(tileManager.getTilesSize());
    

    
  }
  
  public void startGame() {
    currentPlayer = 0;
    hands.get(currentPlayer).sortHand();
    System.out.println(hands.get(currentPlayer).toString());
    Scanner userInput = new Scanner(System.in);
    int readInt = userInput.nextInt();
    System.out.println("Discarded tile " + hands.get(currentPlayer).getTiles().get(readInt).toString());
    hands.get(currentPlayer).discardTile(hands.get(currentPlayer).getTiles().get(readInt));
    hands.get(currentPlayer).addTile(tileManager.dealTile());
    System.out.println("Dealt tile " + hands.get(currentPlayer).getTiles().get(hands.get(currentPlayer).getTiles().size() - 1).toString());
    hands.get(currentPlayer).sortHand();
    System.out.println(hands.get(currentPlayer).toString());
//    while (tileManager.getTilesSize() > 0) {
//      Scanner userInput = new Scanner(System.in);
//      System.out.println(hands.get(currentPlayer).toString());
//    }
  }
  
  private void dealStartingHands() {
    for (int i = 0; i < 13; i++) {
      for (Hand hand : hands) {
        hand.addTile(tileManager.dealTile());
      }
    }
  }
  
  
  private void tileSetup(TileManager tileManager) {
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

  private void addHonorTiles(TileManager tileManager,Suit suit) {
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

  private void addNumberTiles(TileManager tileManager,Suit suit) {
    for (int i = 1; i <= 9; i++) {
      tileManager.addTile(new NumberTile(suit,i));
      tileManager.addTile(new NumberTile(suit,i));
      tileManager.addTile(new NumberTile(suit,i));
      tileManager.addTile(new NumberTile(suit,i));
    }
  }

  private void printTileManager(TileManager tileManager) {
    for (Tile tile : tileManager.getTiles()) {
      System.out.println(tile.toString());
    }
  }
  
  private void printPlayerHand(Hand hand) {
    System.out.println(hand.getPlayerName());
    for (Tile tile : hand.getTiles()) {
      System.out.println(tile.toString());
    }
  }
  
}

package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;

public class WinChecker {
  
  static TileHelper tileHelper = new TileHelper();
  
  
  public static int pairCounter(Hand hand) {
    int pairs = 0;
    Hand workingHand = hand;

    for (int i = 0; i < hand.getTiles().size()-1; i++) {
      if (hand.getTiles().get(i).toString().equals(hand.getTiles().get(i+1).toString())) {
        pairs++;
        i++;
      }
    }
    
    return pairs;
  }
  
  public static int tripleCounter(Hand hand) {
    int triple = 0;

    for (int i = 0; i < hand.getTiles().size() - 2; i++) {
      if (hand.getTiles().get(i).toString().equals(hand.getTiles().get(i+1).toString()) 
          && hand.getTiles().get(i).toString().equals(hand.getTiles().get(i+2).toString())) {
        triple++;
        i += 2;
      }
    }
    return triple;
  }

  public int seriesCounter2(Hand hand) {
    int series = 0;
    List<TreeSet<Tile>> tileSets = new ArrayList<>();
    List<Tile> workingHand = hand.getTilesOfSuit(Suit.Bamboo);
    for (Tile tile : workingHand) {
      if (tileSets.isEmpty()) {
        TreeSet<Tile> test = new TreeSet<>();
        test.addLast(tile);
        tileSets.add(new TreeSet<>());
        tileSets.getFirst().addLast(tile);
      }
      for (NavigableSet<Tile> set : tileSets) {
        if (set.getLast().equals(tile)) {
          continue;
        }
        if (((NumberTile) set.getLast()).getNumber() + 1 == ((NumberTile) tile).getNumber()) {
          set.addLast(tile);
          break;
        }
      }
    }
    System.out.println(tileSets);
    return series;
  }
  
  public static boolean isWinningHand(Hand hand) {
    boolean winningHand = false;
    int pairs = pairCounter(hand);
    
    
    if (pairs == 7) {
      winningHand = true;
    }
    
    return winningHand;
  }
  
}

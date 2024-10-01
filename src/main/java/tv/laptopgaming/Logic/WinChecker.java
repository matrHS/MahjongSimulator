package tv.laptopgaming.Logic;

import java.util.Iterator;
import java.util.List;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Tile;

public class WinChecker {
  
  
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
  
  public static int seriesCounter(Hand hand) {
    int series = 0;
    List<Tile> workingHand = hand.getTiles();

    int count = 0;
    for (int i = 0; i < workingHand.size()-2; i++) {
      
      Tile currentTile = workingHand.get(i);
      boolean nonNumberTile = false;
      for (int j = i; j < i+3; j++) {
        if (!(workingHand.get(j) instanceof NumberTile)) {
          nonNumberTile = true;
        }
      }
      if (nonNumberTile) {
        break;
      }
      
      int comparisonResult = currentTile.compareTo(workingHand.get(i+1));
      if (comparisonResult == 0) {
        if (((NumberTile) currentTile).getNumber()+1 == ((NumberTile) workingHand.get(i+1)).getNumber()) {
          count++;
          comparisonResult = currentTile.compareTo(workingHand.get(i+2));
          if (comparisonResult == 0) {
            if (((NumberTile) currentTile).getNumber()+2 == ((NumberTile) workingHand.get(i+2)).getNumber()) {
              count++;
              series++;
              i += 2;
            }
          }
        }
      }
    }
    
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

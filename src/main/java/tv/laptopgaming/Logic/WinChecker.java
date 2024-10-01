package tv.laptopgaming.Logic;

import java.util.Iterator;
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
    Iterator<Tile> tileIterator = hand.getIterator();
    
    Tile workingTile = tileIterator.next();
    
    int count=0;
    while (tileIterator.hasNext() && workingTile instanceof NumberTile) {
      int storedNumber = ((NumberTile) workingTile).getNumber();
      workingTile = tileIterator.next();
      if (storedNumber+1 == ((NumberTile) workingTile).getNumber()) {
        count++;
      }
      if (count == 3) {
        series++;
        count = 0;
      }
      
      return series;
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

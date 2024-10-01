package tv.laptopgaming.Logic;

import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.Tile;

public class WinChecker {
  
  public static int pairCounter(Hand hand) {
    int pairs = 0;

    for (int i = 0; i < hand.getTiles().size()-1; i++) {
      if (hand.getTiles().get(i).toString().equals(hand.getTiles().get(i+1).toString())) {
        pairs++;
        i++;
      }
    }
    
    return pairs;
  }
  
  
  
}

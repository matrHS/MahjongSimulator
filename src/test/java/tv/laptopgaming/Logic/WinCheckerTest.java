package tv.laptopgaming.Logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;

class WinCheckerTest {

  @Test
  public void testPairChecker() {
    Hand hand = new Hand("Test Player");
    hand.addTile(new NumberTile(Suit.Bamboo, 1));
    hand.addTile(new NumberTile(Suit.Bamboo, 1));
    hand.addTile(new NumberTile(Suit.Bamboo, 1));
    hand.addTile(new NumberTile(Suit.Bamboo, 1));
    hand.addTile(new NumberTile(Suit.Bamboo, 2));
    hand.addTile(new NumberTile(Suit.Bamboo, 3));
    hand.addTile(new NumberTile(Suit.Dots, 6));
    hand.addTile(new NumberTile(Suit.Dots, 6));
    hand.addTile(new NumberTile(Suit.Symbol, 2));
    hand.addTile(new NumberTile(Suit.Symbol, 3));
    hand.addTile(new NumberTile(Suit.Symbol, 3));
    hand.addTile(new HonorTile(Suit.Symbol, Honor.East));
    hand.addTile(new HonorTile(Suit.Symbol, Honor.East));
    hand.addTile(new HonorTile(Suit.Dragon, Honor.Green));
    WinChecker winChecker = new WinChecker();
    
    assertEquals(5, winChecker.pairCounter(hand));
  }
  
}
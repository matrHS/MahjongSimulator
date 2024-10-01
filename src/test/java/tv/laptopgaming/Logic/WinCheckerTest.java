package tv.laptopgaming.Logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;

class WinCheckerTest {

  private Hand randomNonWinningHand;
  private Hand randomWinningHand;
  private Hand pairWinningHand;
  private Hand seriesWinningHand;
  
  @BeforeEach
  public void setUp() {
    randomNonWinningHand = new Hand("randomNonWinningHand");
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    randomNonWinningHand.addTile(new NumberTile(Suit.Bamboo, 3));
    randomNonWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    randomNonWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    randomNonWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    randomNonWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    randomNonWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    randomNonWinningHand.addTile(new HonorTile(Suit.Symbol, Honor.East));
    randomNonWinningHand.addTile(new HonorTile(Suit.Symbol, Honor.East));
    randomNonWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Green));
    
    randomWinningHand = new Hand("randomWinningHand");
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    randomWinningHand.addTile(new NumberTile(Suit.Bamboo, 3));
    randomWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    randomWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    randomWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    randomWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    randomWinningHand.addTile(new NumberTile(Suit.Symbol, 4));
    randomWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    randomWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    randomWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    
    pairWinningHand = new Hand("pairWinningHand");
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    pairWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    pairWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    pairWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    pairWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    pairWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    pairWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    pairWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    pairWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    pairWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    
    seriesWinningHand = new Hand("seriesWinningHand");
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 1));
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 2));
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 3));
    seriesWinningHand.addTile(new NumberTile(Suit.Bamboo, 3));
    seriesWinningHand.addTile(new NumberTile(Suit.Dots, 6));
    seriesWinningHand.addTile(new NumberTile(Suit.Dots, 7));
    seriesWinningHand.addTile(new NumberTile(Suit.Dots, 8));
    seriesWinningHand.addTile(new NumberTile(Suit.Symbol, 4));
    seriesWinningHand.addTile(new NumberTile(Suit.Symbol, 5));
    seriesWinningHand.addTile(new NumberTile(Suit.Symbol, 6));
    seriesWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    seriesWinningHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
  }
  
  @Test
  public void testPairChecker() {
    WinChecker winChecker = new WinChecker();
    
    assertEquals(5, winChecker.pairCounter(randomNonWinningHand));
    assertEquals(7, winChecker.pairCounter(pairWinningHand));
  }
  
  @Test
  public void testTripleChecker() {
    WinChecker winChecker = new WinChecker();
    
    assertEquals(1,winChecker.tripleCounter(randomNonWinningHand));
    assertEquals(2,winChecker.tripleCounter(randomWinningHand));
  }
  
  @Test
  public void testSeriesChecker() {
    WinChecker winChecker = new WinChecker();
    
    System.out.println(randomNonWinningHand);
    System.out.println(seriesWinningHand);
    assertEquals(1,winChecker.seriesCounter2(randomNonWinningHand));
    assertEquals(4,winChecker.seriesCounter2(seriesWinningHand));
  }
  
  @Test
  public void testWinningHand() {
    WinChecker winChecker = new WinChecker();
    
    assertFalse(winChecker.isWinningHand(randomNonWinningHand));
    assertTrue(winChecker.isWinningHand(pairWinningHand));
  }
  
  
  
}
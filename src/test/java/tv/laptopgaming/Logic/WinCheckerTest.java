package tv.laptopgaming.Logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.Honor;
import tv.laptopgaming.Entity.HonorTile;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Suit;
import tv.laptopgaming.Entity.Tile;

class WinCheckerTest {

  static TileHelper tileHelper = new TileHelper();
  private Hand randomNonWinningHand;
  private Hand randomWinningHand;
  private Hand pairWinningHand;
  private Hand seriesWinningHand;
  private Hand seriesUltraWinningHand;
  private Hand seriesGapWinningHand;
  
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
    
    seriesUltraWinningHand = new Hand("seriesUltraWinningHand");
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 1));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 1));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 1));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 1));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Bamboo, 5));
    seriesUltraWinningHand.addTile(new NumberTile(Suit.Bamboo, 5));

    seriesGapWinningHand = new Hand("test");
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 1));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 2));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 3));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 5));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 6));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 7));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 7));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 8));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Symbol, 9));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Bamboo, 3));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Bamboo, 4));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Bamboo, 5));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Dots, 5));
    seriesGapWinningHand.addTile(new NumberTile(Suit.Dots, 5));
  }

  @Test
  public void testSubtractList() {
    WinChecker winChecker = new WinChecker();
    
    List<TreeSet<Tile>> seriesUltraList = winChecker.seriesList(seriesUltraWinningHand);
    List<Tile> seriesUltraRemoved = seriesUltraWinningHand.getHandMinusList(
        tileHelper.convertTreeToFlatSetNonSingle(seriesUltraList));

    List<TreeSet<Tile>> randomWinningList = winChecker.seriesList(randomWinningHand);
    List<Tile> randomWinningRemoved = randomWinningHand.getHandMinusList(
        tileHelper.convertTreeToFlatSetNonSingle(randomWinningList));
    
    
    assertEquals(1, winChecker.pairCounter(seriesUltraRemoved));
    assertEquals(3, winChecker.pairCounter(randomWinningRemoved));
  }
  
  @Test
  public void testPairChecker() {
    WinChecker winChecker = new WinChecker();
    
    assertEquals(5, winChecker.pairCounter(randomNonWinningHand.getTiles()));
    assertEquals(4, winChecker.pairCounter(seriesWinningHand.getTiles()));
    assertEquals(7, winChecker.pairCounter(pairWinningHand.getTiles()));
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

    assertEquals(1,winChecker.seriesCounter(randomNonWinningHand));
    assertEquals(4,winChecker.seriesCounter(seriesWinningHand));
    assertEquals(4,winChecker.seriesCounter(seriesUltraWinningHand));
    assertEquals(4,winChecker.seriesCounter(seriesGapWinningHand));
  }
  

  
  @Test
  public void testWinningHand() {
    WinChecker winChecker = new WinChecker();
    
    assertFalse(winChecker.isWinningHand(randomNonWinningHand));
    assertTrue(winChecker.isWinningHand(pairWinningHand));
    assertTrue(winChecker.isWinningHand(seriesWinningHand));
    assertTrue(winChecker.isWinningHand(randomWinningHand));
  }
  
  
  
}
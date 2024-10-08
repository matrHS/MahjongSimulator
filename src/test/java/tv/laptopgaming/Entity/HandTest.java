package tv.laptopgaming.Entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandTest {

  private Hand defaultHand;
  
  @BeforeEach
  public void handSetup() {
    defaultHand = new Hand("defaultHand");
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 1));
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 1));
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 1));
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 1));
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 2));
    defaultHand.addTile(new NumberTile(Suit.Bamboo, 2));
    defaultHand.addTile(new NumberTile(Suit.Dots, 6));
    defaultHand.addTile(new NumberTile(Suit.Dots, 6));
    defaultHand.addTile(new NumberTile(Suit.Symbol, 2));
    defaultHand.addTile(new NumberTile(Suit.Symbol, 2));
    defaultHand.addTile(new NumberTile(Suit.Symbol, 3));
    defaultHand.addTile(new NumberTile(Suit.Symbol, 3));
    defaultHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    defaultHand.addTile(new HonorTile(Suit.Dragon, Honor.Red));
    
  }
  
  
  
}
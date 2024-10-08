package tv.laptopgaming.Logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import tv.laptopgaming.Entity.Hand;
import tv.laptopgaming.Entity.NumberTile;
import tv.laptopgaming.Entity.Tile;

public class WinChecker {

  static TileHelper tileHelper = new TileHelper();

  /**
   * Checks for pairs in hand.
   *
   * @param hand Hand to check for pairs
   * @return Number of pairs found
   */
  public static int pairCounter(Hand hand) {
    int pairs = 0;
    Hand workingHand = hand;

    for (int i = 0; i < hand.getTiles().size() - 1; i++) {
      if (hand.getTiles().get(i).toString().equals(hand.getTiles().get(i + 1).toString())) {
        pairs++;
        i++;
      }
    }

    return pairs;
  }

  /**
   * Checks for triples in hand.
   *
   * @param hand Hand to check for triples
   * @return Number of triples found
   */
  public static int tripleCounter(Hand hand) {
    int triple = 0;

    for (int i = 0; i < hand.getTiles().size() - 2; i++) {
      if (hand.getTiles().get(i).toString().equals(hand.getTiles().get(i + 1).toString())
          && hand.getTiles().get(i).toString().equals(hand.getTiles().get(i + 2).toString())) {
        triple++;
        i += 2;
      }
    }
    return triple;
  }

  /**
   * Checks for series of 3 tiles for all suits in hand.
   * Not the most maintainable solution, but it works well.
   * <br>
   * Checks for series of 3 and allows for duplicates.
   * if tile is in series with the tile in the first set, it is added to the first set.
   * if tile is not in series, it checks if the tile is a duplicate
   * if the tile is a duplicate, it checks if there is another set in the list
   * if there is not another set, it adds the tile to a new set
   * if the tile is not a duplicate, it checks if the tile is in series with the tile in the next set
   * if it is, it adds the tile to the next set
   * if it is not, it repeats the process of seeing if there are more sets to check against.
   *
   * @param hand Hand to check for series
   * @return Number of series found
   */
  public int seriesCounter(Hand hand) {
    int series = 0;
    List<TreeSet<Tile>> tileSets = new ArrayList<>();
    List<Tile> workingHand = hand.getTiles();
    for (Tile tile : workingHand) {
      // Exits the checks if the tile is an honor tile as they cannot be in series
      if (!(tile instanceof NumberTile)) {
        break;
      }

      // Adds the first tile to the first set (skips tile after adding it to the first set)
      if (tileSets.isEmpty()) {
        tileSets.add(new TreeSet<>(Comparator.comparing(Tile::toString)));
        tileSets.getFirst().add(tile);
        continue;
      }
      // Loops equals to the number of sets
      for (int i = 0; i < tileSets.size(); i++) {

        // Added a check to see if there is another set in list.
        // If there is, it will continue to the next set. 
        // if not, it will check for duplicate and add to a new set
        if (tileSets.get(i).size() == 3) {
          if (tileSets.size() > i + 1) {
            continue;
          }
        }
        // Check if the current tile is in series with the last tile in current set
        // Also checks if the suit is the same
        if (((NumberTile) tileSets.get(i).getLast()).getNumber() + 1 ==
            ((NumberTile) tile).getNumber()
            && tileSets.get(i).getLast().getSuit() == tile.getSuit()) {
          tileSets.get(i).add(tile);
          if (tileSets.get(i).size() == 3) {
            series++;
          }
          break;
        }
        // Check if current tile is a duplicate with last tile in current set
        if (((NumberTile) tileSets.get(i).getLast()).getNumber() ==
            ((NumberTile) tile).getNumber()) {
          // Check if there is another set to check against
          if (tileSets.size() > i + 1) {
            continue;
          }
          // If there is no other set, add the tile to a new set
          tileSets.add(new TreeSet<>(Comparator.comparing(Tile::toString)));
          tileSets.getLast().add(tile);
          break;
        }
        // If the tile was not a duplicate, add the tile as a new set.
        tileSets.add(new TreeSet<>(Comparator.comparing(Tile::toString)));
        tileSets.getLast().add(tile);
        break;

      }
      // Clears the tileSets list for the next suit
    }
    System.out.println(tileSets);
    return series;
  }

  /**
   * Work in progress.
   * Planning to add separate methods defining each winning hand.
   *
   * @param hand Hand to check for winning hand
   * @return True if hand is a winning hand
   */
  public static boolean isWinningHand(Hand hand) {
    boolean winningHand = false;
    int pairs = pairCounter(hand);


    if (pairs == 7) {
      winningHand = true;
    }

    return winningHand;
  }

}

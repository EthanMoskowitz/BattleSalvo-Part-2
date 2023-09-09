package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa04.MockRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests ConsolePlayer and its associated methods
 */
class ConsolePlayerTest {

  private ConsolePlayer player;
  private ConsolePlayerDependencies playerDependencies;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  void setup() {
    playerDependencies = new ConsolePlayerDependencies();
    player = new ConsolePlayer("Player", new MockRandom(), playerDependencies);
  }

  /**
   * Tests the getDependencies method
   */
  @Test
  void getDependencies() {
    assertEquals(playerDependencies, player.getDependencies());
  }

  /**
   * Tests the getOpponentBoard method
   */
  @Test
  void getOpponentBoard() {
    assertEquals(this.player.opponentBoard, player.getOpponentBoard());
  }

  /**
   * Tests the takeShots method
   */
  @Test
  void takeShots() {
    Coord one = new Coord(5, 6, CoordType.SHIP);
    Coord two = new Coord(1, 0, CoordType.EMPTY);
    List<Coord> shots = new ArrayList<>(Arrays.asList(one, two));
    playerDependencies.addCoord(one);
    playerDependencies.addCoord(two);
    assertTrue(Coord.sameCoords(shots, player.takeShots()));
  }
}
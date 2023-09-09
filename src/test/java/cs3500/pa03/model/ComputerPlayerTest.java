package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa04.MockRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ComputerPlayer and its associated methods
 */
class ComputerPlayerTest {

  private ComputerPlayer player;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  void setup() {
    player = new ComputerPlayer(new MockRandom());
    HashMap<ShipType, Integer> specifications = new HashMap<>();
    specifications.put(ShipType.CARRIER, 1);
    specifications.put(ShipType.BATTLESHIP, 1);
    specifications.put(ShipType.DESTROYER, 1);
    specifications.put(ShipType.SUBMARINE, 1);
    player.setup(6, 6, specifications);
  }


  /**
   * Tests the takeShots method
   */
  @Test
  void takeShots() {
    Coord one = new Coord(1, 4, CoordType.EMPTY);
    Coord two = new Coord(5, 5, CoordType.EMPTY);
    Coord three = new Coord(2, 3, CoordType.EMPTY);
    Coord four = new Coord(3, 5, CoordType.EMPTY);
    List<Coord> expected = new ArrayList<>(Arrays.asList(one, two, three, four));
    List<Coord> shots = player.takeShots();
    assertTrue(Coord.sameCoords(expected, shots));
  }
}
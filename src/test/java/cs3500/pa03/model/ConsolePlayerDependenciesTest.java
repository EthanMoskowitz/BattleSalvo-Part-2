package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ConsolePlayerDependencies and its associated methods
 */
class ConsolePlayerDependenciesTest extends SalvoTest {

  private ConsolePlayerDependencies consolePlayerDependencies;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  void setup() {
    consolePlayerDependencies = new ConsolePlayerDependencies();
  }

  /**
   * Tests the addCoord method
   */
  @Test
  void testAddCoord() {
    List<Coord> coords = new ArrayList<>();
    assertTrue(Coord.sameCoords(coords, consolePlayerDependencies.getCurrentTurn()));
    coords.add(carrierCoordOne);
    consolePlayerDependencies.addCoord(carrierCoordOne);
    assertTrue(Coord.sameCoords(coords, consolePlayerDependencies.getCurrentTurn()));
  }

  /**
   * Tests the clear shots method
   */
  @Test
  void testClearShots() {
    consolePlayerDependencies.addCoord(carrierCoordOne);
    consolePlayerDependencies.addCoord(battleshipCoordFive);
    consolePlayerDependencies.addCoord(submarineCoordOne);
    List<Coord> shots = new ArrayList<>(Arrays.asList(
        carrierCoordOne, battleshipCoordFive, submarineCoordOne));
    assertTrue(Coord.sameCoords(shots, consolePlayerDependencies.getCurrentTurn()));
    consolePlayerDependencies.clearShots();
    assertTrue(Coord.sameCoords(new ArrayList<>(), consolePlayerDependencies.getCurrentTurn()));
    assertTrue(Coord.sameCoords(shots, consolePlayerDependencies.getAllShots()));
  }

  /**
   * Tests the getCurrentTurn method
   */
  @Test
  void testGetCurrentTurn() {
    List<Coord> shots = new ArrayList<>(Arrays.asList(
        submarineCoordOne, submarineCoordTwo));
    consolePlayerDependencies.addCoord(submarineCoordOne);
    consolePlayerDependencies.addCoord(submarineCoordTwo);
    assertTrue(Coord.sameCoords(shots, consolePlayerDependencies.getCurrentTurn()));
  }

  /**
   * Tests the getAllShots method
   */
  @Test
  void testGetAllShots() {
    consolePlayerDependencies.addCoord(submarineCoordOne);
    consolePlayerDependencies.addCoord(submarineCoordTwo);
    consolePlayerDependencies.clearShots();
    List<Coord> shots = new ArrayList<>(Arrays.asList(
        submarineCoordOne, submarineCoordTwo));
    assertTrue(Coord.sameCoords(shots, consolePlayerDependencies.getAllShots()));
  }

}
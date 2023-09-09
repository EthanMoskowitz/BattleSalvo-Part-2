package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing Coord and its associated methods
 */
class CoordTest {

  private Coord empty;
  private Coord hit;
  private Coord miss;
  private Coord ship;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    empty = new Coord(10, 5, CoordType.EMPTY);
    hit = new Coord(0, 0, CoordType.HIT);
    miss = new Coord(2, 5, CoordType.MISS);
    ship = new Coord(3, 8, CoordType.SHIP);
  }

  /**
   * Tests the getRow method
   */
  @Test
  void getRow() {
    assertEquals(5, empty.getRow());
    assertEquals(0, hit.getRow());
    assertEquals(5, miss.getRow());
    assertEquals(8, ship.getRow());
  }

  /**
   * Tests the getCol method
   */
  @Test
  void getCol() {
    assertEquals(10, empty.getCol());
    assertEquals(0, hit.getCol());
    assertEquals(2, miss.getCol());
    assertEquals(3, ship.getCol());
  }

  /**
   * Tests the getType method
   */
  @Test
  void getType() {
    assertEquals(CoordType.EMPTY, empty.getType());
    assertEquals(CoordType.HIT, hit.getType());
    assertEquals(CoordType.MISS, miss.getType());
    assertEquals(CoordType.SHIP, ship.getType());
  }

  /**
   * Tests the isEmpty method
   */
  @Test
  void testIsEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(hit.isEmpty());
  }

  /**
   * Tests the setType method
   */
  @Test
  void setType() {
    assertEquals(CoordType.EMPTY, empty.getType());
    empty.setType(CoordType.HIT);
    assertEquals(CoordType.HIT, empty.getType());
    assertEquals(CoordType.SHIP, ship.getType());
    ship.setType(CoordType.EMPTY);
    assertEquals(CoordType.EMPTY, ship.getType());
    ship.setType(CoordType.MISS);
    assertEquals(CoordType.MISS, ship.getType());
  }

  /**
   * Tests the sameCoords method
   */
  @Test
  void testSameCoords() {
    List<Coord> one = new ArrayList<>(Arrays.asList(empty, miss));
    List<Coord> two = new ArrayList<>(Collections.singletonList(ship));
    assertFalse(Coord.sameCoords(one, two));
    two = new ArrayList<>(Arrays.asList(empty, ship));
    assertFalse(Coord.sameCoords(one, two));
    two  = new ArrayList<>(Arrays.asList(empty, miss));
    assertTrue(Coord.sameCoords(one, two));
  }

  /**
   * Tests the equals method
   */
  @Test
  void testEquals() {
    Object o = new Object();
    assertNotEquals(miss, o);
    assertNotEquals(miss, hit);
    Coord sameRow = new Coord(2, 6, CoordType.SHIP);
    Coord sameRowCol = new Coord(2, 5, CoordType.HIT);
    Coord identical = new Coord(2, 5, CoordType.MISS);
    assertNotEquals(miss, sameRow);
    assertNotEquals(miss, sameRowCol);
    assertEquals(miss, identical);
  }
}
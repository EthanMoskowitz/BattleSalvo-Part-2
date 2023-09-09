package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ShipTest extends SalvoTest {

  /**
   * Tests the getCoords method
   */
  @Test
  void testGetCoords() {
    assertEquals(submarineCoords, submarine.getCoords());
    assertEquals(battleshipCoords, battleship.getCoords());
  }

  /**
   * Tests the getCoords method
   */
  @Test
  void testStillAfloat() {
    assertTrue(carrier.stillAfloat());
    carrier.sink();
    assertFalse(carrier.stillAfloat());
  }

  /**
   *
   */
  @Test
  void testSink() {
    assertTrue(submarine.stillAfloat());
    submarine.sink();
    assertFalse(submarine.stillAfloat());
    submarine.sink();
    assertFalse(submarine.stillAfloat());
  }

  /**
   * Tests the toString method
   */
  @Test
  void testToString() {
    assertEquals("C", carrier.toString());
    assertEquals("B", battleship.toString());
    assertEquals("D", destroyer.toString());
    assertEquals("S", submarine.toString());
  }

  /**
   * Tests the equals method
   */
  @Test
  void testEquals() {
    Object o = new Object();
    assertNotEquals(submarine, o);
    assertNotEquals(submarine, carrier);
    Ship sameType = new Ship(ShipType.SUBMARINE, new ArrayList<>());
    assertNotEquals(submarine, sameType);
    Ship sameTypeAndCoords = new Ship(ShipType.SUBMARINE, submarineCoords);
    sameTypeAndCoords.sink();
    assertNotEquals(submarine, sameTypeAndCoords);
    Ship identical = new Ship(ShipType.SUBMARINE, submarineCoords);
    assertEquals(submarine, identical);
  }
}
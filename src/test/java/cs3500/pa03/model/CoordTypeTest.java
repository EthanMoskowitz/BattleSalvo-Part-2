package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing CoordType and its associated methods
 */
class CoordTypeTest {

  /**
   * Tests the toString() method
   */
  @Test
  void testToString() {
    assertEquals("*", CoordType.EMPTY.toString());
    assertEquals("S", CoordType.SHIP.toString());
    assertEquals("M", CoordType.MISS.toString());
    assertEquals("H", CoordType.HIT.toString());
  }
}
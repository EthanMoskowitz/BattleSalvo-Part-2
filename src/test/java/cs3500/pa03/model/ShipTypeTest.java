package cs3500.pa03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class for testing ShipType and its associated methods
 */
class ShipTypeTest {

  /**
   * Tests the getSize method
   */
  @Test
  void testGetSize() {
    assertEquals(6, ShipType.CARRIER.getSize());
    assertEquals(5, ShipType.BATTLESHIP.getSize());
    assertEquals(4, ShipType.DESTROYER.getSize());
    assertEquals(3, ShipType.SUBMARINE.getSize());
  }

}
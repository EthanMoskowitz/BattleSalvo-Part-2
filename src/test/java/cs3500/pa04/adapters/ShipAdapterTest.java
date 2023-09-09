package cs3500.pa04.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.SalvoTest;
import cs3500.pa04.Direction;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.ShipJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ShipAdapter and its associated methods
 */
class ShipAdapterTest extends SalvoTest {

  private ShipJson verticalJson;
  private ShipJson horizontalJson;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    CoordJson verticalCoord = new CoordJson(0, 0);
    verticalJson = new ShipJson(verticalCoord, 6, Direction.VERTICAL);
    CoordJson horizontalCoord = new CoordJson(1, 1);
    horizontalJson = new ShipJson(horizontalCoord, 5, Direction.VERTICAL);
  }

  /**
   * Tests the ShipToJson method
   */
  @Test
  public void testShipToJson() {
    assertEquals(verticalJson, ShipAdapter.shipToJson(carrier));
    assertEquals(horizontalJson, ShipAdapter.shipToJson(battleship));
  }

}
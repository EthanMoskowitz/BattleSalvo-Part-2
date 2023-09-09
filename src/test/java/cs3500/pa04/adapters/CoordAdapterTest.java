package cs3500.pa04.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.CoordType;
import cs3500.pa04.json.CoordJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents tests for coord adapter
 */
class CoordAdapterTest {
  private Coord coord;
  private CoordJson coordJson;

  /**
   * Instantiates coords and coord jsons
   */
  @BeforeEach
  void setup() {
    coord = new Coord(5, 4, CoordType.EMPTY);
    coordJson = new CoordJson(5, 4);
  }

  /**
   * Tests the jsonToCoord method
   */
  @Test
  public void testJsonToCoord() {
    assertEquals(coord, CoordAdapter.jsonToCoord(coordJson));
  }

  /**
   * Tests the coordToJson method
   */
  @Test
  public void testCoordToJson() {
    assertEquals(coordJson, CoordAdapter.coordToJson(coord));
  }


}

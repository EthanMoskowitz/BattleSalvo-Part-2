package cs3500.pa04.adapters;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.CoordType;
import cs3500.pa04.json.CoordJson;

/**
 * Class for adapting Coords through Json
 */
public class CoordAdapter {

  /**
   * Adapts a CoordJson into a Coord
   *
   * @param json a CoordJson
   * @return the CoordJson as a Coord
   */
  public static Coord jsonToCoord(CoordJson json) {
    return new Coord(json.x(), json.y(), CoordType.EMPTY);
  }

  /**
   * Adapts a Coord into a CoordJson
   *
   * @param coord a Coord
   * @return the Coord as a CoordJson
   */
  public static CoordJson coordToJson(Coord coord) {
    return new CoordJson(coord.getCol(), coord.getRow());
  }

}

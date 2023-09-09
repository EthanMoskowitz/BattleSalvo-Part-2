package cs3500.pa04.adapters;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import cs3500.pa04.Direction;
import cs3500.pa04.json.CoordJson;
import cs3500.pa04.json.ShipJson;
import java.util.List;

/**
 * Class for adapting Ships through Json
 */
public class ShipAdapter {

  /**
   * Adapts a ShipJson to a Ship
   *
   * @param ship a Ship
   * @return the Ship as a ShipJson
   */
  public static ShipJson shipToJson(Ship ship) {
    List<Coord> coords = ship.getCoords();
    Coord coord = coords.get(0);
    CoordJson startingCoord = new CoordJson(coord.getCol(), coord.getRow());
    int length = ship.getType().getSize();
    Direction direction;
    if (coords.get(0).getRow() == coords.get(1).getRow()) {
      direction = Direction.HORIZONTAL;
    } else {
      direction = Direction.VERTICAL;
    }
    return new ShipJson(startingCoord, length, direction);
  }

}

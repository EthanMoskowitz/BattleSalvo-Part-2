package cs3500.pa03.model;

import java.util.ArrayList;

/**
 * Represents a ship in BattleSalvo
 */
public class Ship {

  private final ShipType type;
  private final ArrayList<Coord> coords;
  private boolean sunk;

  /**
   * Instantiates a Ship
   *
   * @param type the type of ship
   * @param coords the coordinates the ship is at
   */
  public Ship(ShipType type, ArrayList<Coord> coords) {
    this.type = type;
    this.coords = coords;
    this.sunk = false;
  }

  /**
   * Gets the ship type
   *
   * @return the type
   */
  public ShipType getType() {
    return this.type;
  }

  /**
   * Gets the coords of the ship
   *
   * @return a list of coords of the ship
   */
  public ArrayList<Coord> getCoords() {
    return this.coords;
  }

  /**
   * Returns if this ship is sunk
   *
   * @return if the ship has sunk
   */
  public boolean stillAfloat() {
    return !this.sunk;
  }

  /**
   * Sinks a ship
   *
   */
  public void sink() {
    this.sunk = true;
  }

  /**
   * Returns the first letter of the ship type
   *
   * @return a single character String representing the ship type
   */
  @Override
  public String toString() {
    return this.type.toString().substring(0, 1);
  }

  /**
   * Checks if the given object is the same as this ship
   *
   * @param o an object
   * @return if the two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Ship other)) {
      return false;
    }
    return this.type.equals(other.type)
        && Coord.sameCoords(this.coords, other.coords)
        && this.sunk == other.sunk;
  }

}

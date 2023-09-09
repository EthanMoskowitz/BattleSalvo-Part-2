package cs3500.pa03.model;

/**
 * Represents the types of Ships in BattleSalvo
 */
public enum ShipType {

  /**
   * A carrier ship with size 6
   */
  CARRIER(6),

  /**
   * A battleship with size 5
   */
  BATTLESHIP(5),

  /**
   * A destroyer with size 4
   */
  DESTROYER(4),

  /**
   * A submarine with size 3
   */
  SUBMARINE(3);

  private final int size;

  /**
   * Initializes a ShipType
   *
   * @param size the size of the ship
   */
  ShipType(int size) {
    this.size = size;
  }

  /**
   * Returns the size of the ship type
   *
   * @return the size of this type
   */
  public int getSize() {
    return this.size;
  }

}

package cs3500.pa03.model;

/**
 * Represents a coordinate type
 */
public enum CoordType {

  /**
   * The coord does not contain a ship
   */
  EMPTY("*"),

  /**
   * The coord contains a ship
   */
  SHIP("S"),

  /**
   * The coord has been shot at and is a miss
   */
  MISS("M"),

  /**
   * The coord has been shot at and is a hit
   */
  HIT("H");

  private final String symbol;

  /**
   * Instantiates a CoordType
   *
   * @param symbol the symbol to display to the screen
   */
  CoordType(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Returns the symbol of the coord type
   *
   * @return a String of the symbol
   */
  @Override
  public String toString() {
    return this.symbol;
  }
}

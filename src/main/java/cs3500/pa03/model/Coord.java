package cs3500.pa03.model;

import java.util.List;

/**
 * Represents a coordinate in BattleSalvo
 */
public class Coord {

  private final int row;
  private final int col;
  private CoordType type;

  /**
   * Instantiates a Coord
   *
   * @param row the row on the board
   * @param col the column on the board
   * @param type the type of coord
   */
  public Coord(int col, int row, CoordType type) {
    this.row = row;
    this.col = col;
    this.type = type;
  }

  /**
   * Gets the row of the coord
   *
   * @return the row of the coord
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Gets the col of the coord
   *
   * @return the col of the coord
   */
  public int getCol() {
    return this.col;
  }

  /**
   * Gets the type of coord
   *
   * @return the type of coord
   */
  public CoordType getType() {
    return this.type;
  }

  /**
   * Determines if this coord is empty
   *
   * @return if the current coord is empty
   */
  public boolean isEmpty() {
    return this.type.equals(CoordType.EMPTY);
  }

  /**
   * Sets the type of this coord to the given
   *
   * @param type the coord type to set the coord to
   */
  public void setType(CoordType type) {
    this.type = type;
  }

  /**
   * Determines if two list of coords are equal
   *
   * @param one the first list of coords
   * @param two the second list of coords
   * @return if the two lists are equivalent
   */
  public static boolean sameCoords(List<Coord> one, List<Coord> two) {
    if (one.size() != two.size()) {
      return false;
    }
    for (int i = 0; i < one.size(); i++) {
      if (!one.get(i).equals(two.get(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Determines if this object is the same at this coord
   *
   * @param o an object
   * @return if the two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Coord other)) {
      return false;
    }
    return this.row == other.row
        && this.col == other.col
        && this.type.equals(other.type);
  }

}

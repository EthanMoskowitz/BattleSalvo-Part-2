package cs3500.pa03.model;

import cs3500.pa04.controller.Randomable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for a BattleSalvo player
 */
public abstract class SalvoPlayer implements Player {

  /**
   * Player's name
   */
  protected final String name;

  /**
   * Random object
   */
  protected final Randomable random;

  /**
   * List of ships
   */
  protected ArrayList<Ship> ships;

  /**
   * The user's board
   */
  protected Coord[][] userBoard;

  /**
   * The opponent's board
   */
  protected Coord[][] opponentBoard;

  /**
   * Coordinate list of player's current shots
   */
  protected List<Coord> currentTurnShots = new ArrayList<>();

  /**
   * Instantiates a BattleSalvo player
   *
   * @param name the name of the player
   * @param random a random object
   */
  public SalvoPlayer(String name, Randomable random) {
    this.name = name;
    this.random = random;
  }

  /**
   * Returns the name of the player
   *
   * @return the name of the player as a String
   */
  @Override
  public String name() {
    return this.name;
  }

  /**
   * Given the specifications for a BattleSalvo board, return a list of ships with their locations
   * on the board.
   *
   * @param height the height of the board, range: [6, 15] inclusive
   * @param width the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *        appear on the board
   * @return the placements of each ship on the board
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    initializeBoards(height, width);
    ArrayList<Ship> carriers = placeShips(ShipType.CARRIER,
        specifications.get(ShipType.CARRIER));
    ArrayList<Ship> battleships = placeShips(ShipType.BATTLESHIP,
        specifications.get(ShipType.BATTLESHIP));
    ArrayList<Ship> destroyers = placeShips(ShipType.DESTROYER,
        specifications.get(ShipType.DESTROYER));
    ArrayList<Ship> submarines = placeShips(ShipType.SUBMARINE,
        specifications.get(ShipType.SUBMARINE));
    ArrayList<Ship> ships = new ArrayList<>();
    ships.addAll(carriers);
    ships.addAll(battleships);
    ships.addAll(destroyers);
    ships.addAll(submarines);
    this.ships = ships;
    return ships;
  }

  /**
   * Places ships on the user's board
   *
   * @param type the type of ships to place
   * @param numShips the number of ships to place
   * @return a list of the ships placed
   */
  private ArrayList<Ship> placeShips(ShipType type, int numShips) {
    ArrayList<Ship> ships = new ArrayList<>();
    for (int i = 0; i < numShips; i++) {
      boolean vertical = random.nextBoolean();
      Ship ship;
      if (vertical) {
        ship = placeVerticalShip(type);
      } else {
        ship = placeHorizontalShip(type);
      }
      ships.add(ship);
    }
    return ships;
  }

  /**
   * Places a ship vertically on the board
   *
   * @param type the type of ship to place
   * @return the ship that has been placed
   */
  private Ship placeVerticalShip(ShipType type) {
    ArrayList<Coord> coords = new ArrayList<>();
    Coord coord = generateRandomCoord(type);
    coords.add(coord);
    for (int j = 1; j < type.getSize(); j++) {
      Coord c;
      try {
        c = userBoard[coord.getRow() + j][coord.getCol()];
      } catch (ArrayIndexOutOfBoundsException e) {
        return placeHorizontalShip(type);
      }
      if (!c.isEmpty()) {
        return placeHorizontalShip(type);
      } else {
        coords.add(c);
      }
    }
    for (Coord validCord : coords) {
      validCord.setType(CoordType.SHIP);
    }
    return new Ship(type, coords);
  }

  /**
   * Places a ship horizontally on the board
   *
   * @param type the type of ship to place
   * @return the ship that has been placed
   */
  private Ship placeHorizontalShip(ShipType type) {
    ArrayList<Coord> coords = new ArrayList<>();
    Coord coord = generateRandomCoord(type);
    coords.add(coord);
    for (int j = 1; j < type.getSize(); j++) {
      Coord c;
      try {
        c = userBoard[coord.getRow()][coord.getCol() + j];
      } catch (ArrayIndexOutOfBoundsException e) {
        return placeVerticalShip(type);
      }
      if (!c.isEmpty()) {
        return placeVerticalShip(type);
      } else {
        coords.add(c);
      }
    }
    for (Coord validCord : coords) {
      validCord.setType(CoordType.SHIP);
    }
    return new Ship(type, coords);
  }

  /**
   * Generates a random coord on the user's board
   *
   * @return a random coord
   */
  private Coord generateRandomCoord(ShipType type) {
    int randRow = random.nextInt(this.userBoard.length - (type.getSize() - 1));
    int randCol = random.nextInt(this.userBoard[0].length - (type.getSize() - 1));
    Coord randCoord = this.userBoard[randRow][randCol];
    while (!randCoord.getType().equals(CoordType.EMPTY)) {
      randRow = random.nextInt(this.userBoard.length);
      randCol = random.nextInt(this.userBoard[0].length);
      randCoord = this.userBoard[randRow][randCol];
    }
    return randCoord;
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public abstract List<Coord> takeShots();

  /**
   * Sets a player's current turn shots
   *
   * @param shots the shots to set
   */
  public void setCurrentTurnShots(List<Coord> shots) {
    this.currentTurnShots = shots;
  }

  /**
   * Gets the number of shots the player can take
   *
   * @return the count of shots they can take next turn
   */
  public int getShotCount() {
    int emptySpots = 0;
    for (Coord[] coords : this.opponentBoard) {
      for (Coord c : coords) {
        if (c.isEmpty()) {
          emptySpots++;
        }
      }
    }
    int count = 0;
    for (Ship s : ships) {
      if (s.stillAfloat()) {
        count++;
      }
    }
    return Math.min(emptySpots, count);
  }

  /**
   * Gets the user's list of ships
   *
   * @return an ArrayList of ships on the user's board
   */
  public ArrayList<Ship> getShips() {
    return this.ships;
  }

  /**
   * Gets the user's board
   *
   * @return a Coord[][] of the user's board
   */
  public Coord[][] getUserBoard() {
    return this.userBoard;
  }

  /**
   * Given the list of shots the opponent has fired on this player's board, report which
   * shots hit a ship on this player's board.
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a filtered list of the given shots that contain all locations of shots that hit a
   *         ship on this board
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    ArrayList<Coord> coordsHit = new ArrayList<>();
    for (Coord coord : opponentShotsOnBoard) {
      Coord coordShot = this.userBoard[coord.getRow()][coord.getCol()];
      if (coordShot.getType().equals(CoordType.SHIP)) {
        coordsHit.add(coord);
        coordShot.setType(CoordType.HIT);
      } else {
        coordShot.setType(CoordType.MISS);
      }
    }
    checkSunk();
    return coordsHit;
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord coord : currentTurnShots) {
      Coord coordShot = this.opponentBoard[coord.getRow()][coord.getCol()];
      if (shotsThatHitOpponentShips.contains(coordShot)) {
        coordShot.setType(CoordType.HIT);
      } else {
        coordShot.setType(CoordType.MISS);
      }
    }
  }

  /**
   * Sinks any ships that have had all their coords hit
   */
  private void checkSunk() {
    for (Ship s : this.ships) {
      boolean sunk = true;
      for (Coord coord : s.getCoords()) {
        if (coord.getType().equals(CoordType.SHIP)) {
          sunk = false;
          break;
        }
      }
      if (sunk && s.stillAfloat()) {
        s.sink();
      }
    }
  }

  /**
   * Determines if the current player has lost
   *
   * @return if the game is over
   */
  public boolean gameOver() {
    for (Ship s : this.ships) {
      if (s.stillAfloat()) {
        return false;
      }
    }
    return true;
  }

  /**
   * Notifies the player that the game is over.
   * Win, lose, and draw should all be supported
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {

  }

  /**
   * Initializes both boards to empty coords
   *
   * @param height the height of the board
   * @param width the width of the board
   */
  private void initializeBoards(int height, int width) {
    this.userBoard = new Coord[height][width];
    this.opponentBoard = new Coord[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        this.userBoard[i][j] = new Coord(j, i, CoordType.EMPTY);
        this.opponentBoard[i][j] = new Coord(j, i, CoordType.EMPTY);
      }
    }
  }
}

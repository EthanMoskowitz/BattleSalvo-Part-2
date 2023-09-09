package cs3500.pa03.model;

import cs3500.pa04.controller.Randomable;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class for a computer (AI) player
 */
public class ComputerPlayer extends SalvoPlayer {

  private final ArrayList<Coord> remainingCoords = new ArrayList<>();

  /**
   * Initializes a ComputerPlayer
   *
   * @param random a random object
   */
  public ComputerPlayer(Randomable random) {
    super("Computer", random);
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    populateCoords();
    List<Coord> shots = new ArrayList<>();
    while (shots.size() < this.getShotCount()) {
      int index = random.nextInt(this.remainingCoords.size());
      Coord shot = remainingCoords.remove(index);
      shots.add(shot);
    }
    setCurrentTurnShots(shots);
    return shots;
  }

  /**
   * Populates a list of valid coordinates for the computer to fire at
   */
  private void populateCoords() {
    this.remainingCoords.clear();
    for (Coord[] coords : this.opponentBoard) {
      for (Coord coord : coords) {
        if (coord.getType().equals(CoordType.EMPTY)) {
          this.remainingCoords.add(coord);
        }
      }
    }
  }

}

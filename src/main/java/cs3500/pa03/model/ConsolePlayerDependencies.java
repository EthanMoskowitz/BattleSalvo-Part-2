package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Dependency class for handling console user shot inputs
 */
public class ConsolePlayerDependencies {

  private final ArrayList<Coord> currentTurn = new ArrayList<>();
  private final ArrayList<Coord> allShots = new ArrayList<>();

  /**
   * Adds a coordinate to the player's current turn
   *
   * @param c a coordinate
   */
  public void addCoord(Coord c) {
    this.currentTurn.add(c);
    this.allShots.add(c);
  }

  /**
   * Clears the shots of the current turn and adds them to the all-time shots
   */
  public void clearShots() {
    this.currentTurn.clear();
  }

  /**
   * Returns the user's current turn shots
   *
   * @return a list of the shots the user has fired this turn
   */
  public List<Coord> getCurrentTurn() {
    return this.currentTurn;
  }

  /**
   * Gets the user's all time shots
   *
   * @return a list of shots the user has shot at throughout the game
   */
  public List<Coord> getAllShots() {
    return this.allShots;
  }


}

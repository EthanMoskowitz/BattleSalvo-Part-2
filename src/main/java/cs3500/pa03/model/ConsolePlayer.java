package cs3500.pa03.model;

import cs3500.pa04.controller.Randomable;
import java.util.List;

/**
 * Player class for a player playing through the console
 */
public class ConsolePlayer extends SalvoPlayer {

  private final ConsolePlayerDependencies dependencies;

  /**
   * Initializes a ConsolePlayer
   *
   * @param name the name of the player
   * @param random a random object
   * @param dependencies a console player's dependencies
   */
  public ConsolePlayer(String name, Randomable random, ConsolePlayerDependencies dependencies) {
    super(name, random);
    this.dependencies = dependencies;
  }

  /**
   * Gets this player's dependencies
   *
   * @return this console player's dependencies
   */
  public ConsolePlayerDependencies getDependencies() {
    return this.dependencies;
  }

  /**
   * Gets the opponent's board
   *
   * @return a Coord[][] of the opponent's board
   */
  public Coord[][] getOpponentBoard() {
    return this.opponentBoard;
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    return this.dependencies.getCurrentTurn();
  }

}

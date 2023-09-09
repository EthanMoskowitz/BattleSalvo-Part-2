package cs3500.pa03.view;

import cs3500.pa03.model.BoardType;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.SalvoPlayer;

/**
 * Interface for displaying a BattleSalvo game
 */
public interface BattleSalvoView {

  /**
   * Reads the next line of input from the readable
   *
   * @return the next line of input as a String
   */
  String[] read();

  /**
   * Welcomes the user
   */
  void welcome();

  /**
   * Prompts the user for board dimensions
   */
  void dimensions();

  /**
   * Re-prompts the user if the dimensions entered were invalid
   */
  void invalidDimensions();

  /**
   * Prompts the user to select a fleet
   *
   * @param maxSize the maximum fleet size
   */
  void fleetSelect(int maxSize);

  /**
   * Re-prompts the user if the fleet entered was invalid
   *
   * @param maxSize the maximum fleet size
   */
  void invalidFleet(int maxSize);

  /**
   * Prompts the user to enter valid shots
   *
   * @param numShots the number of shots they can enter
   */
  void shots(int numShots);

  /**
   * Re-prompts the user if they enter an invalid shot
   *
   * @param numShots the number of shots they can enter
   */
  void invalidShots(int numShots);

  /**
   * Displays a player's board
   *
   * @param player the player to display
   * @param board the player's board
   * @param type the visibility level to display the board
   */
  void displayBoard(SalvoPlayer player, Coord[][] board, BoardType type);

  /**
   * Displays the result of the game
   *
   * @param result the result of the game
   * @param reason the reason for the result
   */
  void result(GameResult result, String reason);

}

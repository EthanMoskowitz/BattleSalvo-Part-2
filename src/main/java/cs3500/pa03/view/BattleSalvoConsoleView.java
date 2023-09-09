package cs3500.pa03.view;

import cs3500.pa03.model.BoardType;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.CoordType;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.SalvoPlayer;
import cs3500.pa03.model.Ship;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class for displaying the BattleSalvo game to the console
 */
public class BattleSalvoConsoleView implements BattleSalvoView {

  // color constants
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_YELLOW = "\033[0;33m";

  private final Scanner scanner;
  private final Appendable appendable;

  /**
   * Instantiates a BattleSalvoConsoleView
   *
   * @param readable a readable source to read from
   * @param appendable an appendable to append the output to
   */
  public BattleSalvoConsoleView(Readable readable, Appendable appendable) {
    this.scanner = new Scanner(readable);
    this.appendable = appendable;
  }

  /**
   * Reads the next line of input from the readable
   *
   * @return the next int
   */
  public String[] read() {
    return scanner.nextLine().split(" ");
  }

  /**
   * Welcomes the user
   */
  @Override
  public void welcome() {
    try {
      appendable.append(System.getProperty("line.separator"));
      appendable.append("Welcome to BattleSalvo, Battleship with a twist!");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user for board dimensions
   */
  @Override
  public void dimensions() {
    try {
      appendable.append("Please enter a valid height and width below:");
      appendable.append(System.getProperty("line.separator"));
      separator();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Re-prompts the user if the dimensions entered were invalid
   */
  @Override
  public void invalidDimensions() {
    try {
      appendable.append("You entered invalid dimensions.");
      appendable.append(System.getProperty("line.separator"));
      appendable.append("Board dimensions must be between 6 and 15 (inclusive).");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user to select a fleet
   *
   * @param maxSize the maximum fleet size
   */
  @Override
  public void fleetSelect(int maxSize) {
    try {
      appendable.append("Please enter your fleet in the order "
          + "[Carrier, Battleship, Destroyer, Submarine].");
      appendable.append(System.getProperty("line.separator"));
      appendable.append("Remember, your fleet may not exceed ").append(String.valueOf(maxSize));
      appendable.append(System.getProperty("line.separator"));
      separator();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Re-prompts the user if the fleet entered was invalid
   *
   * @param maxSize the maximum fleet size
   */
  @Override
  public void invalidFleet(int maxSize) {
    try {
      appendable.append("You entered an invalid fleet.");
      appendable.append(System.getProperty("line.separator"));
      fleetSelect(maxSize);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Prompts the user to enter valid shots
   *
   * @param numShots the number of shots they can enter
   */
  @Override
  public void shots(int numShots) {
    try {
      appendable.append("Please enter ").append(String.valueOf(numShots)).append(" shots.");
      appendable.append(System.getProperty("line.separator"));
      separator();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Re-prompts the user if they enter an invalid shot
   *
   * @param numShots the number of shots they can enter
   */
  @Override
  public void invalidShots(int numShots) {
    try {
      appendable.append("The previous shot was invalid.");
      appendable.append(System.getProperty("line.separator"));
      appendable.append("Please enter ").append(String.valueOf(numShots)).append(" more shots.");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays a player's board
   *
   * @param player the player to display
   * @param board  the player's board
   * @param type the visibility level to display the board
   */
  @Override
  public void displayBoard(SalvoPlayer player, Coord[][] board, BoardType type) {
    try {
      separator();
      appendable.append(player.name()).append("'s board:");
      appendable.append(System.getProperty("line.separator"));
      appendable.append(System.getProperty("line.separator"));
      String packagedBoard = packageBoard(player, board, type);
      appendable.append(packagedBoard);
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Packages a board into a String
   *
   * @param player the player that's board will be packaged
   * @param board the board to package
   * @param type the visibility level to display the board
   * @return a board packaged into a String
   */
  private String packageBoard(SalvoPlayer player, Coord[][] board, BoardType type) {
    StringBuilder packagedBoard = new StringBuilder();
    for (Coord[] coords : board) {
      for (Coord coord : coords) {
        CoordType coordType = coord.getType();
        if (type.equals(BoardType.USER)) {
          switch (coordType) {
            case HIT ->
                packagedBoard.append(ANSI_RED).append(coordType).append(ANSI_RESET).append(" ");
            case MISS ->
                packagedBoard.append(ANSI_YELLOW).append(coordType).append(ANSI_RESET).append(" ");
            case SHIP -> {
              String symbol = " ";
              for (Ship s : player.getShips()) {
                if (s.getCoords().contains(coord)) {
                  symbol = s.toString();
                }
              }
              packagedBoard.append(ANSI_CYAN).append(symbol).append(ANSI_RESET).append(" ");
            }
            default -> packagedBoard.append(CoordType.EMPTY).append(" ");
          }
        } else {
          switch (coordType) {
            case HIT ->
                packagedBoard.append(ANSI_RED).append(coordType).append(ANSI_RESET).append(" ");
            case MISS ->
                packagedBoard.append(ANSI_YELLOW).append(coordType).append(ANSI_RESET).append(" ");
            default -> packagedBoard.append(CoordType.EMPTY).append(" ");
          }
        }
      }
      packagedBoard.append(System.getProperty("line.separator"));
    }
    return packagedBoard.toString();
  }

  /**
   * Displays the result of the game
   *
   * @param result the result of the game
   * @param reason the reason for the result
   */
  @Override
  public void result(GameResult result, String reason) {
    try {
      separator();
      appendable.append(System.getProperty("line.separator"));
      appendable.append("Game over!");
      appendable.append(System.getProperty("line.separator"));
      appendable.append("You ").append(result.toString()).append(" because: ").append(reason);
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Displays a line separator
   */
  private void separator() {
    try {
      appendable.append("-----------------------------------------------------");
      appendable.append(System.getProperty("line.separator"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}

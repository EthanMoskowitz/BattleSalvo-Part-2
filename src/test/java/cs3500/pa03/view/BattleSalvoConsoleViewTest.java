package cs3500.pa03.view;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa03.model.BoardType;
import cs3500.pa03.model.ConsolePlayer;
import cs3500.pa03.model.ConsolePlayerDependencies;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.SalvoPlayer;
import cs3500.pa03.model.ShipType;
import cs3500.pa04.MockRandom;
import java.io.StringReader;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleSalvoConsoleViewTest {

  private Readable input;
  private StringBuilder output;
  private BattleSalvoConsoleView battleSalvoConsoleView;
  private BattleSalvoConsoleView mockConsoleView;
  private SalvoPlayer player;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    input = new StringReader("");
    output = new StringBuilder();
    MockAppendable mockAppendable = new MockAppendable();
    battleSalvoConsoleView = new BattleSalvoConsoleView(input, output);
    mockConsoleView = new BattleSalvoConsoleView(input, mockAppendable);
    player = new ConsolePlayer("User", new MockRandom(), new ConsolePlayerDependencies());
    HashMap<ShipType, Integer> specifications = new HashMap<>();
    specifications.put(ShipType.CARRIER, 1);
    specifications.put(ShipType.BATTLESHIP, 1);
    specifications.put(ShipType.DESTROYER, 1);
    specifications.put(ShipType.SUBMARINE, 1);
    player.setup(6, 6, specifications);
  }

  /**
   * Tests the read method
   */
  @Test
  void testRead() {
    input = new StringReader("hello world");
    battleSalvoConsoleView = new BattleSalvoConsoleView(input, output);
    String[] expectedOutput = {"hello", "world"};
    String[] readOutput = battleSalvoConsoleView.read();
    assertArrayEquals(expectedOutput, readOutput);
  }

  /**
   * Tests the welcome method
   */
  @Test
  void testWelcome() {
    String welcome = """
        
        Welcome to BattleSalvo, Battleship with a twist!
        """.replaceAll(
        "\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.welcome();
    assertEquals(welcome, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.welcome());
  }

  /**
   * Tests the dimensions method
   */
  @Test
  void testDimensions() {
    String dimensions = """
    Please enter a valid height and width below:
    -----------------------------------------------------
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.dimensions();
    assertEquals(dimensions, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.dimensions());
  }

  /**
   * Tests the invalid dimensions method
   */
  @Test
  void testInvalidDimensions() {
    String invalidDimensions = """
    You entered invalid dimensions.
    Board dimensions must be between 6 and 15 (inclusive).
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.invalidDimensions();
    assertEquals(invalidDimensions, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.invalidDimensions());
  }

  /**
   * Tests the fleet select method
   */
  @Test
  void testFleetSelect() {
    String fleetSelect = """
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 8
        -----------------------------------------------------
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.fleetSelect(8);
    assertEquals(fleetSelect, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.fleetSelect(8));
  }

  /**
   * Tests the invalidFleet method
   */
  @Test
  void testInvalidFleet() {
    String invalidFleet = """
        You entered an invalid fleet.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 10
        -----------------------------------------------------
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.invalidFleet(10);
    assertEquals(invalidFleet, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.invalidFleet(10));
  }

  /**
   * Tests the shots method
   */
  @Test
  void testShots() {
    String shots = """
        Please enter 7 shots.
        -----------------------------------------------------
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.shots(7);
    assertEquals(shots, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.shots(7));
  }

  /**
   * Tests the invalidShots method
   */
  @Test
  void testInvalidShots() {
    String invalidShots = """
        The previous shot was invalid.
        Please enter 3 more shots.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.invalidShots(3);
    assertEquals(invalidShots, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.invalidShots(3));
  }

  /**
   * Tests the displayBoard method for a user
   */
  @Test
  void testDisplayBoardUser() {
    String userExpected = """
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * * * *\s
                
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.displayBoard(player, player.getUserBoard(), BoardType.USER);
    assertEquals(userExpected, output.toString());
    assertThrows(RuntimeException.class, () ->
        mockConsoleView.displayBoard(player, player.getUserBoard(), BoardType.USER));
  }

  /**
   * Tests the displayBoard method for an opponent
   */
  @Test
  void testDisplayBoardOpponent() {
    String opponentExpected = """
        -----------------------------------------------------
        User's board:
                
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
                
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    battleSalvoConsoleView.displayBoard(player, player.getUserBoard(), BoardType.OPPONENT);
    assertEquals(opponentExpected, output.toString());
    assertThrows(RuntimeException.class, () ->
        mockConsoleView.displayBoard(player, player.getUserBoard(), BoardType.OPPONENT));
  }

  /**
   * Tests the result method
   */
  @Test
  void testResult() {
    String resultOutput =
        "-----------------------------------------------------"
            + System.getProperty("line.separator")
            + System.getProperty("line.separator")
        + "Game over!" + System.getProperty("line.separator")
        + "You WIN because:  User sunk all of Computer's ships."
        + System.getProperty("line.separator");
    GameResult result = GameResult.WIN;
    String reason = " User sunk all of Computer's ships.";
    battleSalvoConsoleView.result(result, reason);
    assertEquals(resultOutput, output.toString());
    assertThrows(RuntimeException.class, () -> mockConsoleView.result(result, reason));
  }

}
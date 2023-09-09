package cs3500.pa03.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.ConsolePlayer;
import cs3500.pa03.model.ConsolePlayerDependencies;
import cs3500.pa03.view.BattleSalvoConsoleView;
import cs3500.pa03.view.BattleSalvoView;
import cs3500.pa04.MockRandom;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

/**
 * Tests the BattleSalvoController test and its associated methods
 */
class BattleSalvoControllerTest {

  /**
   * Tests the run method with an integration test for when the user wins
   */
  @Test
  void testRunWin() {
    String winInputs = """
        hello hello hello
        6 6 6
        18 -1
        -1 18
        6 6
        -1 2 3 4
        1 2 3 4 5 5
        1 2 3
        2 3 4 5
        1 1 1 1
        0 0
        1 1
        2 2
        3 3
        0 1
        0 2
        0 3
        0 4
        0 5
        1 0
        2 0
        3 0
        4 0
        5 0
        2 1
        3 1
        hello
        -1 0
        2 1 2
        18 18
        0 0
        4 1
        5 1
        2 4
        2 5
        1 4
        4 3
        4 4
        5 3
        4 2
        4 5
        5 4
        5 5
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    Readable winInput = new StringReader(winInputs);
    Appendable winOutput = new StringBuilder();
    BattleSalvoView winView = new BattleSalvoConsoleView(winInput, winOutput);
    ConsolePlayer winPlayerOne = new ConsolePlayer("User", new MockRandom(),
        new ConsolePlayerDependencies());
    ComputerPlayer winPlayerTwo = new ComputerPlayer(new MockRandom());
    BattleSalvoController winController =
        new BattleSalvoController(winView, winPlayerOne, winPlayerTwo);
    String expected = """
                
        Welcome to BattleSalvo, Battleship with a twist!
        Please enter a valid height and width below:
        -----------------------------------------------------
        You entered invalid dimensions.
        Board dimensions must be between 6 and 15 (inclusive).
        You entered invalid dimensions.
        Board dimensions must be between 6 and 15 (inclusive).
        You entered invalid dimensions.
        Board dimensions must be between 6 and 15 (inclusive).
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        You entered an invalid fleet.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        You entered an invalid fleet.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        You entered an invalid fleet.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        You entered an invalid fleet.
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * * * *\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * * * *\s
        * [31mH[0m * * * *\s
        * * [0;33mM[0m * * *\s
        * * * [0;33mM[0m * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * * [0;33mM[0m *\s
        [31mH[0m [36mB[0m * * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m *\s
        * [31mH[0m * * * *\s
        * * [0;33mM[0m * * *\s
        * * * [0;33mM[0m * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m * * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m * [0;33mM[0m * * *\s
        [31mH[0m * * [0;33mM[0m * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m * [0;33mM[0m * *\s
        [31mH[0m * * * * *\s
        [31mH[0m * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        The previous shot was invalid.
        Please enter 4 more shots.
        The previous shot was invalid.
        Please enter 4 more shots.
        The previous shot was invalid.
        Please enter 4 more shots.
        The previous shot was invalid.
        Please enter 4 more shots.
        The previous shot was invalid.
        Please enter 4 more shots.
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m * *\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m [31mH[0m * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [36mS[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m * *\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m *\s
        [31mH[0m [31mH[0m * [0;33mM[0m * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [36mS[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [31mH[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m * *\s
        [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
                
        Game over!
        You WIN because: User has sunk all of Computer's ships.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    winController.run();
    System.out.println(winOutput);
    assertEquals(expected, winOutput.toString());
  }

  /**
   * Tests the run method with an integration test for when the user loses
   */
  @Test
  void testRunLose() {
    String loseInputs = """
        6 6
        1 1 1 1
        0 0
        1 1
        2 2
        3 3
        4 4
        5 5
        0 5
        1 4
        2 3
        3 2
        4 1
        5 0
        0 4
        0 3
        1 3
        1 5
        2 4
        2 5
        2 0
        3 0
        5 2
        5 3
        3 5
        5 1
        5 4
        4 5
        0 1
        1 2
        0 2
        1 0
        4 3
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    Readable loseInput = new StringReader(loseInputs);
    Appendable loseOutput = new StringBuilder();
    BattleSalvoView loseView = new BattleSalvoConsoleView(loseInput, loseOutput);
    ConsolePlayer losePlayerOne = new ConsolePlayer("User", new MockRandom(),
        new ConsolePlayerDependencies());
    ComputerPlayer losePlayerTwo = new ComputerPlayer(new MockRandom());
    BattleSalvoController loseController =
        new BattleSalvoController(loseView, losePlayerOne, losePlayerTwo);
    String expected = """
                
        Welcome to BattleSalvo, Battleship with a twist!
        Please enter a valid height and width below:
        -----------------------------------------------------
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * * * *\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * * * *\s
        * [31mH[0m * * * *\s
        * * [0;33mM[0m * * *\s
        * * * [0;33mM[0m * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * * [0;33mM[0m *\s
        [31mH[0m [36mB[0m * * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * * * [0;33mM[0m\s
        * [31mH[0m * * [0;33mM[0m *\s
        * * [0;33mM[0m * * *\s
        * * * [0;33mM[0m * *\s
        * * * * [31mH[0m *\s
        * * * * * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * * * [0;33mM[0m\s
        * [31mH[0m * * [0;33mM[0m *\s
        * * [0;33mM[0m [0;33mM[0m * *\s
        * * [0;33mM[0m [0;33mM[0m * *\s
        * [31mH[0m * * [31mH[0m *\s
        [31mH[0m * * * * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * [31mH[0m [31mH[0m [0;33mM[0m\s
        * [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        * * [0;33mM[0m [0;33mM[0m * *\s
        * * [0;33mM[0m [0;33mM[0m * *\s
        * [31mH[0m * * [31mH[0m *\s
        [31mH[0m * * * * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [31mH[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * [31mH[0m [31mH[0m [0;33mM[0m\s
        * [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m * *\s
        * [31mH[0m * * [31mH[0m *\s
        [31mH[0m * * * * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [31mH[0m [36mD[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * * [31mH[0m [31mH[0m [0;33mM[0m\s
        * [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m * [0;33mM[0m\s
        * [31mH[0m * * [31mH[0m *\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m * [0;33mM[0m\s
                
        Please enter 3 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m * [31mH[0m [31mH[0m [0;33mM[0m\s
        * [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m * [0;33mM[0m\s
        * [31mH[0m * * [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 2 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        * [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m [0;33mM[0m * [0;33mM[0m\s
        * [31mH[0m * * [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 1 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [36mB[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [36mB[0m [0;33mM[0m [0;33mM[0m * [0;33mM[0m\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
                
        Game over!
        You LOSE because: Computer has sunk all of User's ships.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    loseController.run();
    assertEquals(expected, loseOutput.toString());
  }

  /**
   * Tests the run method with an integration test for when the user draws
   */
  @Test
  void testRunDraw() {
    String drawInputs = """
        6 6
        1 1 1 1
        4 1
        5 5
        3 2
        5 3
        0 5
        3 0
        1 4
        2 0
        5 4
        1 3
        5 0
        2 2
        3 1
        2 5
        4 0
        0 3
        0 0
        1 1
        3 4
        0 2
        1 0
        1 5
        4 4
        5 1
        0 1
        2 1
        4 5
        4 3
        1 2
        3 5
        0 4
        2 4
        2 3
        3 3
        4 2
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    Readable drawInput = new StringReader(drawInputs);
    Appendable drawOutput = new StringBuilder();
    BattleSalvoView drawView = new BattleSalvoConsoleView(drawInput, drawOutput);
    ConsolePlayer drawPlayerOne = new ConsolePlayer("User", new MockRandom(),
        new ConsolePlayerDependencies());
    ComputerPlayer drawPlayerTwo = new ComputerPlayer(new MockRandom());
    BattleSalvoController drawController =
        new BattleSalvoController(drawView, drawPlayerOne, drawPlayerTwo);
    String expected = """
                
        Welcome to BattleSalvo, Battleship with a twist!
        Please enter a valid height and width below:
        -----------------------------------------------------
        Please enter your fleet in the order [Carrier, Battleship, Destroyer, Submarine].
        Remember, your fleet may not exceed 6
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * * * *\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m * * * *\s
        [36mC[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * *\s
        * * * * * *\s
        * * * * * *\s
        * * [0;33mM[0m * * *\s
        * [31mH[0m * * * *\s
        * * * [0;33mM[0m * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * * [0;33mM[0m *\s
        [31mH[0m [36mB[0m * * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m * [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * [0;33mM[0m\s
        * * * * [0;33mM[0m *\s
        [31mH[0m * * * * *\s
        [31mH[0m * [0;33mM[0m * * *\s
        * [31mH[0m * * * *\s
        * * * [0;33mM[0m * [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [36mS[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * *\s
        [36mC[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * * * [0;33mM[0m\s
        * * * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m * [0;33mM[0m * * *\s
        [31mH[0m * [0;33mM[0m * * *\s
        * [31mH[0m * * * *\s
        [31mH[0m * * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [36mC[0m * [36mS[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [36mB[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        * * * [31mH[0m * [0;33mM[0m\s
        * * * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m * [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * *\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m * * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [36mC[0m [31mH[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [36mD[0m [36mD[0m\s
        [31mH[0m [36mB[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * [31mH[0m [31mH[0m * [0;33mM[0m\s
        * [31mH[0m * [0;33mM[0m [0;33mM[0m *\s
        [31mH[0m * [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m * * * *\s
        [31mH[0m * * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 4 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m * [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [36mB[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [31mH[0m [36mD[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m * [31mH[0m [31mH[0m * [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m * [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m * * [31mH[0m *\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 3 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [36mD[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m * [0;33mM[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m * * [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 2 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [36mS[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m *\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 2 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * * [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 1 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 1 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m * [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 1 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [36mD[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m * [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        Please enter 1 shots.
        -----------------------------------------------------
        -----------------------------------------------------
        User's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
        Computer's board:
                
        [31mH[0m [0;33mM[0m [31mH[0m [31mH[0m [31mH[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
        [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m [31mH[0m\s
        [31mH[0m [31mH[0m * [0;33mM[0m [0;33mM[0m [0;33mM[0m\s
                
        -----------------------------------------------------
                
        Game over!
        You DRAW because: both players have sunk the opponent's ships.
        """.replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    drawController.run();
    assertEquals(expected, drawOutput.toString());
  }
}
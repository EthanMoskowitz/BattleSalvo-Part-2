package cs3500.pa04.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.GameResult;
import cs3500.pa04.MockRandom;
import cs3500.pa04.json.JsonTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing ProxyController and its associated methods
 */
class ProxyControllerTest extends JsonTest {
  private ByteArrayOutputStream testLog;
  private ProxyController controller;

  @BeforeEach
  public void setup() {
    testLog = new ByteArrayOutputStream(2048);
    assertEquals("", logToString());
  }

  /**
   * Converts the ByteArrayOutputStream log to a string in UTF_8 format
   *
   * @return String representing the current log buffer
   */
  private String logToString() {
    return testLog.toString(StandardCharsets.UTF_8);
  }

  /**
   * Tests the run method
   */
  @Test
  public void testRun() {
    Mocket socket = new Mocket(testLog, List.of(
        joinRequest().toString(),
        setupRequest(6, 6, 1, 1, 1, 1).toString(),
        takeShotsRequest().toString(),
        reportDamage(hits).toString(),
        successfulHitsRequest(hits).toString(),
        endGameRequest(GameResult.WIN, "You win because...").toString()));


    // Create a Controller
    try {
      controller = new ProxyController(socket, new ComputerPlayer(new MockRandom()));
    } catch (IOException e) {
      fail(); // fail if the dealer can't be created
    }

    // run the controller and verify the response
    controller.run();
    String expected =
        "{\"method-name\":\"join\",\"arguments\":{\"name\":\"user\",\"game-type\":\"SINGLE\"}}"
        + System.getProperty("line.separator")
        + "{\"method-name\":\"setup\",\"arguments\":{\"fleet\":[{\"coord\":{\"x\":0,\"y\":0},"
            + "\"length\":6,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":1,\"y\":1},\"length\":5,"
            + "\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":2,\"y\":4},\"length\":4,"
            + "\"direction\":\"HORIZONTAL\"},{\"coord\":{\"x\":2,\"y\":0},\"length\":3,"
            + "\"direction\":\"HORIZONTAL\"}]}}" + System.getProperty("line.separator")
        + "{\"method-name\":\"take-shots\",\"arguments\":{\"coordinates\":[{\"x\":1,\"y\":4},"
            + "{\"x\":5,\"y\":5},{\"x\":2,\"y\":3},{\"x\":3,\"y\":5}]}}"
            + System.getProperty("line.separator")
        + "{\"method-name\":\"report-damage\",\"arguments\":{\"coordinates\":[{\"x\":0,\"y\":0},"
            + "{\"x\":1,\"y\":3}]}}" + System.getProperty("line.separator")
        + "{\"method-name\":\"successful-hits\",\"arguments\":{}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"end-game\",\"arguments\":{}}"
            + System.getProperty("line.separator");
    assertEquals(expected, logToString());
  }

  /**
   * Tests the controller for an invalid json message
   */
  @Test
  public void testInvalidMessage() {

    Mocket socket = new Mocket(testLog, List.of(joinRequest().toString(),
        invalidNode.toString()));

    // Create a Controller
    try {
      controller = new ProxyController(socket, new ComputerPlayer(new MockRandom()));
    } catch (IOException e) {
      fail(); // fail if the dealer can't be created
    }

    assertThrows(IllegalStateException.class, () -> controller.run());
  }

  /**
   * Tests the controller for a server where it would lose
   */
  @Test
  public void testLose() {
    Mocket socket = new Mocket(testLog, List.of(
        joinRequest().toString(),
        setupRequest(6, 6, 1, 1, 1, 1).toString(),
        takeShotsRequest().toString(),
        reportDamage(hits).toString(),
        successfulHitsRequest(hits).toString(),
        takeShotsRequest().toString(),
        reportDamage(hits2).toString(),
        successfulHitsRequest(hits2).toString(),
        endGameRequest(GameResult.LOSE, "You lose because...").toString()));

    // Create a Controller
    try {
      controller = new ProxyController(socket, new ComputerPlayer(new MockRandom()));
    } catch (IOException e) {
      fail(); // fail if the dealer can't be created
    }

    // run the controller and verify the response
    controller.run();
    String expected =
        "{\"method-name\":\"join\",\"arguments\":{\"name\":\"user\",\"game-type\":\"SINGLE\"}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"setup\",\"arguments\":{\"fleet\":[{\"coord\":{\"x\":0,\"y\":0},"
            + "\"length\":6,\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":1,\"y\":1},\"length\":5,"
            + "\"direction\":\"VERTICAL\"},{\"coord\":{\"x\":2,\"y\":4},\"length\":4,"
            + "\"direction\":\"HORIZONTAL\"},{\"coord\":{\"x\":2,\"y\":0},\"length\":3,"
            + "\"direction\":\"HORIZONTAL\"}]}}" + System.getProperty("line.separator")
            + "{\"method-name\":\"take-shots\",\"arguments\":{\"coordinates\":[{\"x\":1,\"y\":4},"
            + "{\"x\":5,\"y\":5},{\"x\":2,\"y\":3},{\"x\":3,\"y\":5}]}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"report-damage\",\"arguments\":{\"coordinates\":[{\"x\":0,\"y\":0}"
            + ",{\"x\":1,\"y\":3}]}}" + System.getProperty("line.separator")
            + "{\"method-name\":\"successful-hits\",\"arguments\":{}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"take-shots\",\"arguments\":{\"coordinates\":[{\"x\":5,\"y\":0},"
            + "{\"x\":0,\"y\":3},{\"x\":4,\"y\":1},{\"x\":0,\"y\":2}]}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"report-damage\",\"arguments\":{\"coordinates\":[]}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"successful-hits\",\"arguments\":{}}"
            + System.getProperty("line.separator")
            + "{\"method-name\":\"end-game\",\"arguments\":{}}"
            + System.getProperty("line.separator");
    assertEquals(expected, logToString());

  }

}
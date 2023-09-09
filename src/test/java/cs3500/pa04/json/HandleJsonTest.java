package cs3500.pa04.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.model.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing HandleJson and its associated methods
 */
class HandleJsonTest extends JsonTest {

  private HandleJson handler;
  private ObjectMapper mapper;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    handler = new HandleJson();
    mapper = new ObjectMapper();
  }

  /**
   * Tests the handleJoin method
   */
  @Test
  public void testHandleJoin() {
    JsonNode expected = joinResponse("user", GameType.SINGLE);
    JsonNode response = handler.handleJoin();
    assertEquals(expected, response);
  }

  /**
   * Tests the handleSetup method
   */
  @Test
  public void testHandleSetup() {
    JsonNode setupRequest = setupRequest(
        6, 6, 1, 1, 1, 1);
    MessageJson message = mapper.convertValue(setupRequest, MessageJson.class);
    JsonNode response = handler.handleSetup(message.arguments(), player);
    JsonNode expected = setupResponse(ships);
    System.out.println(response);
    System.out.println(expected);
    assertEquals(expected, response);
  }

  /**
   * Tests the handleTakeShots method
   */
  @Test
  public void testHandleTakeShots() {
    setupBoard();
    JsonNode response = handler.handleTakeShots(player);
    JsonNode expected = takeShotsResponse(shots);
    assertEquals(expected, response);
  }

  /**
   * Tests the reportDamage method
   */
  @Test
  public void testReportDamage() {
    setupBoard();
    JsonNode reportDamageRequest = reportDamage(coords);
    MessageJson message = mapper.convertValue(reportDamageRequest, MessageJson.class);
    JsonNode response = handler.handleReportDamage(message.arguments(), player);
    assertEquals(reportDamageRequest, response);
  }

  /**
   * Tests the successfulHits method
   */
  @Test
  public void testSuccessfulHits() {
    setupBoard();
    JsonNode successfulHits = successfulHitsRequest(hits);
    MessageJson message = mapper.convertValue(successfulHits, MessageJson.class);
    JsonNode response = handler.handleSuccessfulHits(message.arguments(), player);
    JsonNode expected = successfulHitsResponse();
    assertEquals(expected, response);
  }

  /**
   * Tests the endGame method
   */
  @Test
  public void testEndGame() {
    setupBoard();
    JsonNode endGame = endGameRequest(GameResult.WIN, "You win because...");
    MessageJson message = mapper.convertValue(endGame, MessageJson.class);
    JsonNode response = handler.handleEndGame(message.arguments(), player);
    JsonNode expected = endGameResponse();
    assertEquals(expected, response);
  }

}
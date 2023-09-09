package cs3500.pa04.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.ShipType;
import cs3500.pa04.Direction;
import cs3500.pa04.MockRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for holding Json test data
 */
public abstract class JsonTest {

  protected final ComputerPlayer player = new ComputerPlayer(new MockRandom());
  private final ObjectMapper mapper = new ObjectMapper();

  private final CoordJson carrierCoord = new CoordJson(0, 0);
  private final ShipJson carrier = new ShipJson(carrierCoord, 6, Direction.VERTICAL);
  private final CoordJson battleshipCoord = new CoordJson(1, 1);
  private final ShipJson battleship = new ShipJson(battleshipCoord, 5, Direction.VERTICAL);
  private final CoordJson destroyerCoord = new CoordJson(2, 4);
  private final ShipJson destroyer = new ShipJson(destroyerCoord, 4, Direction.HORIZONTAL);
  private final CoordJson submarineCoord = new CoordJson(2, 0);
  private final ShipJson submarine = new ShipJson(submarineCoord, 3, Direction.HORIZONTAL);
  protected final ShipJson[] ships = new ShipJson[]{carrier, battleship, destroyer, submarine};

  private final CoordJson takeShotOne = new CoordJson(1, 4);
  private final CoordJson takeShotTwo = new CoordJson(5, 5);
  private final CoordJson takeShotThree = new CoordJson(2, 3);
  private final CoordJson takeShotFour = new CoordJson(3, 5);
  protected final CoordJson[] shots =
      new CoordJson[]{takeShotOne, takeShotTwo, takeShotThree, takeShotFour};

  private final CoordJson reportCoordOne = new CoordJson(0, 1);
  private final CoordJson reportCoordTwo = new CoordJson(0, 2);
  private final CoordJson reportCoordThree = new CoordJson(0, 3);
  private final CoordJson reportCoordFour = new CoordJson(0, 4);
  protected final CoordJson[] coords = new CoordJson[]{reportCoordOne, reportCoordTwo,
      reportCoordThree, reportCoordFour};

  private final CoordJson successfulHitOne = new CoordJson(0, 0);
  private final CoordJson successfulHitTwo = new CoordJson(1, 3);
  protected final CoordJson[] hits = new CoordJson[]{successfulHitOne, successfulHitTwo};

  private final CoordJson successfulHitThree = new CoordJson(4, 3);
  private final CoordJson successfulHitFour = new CoordJson(2, 2);
  protected final CoordJson[] hits2 = new CoordJson[]{successfulHitThree, successfulHitFour};

  private final MessageJson invalid =
      new MessageJson("invalid", mapper.createObjectNode());
  protected final JsonNode invalidNode = JsonUtils.serializeRecord(invalid);

  /**
   * Provides a JsonNode representing a join request from the server
   *
   * @return a join request JsonNode
   */
  protected JsonNode joinRequest() {
    JsonNode emptyJson = mapper.createObjectNode();
    MessageJson joinMessageServer = new MessageJson("join", emptyJson);
    return JsonUtils.serializeRecord(joinMessageServer);
  }

  /**
   * Provides a JsonNode representing a join response from the client
   *
   * @param name the name of the user
   * @param type the type of game
   * @return a join response JsonNode
   */
  protected JsonNode joinResponse(String name, GameType type) {
    JsonNode joinNode =
        JsonUtils.serializeRecord(new JoinJson(name, type));
    MessageJson joinMessage = new MessageJson("join", joinNode);
    return JsonUtils.serializeRecord(joinMessage);
  }

  /**
   * Provides a JsonNode representing a setup request from the server
   *
   * @param height the height of the board
   * @param width the width of the board
   * @param carriers the number of carriers
   * @param battleships the number of battleships
   * @param destroyers the number of destroyers
   * @param submarines the number of submarines
   * @return a setup request JsonNode
   */
  protected JsonNode setupRequest(int height, int width, int carriers, int battleships,
                                  int destroyers, int submarines) {
    FleetSpecJson fleetSpec =
        new FleetSpecJson(carriers, battleships, destroyers, submarines);
    JsonNode setupArgs =
        JsonUtils.serializeRecord(new SetupJson(height, width, fleetSpec));
    MessageJson setupServer = new MessageJson("setup", setupArgs);
    return JsonUtils.serializeRecord(setupServer);
  }

  /**
   * Provides a JsonNode representing a setup response from the client
   *
   * @param ships a list of ShipJsons
   * @return a setup response JsonNode
   */
  protected JsonNode setupResponse(ShipJson[] ships) {
    FleetJson fleet = new FleetJson(ships);
    JsonNode fleetArgs = JsonUtils.serializeRecord(fleet);
    MessageJson fleetMessage = new MessageJson("setup", fleetArgs);
    return JsonUtils.serializeRecord(fleetMessage);
  }

  /**
   * Provides a JsonNode representing a takeShots request from the server
   *
   * @return a takeShots request JsonNode
   */
  protected JsonNode takeShotsRequest() {
    MessageJson takeShotsMessage =
        new MessageJson("take-shots", mapper.createObjectNode());
    return  JsonUtils.serializeRecord(takeShotsMessage);
  }

  /**
   * Provides a JsonNode representing a takeShots response from the client
   *
   * @param coords a list of CoordJson
   * @return a takeShots response JsonNode
   */
  protected JsonNode takeShotsResponse(CoordJson[] coords) {
    CoordinatesJson coordinateShots = new CoordinatesJson(coords);
    JsonNode coordinatesNode = JsonUtils.serializeRecord(coordinateShots);
    MessageJson coordinatesMessage =
        new MessageJson("take-shots", coordinatesNode);
    return JsonUtils.serializeRecord(coordinatesMessage);
  }

  /**
   * Provides a JsonNode representing a reportDamage request/response from the server/client
   *
   * @param coords a list of CoordJson
   * @return a reportDamage request JsonNode
   */
  protected JsonNode reportDamage(CoordJson[] coords) {
    CoordinatesJson coordinatesJson = new CoordinatesJson(coords);
    JsonNode reportDamageArgs = JsonUtils.serializeRecord(coordinatesJson);
    MessageJson reportDamageMessage =
        new MessageJson("report-damage", reportDamageArgs);
    return JsonUtils.serializeRecord(reportDamageMessage);
  }

  /**
   * Provides a JsonNode representing a successfulHits request from the server
   *
   * @param hits a list of CoordJson
   * @return a successfulHits request JsonNode
   */
  protected JsonNode successfulHitsRequest(CoordJson[] hits) {
    CoordinatesJson successfulCoordinates = new CoordinatesJson(hits);
    JsonNode successfulArgs = JsonUtils.serializeRecord(successfulCoordinates);
    MessageJson successfulMessageServer =
        new MessageJson("successful-hits", successfulArgs);
    return JsonUtils.serializeRecord(successfulMessageServer);
  }

  /**
   * Provides a JsonNode representing a successfulHits response from the client
   *
   * @return a successfulHits response JsonNode
   */
  protected JsonNode successfulHitsResponse() {
    JsonNode emptyArgs = mapper.createObjectNode();
    MessageJson successfulMessage =
        new MessageJson("successful-hits", emptyArgs);
    return JsonUtils.serializeRecord(successfulMessage);
  }

  /**
   * Provides a JsonNode representing an endGame request from the server
   *
   * @param result the game result
   * @param reason the reason fot the result
   * @return an endGame request JsonNode
   */
  protected JsonNode endGameRequest(GameResult result, String reason) {
    EndJson endJson = new EndJson(result, reason);
    JsonNode endGameArgs = JsonUtils.serializeRecord(endJson);
    MessageJson endGameServer = new MessageJson("end-game", endGameArgs);
    return JsonUtils.serializeRecord(endGameServer);
  }

  /**
   * Provides a JsonNode representing an endGame response from the client
   *
   * @return an endGame response JsonNode
   */
  protected JsonNode endGameResponse() {
    JsonNode emptyArgs = mapper.createObjectNode();
    MessageJson endResponse = new MessageJson("end-game", emptyArgs);
    return JsonUtils.serializeRecord(endResponse);
  }

  /**
   * Initializes the test data
   */
  protected void setupBoard() {
    Map<ShipType, Integer> specs = new HashMap<>();
    specs.put(ShipType.CARRIER, 1);
    specs.put(ShipType.BATTLESHIP, 1);
    specs.put(ShipType.DESTROYER, 1);
    specs.put(ShipType.SUBMARINE, 1);
    player.setup(6, 6, specs);
  }

}

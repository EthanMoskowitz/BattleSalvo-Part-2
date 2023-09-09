package cs3500.pa04.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import cs3500.pa04.adapters.CoordAdapter;
import cs3500.pa04.adapters.ShipAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles the Jsons for input and output
 */
public class HandleJson {
  private final ObjectMapper mapper;

  /**
   * Instantiates a HandleJson
   */
  public HandleJson() {
    mapper = new ObjectMapper();
  }

  /**
   * Handles a Json join request
   *
   * @return a serialized Json response
   */
  public JsonNode handleJoin() {
    JoinJson joinJson = new JoinJson("user", GameType.SINGLE);
    JsonNode argsNode = JsonUtils.serializeRecord(joinJson);
    MessageJson joinMessage = new MessageJson("join", argsNode);
    return JsonUtils.serializeRecord(joinMessage);
  }

  /**
   * Handles a Json setup request
   *
   * @param args     the received arguments
   * @param computer the computer player
   * @return a serialized Json response
   */
  public JsonNode handleSetup(JsonNode args, ComputerPlayer computer) {
    SetupJson setup = mapper.convertValue(args, SetupJson.class);
    int height = setup.height();
    int width = setup.width();
    Map<ShipType, Integer> map = new HashMap<>();
    map.put(ShipType.CARRIER, setup.fleetSpec().numCarriers());
    map.put(ShipType.BATTLESHIP, setup.fleetSpec().numBattleships());
    map.put(ShipType.DESTROYER, setup.fleetSpec().numDestroyers());
    map.put(ShipType.SUBMARINE, setup.fleetSpec().numSubmarines());
    List<Ship> shipList = computer.setup(height, width, map);
    ShipJson[] shipJsons = new ShipJson[shipList.size()];
    for (int i = 0; i < shipList.size(); i++) {
      shipJsons[i] = ShipAdapter.shipToJson(shipList.get(i));
    }
    FleetJson fleetJson = new FleetJson(shipJsons);
    JsonNode fleetNode = JsonUtils.serializeRecord(fleetJson);
    MessageJson setupMessage = new MessageJson("setup", fleetNode);
    return JsonUtils.serializeRecord(setupMessage);
  }

  /**
   * Handles a Json takeShots request
   *
   * @param computer the computer player
   * @return a serialized Json response
   */
  public JsonNode handleTakeShots(ComputerPlayer computer) {
    List<Coord> coords = computer.takeShots();
    CoordJson[] coordJsons = new CoordJson[coords.size()];
    for (int i = 0; i < coords.size(); i++) {
      coordJsons[i] = CoordAdapter.coordToJson(coords.get(i));
    }
    CoordinatesJson coordinatesJson = new CoordinatesJson(coordJsons);
    JsonNode coordinatesNode = JsonUtils.serializeRecord(coordinatesJson);
    MessageJson takeShotsMessage = new MessageJson("take-shots", coordinatesNode);
    return JsonUtils.serializeRecord(takeShotsMessage);
  }

  /**
   * Handles a Json reportDamage request
   *
   * @param args the received arguments
   * @param computer the computer
   * @return a serialized Json response
   */
  public JsonNode handleReportDamage(JsonNode args, ComputerPlayer computer) {
    CoordinatesJson coordinatesJson = mapper.convertValue(args, CoordinatesJson.class);
    List<Coord> coords = new ArrayList<>();
    for (CoordJson coordJson : coordinatesJson.coords()) {
      Coord c = CoordAdapter.jsonToCoord(coordJson);
      coords.add(c);
    }
    List<Coord> damage = computer.reportDamage(coords);
    CoordJson[] damageJson;
    damageJson = new CoordJson[damage.size()];
    for (int i = 0; i < damageJson.length; i++) {
      damageJson[i] = CoordAdapter.coordToJson(damage.get(i));
    }
    CoordinatesJson damageCoordinates = new CoordinatesJson(damageJson);
    JsonNode damageNode = JsonUtils.serializeRecord(damageCoordinates);
    MessageJson reportDamageMessage = new MessageJson("report-damage", damageNode);
    return JsonUtils.serializeRecord(reportDamageMessage);
  }

  /**
   * Handles a Json successfulHits request
   *
   * @param args     the received arguments
   * @param computer the computer player
   * @return a serialized Json response
   */
  public JsonNode handleSuccessfulHits(JsonNode args, ComputerPlayer computer) {
    CoordinatesJson coordinatesJson;
    coordinatesJson = mapper.convertValue(args, CoordinatesJson.class);
    List<Coord> coords = new ArrayList<>();
    for (CoordJson coordJson : coordinatesJson.coords()) {
      Coord c = CoordAdapter.jsonToCoord(coordJson);
      coords.add(c);
    }
    computer.successfulHits(coords);
    JsonNode node = mapper.createObjectNode();
    MessageJson successfulHitsMessage = new MessageJson("successful-hits", node);
    return JsonUtils.serializeRecord(successfulHitsMessage);
  }

  /**
   * Handles a Json endGame request
   *
   * @param args     the received arguments
   * @param computer the computer player
   * @return a serialized Json response
   */
  public JsonNode handleEndGame(JsonNode args, ComputerPlayer computer) {
    EndJson endJson = mapper.convertValue(args, EndJson.class);
    GameResult result = endJson.result();
    String reason = endJson.reason();
    computer.endGame(result, reason);
    JsonNode node = mapper.createObjectNode();
    MessageJson endGameMessage = new MessageJson("end-game", node);
    return JsonUtils.serializeRecord(endGameMessage);
  }

}

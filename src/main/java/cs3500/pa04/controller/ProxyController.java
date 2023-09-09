package cs3500.pa04.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.controller.Controller;
import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa04.json.HandleJson;
import cs3500.pa04.json.MessageJson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Represents a proxy controller for communicating to the server
 */
public class ProxyController implements Controller {
  private final ObjectMapper mapper;
  private final Socket server;
  private final InputStream in;
  private final PrintStream out;
  private final ComputerPlayer computer;
  private final HandleJson handler;

  /**
   * Instantiates a Proxy Controller
   *
   * @param server socket to read and write to
   * @param computer computer player to play the game
   * @throws IOException if an IO error with the server occurs
   */
  public ProxyController(Socket server, ComputerPlayer computer) throws IOException {
    this.mapper = new ObjectMapper();
    this.server = server;
    this.in = server.getInputStream();
    this.out = new PrintStream(server.getOutputStream());
    this.computer = computer;
    this.handler = new HandleJson();
  }

  /**
   * Runs the controller
   */
  @Override
  public void run() {
    try {
      JsonParser parser = mapper.getFactory().createParser(this.in);

      while (!this.server.isClosed()) {
        MessageJson message = parser.readValueAs(MessageJson.class);
        delegateMessage(message);
      }

    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Delegates incoming Json messages
   *
   * @param message the MessageJson to delegate
   * @throws IOException if an IO error with the server occurs
   */
  private void delegateMessage(MessageJson message) throws IOException {
    String name = message.messageName();
    JsonNode args = message.arguments();

    switch (name) {
      case "join" -> join();
      case "setup" -> setup(args);
      case "take-shots" -> takeShots();
      case "report-damage" -> reportDamage(args);
      case "successful-hits" -> successfulHits(args);
      case "end-game" -> endGame(args);
      default -> throw new IllegalStateException("Invalid message name");
    }

  }

  /**
   * Responses to the server with a join request
   */
  private void join() {
    JsonNode joinResponse = handler.handleJoin();
    this.out.println(joinResponse);
  }

  /**
   * Responds to the server with a setup request
   *
   * @param args the received JsonNode
   */
  private void setup(JsonNode args) {
    JsonNode setupResponse = handler.handleSetup(args, this.computer);
    this.out.println(setupResponse);
  }

  /**
   * Responds to the server with a takeShots request
   */
  private void takeShots() {
    JsonNode takeShotsResponse = handler.handleTakeShots(this.computer);
    this.out.println(takeShotsResponse);
  }

  /**
   * Responds to the server with a reportDamage request
   *
   * @param args the received JsonNode
   */
  private void reportDamage(JsonNode args) {
    JsonNode reportDamageResponse = handler.handleReportDamage(args, this.computer);
    this.out.println(reportDamageResponse);
  }

  /**
   * Responds to the server with a successfulHits request
   *
   * @param args the received JsonNode
   */
  private void successfulHits(JsonNode args) {
    JsonNode successfulHitsResponse = handler.handleSuccessfulHits(args, this.computer);
    this.out.println(successfulHitsResponse);
  }

  /**
   * Responds to the server with an endGame request
   *
   * @param args the received JsonNode
   * @throws IOException if an IO error with the server occurs
   */
  private void endGame(JsonNode args) throws IOException {
    JsonNode endGameResponse = handler.handleEndGame(args, this.computer);
    this.out.println(endGameResponse);
    server.close();
  }
}

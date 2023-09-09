package cs3500.pa04;

import cs3500.pa03.controller.BattleSalvoController;
import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.ConsolePlayer;
import cs3500.pa03.model.ConsolePlayerDependencies;
import cs3500.pa03.view.BattleSalvoConsoleView;
import cs3500.pa03.view.BattleSalvoView;
import cs3500.pa04.controller.ProxyController;
import cs3500.pa04.controller.RandomDecorator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required for user vs. computer games
   *             - two command line args required for server mode, provide a host and port
   */
  public static void main(String[] args) {
    switch (args.length) {
      case 0 -> {
        BattleSalvoView view =
            new BattleSalvoConsoleView(new InputStreamReader(System.in), System.out);
        ConsolePlayer playerOne = new ConsolePlayer("User",
            new RandomDecorator(), new ConsolePlayerDependencies());
        ComputerPlayer playerTwo = new ComputerPlayer(new RandomDecorator());
        new BattleSalvoController(view, playerOne, playerTwo).run();
      }
      case 2 -> {
        ProxyController controller;
        try {
          Socket server = validateServer(args);
          controller = new ProxyController(server, new ComputerPlayer(new RandomDecorator()));
          controller.run();
        } catch (IOException e) {
          System.err.println("Could not connect to server.");
        }
      }
      default -> {
        System.err.println("Provide a valid host and port to play against the server.");
        System.err.println("Provide no arguments to play against the computer.");
      }
    }
  }

  /**
   * Validates the given server arguments
   *
   * @param args the received arguments
   * @return a Socket to the server
   * @throws IOException if the Socket is invalid
   */
  private static Socket validateServer(String[] args) throws IOException {
    int port = Integer.parseInt(args[1]);
    return new Socket(args[0], port);
  }

}
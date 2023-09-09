package cs3500.pa04;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {

  private String[] incorrectLength;
  private String[] parseError;
  private String[] emptyArgs;
  private String[] serverArgs;

  /**
   * Instantiates the test data
   */
  @BeforeEach
  public void setup() {
    incorrectLength = new String[]{"0.0.0.0", "35001", "extra string"};
    parseError = new String[]{"0.0.0.0", "not a String"};
    emptyArgs = new String[]{};
    serverArgs = new String[]{"0.0.0.0", "35001"};
  }

  /**
   * Tests the Driver for exceptions and errors
   */
  @Test
  public void testDriverExceptions() {
    // No exception is thrown, an error message is printed for the user
    assertDoesNotThrow(() -> Driver.main(incorrectLength));
    // The input cannot be parsed to create a new socket
    assertThrows(NumberFormatException.class, () -> Driver.main(parseError));
    // Program will enter user mode, but throw exception since the scanner reads no user input
    assertThrows(NoSuchElementException.class, () -> Driver.main(emptyArgs));
    // No exception is thrown, an error message is printed for the user
    assertDoesNotThrow(() -> Driver.main(serverArgs));
  }

}
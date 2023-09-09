package cs3500.pa04.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing RandomDecorator and its associated methods
 */
class RandomDecoratorTest {

  private RandomDecorator randomDecorator;
  private Random random;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    randomDecorator = new RandomDecorator(1);
    random = new Random(1);
  }

  /**
   * Tests the nextInt methods
   */
  @Test
  public void testNextInt() {
    assertEquals(random.nextInt(), randomDecorator.nextInt());
    assertEquals(random.nextInt(10), randomDecorator.nextInt(10));
  }

  /**
   * Tests the nextBoolean method
   */
  @Test
  public void testNextBoolean() {
    assertEquals(random.nextBoolean(), randomDecorator.nextBoolean());
  }

}
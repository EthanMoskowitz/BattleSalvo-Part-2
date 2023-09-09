package cs3500.pa04.controller;

import java.util.Random;

/**
 * Class for decorating a random object
 */
public class RandomDecorator implements Randomable {

  private final Random rand;

  /**
   * Instantiates a random RandomDecorator
   */
  public RandomDecorator() {
    this.rand = new Random();
  }

  /**
   * Instantiates a seeded RandomDecorator
   *
   * @param seed a seed
   */
  public RandomDecorator(int seed) {
    this.rand = new Random(seed);
  }

  /**
   * Get the next random integer
   *
   * @return the next integer in the random sequence
   */
  @Override
  public int nextInt() {
    return this.rand.nextInt();
  }

  /**
   * Gets the next random integer within the given bound
   *
   * @param bound the upper bound
   * @return the next integer in the random sequence within the bound
   */
  @Override
  public int nextInt(int bound) {
    return this.rand.nextInt(bound);
  }

  /**
   * Gets the next random boolean
   *
   * @return the next boolean in the random sequence
   */
  @Override
  public boolean nextBoolean() {
    return this.rand.nextBoolean();
  }
}

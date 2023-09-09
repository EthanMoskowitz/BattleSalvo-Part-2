package cs3500.pa04.controller;

/**
 * Interface for random object decorators
 */
public interface Randomable {

  /**
   * Get the next random integer
   *
   * @return the next integer in the random sequence
   */
  int nextInt();

  /**
   * Gets the next random integer within the given bound
   *
   * @param bound the upper bound
   * @return the next integer in the random sequence within the bound
   */
  int nextInt(int bound);

  /**
   * Gets the next random boolean
   *
   * @return the next boolean in the random sequence
   */
  boolean nextBoolean();

}

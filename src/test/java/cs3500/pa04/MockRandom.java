package cs3500.pa04;

import cs3500.pa04.controller.Randomable;

/**
 * Mock class for testing random seeded methods
 */
public class MockRandom implements Randomable {

  private int intsIndex = 0;
  private int boolIndex = 0;
  private final int[] ints =
      new int[]{0, 0, 0, 0, 2, 4, 1, 1, 1, 1, 3, 0, 4, 2, 3, 1, 2, 2, 1, 0, 2, 5, 2, 3, 0, 2,
          25, 34, 20, 31, 5, 17, 9, 10, 27, 8, 23, 10, 13, 12, 15, 3, 0, 4, 10, 1, 2, 3, 10, 11,
          0, 2, 8, 7, 1, 4, 0, 1, 0, 0, 0};
  private final boolean[] booleans =
      new boolean[]{true, false, false, true, true, false, false, true, true};

  /**
   * Get the next random integer
   *
   * @return the next integer in the random sequence
   */
  @Override
  public int nextInt() {
    int next = ints[intsIndex];
    this.intsIndex++;
    return next;
  }

  /**
   * Gets the next random integer within the given bound
   *
   * @param bound the upper bound
   * @return the next integer in the random sequence within the bound
   */
  @Override
  public int nextInt(int bound) {
    return nextInt();
  }

  /**
   * Gets the next random boolean
   *
   * @return the next boolean in the random sequence
   */
  @Override
  public boolean nextBoolean() {
    boolean next = booleans[boolIndex];
    this.boolIndex++;
    return next;
  }
}

package org.rmb.math.math;

import java.util.List;

/**
 * <p>Methods that give numbers as {@link List}s.</p>
 */
public final class Number {

   /**
    * Not for external instantiation.
    */
   private Number() {
   }

   /**
    * Numbers one to nine in a list.
    *
    * @return list of 1 - 9.
    */
   public static List<Integer> listOfNumbersOneToNine() {
      return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
   }

   /**
    * Numbers one to nine in a 3 * 3 grid.
    *
    * @return list of lists representing a 3 * 3 grid of numbers 1 - 9.
    */
   public static List<List<Integer>> gridOfNumbersThreeByThree() {
      return List.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9)
      );
   }
}

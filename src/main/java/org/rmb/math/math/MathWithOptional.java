package org.rmb.math.math;

import java.util.Optional;

/**
 * <p>Some math methods that return {@link Optional}s and are null-safe.</p>
 *
 * <p>The advantage of returning results wrapped in an {@link Optional} is that you are making one point very clear:
 * <em>the result can be null</em> and you are forcing the caller to deal with with it in some way.</p>
 */
public final class MathWithOptional {

   /**
    * Not for external instantiation.
    */
   private MathWithOptional() {
   }

   /**
    * Double a given <code>multiplicand</code>.
    *
    * @param multiplicand the number to be multiplied: the multiplier is 2. Can be null.
    *
    * @return the product of <code>multiplicand * 2</code> wrapped in an {@link Optional} or {@link Optional#empty()} if
    *       <code>multiplicand</code> is null.
    */
   public static Optional<Integer> doubleNumber(final Integer multiplicand) {
      // Rather than test if multiplicand is null, wrap it in an Optional that gives us methods to deal with nulls.
      return Optional.ofNullable(multiplicand)
            // Directly return result of map:
            //  - if number is present (not null) result of map is Optional.of(number * 2)
            //  - if number is null, result of map is Optional.empty()
            .map(number -> number * 2);
   }

   /**
    * Triple a given <code>multiplicand</code>.
    *
    * @param multiplicand the number to be multiplied: the multiplier is 3. Can be null.
    *
    * @return the product of <code>multiplicand * 3</code> wrapped in an {@link Optional} or {@link Optional#empty()} if
    *       <code>multiplicand</code> is null.
    */
   public static Optional<Integer> tripleNumber(final Integer multiplicand) {
      // Rather than test if multiplicand is null, wrap it in an Optional that gives us methods to deal with nulls.
      return Optional.ofNullable(multiplicand)
            // Directly return result of map:
            //  - if number is present (not null) result of map is Optional.of(number * 3)
            //  - if number is null, result of map is Optional.empty()
            .map(number -> number * 3);
   }
}

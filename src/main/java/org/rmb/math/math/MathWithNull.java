package org.rmb.math.math;

import java.util.Optional;

/**
 * <p>Some math methods that return nulls but are null-safe.</p>
 *
 * <p>Returning a null is a common enough way to signal "no result" to the caller. The caller should then test if the
 * return value is null and deal with it. This leaves code with lots of <strong>if</strong> statements and risks {@link
 * NullPointerException}s any time the developer either forgets to check for nulls or otherwise assumes that the result
 * of a method can never be null.</p>
 */
public final class MathWithNull {

   /**
    * Not for external instantiation.
    */
   private MathWithNull() {
   }

   /**
    * Double a given <code>multiplicand</code>.
    *
    * @param multiplicand the number to be multiplied: the multiplier is 2. Can be null.
    *
    * @return the product of <code>multiplicand * 2</code> or <code>null</code> if <code>multiplicand</code> is null.
    */
   public static Integer doubleNumber(final Integer multiplicand) {
      // Rather than test if multiplicand is null, wrap it in an Optional that gives us methods to deal with nulls.
      return Optional.ofNullable(multiplicand)
            // Map:
            //  - if number is present (not null) result of map is Optional.of(number * 2)
            //  - if number is null, result of map is Optional.empty()
            .map(number -> number * 2)
            // Return value if Optional is not empty; otherwise return null.
            .orElse(null);
   }

   /**
    * Triple a given <code>multiplicand</code>.
    *
    * @param multiplicand the number to be multiplied: the multiplier is 3. Can be null.
    *
    * @return the product of <code>multiplicand * 3</code> or <code>null</code> if <code>multiplicand</code> is null.
    */
   public static Integer tripleNumber(final Integer multiplicand) {
      // Rather than test if multiplicand is null, wrap it in an Optional that gives us methods to deal with nulls.
      return Optional.ofNullable(multiplicand)
            // Map:
            //  - if number is present (not null) result of map is Optional.of(number * 3)
            //  - if number is null, result of map is Optional.empty()
            .map(number -> number * 3)
            // Return value if Optional is not empty; otherwise return null.
            .orElse(null);
   }

}

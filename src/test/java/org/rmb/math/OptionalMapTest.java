package org.rmb.math;

import org.junit.jupiter.api.Test;
import org.rmb.math.math.MathWithNull;
import org.rmb.math.math.MathWithOptional;

import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>Testing {@link Optional}. This is me working my way through what I am learning from
 * <a href="https://www.baeldung.com/java-difference-map-and-flatmap">The Difference Between map() and flatMap()</a>
 *
 * @see <a href="https://www.baeldung.com/java-difference-map-and-flatmap">The Difference Between map() and
 *       flatMap()</a></p>
 */
class OptionalMapTest {

   /**
    * <p>The map() method works well with {@link Optional} – if the function returns the exact type I need.</p>
    *
    * <p>In this case, I have a function that returns an {@link Integer} (which may be null): {@link
    * MathWithNull#doubleNumber(Integer)}. I want to call the function in a null-safe way, so I wrap my value in an
    * <code>Optional</code> and call the function via {@link Optional#map(Function)}. This does two things:</p>
    *
    * <ol>
    *    <li>The function will only be called if my value is <strong>not null</strong>.</li>
    *    <li>The return result will be wrapped in an {@link Optional}, making it easier for me to deal with a null
    *    result.</li>
    * </ol>
    *
    * <p>Map method:</p>
    *
    * <ol>
    *    <li>If value is present, apply function to it and return an <code>Optional</code> wrapped around the result
    *    .</li>
    *    <li>If value is empty, return {@link Optional#empty()}.</li>
    * </ol>
    */
   @Test
   void optionalOf() {
      // I want to apply the function to a value in an NPE safe way (because the value might be null), so wrap
      // the value in an Optional.
      final var value = Optional.of(5);

      // Apply the function to our NPE safe Optional using map().
      final var functionResult = value.map(MathWithNull::doubleNumber);

      // Check result - an Optional wrapping an Integer.
      assertEquals(Optional.of(10), functionResult);
   }

   /**
    * But if I have a function that also returns an {@link Optional} ({@link MathWithOptional#doubleNumber(Integer)}),
    * then doing the same thing means I get a nested <code>Optional</code> - an <code>Optional</code> wrapping an
    * <code>Optional</code>.
    */
   @Test
   void optionalOfOptional() {
      // I want to apply the function to a value in an NPE safe way (because the value might be null), so wrap
      // the value in an Optional.
      final var value = Optional.of(5);

      // Apply the function to our NPE safe Optional using map().
      final var functionResult = value.map(MathWithOptional::doubleNumber);

      // Check result - an Optional wrapping an Optional wrapping an Integer.
      assertEquals(Optional.of(Optional.of(10)), functionResult);
   }

   /**
    * The answer is to apply {@link Optional#flatMap(Function)} - to unpack the nested {@link Optional}s.
    */
   @Test
   void optionalOfFlatMap() {
      // I want to apply the function to a value in an NPE safe way (because the value might be null), so wrap
      // the value in an Optional.
      final var value = Optional.of(5);

      // Apply the function to our NPE safe Optional using flatMap().
      final var functionResult = value.flatMap(MathWithOptional::doubleNumber);

      // Check result - an Optional wrapping an Integer.
      assertEquals(Optional.of(10), functionResult);
   }

}

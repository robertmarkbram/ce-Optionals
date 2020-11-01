package org.rmb.math;

import org.junit.jupiter.api.Test;
import org.rmb.math.math.MathWithNull;
import org.rmb.math.math.Number;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>Testing {@link Stream#map(Function)} and {@link Stream#flatMap(Function)}. This
 * is me working my way through what I am learning from
 * <a href="https://www.baeldung.com/java-difference-map-and-flatmap">The Difference Between map() and flatMap()</a>
 *
 * @see <a href="https://www.baeldung.com/java-difference-map-and-flatmap">The Difference Between map() and
 *       flatMap()</a></p>
 */
class StreamMapTest {

   /**
    * <p>Applying a function to a {@link Stream} of values.</p>
    */
   @Test
   void streamMap() {
      // Stream values from a list.
      final var doubled = Number.listOfNumbersOneToNine()
            .stream()
            // Apply a function to each value.
            .map(MathWithNull::doubleNumber)
            // Collect the result in a list.
            .collect(Collectors.toList());

      // Result is a list of integers.
      assertEquals(List.of(2, 4, 6, 8, 10, 12, 14, 16, 18), doubled);
   }

   /**
    * <p>Applying a function to a {@link Stream} of <code>Stream</code> of values.</p>
    */
   @Test
   void streamFlapMap() {
      // Stream values from a list of lists.
      final var gridOfNumbersFlatMappedTolist = Number.gridOfNumbersThreeByThree()
            .stream()
            // Now I have a stream of elements where each element is a list. Replace each element list with a stream
            // of their own elements and combine all of them into one stream.
            .flatMap(Collection::stream)
            // Apply a function to each value.
            .map(MathWithNull::doubleNumber)
            // Collect the result in a list.
            .collect(Collectors.toList());

      // Result is a list of integers.
      assertEquals(List.of(2, 4, 6, 8, 10, 12, 14, 16, 18), gridOfNumbersFlatMappedTolist);
   }

}

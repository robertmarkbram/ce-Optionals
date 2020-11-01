package org.rmb;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalsTest {

   @Test
   public void optionalOf() {
      Optional<String> s = Optional.of("test");
      assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
   }

}

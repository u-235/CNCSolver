/*
 * Copyright 2022 © Nick Egorrov, nicegorov@yandex.ru
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package u235.g17.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ToleranceTest {

    /**
     * Test of Tolerance constructor.
     */
    @Test
    public void testTolerance() {
        boolean hasThrow = false;
        try {
            Tolerance t = new Tolerance(0.0, 0.000001);
        } catch (IllegalArgumentException e) {
            hasThrow = true;
        }
        assertTrue(hasThrow,
                "Expected IllegalArgumentException due linear is equal to zero");

        hasThrow = false;
        try {
            Tolerance t = new Tolerance(0.0001, 0.0);
        } catch (IllegalArgumentException e) {
            hasThrow = true;
        }
        assertTrue(hasThrow,
                "Expected IllegalArgumentException due angular is equal to zero");

        Tolerance tolerance = new Tolerance(0.0001, 0.000001);
        assertEquals(0.0001, tolerance.linear);
        assertEquals(0.000001, tolerance.angular);

        tolerance = new Tolerance(-0.0001, -0.000001);
        assertEquals(0.0001, tolerance.linear);
        assertEquals(0.000001, tolerance.angular);
    }

    /**
     * Test of isLinearAcceptable method, of class Tolerance.
     */
    @Test
    public void testIsLinearAcceptable() {
        Tolerance instance = DefaultTolerance.instance();
        double yes = instance.linear * 0.999999;
        double h_yes = yes * Math.sqrt(2) / 2;
        double no = instance.linear * 1.000001;
        double h_no = no * Math.sqrt(2) / 2;

        assertTrue(instance.isLinearAcceptable(0, yes));
        assertTrue(instance.isLinearAcceptable(0, -yes));
        assertTrue(instance.isLinearAcceptable(yes, 0));
        assertTrue(instance.isLinearAcceptable(-yes, 0));
        assertTrue(instance.isLinearAcceptable(h_yes, h_yes));

        assertFalse(instance.isLinearAcceptable(0, no));
        assertFalse(instance.isLinearAcceptable(0, -no));
        assertFalse(instance.isLinearAcceptable(no, 0));
        assertFalse(instance.isLinearAcceptable(-no, 0));
        assertFalse(instance.isLinearAcceptable(h_no, h_no));
    }

    /**
     * Test of isAngularAcceptable method, of class Tolerance.
     */
    @Test
    public void testIsAngularAcceptable() {
        Tolerance instance = DefaultTolerance.instance();
        double yes = instance.angular * 0.999999;
        double no = instance.angular * 1.000001;

        assertTrue(instance.isAngularAcceptable(yes));
        assertTrue(instance.isAngularAcceptable(-yes));

        assertFalse(instance.isAngularAcceptable(no));
        assertFalse(instance.isAngularAcceptable(-no));
    }
}

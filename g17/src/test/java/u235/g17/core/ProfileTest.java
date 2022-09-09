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
public class ProfileTest {

    /**
     * Test of getTolerance method, of class Profile.
     */
    @Test
    public void testGetTolerance() {
        Profile profile = new Profile();
        assertNotNull(profile.getTolerance());
    }

    /**
     * Test of setTolerance method, of class Profile.
     */
    @Test
    public void testSetTolerance() {
        Profile profile = new Profile();
        profile.setTolerance(null);
        assertNotNull(profile.getTolerance());

        Tolerance tolerance = new Tolerance(0.01, 0.0001);
        assertNotNull(tolerance, "Unable create new Tolerance.");
        profile.setTolerance(tolerance);
        assertEquals(tolerance, profile.getTolerance());
    }
}

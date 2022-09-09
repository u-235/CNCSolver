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
public class BaseTest {

    /**
     * Test of getProfile method, of class Base.
     */
    @Test
    public void testGetProfile() {
        Base instance = new Base(null);
        assertEquals(DefaultProfile.instance(), instance.getProfile());
        
        Profile profile = new Profile(new Tolerance(0.1, 0.001));
        instance.setProfile(profile);
        assertEquals(profile, instance.getProfile());
    }

    /**
     * Test of setProfile method, of class Base.
     */
    @Test
    public void testSetProfile() {
        Base instance = new Base(null);
        instance.setProfile(null);
        assertEquals(DefaultProfile.instance(), instance.getProfile());
    }
}
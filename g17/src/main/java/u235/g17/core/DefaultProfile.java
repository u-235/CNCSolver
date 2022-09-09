/*
 * Copyright 2022 © Nick Egorrov, nicegorov@yandex.ru.
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

/**
 * The class provides a default {@linkplain Profile profile}.
 */
public class DefaultProfile {

    private static final Profile defaultProfile = doDefaultProfile();

    private DefaultProfile() {
    }

    /**
     * Returns the default profile.
     *
     * @return The default profile. The return value is guaranteed not to be
     * <code>null</code>.
     */
    public static Profile instance() {
        return defaultProfile;
    }

    private static Profile doDefaultProfile() {
        return new Profile(DefaultTolerance.instance());
    }
}

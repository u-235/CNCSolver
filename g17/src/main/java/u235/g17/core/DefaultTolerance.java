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

/**
 * The class provides a default {@linkplain Tolerance tolerance}.
 */
public class DefaultTolerance {

    /**
     * Default linear dimension discreteness.
     */
    public static final double DEFAULT_LINEAR_DISCRETE = 0.001;
    /**
     * Default angular dimension discreteness.
     */
    public static final double DEFAULT_ANGULAR_DISCRETE = Math.PI / 180d * 0.0001;
    /**
     * Ratio of tolerance to discreteness.
     */
    public static final double TOLERANCE_TO_DISCRETE = 1d / 3d;
    private static final Tolerance defaultTolerance = doDefaultTolerance();

    private DefaultTolerance() {
    }

    /**
     * Returns the default tolerance.
     *
     * @return The default tolerance. The return value is guaranteed not to be
     * <code>null</code>.
     */
    public static Tolerance instance() {
        return defaultTolerance;
    }

    private static Tolerance doDefaultTolerance() {
        return new Tolerance(
                DEFAULT_LINEAR_DISCRETE * TOLERANCE_TO_DISCRETE,
                DEFAULT_ANGULAR_DISCRETE * TOLERANCE_TO_DISCRETE);
    }
}

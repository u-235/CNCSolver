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
 * A class with settings for calculations and transformations. Currently
 * contains tolerances. Unlike most classes of the package, this one is mutable.
 */
public class Profile {

    private Tolerance tolerance;

    /**
     * Creates a profile with the specified tolerance.
     *
     * @param tolerance the tolerance. If <code>null</code> is specified, the
     * {@linkplain DefaultTolerance#instance() default tolerance} will be used.
     */
    public Profile(Tolerance tolerance) {
        realSetTolerance(tolerance);
    }

    /**
     * Creates a profile with the {@linkplain DefaultTolerance#instance()
     * default tolerance}.
     */
    public Profile() {
        this(null);
    }

    /**
     * Returns the tolerance.
     *
     * @return The tolerance. The return value is guaranteed not to be
     * <code>null</code>.
     */
    public Tolerance getTolerance() {
        return tolerance;
    }

    private void realSetTolerance(Tolerance tolerance) {
        if (tolerance != null) {
            this.tolerance = tolerance;
        } else {
            this.tolerance = DefaultTolerance.instance();
        }
    }

    /**
     * Sets the tolerance.
     *
     * @param tolerance the tolerance to set. If <code>null</code> is specified,
     * the {@linkplain DefaultTolerance#instance() default tolerance} will be
     * used.
     */
    public void setTolerance(Tolerance tolerance) {
        realSetTolerance(tolerance);
    }
}

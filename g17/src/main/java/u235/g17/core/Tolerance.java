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
 * A class for representing the tolerance of deviations of linear and angular
 * dimensions. The {@link #isLinearAcceptable(double, double)} and
 * {@link #isAngularAcceptable(double)} methods must be used to determine if
 * deviations are acceptable.
 */
public class Tolerance {

    /**
     * Acceptable error of linear dimensions. Always positive non-zero value.
     */
    public final double linear;
    /**
     * Acceptable error of angular dimensions. Always positive non-zero value.
     */
    public final double angular;

    /**
     * Creates an object with the specified tolerances. The value of tolerance
     * must not be zero.
     *
     * @param linear acceptable error of linear dimensions.
     * @param angular acceptable error of angular dimensions.
     *
     * @throws IllegalArgumentException if any parameter is zero.
     */
    public Tolerance(double linear, double angular) {
        if (linear == 0 || angular == 0) {
            throw new IllegalArgumentException();
        }

        this.linear = Math.abs(linear);
        this.angular = Math.abs(angular);
    }

    /**
     * Checks the acceptability of the specified deviation of the linear
     * dimension. The deviation is calculated as the hypotenuse of a triangle
     * with specified catheters.
     *
     * @param deltaX projection of the deviation onto the X-axis.
     * @param deltaY projection of the deviation onto the Y-axis.
     * @return If the deviation is within tolerance, the method returns
     * <code>true</code>.
     */
    public boolean isLinearAcceptable(double deltaX, double deltaY) {
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY) <= linear;
    }

    /**
     * Checks the acceptability of the specified deviation of the angular
     * dimension.
     *
     * @param angle angular deviation.
     * @return If the deviation is within tolerance, the method returns
     * <code>true</code>.
     */
    public boolean isAngularAcceptable(double angle) {
        return Math.abs(angle) <= angular;
    }
}

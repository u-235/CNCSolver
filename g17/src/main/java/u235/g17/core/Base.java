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
 * A base class for entities that need some kind of setting for comparisons
 * or transformations.
 * 
 * @see Match
 * @see Tolerance
 */
public class Base {

    private Profile profile;

    /**
     * Creates a object with the specified profile.
     * 
     * @param profile the profile. If <code>null</code> is specified, the
     * {@linkplain DefaultProfile#instance() default profile} will be used.
     */
    public Base(Profile profile) {
        realSetProfile(profile);
    }

    /**
     * Returns the profile.
     * 
     * @return The profile. The return value is guaranteed not to be
     * <code>null</code>.
     */
    public final Profile getProfile() {
        return profile;
    }

    private void realSetProfile(Profile profile) {
        if (profile != null) {
            this.profile = profile;
        } else {
            this.profile = DefaultProfile.instance();
        }
    }

    /**
     * Sets the profile.
     * 
     * @param profile the profile to set. If <code>null</code> is specified,
     * the {@linkplain DefaultProfile#instance() default profile} will be used.
     * 
     * @see Base(profile)
     */
    public void setProfile(Profile profile) {
        realSetProfile(profile);
    }

    /**
     * Returns the tolerance that is set in the current profile.
     *
     * @return The tolerance. The return value is guaranteed not to be
     * <code>null</code>.
     * 
     * @see setProfile(Profile)
     */
    public Tolerance tolerance() {
        return getProfile().getTolerance();
    }
}

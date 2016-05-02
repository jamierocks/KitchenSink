/*
 * This file is part of KitchenSink, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016, Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.jamierocks.kitchensink

/**
 * The KitchenSink extension.
 */
class KitchenSinkExtension {

    /**
     * By setting this to {@code true}, KitchenSink will setup your IDE for SpongeVanilla.
     *
     * You may have more than one flavour running at once.
     */
    boolean vanilla = false

    /**
     * This setting sets the version of SpongeVanilla that will be obtained.
     */
    String vanillaVersion

    /**
     * This setting allows you to specify where SpongeVanilla will be placed.
     */
    String vanillaDir = "run/vanilla"

    /**
     * By setting this to {@code true}, KitchenSink will setup your IDE for SpongeForge.
     *
     * You may have more than one flavour running at once.
     */
    boolean forge = false

    /**
     * This setting allows you to specify where SpongeForge will be placed.
     */
    String forgeDir = "run/forge"

}

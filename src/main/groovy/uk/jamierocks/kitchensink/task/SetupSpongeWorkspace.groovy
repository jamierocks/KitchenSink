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

package uk.jamierocks.kitchensink.task

import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import uk.jamierocks.kitchensink.KitchenSinkExtension
import uk.jamierocks.kitchensink.util.Constants

/**
 * This task ensures of the existence of the run
 * directories specified in {@link KitchenSinkExtension}.
 *
 * This task will also download all the enabled flavours
 * of Sponge specified in {@link KitchenSinkExtension}.
 */
class SetupSpongeWorkspace extends DefaultTask {

    KitchenSinkExtension kitchenSinkExtension

    @TaskAction
    void doTask() {
        // Checks if Vanilla is enabled
        if (this.kitchenSinkExtension.vanilla) {
            // creates its directory if it doesn't already exist
            if (!this.kitchenSinkExtension.vanillaDir.exists()) {
                this.kitchenSinkExtension.vanillaDir.mkdirs()
            }

            File outputJar = new File(this.kitchenSinkExtension.vanillaDir,
                    "spongevanilla-" + this.kitchenSinkExtension.vanillaVersion + ".jar")

            if (!outputJar.exists()) {
                URL jarUrl = new URL(Constants.SPONGE_REPO + "org/spongepowered/spongevanilla/" +
                        this.kitchenSinkExtension.vanillaVersion + "/spongevanilla-" +
                        this.kitchenSinkExtension.vanillaVersion + ".jar")

                FileUtils.copyURLToFile(jarUrl, outputJar)
            }
        }

        // Checks if Forge is enabled
        if (this.kitchenSinkExtension.forge) {
            // creates its directory if it doesn't already exist
            if (!this.kitchenSinkExtension.forgeDir.exists()) {
                this.kitchenSinkExtension.forgeDir.mkdirs()
            }

            // TODO: download SpongeForge
        }
    }

}

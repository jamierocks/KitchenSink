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

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import uk.jamierocks.kitchensink.KitchenSinkExtension
import uk.jamierocks.kitchensink.KitchenSinkPlugin

import java.nio.charset.Charset

/**
 * This task will create run configurations for IntelliJ.
 */
class GenIntellijTasksTask extends DefaultTask {

    KitchenSinkExtension kitchenSinkExtension

    @TaskAction
    void doTask() {
        // Check runConfigurations directory exists
        File runConfigurations = new File(".idea", "runConfigurations")
        if (!runConfigurations.exists()) {
            runConfigurations.mkdirs()
        }

        // SpongeVanilla
        if (this.kitchenSinkExtension.vanilla) {
            StringBuilder builder = new StringBuilder()

            InputStreamReader reader =
                    new InputStreamReader(KitchenSinkPlugin.getClassLoader().getResourceAsStream("ideaTemplate.xml"))

            for (String line : reader.readLines()) {
                builder.append(line
                        .replace("{{ flavour }}", "SpongeVanilla")
                        .replace("{{ version }}", this.kitchenSinkExtension.vanillaVersion)
                        .replace("{{ dir }}", this.kitchenSinkExtension.vanillaDir)
                        .replace("{{ jar }}", "spongevanilla-" + this.kitchenSinkExtension.vanillaVersion + ".jar"))
                builder.append("\n")
            }

            reader.close()

            new File(runConfigurations, "SpongeVanilla.xml").newOutputStream().withStream {
                s -> s.write(builder.toString().getBytes(Charset.forName("utf-8")))
            }
        }
    }

}

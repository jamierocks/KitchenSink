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

import org.gradle.api.Plugin
import org.gradle.api.Project
import uk.jamierocks.kitchensink.task.GenIntellijTasksTask
import uk.jamierocks.kitchensink.task.SetupSpongeWorkspace
import uk.jamierocks.kitchensink.util.Constants
/**
 * The Gradle plugin.
 */
class KitchenSinkPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // Add LaunchTool to dependencies
        File kitchenSinkDir = new File("build", "kitchensink")
        File launchTool = new File(kitchenSinkDir, "LaunchTool-" + Constants.VERSION + ".jar")

        if (launchTool.exists()) {
            project.dependencies {
                compile project.files(launchTool)
            }
        }

        project.with {
            KitchenSinkExtension extension = extensions.create('kitchensink', KitchenSinkExtension)

            task('setupSpongeWorkspace', type: SetupSpongeWorkspace)
            task('genIntellijTasks', type: GenIntellijTasksTask)

            afterEvaluate {
                tasks.setupSpongeWorkspace.with {
                    kitchenSinkExtension = extension
                }
                tasks.genIntellijTasks.with {
                    kitchenSinkExtension = extension
                }
            }
        }
    }

}

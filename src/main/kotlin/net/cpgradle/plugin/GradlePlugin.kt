package net.cpgradle.plugin

import net.cpgradle.ext.PluginExtension
import net.cpgradle.log.SignatureBuilder
import net.cpgradle.tasks.ApplySpecialSourceTask
import net.cpgradle.tasks.CheckDestinationTask
import net.cpgradle.tasks.DownloadMappingTask
import net.cpgradle.tasks.DownloadTargetJarTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * The actual implementation of the plugin's core.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class GradlePlugin : Plugin<Project> {
    override fun apply(project: Project?) {
        project?.afterEvaluate {
            // "#################################################"
            // "                 CoderPackGradle                 "
            // "    Created by PizzaCrust, licensed under GPL    "
            // "#################################################"
            // main: 17 characters
            // sub: 4 characters
            SignatureBuilder()
                    .border(SignatureBuilder.Border.HASH)
                    .main("CoderPackGradle")
                    .mainSpaces(17)
                    .subtitle("Created by PizzaCrust, licensed under GPL")
                    .subSpaces(4)
                    .log()
        }
        project?.extensions?.add("coderpack", PluginExtension::class.java)
        project?.tasks?.create("checkDest", CheckDestinationTask::class.java)
        project?.tasks?.create("downloadJar", DownloadTargetJarTask::class.java)
        project?.tasks?.create("downloadMappings", DownloadMappingTask::class.java)
        project?.tasks?.create("applySpecialSource", ApplySpecialSourceTask::class.java)
    }
}
package net.cpgradle.plugin

import net.cpgradle.ext.PluginExtension
import net.cpgradle.log.SignatureBuilder
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * The actual implementation of the plugin's core.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class GradlePlugin : Plugin<Project> {
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
        project?.extensions?.add("cpg", PluginExtension::class.java)
    }
}
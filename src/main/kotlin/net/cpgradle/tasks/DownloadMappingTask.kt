package net.cpgradle.tasks

import net.cpgradle.ext.Downloader
import net.cpgradle.ext.PluginExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * The task that download mappings from the plugin extension provided.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class DownloadMappingTask : DefaultTask() {
    init {
        this.group = "coderpack"
        this.dependsOn("downloadJar")
    }

    @TaskAction fun doTask() {
        val ext: PluginExtension = project.extensions.getByType(PluginExtension::class.java)
        val outputFile: java.io.File = File(CheckDestinationTask.destination, "jar.srg")
        Downloader(outputFile, ext.mappingLink!!)
    }
}
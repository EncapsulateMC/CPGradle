package net.cpgradle.tasks

import net.cpgradle.ext.Downloader
import net.cpgradle.ext.PluginExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.ReadableByteChannel

/**
 * The task that downloads a target JAR from the one specified from the extension.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class DownloadTargetJar : DefaultTask() {
    init {
        this.group = "coderpack"
        this.dependsOn("checkDest")
    }

    @TaskAction fun doTask() {
        val ext: PluginExtension = project.extensions.getByType(PluginExtension::class.java)
        val outputFile: java.io.File = File(CheckDestinationTask.destination, "target.jar")
        Downloader(outputFile, ext.targetJarLink)
    }
}
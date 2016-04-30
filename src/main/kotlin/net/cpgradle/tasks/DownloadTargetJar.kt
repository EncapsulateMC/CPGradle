package net.cpgradle.tasks

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
        val theURL: URL = URL(ext.mappingLink)
        val rbc: ReadableByteChannel = Channels.newChannel(theURL.openStream())
        val outputFile: java.io.File = File(CheckDestinationTask.destination, "target.jar")
        val outputStream: FileOutputStream = FileOutputStream(outputFile)
        outputStream.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
    }
}
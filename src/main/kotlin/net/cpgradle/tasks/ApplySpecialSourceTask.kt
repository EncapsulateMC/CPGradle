package net.cpgradle.tasks

import net.cpgradle.ext.PluginExtension
import net.md_5.specialsource.SpecialSource
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * The task that applies the SRG mappings to the target JAR.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class ApplySpecialSourceTask : DefaultTask() {
    init {
        this.group = "coderpack"
        this.dependsOn("downloadMappings")
    }

    @TaskAction fun doTask() {
        val ext: PluginExtension = project.extensions.getByType(PluginExtension::class.java)
        val finalJar: File = File(CheckDestinationTask.destination, ext.jarName)
        SpecialSource.main(
                arrayOf("--quiet",
                        "--srg-in",
                        DownloadMappingTask.outFile.absolutePath,
                        "--in-jar",
                        DownloadTargetJarTask.outFile.absolutePath,
                        "--out-jar",
                        finalJar.absolutePath)
        )
    }
}
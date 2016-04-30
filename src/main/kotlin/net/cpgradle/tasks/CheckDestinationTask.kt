package net.cpgradle.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.FileNotFoundException

/**
 * The tasks that checks the destination.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class CheckDestinationTask : DefaultTask() {
    companion object StaticFields {
        val destination: java.io.File = File(System.getProperty("user.dir"), "libs")
    }

    init {
        this.group = "coderpack"
    }

    @TaskAction fun doTask() {
        if (CheckDestinationTask.destination.exists()) {
            delete(CheckDestinationTask.destination)
        }
        if (!CheckDestinationTask.destination.exists()) {
            CheckDestinationTask.destination.mkdir()
        }
    }

    fun delete(file: File) {
        if (file.isDirectory()) {
            for (c in file.listFiles()) {
                delete(c);
            }
        }
        if (!file.delete())
            throw FileNotFoundException("Failed to delete file: " + file);
    }
}
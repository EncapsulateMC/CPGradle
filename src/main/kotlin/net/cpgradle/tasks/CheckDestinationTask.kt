package net.cpgradle.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * The tasks that checks the destination.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class CheckDestinationTask : DefaultTask() {
    companion object StaticFields {
        val destination: java.io.File = File(System.getProperty("user.dir"), "libs")
    }

    @TaskAction fun doTask() {
        if (!CheckDestinationTask.destination.exists()) {
            CheckDestinationTask.destination.mkdir()
        }
    }
}
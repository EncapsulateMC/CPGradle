package net.cpgradle.ext

/**
 * Allows providing information to the plugin to make this plugin more dynamic.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class PluginExtension(mappingURL: String, targetJarUrl: String, finalJarName: String) {
    var mappingLink: String
    var targetJarLink: String
    var jarName: String

    init {
        this.mappingLink = mappingURL
        this.targetJarLink = targetJarUrl
        this.jarName = finalJarName
    }
}
package net.cpgradle.ext

/**
 * Allows providing information to the plugin to make this plugin more dynamic.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class PluginExtension {
    var mappingLink: String? = null
    var targetJarLink: String? = null
    var jarName: String? = null
}
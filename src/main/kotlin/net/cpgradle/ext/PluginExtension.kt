package net.cpgradle.ext

/**
 * Allows providing information to the plugin to make this plugin more dynamic.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class PluginExtension {
    var mapping: String? = null
    var targetJar: String? = null
    var jarName: String? = null
}
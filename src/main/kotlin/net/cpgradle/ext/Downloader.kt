package net.cpgradle.ext

import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.ReadableByteChannel

/**
 * Downloads a file.
 *
 * @subce 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class Downloader(outputFile: File, url: String) {
    init {
        val theURL: URL = URL(url)
        val rbc: ReadableByteChannel = Channels.newChannel(theURL.openStream())
        val outputStream: FileOutputStream = FileOutputStream(outputFile)
        outputStream.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
    }
}
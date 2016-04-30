package net.cpgradle.log

/**
 * A signature builder for logging.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class SignatureBuilder {

    /**
     * Testing module.
     */
    companion object Test {
        @JvmStatic fun main(args: Array<String>) {
            SignatureBuilder()
                    .border(Border.EQUALS)
                    .main("Test Signature")
                    .mainSpaces(0)
                    .subtitle("Woo! It works!")
                    .subSpaces(0)
                    .log()
            println("Gradle Plugin Signature")
            SignatureBuilder()
                    .border(SignatureBuilder.Border.HASH)
                    .main("CoderPackGradle")
                    .mainSpaces(17)
                    .subtitle("Created by PizzaCrust, licensed under GPL")
                    .subSpaces(4)
                    .log()
        }
    }

    /**
     * Represents the borders compatible with the builder.
     */
    enum class Border(coreValue: String) {
        HASH("#"),
        DASH("-"),
        EQUALS("=");

        private val value: String

        init {
            this.value = coreValue
        }

        fun getCoreValue() : String {
            return value
        }
    }

    /**
     * Core signature values.
     */
    private var borderType : Border? = null
    private var signatureMain : String? = null
    private var signatureSub : String? = null
    private var mainSpaces : Int? = null
    private var subSpaces : Int? = null

    /**
     * Sets the border enum.
     */
    fun border(enumType : Border) : SignatureBuilder {
        this.borderType = enumType
        return this
    }

    /**
     * Retrieves the border's enum.
     */
    fun border() : Border? {
        return borderType
    }

    /**
     * Retrieves the main value of the signature.
     */
    fun main() : String? {
        return signatureMain
    }

    /**
     * Sets the main value of the signature.
     */
    fun main(string: String) : SignatureBuilder {
        this.signatureMain = string
        return this
    }

    /**
     * Sets the secondary value of the signature.
     */
    fun subtitle(string: String) : SignatureBuilder {
        this.signatureSub = string
        return this
    }

    /**
     * Retrieves the secondary value of the signature.
     */
    fun subtitle() : String? {
        return signatureSub
    }

    /**
     * Sets the amount of sub spaces.
     */
    fun subSpaces(space: Int) : SignatureBuilder {
        this.subSpaces = space
        return this
    }

    /**
     * Sets the amount of main spaces.
     */
    fun mainSpaces(space: Int) : SignatureBuilder {
        this.mainSpaces = space
        return this
    }

    /**
     * Retrieves the amount of main spaces.
     */
    fun mainSpaces() : Int? {
        return mainSpaces
    }

    /**
     * Retrieves the amount of sub spaces.
     */
    fun subSpaces() : Int? {
        return subSpaces
    }

    /**
     * Builds and logs to the console.
     */
    fun log() {
        val borderCount = 49
        var currentBorderIndex = 0
        val upperBorderBuilder = StringBuilder()
        while (currentBorderIndex != borderCount) {
            upperBorderBuilder.append(border()?.getCoreValue())
            currentBorderIndex++
        }
        currentBorderIndex = 0
        val downBorderBuilder = StringBuilder()
        while (currentBorderIndex != borderCount) {
            downBorderBuilder.append(border()?.getCoreValue())
            currentBorderIndex++
        }
        currentBorderIndex = 0
        val mspaceBuilder = StringBuilder()
        while (currentBorderIndex != mainSpaces()) {
            mspaceBuilder.append(" ")
            currentBorderIndex++
        }
        currentBorderIndex = 0
        val sspaceBuilder = StringBuilder()
        while (currentBorderIndex != subSpaces()) {
            sspaceBuilder.append(" ")
            currentBorderIndex++
        }
        println(upperBorderBuilder.toString())
        println("${mspaceBuilder.toString()}${main()}${mspaceBuilder.toString()}")
        println("${sspaceBuilder.toString()}${subtitle()}${sspaceBuilder.toString()}")
        println(downBorderBuilder.toString())
    }
}
package kloudfunktions.misc

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * The [Os] module provides a number of operating system-related utility methods.
 * [Node.js Doc](https://nodejs.org/api/os.html).
 */
@JsModule("os")
@JsNonModule
external object Os {
    /**
     * The [Os.tmpdir] method returns a string specifying the operating system's default directory for temporary files.
     * @return [String]
     */
    fun tmpdir() : String
}
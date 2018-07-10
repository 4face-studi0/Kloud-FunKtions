package kloudfunktions.misc

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * The [Path] module provides utilities for working with file and directory paths.
 * [Node.js Doc](https://nodejs.org/api/path.htm).
 */
@JsModule("path")
@JsNonModule
external object Path {
    /**
     * The [Path.join] method joins all given path segments together using the platform specific separator as a
     * delimiter, then normalizes the resulting path.
     * Zero-length path segments are ignored. If the joined path string is a zero-length string then '.'
     * will be returned, representing the current working directory.
     * @param path A sequence of path segments.
     * @return [String]
     *
     * **JS Example**
     *      > path.join('/foo', 'bar', 'baz/asdf', 'quux', '..');
     *      // Returns: '/foo/bar/baz/asdf'
     */
    fun join( vararg path: String ) : String
}
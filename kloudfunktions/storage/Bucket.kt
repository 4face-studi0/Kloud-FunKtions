package kloudfunktions.kloudfunktions.storage

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 *
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/storage/1.7.x/Bucket).
 */
external class Bucket {

    /**
     * The bucket's name.
     */
    val name: String

    /**
     * Create a [File] object.
     * @see File to see how to handle the different use cases you may have.
     * @param name The name of the file in this bucket.
     */
    fun file( name: String, options: FileOptions ) : File

}
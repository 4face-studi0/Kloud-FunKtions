package kloudfunktions.kloudfunktions.storage

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * Namespace for Google Cloud Storage functions.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.storage).
 */
external interface StorageNamespace {
    /**
     * Registers a Cloud Function scoped to a specific storage bucket.
     * @param bucket Name of the bucket to which this Cloud Function is scoped.
     * @return Storage [BucketBuilder] interface.
     */
    fun bucket( bucket: String ) : BucketBuilder

    /**
     * Registers a Cloud Function scoped to the default storage bucket for the project.
     * @return Storage [ObjectBuilder] interface.
     */
    fun `object`() : ObjectBuilder
}
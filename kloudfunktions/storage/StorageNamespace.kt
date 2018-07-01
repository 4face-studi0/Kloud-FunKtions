package kloudfunktions.kloudfunktions.storage

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * Namespace for Google Cloud Storage functions.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.storage).
 */
external interface StorageNamespace {
    /**
     * Registers a Cloud Function scoped to a specific storage bucket.
     */
    fun bucket()
}
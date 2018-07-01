package kloudfunktions.kloudfunktions.storage

import kloudfunktions.kloudfunktions.Functions
import kotlin.js.Promise

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * The Google Cloud Storage object builder interface.
 * Access via [Functions.storage] [StorageNamespace.object].
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.storage.ObjectBuilder).
 */
external interface ObjectBuilder {
    /**
     * Event handler sent only when a bucket has enabled object versioning. This event indicates that the
     * live version of an object has become an archived version, either because it was archived or because it
     * was overwritten by the upload of an object of the same name.
     */
    fun onArchive() : Promise<Any>

}
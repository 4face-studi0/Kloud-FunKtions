package kloudfunktions.kloudfunktions.storage

import kloudfunktions.kloudfunktions.Functions

/**
 * @author 4face (Davide Giuseppe Farella).
 * The Google Cloud Storage bucket builder interface.
 * Access via [Functions.storage] [StorageNamespace.bucket].
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.storage.BucketBuilder).
 */
external interface BucketBuilder {
    /**
     * Event handler which fires every time a Google Cloud Storage change occurs.
     * @return Storage [ObjectBuilder] interface scoped to the specified storage bucket.
     */
    fun `object`() : ObjectBuilder
}
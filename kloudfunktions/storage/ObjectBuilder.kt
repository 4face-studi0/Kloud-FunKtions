@file:Suppress("unused")

package kloudfunktions.kloudfunktions.storage

import kloudfunktions.kloudfunktions.CloudFunction
import kloudfunktions.kloudfunktions.EventContext
import kloudfunktions.kloudfunktions.Functions
import kotlin.js.Promise

/**
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
     * @param handler Event handler which is run every time a Google Cloud Storage archival occurs.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onArchive( handler: (ObjectMetadata, EventContext) -> Promise<Any> ) : CloudFunction

    /**
     * Event handler which fires every time a Google Cloud Storage deletion occurs.
     * Sent when an object has been permanently deleted. This includes objects that are overwritten or are deleted
     * as part of the bucket's lifecycle configuration. For buckets with object versioning enabled, this is not
     * sent when an object is archived, even if archival occurs via the TODO storage.objects.delete method.
     * @param handler Event handler which is run every time a Google Cloud Storage deletion occurs.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onDelete( handler: (ObjectMetadata, EventContext) -> Promise<Any> ) : CloudFunction

    /**
     * Event handler which fires every time a Google Cloud Storage object creation occurs.
     * Sent when a new object (or a new generation of an existing object) is successfully created in the bucket.
     * This includes copying or rewriting an existing object. A failed upload does not trigger this event.
     * @param handler Event handler which is run every time a Google Cloud Storage object creation occurs.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onFinalize( handler: (ObjectMetadata, EventContext) -> Promise<Any> ) : CloudFunction

    /**
     * Event handler which fires every time the metadata of an existing object changes.
     * @param handler Event handler which is run every time a Google Cloud Storage metadata update occurs.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onMetadataUpdate( handler: (ObjectMetadata, EventContext) -> Promise<Any> ) : CloudFunction

}
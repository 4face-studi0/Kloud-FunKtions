@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

import kloudfunktions.kloudfunktions.CloudFunction
import kloudfunktions.kloudfunktions.EventContext
import kloudfunktions.kloudfunktions.Functions
import kotlin.js.Promise

/**
 * @author 4face (Davide Giuseppe Farella).
 * The Cloud Firestore document builder interface.
 * Access via [Functions.firestore] -> [Firestore.document].
 */
external interface DocumentBuilder {
    /**
     * Event handler that fires every time new data is created in Cloud Firestore.
     * @param handler function(non-null [DocumentSnapshot], optional non-null [EventContext])
     * Event handler which is run every time new data is created in Cloud Firestore.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onCreate( handler: (DocumentSnapshot, EventContext) -> Promise<Any> )

    /**
     * Event handler that fires every time new data is deleted in Cloud Firestore.
     * @param handler function(non-null [DocumentSnapshot], optional non-null [EventContext])
     * Event handler which is run every time new data is deleted in Cloud Firestore.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onDelete( handler: (DocumentSnapshot, EventContext) -> Promise<Any> )

    /**
     * Event handler that fires every time new data is updated in Cloud Firestore.
     * @param handler function(non-null [DocumentSnapshot], optional non-null [EventContext])
     * Event handler which is run every time new data is updated in Cloud Firestore.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onUpdate( handler: (Change, EventContext) -> Promise<Any> )

    /**
     * Event handler that fires every time a Cloud Firestore write of any kind (creation, update, or delete) occurs.
     * @param handler function(non-null [DocumentSnapshot], optional non-null [EventContext])
     * Event handler which is run every time a Cloud Firestore write occurs.
     * Value must not be null.
     * @return A [CloudFunction] which you can export and deploy.
     */
    fun onWrite( handler: (Change, EventContext) -> Promise<Any> )
}
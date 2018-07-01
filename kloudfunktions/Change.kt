@file:Suppress("unused")

package kloudfunktions.kloudfunktions

import kloudfunktions.kloudfunktions.firestore.DocumentBuilder
import kloudfunktions.kloudfunktions.firestore.QueryDocumentSnapshot

/**
 * @author 4face (Davide Giuseppe Farella).
 * The Functions interface for events that change state, such as Realtime Database or Cloud FirestoreNamespace
 * [DocumentBuilder.onWrite] and [DocumentBuilder.onUpdate].
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.Change).
 */
external interface Change {
    /**
     * Represents the state after the event.
     */
    val after: QueryDocumentSnapshot

    /**
     * Represents the state prior to the event.
     */
    val before: QueryDocumentSnapshot
}
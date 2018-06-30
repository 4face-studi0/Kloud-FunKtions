@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

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
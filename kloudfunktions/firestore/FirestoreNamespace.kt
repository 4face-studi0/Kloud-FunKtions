package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 * Namespace for Cloud FirestoreNamespace Functions.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.firestore).
 */
external interface FirestoreNamespace {
    /**
     * Registers a function that triggers on Cloud FirestoreNamespace write events.
     * @param document The document within the database to watch for write events.
     * @return [DocumentBuilder] Cloud FirestoreNamespace builder interface.
     */
    fun document( document: String ): DocumentBuilder
}
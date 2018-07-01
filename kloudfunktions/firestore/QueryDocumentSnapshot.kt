package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 * A QueryDocumentSnapshot contains data read from a document in your Firestore database as part of a query.
 * The document is guaranteed to exist and its data can be extracted with [data] or [get] to get a specific field.
 * A [QueryDocumentSnapshot] offers the same API surface as a [DocumentSnapshot]. Since query results contain
 * only existing documents, the [exists] property will always be true and [data] will never return 'undefined'.
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/QueryDocumentSnapshot).
 */
external class QueryDocumentSnapshot : DocumentSnapshot
package kloudfunktions.kloudfunktions.firestore

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * The Firestore client represents a Firestore Database and is the entry point for all Firestore operations.
 * [Google Dco](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/Firestore).
 */
external class Firestore {
    /**
     * Gets a [CollectionReference] instance that refers to the collection at the specified path.
     * @param collectionPath A slash-separated path to a collection.
     * @return the [CollectionReference] instance.
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('collection');
     *      // Add a document with an auto-generated ID.
     *      collectionRef.add({foo: 'bar'}).then((documentRef) => {
     *          console.log(`Added document at ${documentRef.path})`);
     *      });
     */
    fun collection( collectionPath: String ): CollectionReference

    /**
     * Gets a [DocumentReference] instance that refers to the document at the specified path.
     * @param documentPath A slash-separated path to a document.
     * @return the [DocumentReference] instance.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('collection/document');
     *      console.log(`Path of document is ${documentRef.path}`);
     */
    fun doc( documentPath: String ): DocumentReference
}
package kloudfunktions.kloudfunktions.firestore

import kotlin.js.Promise

/**
 * @author 4face (Davide Giuseppe Farella).
 * A DocumentReference refers to a document location in a Firestore database and can be used to write, read,
 * or listen to the location. The document at the referenced location may or may not exist.
 * A DocumentReference can also be used to create a [CollectionReference] to a subcollection.
 */
external class DocumentReference {
    /**
     * The [Firestore] instance for the Firestore database (useful for performing transactions, etc.).
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.add({foo: 'bar'}).then(documentReference => {
     *          let firestore = documentReference.firestore;
     *          console.log(`Root location for document is ${firestore.formattedName}`);
     *      });
     */
    val firestore: Firestore

    /**
     * Writes to the document referred to by this DocumentReference. If the document does not yet exist, it will
     * be created. If you pass [SetOptions], the provided data can be merged into an existing document.
     * @param data A map of the fields and values for the document.
     * @param options An object to configure the set behavior.
     * @see [SetOptions].
     * @return A [Promise] containing [WriteResult] that resolves with the write time of this set.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.set({foo: 'bar'}).then(res => {
     *          console.log(`Document written at ${res.updateTime}`);
     *      });
     */
    fun set( data: dynamic, options: SetOptions? = definedExternally ) : Promise<WriteResult>
}
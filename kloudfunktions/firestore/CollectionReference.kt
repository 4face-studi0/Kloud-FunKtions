@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

import kotlin.js.Promise

/**
 * @author 4face (Davide Giuseppe Farella).
 * A CollectionReference object can be used for adding documents, getting document references, and querying for
 * documents (using the methods inherited from
 * [Query](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/Query.html)).
 */
external class CollectionReference : Query {

    /**
     * The last path element of the referenced collection.
     *
     * **Example**
     *      > let collectionRef = firestore.collection('col/doc/subcollection');
     *      console.log(`ID of the subcollection: ${collectionRef.id}`);
     */
    val id: String

    /**
     * A reference to the containing Document if this is a subcollection, else null.
     *
     * **Example**
     *      > let collectionRef = firestore.collection('col/doc/subcollection');
     *      let documentRef = collectionRef.parent;
     *      console.log(`Parent name: ${documentRef.path}`);
     */
    val parent: DocumentReference

    /**
     * A string representing the path of the referenced collection (relative to the root of the database).
     *
     * **Example**
     *      > let collectionRef = firestore.collection('col/doc/subcollection');
     *      console.log(`Path of the subcollection: ${collectionRef.path}`);
     */
    val path: String

    /**
     * Add a new document to this collection with the specified data, assigning it a document ID automatically.
     * @param data An Object containing the data for the new document.
     * [DocumentData](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/global.html#DocumentData)
     * @return a [Promise] containing [DocumentReference] pointing to the newly created document.
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.add({foo: 'bar'}).then(documentReference => {
     *          console.log(`Added document with name: ${documentReference.id}`);
     *      });
     */
    fun add( data: dynamic /*DocumentData*/ )

    /**
     * Gets a [DocumentReference] instance that refers to the document at the specified path. If no path is
     * specified, an automatically-generated unique ID will be used for the returned DocumentReference.
     * @param documentPath A slash-separated path to a document.
     * @return The [DocumentReference] instance.
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      let documentRefWithName = collectionRef.doc('doc');
     *      let documentRefWithAutoId = collectionRef.doc();
     *      console.log(`Reference with name: ${documentRefWithName.path}`);
     *      console.log(`Reference with auto-id: ${documentRefWithAutoId.path}`);
     */
    fun doc( documentPath: String? = definedExternally ): DocumentReference

}
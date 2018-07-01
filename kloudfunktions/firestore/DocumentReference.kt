@file:Suppress("unused", "DEPRECATION")

package kloudfunktions.kloudfunktions.firestore

import kloudfunktions.toJson
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
     * The last path element of the referenced document.
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.add({foo: 'bar'}).then(documentReference => {
     *          console.log(`Added document with name '${documentReference.id}'`);
     *      });
     */
    val id: String

    /**
     * A reference to the collection to which this DocumentReference belongs.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      let collectionRef = documentRef.parent;
     *      collectionRef.where('foo', '==', 'bar').get().then(results => {
     *          console.log(`Found ${results.size} matches in parent collection`);
     *      }):
     */
    val parent: CollectionReference

    /**
     * A string representing the path of the referenced document (relative to the root of the database).
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.add({foo: 'bar'}).then(documentReference => {
     *          console.log(`Added document at '${documentReference.path}'`);
     *      });
     */
    val path: String

    /**
     * Gets a [CollectionReference] instance that refers to the collection at the specified path.
     * @param collectionPath A slash-separated path to a collection.
     * @return [CollectionReference] A reference to the new subcollection.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      let subcollection = documentRef.collection('subcollection');
     *      console.log(`Path to subcollection: ${subcollection.path}`);
     */
    fun collection( collectionPath: String ) : CollectionReference

    /**
     * Create a document with the provided object values. This will fail the write if a document exists
     * at its location.
     * @see DocumentReference.createMap extension function for create a [Map].
     * @see DocumentReference.createModel extension function for create a custom model.
     * @param data An object that contains the fields and data to serialize as the document.
     * @return A [Promise] containing [WriteResult] that resolves with the write time of this create.
     *
     * **JS Example**
     *      > let documentRef = firestore.collection('col').doc();
     *      documentRef.create({foo: 'bar'}).then((res) => {
     *          console.log(`Document created at ${res.updateTime}`);
     *      }).catch((err) => {
     *          console.log(`Failed to create document: ${err}`);
     *      });
     */
    @Deprecated("Use the extension function", ReplaceWith("createMap / createModel") )
    internal fun create( data: dynamic ) : Promise<WriteResult>

    /**
     * Deletes the document referred to by this [DocumentReference].
     * A delete for a non-existing document is treated as a success (unless lastUpdateTime is provided).
     * @param precondition A precondition to enforce for this delete.
     * Values in precondition have the following properties:
     * * lastUpdateTime
     * Optional string
     * If set, enforces that the document was last updated at lastUpdateTime (as ISO 8601 string). Fails the
     * delete if the document was last updated at a different time.
     * @return A [Promise] containing [WriteResult] that resolves with the delete time.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.delete().then(() => {
     *          console.log('Document successfully deleted.');
     *      });
     */
    @Deprecated("Use the extension function", ReplaceWith("deleteRef") )
    fun delete( precondition: dynamic = definedExternally ) : Promise<WriteResult>

    /**
     * Retrieve a document from the database. Fails the Promise if the document is not found.
     * @return A [Promise] containing [DocumentSnapshot] that resolved with a DocumentSnapshot for the
     * retrieved document on success. For missing documents, DocumentSnapshot.exists will be false.
     * If the get() fails for other reasons, the Promise will be rejected.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.get().then(documentSnapshot => {
     *          if (documentSnapshot.exists) {
     *              console.log('Document retrieved successfully.');
     *          }
     *      });
     */
    fun get() : Promise<DocumentSnapshot>

    /**
     * Writes to the document referred to by this DocumentReference. If the document does not yet exist, it will
     * be created. If you pass SetOptions, the provided data can be merged into an existing document.
     * @see DocumentReference.setMap extension function for set a [Map].
     * @see DocumentReference.setModel extension function for set a custom model.
     * @param data A map of the fields and values for the document.
     * @param options An object to configure the set behavior.
     * @return A [Promise] containing [WriteResult] that resolves with the write time of this set.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.set({foo: 'bar'}).then(res => {
     *          console.log(`Document written at ${res.updateTime}`);
     *      });
     */
    @Deprecated("Use the extension function", ReplaceWith("setMap / setModel" ) )
    fun set( data: dynamic, options: dynamic = definedExternally ) : Promise<WriteResult>
}

// CREATE.
fun DocumentReference.createMap( map: Map<String, Any> ) = create( map )

fun DocumentReference.createModel( model: Any ) = create( model.toJson() )

// DELETE.
fun DocumentReference.deleteRef( lastUpdateTime: String? ) =
        lastUpdateTime?.let { delete("lastUpdateTime" to lastUpdateTime ) } ?: delete()

// SET.
fun DocumentReference.setMap( map: Map<String, Any>, merge: Boolean? = null ) =
        merge?.let { set( map, "merge" to merge ) } ?: set( map.toJson() )

fun DocumentReference.setMap( map: Map<String, Any>, vararg mergeFields: String ) =
        set( map, mergeFields.toList().toTypedArray() )

fun DocumentReference.setModel( model: Any, merge: Boolean? = null ) =
        merge?.let { set( model.toJson(), "merge" to model ) } ?: set( model.toJson() )

fun DocumentReference.setModel( model: Any, vararg mergeFields: String ) =
        set( model.toJson(), mergeFields.toList().toTypedArray() )


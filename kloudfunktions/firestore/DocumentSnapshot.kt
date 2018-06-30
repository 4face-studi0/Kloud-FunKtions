@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing a Cloud Firestore document delta snapshot.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.firestore.DocumentSnapshot)
 */
external interface DocumentSnapshot {
    /**
     * The date the document was created, formatted as a UTC string.
     */
    val createTime: String?

    /**
     * Returns true if this [DocumentSnapshot] contains any data.
     */
    val exists: Boolean

    /**
     * Extracts a document ID from a [DocumentSnapshot].
     */
    val id: String

    /**
     * The last time the document was read, formatted as a UTC string.
     */
    val readTime: String?

    /**
     * Returns a [DocumentReference] to the database location where the triggering write occurred.
     * This DocumentReference has admin privileges.
     */
    val ref: DocumentReference

    /**
     * The last update time for the document, formatted as a UTC string.
     */
    val updateTime: String?

    /**
     * Retrieves all fields in the document as an object. Returns 'undefined' if the document doesn't exist.
     * @return An object containing all fields in the document or 'undefined' if the document doesn't exist.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.get().then(documentSnapshot => {
     *          let data = documentSnapshot.data();
     *          console.log(`Retrieved data: ${JSON.stringify(data)}`);
     *      });
     */
    fun data() : dynamic

    /**
     * Retrieves the field specified by [field].
     * @param field The field path (e.g. 'foo' or 'foo.bar') to a specific field.
     * @return The data at the specified field location or undefined if no such field exists.
     */
    fun get( field: FieldPath ) : Any

    /**
     * @see get
     */
    fun get( field: String ) : Any

}
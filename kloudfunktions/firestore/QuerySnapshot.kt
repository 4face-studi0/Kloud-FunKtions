@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 * @constructor A QuerySnapshot contains zero or more [QueryDocumentSnapshot] objects representing the results
 * of a query. The documents can be accessed as an array via the documents property or enumerated using
 * the [forEach] method. The number of documents can be determined via the [empty] and [size] properties.
 */
external class QuerySnapshot {
    /**
     * An array of all changes in this QuerySnapshot.
     */
    val docChanges: Array<out DocumentChange>

    /**
     * An array of all the documents in this QuerySnapshot.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then(querySnapshot => {
     *          let docs = querySnapshot.docs;
     *          for (let doc of docs) {
     *              console.log(`Document found at path: ${doc.ref.path}`);
     *          }
     *      });
     */
    val docs: Array<out QueryDocumentSnapshot>

    /**
     * True if there are no documents in the QuerySnapshot.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then(querySnapshot => {
     *          if (querySnapshot.empty) {
     *              console.log('No documents found.');
     *          }
     *      });
     */
    val empty: Boolean

    /**
     * The query on which you called get() or onSnapshot() in order to get this QuerySnapshot.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.limit(10).get().then(querySnapshot => {
     *          console.log(`Returned first batch of results`);
     *          let query = querySnapshot.query;
     *          return query.offset(10).get();
     *      }).then(() => {
     *          console.log(`Returned second batch of results`);
     *      });
     */
    val query: Query

    /**
     * The time this query snapshot was obtained.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then((querySnapshot) => {
     *          console.log(`Query results returned at '${querySnapshot.readTime}'`);
     *      });
     */
    val readTime: String

    /**
     * The number of documents in the QuerySnapshot.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then(querySnapshot => {
     *          console.log(`Found ${querySnapshot.size} documents.`);
     *      });
     */
    val size: Int

    /**
     * Enumerates all of the documents in the QuerySnapshot.
     * @param callback A callback to be called with a QueryDocumentSnapshot for each document in the snapshot.
     * @param thisArg The this binding for the callback.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Document found at path: ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun forEach(
            callback: (QueryDocumentSnapshot) -> Unit,
            thisArg: dynamic = definedExternally
    )

    /**
     * Returns true if the document data in this [QuerySnapshot] is equal to the provided value.
     * @return true if this [QuerySnapshot] is equal to the provided value.
     */
    fun isEqual( other: dynamic ) : Boolean

}
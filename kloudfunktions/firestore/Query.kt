@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package kloudfunktions.kloudfunktions.firestore

import kotlin.js.Promise

/**
 * @author 4face (Davide Giuseppe Farella).
 * @constructor A Query refers to a query which you can read or stream from. You can also construct refined Query
 * objects by adding filters and ordering.
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/Query).
 */
open external class Query {

    /**
     * The Firestore instance for the Firestore database (useful for performing transactions, etc.).
     *
     * **Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.add({foo: 'bar'}).then(documentReference => {
     *          let firestore = documentReference.firestore;
     *          console.log(`Root location for document is ${firestore.formattedName}`);
     *      });
     */
    val firestore: FirestoreNamespace

    /**
     * Creates and returns a new [Query] that ends at the provided set of field values relative to the order of
     * the query. The order of the provided values must match the order of the order by clauses of the query.
     * @param documentSnapshot The snapshot of the document the query results should end at or the field values to
     * end this query at,
     * in order of the query's order by.
     * @return A [Query] with the new ending point.
     *
     * **JS Example**
     *      > let query = firestore.collection('col');
     *      query.orderBy('foo').endAt(42).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun endAt( documentSnapshot: DocumentSnapshot) : Query

    /**
     * @see endAt
     */
    fun endAt( fieldValue: dynamic ) : Query

    /**
     * Creates and returns a new [Query] that ends before the set of field values relative to the order of
     * the query. The order of the provided values must match the order of the order by clauses of the query.
     * @param documentSnapshot The snapshot of the document the query results should end before or the field values
     * to end this query before, in order of the query's order by.
     * @return a [Query] with the new ending point.
     *
     * **JS Example**
     *      > let query = firestore.collection('col');
     *      query.orderBy('foo').endBefore(42).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun endBefore( documentSnapshot: DocumentSnapshot) : Query

    /**
     * @see endBefore
     */
    fun endBefore( fieldValue: dynamic ) : Query

    /**
     * Executes the query and returns the results as a [QuerySnapshot].
     * @return a [Promise] containing [QuerySnapshot] that resolves with the results of the [Query].
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      query.get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun get() : Promise<QuerySnapshot>

    /**
     * Returns true if this [Query] is equal to the provided value.
     * @return a [Boolean] true if this [Query] is equal to the provided value.
     */
    fun isEqual( other: dynamic ) : Boolean

    /**
     * Creates and returns a new [Query] that's additionally limited to only return up to the specified number
     * of documents.
     * This function returns a new (immutable) instance of the Query (rather than modify the existing instance)
     * to impose the limit.
     * @param limit The maximum number of items to return.
     * @return The created [Query].
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '>', 42);
     *      query.limit(1).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun limit( limit: Int ) : Query

    /**
     * Specifies the offset of the returned results.
     * This function returns a new (immutable) instance of the [Query] (rather than modify the existing instance)
     * to impose the offset.
     * @param offset The offset to apply to the Query results.
     * @return The created [Query]
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '>', 42);
     *      query.limit(10).offset(20).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun offset( offset: Int ) : Query

    /** TODO: [onError]
     * Attaches a listener for QuerySnapshot events.
     * @param onNext A callback to be called every time a new [QuerySnapshot] is available.
     * @param onError A optional callback to be called if the listen fails or is cancelled. No further
     * callbacks will occur.
     * @return An unsubscribe function that can be called to cancel the snapshot listener.
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      let unsubscribe = query.onSnapshot(querySnapshot => {
     *          console.log(`Received query snapshot of size ${querySnapshot.size}`);
     *      }, err => {
     *          console.log(`Encountered error: ${err}`);
     *      });
     *      // Remove this listener.
     *      unsubscribe();
     */
    fun onSnapshot(
            onNext: (QuerySnapshot) -> Unit,
            onError: ( (dynamic) -> Unit )? = definedExternally
    )

    /**
     * Creates and returns a new [Query] that's additionally sorted by the specified field, optionally in
     * descending order instead of ascending.
     * This function returns a new (immutable) instance of the Query (rather than modify the existing instance)
     * to impose the field mask.
     * @param fieldPath The field to sort by.
     * @param directionStr Optional direction to sort by ('asc' or 'desc'). If not specified, order will be ascending.
     * @return The created [Query].
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '>', 42);
     *      query.orderBy('foo', 'desc').get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun orderBy(fieldPath: FieldPath, directionStr: String? = definedExternally ) : Query

    /**
     * @see orderBy
     */
    fun orderBy( fieldPath: String, directionStr: String? = definedExternally ) : Query

    /**
     * Creates and returns a new [Query] instance that applies a field mask to the result and returns only the
     * specified subset of fields. You can specify a list of field paths to return, or use an empty list to only
     * return the references of matching documents.
     * This function returns a new (immutable) instance of the Query (rather than modify the existing instance)
     * to impose the field mask.
     * @param fieldPath The field paths to return. Value may be repeated.
     * @return The created [Query].
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      let documentRef = collectionRef.doc('doc');
     *      return documentRef.set({x:10, y:5}).then(() => {
     *          return collectionRef.where('x', '>', 5).select('y').get();
     *      }).then((res) => {
     *          console.log(`y is ${res.docs[0].get('y')}.`);
     *      });
     */
    fun select( vararg fieldPath: FieldPath) : Query

    /**
     * @see select
     */
    fun select( vararg fieldPath: String ) : Query

    /**
     * Creates and returns a new [Query] that starts after the provided set of field values relative to the order
     * of the query. The order of the provided values must match the order of the order by clauses of the query.
     * @param documentSnapshot The snapshot of the document the query results should start after or the field
     * values to start this query after, in order of the query's order by.
     * @return A [Query] with the new starting point.
     *
     * **JS Example**
     *      > let query = firestore.collection('col');
     *      query.orderBy('foo').startAfter(42).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun startAfter( vararg documentSnapshot: DocumentSnapshot) : Query

    /**
     * @see startAfter
     */
    fun startAfter( vararg documentSnapshot: dynamic ) : Query

    /**
     * Creates and returns a new [Query] that starts at the provided set of field values relative to the order
     * of the query. The order of the provided values must match the order of the order by clauses of the query.
     * @param documentSnapshot The snapshot of the document the query results should start at or the field values
     * to start this query at, in order of the query's order by.
     * @return A [Query] with the new starting point.
     *
     * **JS Example**
     *      > let query = firestore.collection('col');
     *      query.orderBy('foo').startAt(42).get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun startAt( vararg documentSnapshot: DocumentSnapshot) : Query

    /**
     * @see startAt
     */
    fun startAt( vararg documentSnapshot: dynamic ) : Query

    /** TODO Stream
     * Executes the query and streams the results as [QueryDocumentSnapshot].
     * @return A stream of [QueryDocumentSnapshot].
     *
     * **JS Example**
     *      > let query = firestore.collection('col').where('foo', '==', 'bar');
     *      let count = 0;
     *      query.stream().on('data', (documentSnapshot) => {
     *          console.log(`Found document with name '${documentSnapshot.id}'`);
     *          ++count;
     *      }).on('end', () => {
     *          console.log(`Total count is ${count}`);
     *      });
     */
    fun stream() : dynamic

    /**
     * Creates and returns a new [Query] with the additional filter that documents must contain the specified
     * field and that its value should satisfy the relation constraint provided.
     * Returns a new Query that constrains the value of a Document property.
     * This function returns a new (immutable) instance of the Query (rather than modify the existing instance)
     * to impose the filter.
     * @param fieldPath The name of a property value to compare.
     * @param opStr A comparison operation in the form of a string (e.g., "<").
     * @param value The value to which to compare the field for inclusion in a query.
     * @return The created [Query].
     *
     * **JS Example**
     *      > let collectionRef = firestore.collection('col');
     *      collectionRef.where('foo', '==', 'bar').get().then(querySnapshot => {
     *          querySnapshot.forEach(documentSnapshot => {
     *              console.log(`Found document at ${documentSnapshot.ref.path}`);
     *          });
     *      });
     */
    fun where( fieldPath: FieldPath, opStr: String, value: dynamic ) : Query

}
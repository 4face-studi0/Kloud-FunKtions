@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 * A WriteResult wraps the write time set by the Firestore servers on sets(), updates(), and creates().
 */
external class WriteResult {
    /**
     * The write time as set by the Firestore servers. Formatted as an ISO-8601 string.
     *
     * **JS Example**
     *      > let documentRef = firestore.doc('col/doc');
     *      documentRef.set({foo: 'bar'}).then(writeResult => {
     *          console.log(`Document written at: ${writeResult.writeTime}`);
     *      });
     */
    val writeTime: String

    /**
     * Returns true if this [WriteResult] is equal to the provided value.
     * @param other The value to compare against.
     * @return true if this [WriteResult] is equal to the provided value.
     */
    fun isEqual( other: dynamic ) : Boolean
}
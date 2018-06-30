@file:Suppress("unused")

package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 * A dot-separated path for navigating sub-objects within a document.
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/firestore/0.14.x/FieldPath).
 */
external class FieldPath {
    /**
     * Constructs a Firestore Field Path.
     * @param segments Sequence of field names that form this path.
     */
    constructor( vararg segments: String )

    /**
     * Constructs a Firestore Field Path.
     * @param segments Sequence of field names that form this path.
     */
    constructor( segments: Array<out String> )

    /**
     * A special FieldPath value to refer to the ID of a document. It can be used in queries to sort or filter
     * by the document ID.
     * @return [FieldPath].
     */
    fun documentId() : FieldPath

    /**
     * Returns true if this FieldPath is equal to the provided value.
     * @param other The value to compare against.
     * @return true if this [FieldPath] is equal to the provided value.
     */
    fun isEqual( other: dynamic ) : Boolean

}
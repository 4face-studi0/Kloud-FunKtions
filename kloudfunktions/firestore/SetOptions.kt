@file:Suppress("unused", "FunctionName")

package kloudfunktions.kloudfunktions.firestore

/**
 * @author 4face (Davide Giuseppe Farella).
 */
typealias SetOptions = (merge: Boolean, mergeFields: String) -> dynamic

/**
 * An object to configure the set behavior.
 * /@param merge If true, merges the values specified in its data argument. Fields omitted remain untouched.
 * /@param mergeFields If provided, only replaces the specified field paths. Any field path that is not specified
 * is ignored and remains untouched.
 * @return a dynamic.
 */
val setOptions: SetOptions get() = { merge, mergeFields ->
    val d: dynamic = object {}
    d["merge"] = merge
    d["mergeFields"] = mergeFields
    d
}
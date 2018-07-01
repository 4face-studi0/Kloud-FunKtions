package kloudfunktions

import kloudfunktions.kloudfunktions.firestore.DocumentSnapshot

/**
 * @author 4Face (Davide Giuseppe Farella).
 * This method convert [Any] to a [JSON] object.
 * @return the parsed [JSON].
 */
fun Any.toJson() = JSON.parse<JSON>( JSON.stringify(this ) )

/**
 * This method convert a [DocumentSnapshot.data] into a Model [T].
 * @return and instance of [T].
 */
@Suppress("UnsafeCastFromDynamic")
fun <T> DocumentSnapshot.toModel() = JSON.parse<T>( JSON.stringify( data() ) )

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
 * @return an instance of [T].
 */
@Suppress("UnsafeCastFromDynamic")
fun <T> DocumentSnapshot.toModel() = JSON.parse<T>( JSON.stringify( data() ) )

/**
 * This method convert a [JSON] into a Model [T].
 * @return an instance of [T].
 */
fun <T> JSON.toModel() = JSON.parse<T>( JSON.stringify(this ) )


// Arrays / Map

fun jsMap( init: (dynamic) -> Unit )= Any().apply { init( asDynamic() ) }.asDynamic()

fun keys( obj: dynamic )= js("Object" ).keys( obj ).unsafeCast<Array<String>>()

fun <T> map( obj: dynamic ) = mapOf(
        * keys( obj )
                .map { it to obj[it].unsafeCast<T>() }
                .toTypedArray()
)

fun <T> mutableMap( obj: dynamic ) = map<T>( obj ).toMutableMap()
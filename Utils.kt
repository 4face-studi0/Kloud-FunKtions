package kloudfunktions

import kotlin.js.Json
import kotlin.js.json

@JsModule("json2plain")
@JsNonModule
external fun jsonToPlain( obj: dynamic ) : dynamic

fun Map<String, Any>.toJs() =
        json( * map { it.key to it.value }.toTypedArray() )

fun Any.toJs(): dynamic = jsonToPlain( JSON.stringify(this ) )
        .also { d -> console.info( d ) }

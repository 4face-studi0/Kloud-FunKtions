package kloudfunktions.kloudfunktions

import kloudfunktions.kloudfunktions.firestore.Firestore

@JsModule("firebase-functions")
@JsNonModule
external object Functions {
    val firestore: Firestore
}

package kloudfunktions.kloudfunktions

import kloudfunktions.kloudfunktions.firestore.Firestore

@JsModule("firebase-admin")
@JsNonModule
external object Admin {
    fun initializeApp()
    fun firestore(): Firestore
}
package kloudfunktions.kloudfunktions

import kloudfunktions.kloudfunktions.firestore.Firestore
import kloudfunktions.messaging.Messaging

@JsModule("firebase-admin")
@JsNonModule
external object Admin {
    fun initializeApp()
    fun firestore(): Firestore
    fun messaging(): Messaging
}
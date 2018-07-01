@file:Suppress("unused")

package kloudfunktions.kloudfunktions

import kloudfunktions.kloudfunktions.firestore.FirestoreNamespace
import kloudfunktions.kloudfunktions.storage.StorageNamespace

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * functions is a global namespace from which all the Cloud Functions services are accessed.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions).
 */
@JsModule("firebase-functions")
@JsNonModule
external object Functions {
    val firestore:  FirestoreNamespace
    val storage:    StorageNamespace
}

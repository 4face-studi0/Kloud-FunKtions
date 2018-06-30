package kloudfunktions.kloudfunktions.firestore

external interface Firestore {
    fun collection( child: String ): CollectionReference
    fun document( path: String ): DocumentBuilder
}
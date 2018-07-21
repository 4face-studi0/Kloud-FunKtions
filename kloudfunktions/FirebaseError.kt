@file:Suppress("unused")

package kloudfunktions.kloudfunktions

/**
 * @author 4face (Davide Giuseppe Farella).
 * [FirebaseError] is a subclass of the standard JavaScript Error object. In addition to a message string and
 * stack trace, it contains a string code.
 * [Google Doc](https://firebase.google.com/docs/reference/admin/node/admin.FirebaseError).
 */
external interface FirebaseError {
    /**
     * Error codes are strings using the following format: "service/string-code". Some examples include
     * "auth/invalid-uid" and "messaging/invalid-recipient".
     * While the message for a given error can change, the code will remain the same between backward-compatible
     * versions of the Firebase SDK.
     */
    val code: String

    /**
     * An explanatory message for the error that just occurred.
     * This message is designed to be helpful to you, the developer. It is not intended to be displayed to the
     * end user of your application (as it will generally not convey meaningful information to them).
     */
    val message: String

    /**
     * A string value containing the execution backtrace when the error originally occurred.
     * This information can be useful to you and can be sent to Firebase Support to help explain the cause of an error.
     */
    val stack: String

    /**
     * @return a [JSON] serializable representation of this object.
     */
    fun toJSON(): JSON
}
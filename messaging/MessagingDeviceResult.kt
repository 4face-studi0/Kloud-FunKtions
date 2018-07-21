@file:Suppress("unused")

package kloudfunktions.messaging

import kloudfunktions.kloudfunktions.FirebaseError

/**
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing the status of a message sent to an individual device.
 * @see Messaging.sentToDevice for code samples and detailed documentation.
 * [Google Doc](https://firebase.google.com/docs/reference/admin/node/admin.messaging.MessagingDeviceResult).
 */
external interface MessagingDeviceResult {
    /**
     * The canonical registration token for the client app that the message was processed and sent to. You should use
     * this value as the registration token for future requests. Otherwise, future messages might be rejected.
     */
    val canonicalRegistrationToken: String?

    /**
     * The error that occurred when processing the message for the recipient.
     */
    val error: FirebaseError?

    /**
     * A unique ID for the successfully processed message.
     */
    val messageId: String?
}
@file:Suppress("unused")

package kloudfunktions.messaging

/**
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing the server response from the [Messaging.sendToTopic] method.
 * [Google Doc](https://firebase.google.com/docs/reference/admin/node/admin.messaging.MessagingTopicResponse).
 */
external interface MessagingTopicResponse {
    /**
     * The message ID for a successfully received request which FCM will attempt to deliver to all subscribed devices.
     */
    val messageId: Int
}
@file:Suppress("unused")

package kloudfunktions.messaging

/**
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing the server response from the [Messaging.sentToDevice] method.
 * @see Messaging.sentToDevice for code samples and detailed documentation.
 * [Google Doc](https://firebase.google.com/docs/reference/admin/node/admin.messaging.MessagingDevicesResponse).
 */
external interface MessagingDevicesResponse {
    /**
     * The number of results that contain a canonical registration token. A canonical registration token is the
     * registration token corresponding to the last registration requested by the client app. This is the token
     * that you should use when sending future messages to the device.
     * You can access the canonical registration tokens within the results property.
     */
    val canonicalRegistrationTokenCount: Int

    /**
     * The number of messages that could not be processed and resulted in an error.
     */
    val failureCount: Int

    /**
     * The unique ID number identifying this multicast message.
     */
    val multicastId: Int

    /**
     * An [Array] of [MessagingDeviceResult] objects representing the status of the processed messages.
     * The objects are listed in the same order as in the request. That is, for each registration token in
     * the request, its result has the same index in this array. If only a single registration token is provided,
     * this array will contain a single object.
     */
    val results: Array<out MessagingDeviceResult>

    /**
     * The number of messages that were successfully processed and sent.
     */
    val successCount: Int
}
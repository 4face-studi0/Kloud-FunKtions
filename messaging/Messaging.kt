package kloudfunktions.messaging

import kotlin.js.Promise

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 */
external interface Messaging {

    fun sentToDevice()

    /** TODO
     * Sends an FCM message to an array of devices corresponding to the provided registration tokens.
     * @see sentToDevice for code samples and detailed documentation.
     * @param registrationTokens An array of registration tokens for the devices to which to send the message.
     * @param payload The message payload.
     * @param options Optional options to alter the message.
     * @return A [Promise] of [MessagingDevicesResponse] fulfilled with the server's response after the message
     * has been sent.
     */
    fun sendToDevice(
            registrationTokens: Array<String>, payload: dynamic, options: dynamic = definedExternally
    ): Promise<MessagingDevicesResponse>

    /**
     * Sends an FCM message to a topic.
     * TODO @see sentToDevice for code samples and detailed documentation.
     * @param topic The topic to which to send the message.
     * @param payload The message payload.
     * @param options Optional options to alter the message.
     * @return A [Promise] of [MessagingTopicResponse] fulfilled with the server's response after the message
     * has been sent.
     */
    fun sendToTopic(
            topic: String, payload: dynamic, options: dynamic = definedExternally
    ): Promise<MessagingTopicResponse>
}

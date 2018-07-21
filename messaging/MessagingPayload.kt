package kloudfunktions.messaging

import kloudfunktions.toJson

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing a Firebase Cloud Messaging message payload. One or both of the data and notification keys
 * are required.
 * [Google Doc](https://firebase.google.com/docs/reference/admin/node/admin.messaging.MessagingPayload).
 */
data class MessagingPayload(
    val data: DataMessagePayload
)

abstract class DataMessagePayload
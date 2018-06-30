@file:Suppress("unused")

package kloudfunktions.kloudfunktions

/**
 * @author 4face (Davide Giuseppe Farella)
 * The context in which an event occurred. An EventContext describes:
 * * The time an event occurred.
 * * A unique identifier of the event.
 * * The resource on which the event occurred, if applicable.
 * * Authorization of the request that triggered the event, if applicable and available.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.EventContext).
 */
external interface EventContext {
    /**
     * Authentication information for the user that triggered the function. This object contains uid and token
     * properties for authenticated users. For more detail including token keys, see the
     * [security rules reference](https://firebase.google.com/docs/firestore/reference/security/#properties).
     * For an unauthenticated user, this field is null. For event types that do not provide user information (all
     * except Realtime Database) or for Firebase admin users, this field will not exist.
     */
    val auth: dynamic

    /**
     * The level of permissions for a user. Valid values are:
     * * ADMIN Developer user or user authenticated via a service account.
     * * USER Known user.
     * * UNAUTHENTICATED Unauthenticated action
     * * null For event types that do not provide user information (all except Realtime Database).
     */
    val authType: String?

    /**
     * The event’s unique identifier.
     */
    val eventId: String

    /**
     * Type of event. Valid values are:
     * * providers/google.firebase.analytics/eventTypes/event.log
     * * providers/google.firebase.database/eventTypes/ref.write
     * * providers/google.firebase.database/eventTypes/ref.create
     * * providers/google.firebase.database/eventTypes/ref.update
     * * providers/google.firebase.database/eventTypes/ref.delete
     * * providers/cloud.firestore/eventTypes/document.write
     * * providers/cloud.firestore/eventTypes/document.create
     * * providers/cloud.firestore/eventTypes/document.update
     * * providers/cloud.firestore/eventTypes/document.delete
     * * providers/firebase.auth/eventTypes/user.create
     * * providers/firebase.auth/eventTypes/user.delete
     * * providers/cloud.pubsub/eventTypes/topic.publish
     * * providers/cloud.storage/eventTypes/object.change
     */
    val eventType: String

    /**
     * An object containing the values of the wildcards in the path parameter provided to the ref() method for a
     * Realtime Database trigger.
     */
    val params: dynamic

    /**
     * The resource that emitted the event. Valid values are:
     * * Analytics — projects/<projectId>/events/<analyticsEventType>
     * * Realtime Database — projects/_/instances/<databaseInstance>/refs/<databasePath>
     * * Storage — projects/_/buckets/<bucketName>/objects/<fileName>#<generation>
     * * Authentication — projects/<projectId>
     * * Pub/Sub — projects/<projectId>/topics/<topicName>
     * Because Realtime Database instances and Cloud Storage buckets are globally unique and not tied to the project,
     * their resources start with projects/_. Underscore is not a valid project name.
     */
    val resource: dynamic

    /**
     * Timestamp for the event as an [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) string.
     */
    val timestamp: String

}
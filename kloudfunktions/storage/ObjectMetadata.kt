@file:Suppress("unused", "DEPRECATION")

package kloudfunktions.kloudfunktions.storage

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * Interface representing a Google Google Cloud Storage object metadata object.
 * [Google Doc](https://firebase.google.com/docs/reference/functions/functions.storage.ObjectMetadata).
 */
external interface ObjectMetadata {
    /**
     * Storage bucket that contains the object.
     */
    val bucket: String

    /**
     * The value of the Cache-Control header, used to determine whether Internet caches are allowed to cache
     * public data for an object.
     */
    val cacheControl: String?

    /**
     * Specifies the number of originally uploaded objects from which a composite object was created.
     */
    val componentCount: Int?

    /**
     * The value of the Content-Disposition header, used to specify presentation information about the
     * data being transmitted.
     */
    val componentDisposition: String?

    /**
     * Content-Encoding to indicate that an object is compressed (for example, with gzip compression) while
     * maintaining its Content-Type.
     */
    val contentEncoding: String?

    /**
     * ISO 639-1 language code of the content.
     */
    val contentLanguage: String?

    /**
     * The object's content type, also known as the MIME type.
     */
    val contentType: String?

    /**
     * The object's CRC32C hash. All Google Cloud Storage objects have a CRC32C hash or MD5 hash.
     */
    val crc32c: String?

    /**
     * Customer-supplied encryption key.
     */
    val costumerEncryption: CostumerEncryption?

    /**
     * Generation version number that changes each time the object is overwritten.
     */
    val generation: String?

    /**
     * The ID of the object, including the bucket name, object name, and generation number.
     */
    val id: String

    /**
     * The kind of the object, which is always [StorageNamespace.object].
     */
    val kind: String

    /**
     * MD5 hash for the object. All Google Cloud Storage objects have a CRC32C hash or MD5 hash.
     */
    val md5Hash: String?

    /**
     * Media download link.
     */
    val mediaLink: String?

    /**
     * User-provided metadata.
     */
    val metadata: dynamic

    /**
     * Meta-generation version number that changes each time the object's metadata is updated.
     */
    val metageneration: String?

    /**
     * The object's name.
     */
    val name: String?

    /**
     * The current state of the object resource.
     * The value can be either "exists" (for object creation and updates) or "not_exists" (for object deletion and moves).
     */
    @Deprecated("Use the extension function", ReplaceWith("getResourceState()" ) )
    val resourceState: dynamic

    /**
     * Link to access the object, assuming you have sufficient permissions.
     */
    val selfLink: String?

    /**
     * The value of the Content-Length header, used to determine the length of the object data in bytes.
     */
    val size: String?

    /**
     * Storage class of the object.
     */
    val storageClass: String?

    /**
     * The creation time of the object in RFC 3339 format.
     */
    val timeCreated: String?

    /**
     * The deletion time of the object in RFC 3339 format. Returned only if this version of the object has been deleted.
     */
    val timeDeleted: String?

    /**
     * The modification time of the object metadata in RFC 3339 format.
     */
    val updated: String?

}

@Suppress("UnsafeCastFromDynamic")
fun ObjectMetadata.getResourceState() = ResourceState.valueOf( resourceState )

/**
 * @property encryptionAlgorithm The encryption algorithm that was used. Always contains the value.
 * @property keySha256 An RFC 4648 base64-encoded string of the SHA256 hash of your encryption key.
 * You can use this SHA256 hash to uniquely identify the AES-256 encryption key required to decrypt the object,
 * which you must store securely.
 */
data class CostumerEncryption(
    val encryptionAlgorithm: String?,
    val keySha256: String?
)

/**
 * @see ObjectMetadata.resourceState
 */
enum class ResourceState { EXISTS, NOT_EXISTS }
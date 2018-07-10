@file:Suppress("unused")

package kloudfunktions.kloudfunktions.storage

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/storage/1.7.x/Storage).
 */
@JsModule("@google-cloud/storage")
@JsNonModule
external fun storage() : Storage

@Deprecated("Don't use default constructor", ReplaceWith("storage()"))
external class Storage {
    /** TODO
     * Cloud Storage uses access control lists (ACLs) to manage object and bucket access. ACLs are the mechanism
     * you use to share objects with other users and allow other users to access your buckets and objects.
     * This object provides constants to refer to the three permission levels that can be granted to an entity:
     * * gcs.acl.OWNER_ROLE - ("OWNER")
     * * gcs.acl.READER_ROLE - ("READER")
     * * gcs.acl.WRITER_ROLE - ("WRITER")
     * [Google Doc](https://cloud.google.com/storage/docs/access-control/lists).
     *
     * **JS Example**
     *      > const storage = require('@google-cloud/storage')();
     *      const albums = storage.bucket('albums');
     *      //-
     *      // Make all of the files currently in a bucket publicly readable.
     *      //-
     *      const options = {
     *          entity: 'allUsers',
     *          role: storage.acl.READER_ROLE
     *      };
     *      albums.acl.add(options, function(err, aclObject) {});
     *      //-
     *      // Make any new objects added to a bucket publicly readable.
     *      //-
     *      albums.acl.default.add(options, function(err, aclObject) {});
     *      //-
     *      // Grant a user ownership permissions to a bucket.
     *      //-
     *      albums.acl.add({
     *          entity: 'user-useremail@example.com',
     *          role: storage.acl.OWNER_ROLE
     *      }, function(err, aclObject) {});
     *      //-
     *      // If the callback is omitted, we'll return a Promise.
     *      //-
     *      albums.acl.add(options).then(function(data) {
     *          const aclObject = data[0];
     *          const apiResponse = data[1];
     *      });
     */
    val acl: dynamic

    fun bucket( path: String ): Bucket
}
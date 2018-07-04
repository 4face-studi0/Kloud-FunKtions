@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package kloudfunktions.kloudfunktions.storage

import kotlin.js.Promise

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/storage/1.7.x/File).
 * @constructor A File object is created from your [Bucket] object using [Bucket.file].
 * @param bucket The Bucket instance this file is attached to.
 * @param name The name of the remote file.
 * @param options Configuration options.
 *
 * **JS Example**
 *      > const storage = require('@google-cloud/storage')();
 *      const myBucket = storage.bucket('my-bucket');
 *      const file = myBucket.file('my-file');
 */
external class File( bucket: Bucket, name: String, options: FileOptions? = definedExternally ) {
    /** TODO
     * Cloud Storage uses access control lists (ACLs) to manage object and bucket access. ACLs are the mechanism
     * you use to share objects with other users and allow other users to access your buckets and objects.
     * An ACL consists of one or more entries, where each entry grants permissions to an entity. Permissions
     * define the actions that can be performed against an object or bucket (for example, READ or WRITE); t
     * he entity defines who the permission applies to (for example, a specific user or group of users).
     * The acl object on a File instance provides methods to get you a list of the ACLs defined on your bucket,
     * as well as set, update, and delete them.
     *
     * **JS Example**
     *      > const storage = require('@google-cloud/storage')();
     *      const myBucket = storage.bucket('my-bucket');
     *      const file = myBucket.file('my-file');
     *      //-
     *      // Make a file publicly readable.
     *      //-
     *      const options = {
     *          entity: 'allUsers',
     *          role: storage.acl.READER_ROLE
     *      };
     *      file.acl.add(options, function(err, aclObject) {});
     *      //-
     *      // If the callback is omitted, we'll return a Promise.
     *      //-
     *      file.acl.add(options).then(function(data) {
     *          const aclObject = data[0];
     *          const apiResponse = data[1];
     *      });
     */
    val acl: dynamic

    /**
     * Copy this file to another file. By default, this will copy the file to the same bucket, but you can choose
     * to copy it to another Bucket by providing a Bucket or File object or a URL starting with "gs://".
     * @param destination Destination file.
     * @param options Configuration options.
     * @param copyCallback Callback function.
     * @return a [Promise] containing [CopyResponse].
     *
     * **JS Example**
     *      > const storage = require('@google-cloud/storage')();
     *      //-
     *      // You can pass in a variety of types for the destination.
     *      //
     *      // For all of the below examples, assume we are working with the following
     *      // Bucket and File objects.
     *      //-
     *      const bucket = storage.bucket('my-bucket');
     *      const file = bucket.file('my-image.png');
     *      //-
     *      // If you pass in a string for the destination, the file is copied to its
     *      // current bucket, under the new name provided.
     *      //-
     *      file.copy('my-image-copy.png', function(err, copiedFile, apiResponse) {
     *          // `my-bucket` now contains:
     *          // - "my-image.png"
     *          // - "my-image-copy.png"
     *          // `copiedFile` is an instance of a File object that refers to your new
     *          // file.
     *      });
     *      //-
     *      // If you pass in a string starting with "gs://" for the destination, the
     *      // file is copied to the other bucket and under the new name provided.
     *      //-
     *      const newLocation = 'gs://another-bucket/my-image-copy.png';
     *      file.copy(newLocation, function(err, copiedFile, apiResponse) {
     *          // `my-bucket` still contains:
     *          // - "my-image.png"
     *          //
     *          // `another-bucket` now contains:
     *          // - "my-image-copy.png"
     *          // `copiedFile` is an instance of a File object that refers to your new
     *          // file.
     *      });
     *      //-
     *      // If you pass in a Bucket object, the file will be copied to that bucket
     *      // using the same name.
     *      //-
     *      const anotherBucket = storage.bucket('another-bucket');
     *      file.copy(anotherBucket, function(err, copiedFile, apiResponse) {
     *          // `my-bucket` still contains:
     *          // - "my-image.png"
     *          //
     *          // `another-bucket` now contains:
     *          // - "my-image.png"
     *          // `copiedFile` is an instance of a File object that refers to your new
     *          // file.
     *      });
     *      //-
     *      // If you pass in a File object, you have complete control over the new
     *      // bucket and filename.
     *      //-
     *      const anotherFile = anotherBucket.file('my-awesome-image.png');
     *      file.copy(anotherFile, function(err, copiedFile, apiResponse) {
     *          // `my-bucket` still contains:
     *          // - "my-image.png"
     *          //
     *          // `another-bucket` now contains:
     *          // - "my-awesome-image.png"
     *          // Note:
     *          // The `copiedFile` parameter is equal to `anotherFile`.
     *      });
     *      //-
     *      // If the callback is omitted, we'll return a Promise.
     *      //-
     *      file.copy(newLocation).then(function(data) {
     *          const newFile = data[0];
     *          const apiResponse = data[1];
     *      });
     *
     * **JS Example**
     *      > // Imports the Google Cloud client library
     *      const Storage = require('@google-cloud/storage');
     *      // Creates a client
     *      const storage = new Storage();
     *      /**
     *       * TO-DO(developer): Uncomment the following lines before running the sample.
     *       */
     *      // const srcBucketName = 'Name of the source bucket, e.g. my-bucket';
     *      // const srcFilename = 'Name of the source file, e.g. file.txt';
     *      // const destBucketName = 'Name of the destination bucket, e.g. my-other-bucket';
     *      // const destFilename = 'Destination name of file, e.g. file.txt';
     *      // Copies the file to the other bucket
     *      storage
     *          .bucket(srcBucketName)
     *          .file(srcFilename)
     *          .copy(storage.bucket(destBucketName).file(destFilename))
     *          .then(() => {
     *              console.log(
     *                  `gs://${srcBucketName}/${srcFilename} copied to gs://${destBucketName}/${destFilename}.`
     *              );
     *          })
     *          .catch(err => {
     *              console.error('ERROR:', err);
     *          });
     */
    fun copy(
            destination: String,
            options: CopyOptions? = definedExternally,
            copyCallback: CopyCallback? = definedExternally
    ) : Promise<CopyResponse>

    /**
     * @see copy
     */
    fun copy(
            destination: Bucket,
            options: CopyOptions? = definedExternally,
            copyCallback: CopyCallback? = definedExternally
    ) : Promise<CopyResponse>

    /**
     * @see copy
     */
    fun copy(
            destination: File,
            options: CopyOptions? = definedExternally,
            copyCallback: CopyCallback? = definedExternally
    ) : Promise<CopyResponse>
}

/**
 * @param encryptionKey A custom encryption key.
 * @param generation Generation to scope the file to.
 * @param kmsKeyName Cloud KMS Key used to encrypt this object, if the object is encrypted by such a key.
 * Limited availability; usable only by enabled projects.
 * @param userProject The ID of the project which will be billed for all requests made from File object.
 */
external class FileOptions(
        encryptionKey:  String? =   definedExternally,
        generation:     Int? =      definedExternally,
        kmsKeyName:     String? =   definedExternally,
        userProject:    String? =   definedExternally
)

/** TODO
 *
 */
external class CopyOptions(

)
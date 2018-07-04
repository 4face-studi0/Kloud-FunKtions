package kloudfunktions.kloudfunktions.storage

/**
 * @author 4face (Davide Giuseppe Farella).
 * [Google Doc](https://cloud.google.com/nodejs/docs/reference/storage/1.7.x/global#CopyCallback).
 * err = Error. Request error, if any. Value may be null.
 * copiedFile = The copied [File].
 * apiResponse = object. The full API response.
 */
typealias CopyCallback = (err: dynamic, copiedFile: File, apiResponse: dynamic) -> Unit
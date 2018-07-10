package kloudfunktions.misc.stream

import kloudfunktions.misc.events.EventEmitter

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * A [Stream] is an abstract interface for working with streaming data in Node.js.
 * The stream module provides a base API that makes it easy to build objects that implement the stream interface.
 * There are many stream objects provided by Node.js. For instance, a request to an HTTP server and
 * process.stdout are both stream instances.
 * Streams can be readable, writable, or both. All streams are instances of [EventEmitter].
 * [NodeJs Doc](https://nodejs.org/dist/v8.11.1/docs/api/stream.html#stream_class_stream).
 */
external interface Stream: EventEmitter
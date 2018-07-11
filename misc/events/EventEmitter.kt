package kloudfunktions.misc.events

import kotlin.js.Promise

/** TODO
 * @author 4face (Davide Giuseppe Farella).
 * The EventEmitter class is defined and exposed by the events module.
 * [NodeJs Doc](https://nodejs.org/dist/v8.11.1/docs/api/events.html#events_class_eventemitter).
 */
@JsModule("events")
@JsNonModule
external interface EventEmitter {
    /**
     * Adds the [listener] function to the end of the listeners array for the event named [eventName].
     * No checks are made to see if the listener has already been added. Multiple calls passing the same
     * combination of [eventName] and listener will result in the listener being added, and called, multiple times.
     * @param eventName The name of the event.
     * @param listener The callback function.
     * @return a reference to the [EventEmitter], so that calls can be chained.
     * By default, event listeners are invoked in the order they are added. The TODO emitter.prependListener()
     * method can be used as an alternative to add the event listener to the beginning of the listeners array.
     *
     * **JS Example**
     *      > server.on('connection', (stream) => {
     *          console.log('someone connected!');
     *      });
     *
     * **JS Example**
     *      > const myEE = new EventEmitter();
     *      myEE.on('foo', () => console.log('a'));
     *      myEE.prependListener('foo', () => console.log('b'));
     *      myEE.emit('foo');
     *      // Prints:
     *      //   b
     *      //   a
     */
    fun on( eventName: String, listener: (Any) -> Unit ) : EventEmitter
}

fun EventEmitter.onData( listener: (Any) -> Unit ) =
        on("data", listener )

fun EventEmitter.onEnd( listener: (Any) -> Unit ) =
        on("end", listener )

@Suppress("UNCHECKED_CAST")
fun EventEmitter.onError(listener: (Throwable) -> Unit ) =
        on("error", listener as ( (Any) -> Unit ) )

fun EventEmitter.toPromise()= Promise<Any> { resolve, reject ->
    onEnd( resolve )
    onError( reject )
}
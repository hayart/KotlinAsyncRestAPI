curl --location --request POST 'localhost:9091/api' \
--header 'Content-type: application/json' \
--data-raw '{
    "username": "hayk",
    "email": "test@developer.am"
}'


-------------------------
Suspending functions are at the center of everything coroutines. A suspending function is simply a function that can be paused and resumed at a later time. They can execute a long running operation and wait for it to complete without blocking.

The syntax of a suspending function is similar to that of a regular function except for the addition of the suspend keyword. It can take a parameter and have a return type. However, suspending functions can only be invoked by another suspending function or within a coroutine.

suspend fun backgroundTask(param: Int): Int {
// long running operation
}

Under the hood, suspend functions are converted by the compiler to another function without the suspend keyword, that takes an addition parameter of type Continuation<T>. The function above for example, will be converted by the compiler to this:

fun backgroundTask(param: Int, callback: Continuation<Int>): Int {
// long running operation
}

Continuation<T> is an interface that contains two functions that are invoked to resume the coroutine with a return value or with an exception if an error had occurred while the function was suspended.

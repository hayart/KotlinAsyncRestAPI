package am.developer.live.streaming.payload

data class MoveResponse(
    var id: Long?,
    var name: String,
    var year: Int) {
    constructor() :  this(0, "", 1900);
}
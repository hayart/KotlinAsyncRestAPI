package am.developer.live.streaming.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("movie")
data class MoveEntity (
    @Id
    val id: Long?,
    var name: String,
    var year: Int
){
    constructor() :  this(null, "", 1900);
}
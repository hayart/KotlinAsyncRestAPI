package am.developer.live.streaming.service

import am.developer.live.streaming.entity.MoveEntity
import am.developer.live.streaming.payload.MoveResponse
import kotlinx.coroutines.flow.Flow

interface MoveService {
    suspend fun save(move: MoveEntity): MoveEntity?;
    suspend fun findAll(): Flow<MoveEntity>;

    //fun addBook(book: BookRequest): ResponseEntity<BookResponse>;
}
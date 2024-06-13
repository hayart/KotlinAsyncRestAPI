package am.developer.live.streaming.repository

import am.developer.live.streaming.entity.MoveEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MoveRepository : CoroutineCrudRepository<MoveEntity, Long> {

    fun findByNameContaining(name: String): Flow<MoveEntity>
/*
    fun findByNameContaining(name: String): Flow<BookEntity>

    fun findByCompanyId(companyId: Long): Flow<BookEntity>
    @Query("SELECT * FROM book WHERE email = :email")
    fun findByEmail(email: String): Flow<BookEntity>*/
}

package am.developer.live.streaming.service.impl

import am.developer.live.streaming.entity.MoveEntity
import am.developer.live.streaming.repository.MoveRepository
import am.developer.live.streaming.service.MoveService
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MoveServiceImpl(private val moveRepository: MoveRepository) : MoveService {

    override suspend fun save(move: MoveEntity): MoveEntity? =
        moveRepository.save(move)

    override suspend fun findAll(): Flow<MoveEntity> =
        moveRepository.findAll()



    suspend fun findCompanyById(id: Long): MoveEntity? =
        moveRepository.findById(id)

    suspend fun deleteCompanyById(id: Long) {
        val foundCompany = moveRepository.findById(id)

        if (foundCompany == null)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "move with id $id was not found.")
        else
            moveRepository.deleteById(id)
    }

    suspend fun findAllCompaniesByNameLike(name: String): Flow<MoveEntity> =
        moveRepository.findByNameContaining(name)

    suspend fun updateCompany(id: Long, requestedCompany: MoveEntity): MoveEntity {
        val foundMove = moveRepository.findById(id)

        return if (foundMove == null)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "move with id $id was not found.")
        else
            moveRepository.save(
                foundMove.copy(id = foundMove.id)
            )
    }



}


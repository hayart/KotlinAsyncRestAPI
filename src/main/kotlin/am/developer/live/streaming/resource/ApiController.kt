package am.developer.live.streaming.resource

import am.developer.live.streaming.entity.MoveEntity
import am.developer.live.streaming.service.MoveService
import org.springframework.web.bind.annotation.*
import kotlinx.coroutines.flow.Flow

@RestController
@RequestMapping("/api")
class ApiController(private val moveService : MoveService) {

    @GetMapping
    suspend fun findAllMoves(): Flow<MoveEntity> {
        return moveService.findAll()
    }

    @PostMapping
    suspend fun createMove(@RequestBody request: MoveEntity): MoveEntity? =
        moveService.save(request)
}

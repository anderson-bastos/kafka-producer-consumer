package kafka.apache.producer

import kafka.apache.domain.User
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    private val orderProducer: UserProducer
) {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(UserController::class.java)
    }

    @PostMapping
    fun save(@RequestBody user: User): ResponseEntity<String> {
        logger.info("Saving user: $user")
        return ResponseEntity.ok("${orderProducer.send(user)} sent topic")
    }
}
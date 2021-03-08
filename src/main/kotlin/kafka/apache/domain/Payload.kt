package kafka.apache.domain

import java.util.*

data class User (
    val id: UUID? = UUID.randomUUID(),
    val name : String?,
    val email: String?
)
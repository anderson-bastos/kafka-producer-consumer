package kafka.apache.producer

import kafka.apache.domain.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Value("\${user.topic}")
    private lateinit var orderTopic: String

    fun send(user: User): String = kafkaTemplate.send(
        orderTopic, UUID.randomUUID().toString(), user.toString()
    ).get().producerRecord.value()
}
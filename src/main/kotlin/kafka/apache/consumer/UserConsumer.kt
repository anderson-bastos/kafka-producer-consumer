package kafka.apache.consumer

import kafka.apache.domain.User
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class UserConsumer {
    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(UserConsumer::class.java)
    }

    @Value("\${user.topic}") private lateinit var orderTopic: String

    @KafkaListener(topics = ["\${user.topic}"], groupId = "group-id")
    fun consumer(consumerRecord: ConsumerRecord<String, String>) {
        logger.info("$consumerRecord")
//        logger.info(consumerRecord.value())
    }
}
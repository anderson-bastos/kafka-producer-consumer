package kafka.apache.consumer

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class OrderConsumer {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(OrderConsumer::class.java)
    }

    @KafkaListener(topics = ["\${order.topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun consumer(order: String) {
        logger.info("Order: $order")
    }
}
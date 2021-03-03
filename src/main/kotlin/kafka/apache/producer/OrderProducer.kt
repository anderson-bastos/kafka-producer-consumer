package kafka.apache.producer

import kafka.apache.consumer.OrderConsumer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/producer")
class OrderProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(OrderProducer::class.java)
    }

    @Value("\${order.topic}")
    private lateinit var orderTopic: String

    @GetMapping("/send")
    fun send() : ResponseEntity<String> {
        val messageKey = UUID.randomUUID()
        var lf : ListenableFuture<SendResult<String, String>> = kafkaTemplate?.send(orderTopic, messageKey.toString())
        var sendResult: SendResult<String, String> = lf.get()
        logger.info(sendResult.producerRecord.value() + " sent topic")
        return ResponseEntity.ok(sendResult.producerRecord.value() + " sent topic")
    }
}
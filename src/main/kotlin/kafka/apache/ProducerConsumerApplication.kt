package kafka.apache

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProducerConsumerApplication

fun main(args: Array<String>) {
	runApplication<ProducerConsumerApplication>(*args)
}

# spring-boot-kafka

## Pré requisitos

- Graadle 3+
- Java 11+
- Docker 18.02.0+

## Preparando ambiente
- Execute o `docker build --build-arg JAR_FILE=build/libs/\*.jar -t kafka/producer-consumer .
  ` para realizar o build do container do projeto.

## Executando

- Execute o `docker-compose up` para inicializar o Zookeeper, Kafka e o kafka/producer-consumer.
- Inicialize o projeto `producer`

## Executando

Para testar, pode ser utilizado o seguinte comando: `./send-order.sh "{\"identifier\": \"12343\",\"customer\": \"Customer X\", \"value\": 1500}"`, onde será inserido o pedido no tópico do Kafka, via a aplicação `producer`, e será cosumido pela aplicação `consumer`, como no log abaixo:
````
2019-05-13 19:41:45.033  INFO 2103 --- [ntainer#0-0-C-1] b.c.emmanuelneri.consumer.OrderConsumer  : Order: Order(identifier=12343, customer=Customer X, value=1500)
````

## Referências

https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/
https://dzone.com/articles/producer-consumer-with-kafka-and-kotlin
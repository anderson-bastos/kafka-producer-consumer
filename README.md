# spring-boot-kafka

## Pré requisitos

- Graadle 6.8.2+
- Java 11+
- Docker 19.03.+
- Docker Composer 1.25.5+

## Preparando ambiente
- Execute o `docker build --build-arg JAR_FILE=build/libs/\*.jar -t kafka/producer-consumer .
  ` para realizar o build do container do projeto.

## Executando

- Execute o `docker-compose up` para inicializar os containeres: Zookeeper, Kafka e o kafka/producer-consumer.

## Executando

Para testar, enviar um POST, conforme exemplo abaixo:
````
curl --location --request POST 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "0c9af398-38a0-4f6a-8cfa-6b3c14dfd814",
    "name": "anderson",
    "email": "anderson-test@test.com.br"
}'
````
Onde será inserido o pedido no tópico do Kafka, via a aplicação `UserProduce`, e será cosumido pela aplicação `UserConsumer`, como no log abaixo:
````
ConsumerRecord(topic = USER_TOPIC, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1615226185150, serialized key size = 36, serialized value size = 93, headers = RecordHeaders(headers = [], isReadOnly = false), key = b86b8f49-3556-422a-bdb7-f6ccc13de31f, value = User(id=0c9af398-38a0-4f6a-8cfa-6b3c14dfd814, name=anderson, email=anderson-test@test.com.br))
````
## Referências

https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/

https://dzone.com/articles/producer-consumer-with-kafka-and-kotlin
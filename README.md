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

- Execute o `docker-compose up` para inicializar o Zookeeper, Kafka e o kafka/producer-consumer.
- Inicialize o projeto `producer`

## Executando

Para testar, pode ser utilizado o seguinte comando: `"""`, onde será inserido o pedido no tópico do Kafka, via a aplicação `producer`, e será cosumido pela aplicação `consumer`, como no log abaixo:
````
...
````

## Referências

https://emmanuelneri.com.br/2019/06/04/kafka-no-spring-boot/

https://dzone.com/articles/producer-consumer-with-kafka-and-kotlin
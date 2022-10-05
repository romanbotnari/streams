# Event streams

Event streaming is the practice of capturing data in real-time from event sources like databases, sensors, mobile devices, cloud services, and software applications in the form of streams of events.

## Functional spec

1. store these event streams durably for later retrieval; 
2. manipulate;
3. process;
4. react in real-time as well as retrospectively; 
5. route to different destination technologies as needed; 

## Use cases

* To process payments and financial transactions in real-time, such as in stock exchanges, banks, and insurances.
* To track and monitor cars, trucks, fleets, and shipments in real-time, such as in logistics and the automotive industry.
* To continuously capture and analyze sensor data from IoT devices or other equipment, such as in factories and wind parks.
* To collect and immediately react to customer interactions and orders, such as in retail, the hotel and travel industry, and mobile applications.
* To monitor patients in hospital care and predict changes in condition to ensure timely treatment in emergencies.
* To connect, store, and make available data produced by different divisions of a company.
* To serve as the foundation for data platforms, event-driven architectures, and microservices.

# Kafka

Kafka is a distributed system consisting of servers and clients that communicate via a high-performance TCP network protocol. It can be deployed on bare-metal hardware, virtual machines, and containers in on-premise as well as cloud environments.

## Servers
Kafka is run as a cluster of one or more servers that can span multiple datacenters or cloud regions. 
The storage layer is formed by the brokers, while Kafka Connect is used to continuously import and export data as event streams to integrate Kafka with your existing systems such as relational databases as well as other Kafka clusters. 

## Clients
Applications and microservices that read, write, and process streams of events in parallel, at scale, and in a fault-tolerant manner even in the case of network problems or machine failures. 

> Kafka ships with some such clients included, which are augmented by dozens of clients provided by the Kafka community: clients are available for Java and Scala including the higher-level Kafka Streams library, for Go, Python, C/C++, and many other programming languages as well as REST APIs.

## Event 

An event records the fact that "something happened" in the world or in your business. It is also called record or message in the documentation. When you read or write data to Kafka, you do this in the form of events. 

An event has a key, value, timestamp, and optional metadata headers.

```
Event key: "Alice"
Event value: "Made a payment of $200 to Bob"
Event timestamp: "Jun. 25, 2020 at 2:06 p.m."
```

## Topic

Topic: a particular stream of data. (Like a table)
Topics are identified by name. Topics support any kind of message. 
The sequence of messages is called a data stream.

(!) Queries not supported.
(!) No data verification

## Partition
Topics are split in partitions.
Messages are ordered by an id called **offset**.

The offsets are tied to the partition, they do not have a meaning outside of the partition.
Data is kept for a limited time.
Kafka topics/partitions are immutable, once data is written it can not be changed. (like the ledgers) 
Offsets are not updated by other operations that insertions. 
Order is guaranteed only within a partition via it's offset. 
Data is assigned to a random partition unless a **key** is provided.
Unlimited number of partitions.

## Producers
Producers write data to topics.
Producers know to which partition to write to.
This load is balanced to many brokers thanks to the number of partitions.

### Key
Producer can choose to send a key with the message (string, number, binary..)
key = null - data is sent round robin (partition 0,1,2)
key != null - then all messages for that key will always go to the same partition
key - send data with key when you need message ordering (because in the same partition)

### Kafka message 
Key - binary 
Value - binary
Compression type - none / gzip / snappy / ..
Headers - key <-> value
Partition + Offset 
Timestamp (system or user generated)

### Message Serialization 

Kafka only accepts bytes as input and sends bytes as output to consumers.
Serialization - transform object into bytes. 
There are different serializares for different types: string / int etc..
The key and value are serialized. 

## Consumers

Consumers read data from a topic (identified by name) - this is a pull model (nothing is sent to the consumer)
Consumers know which broker to read from. (How??)
Data is read in order whithin the partition. (based on offset from low to high value)

### Message deserialization

Deserializer - transforms bytes into objects, for value and key. 
Deserializers are based on types of data, so the consumer must know a priori what data to expect.

During the lifecycle of the topic, the data types should not change, because it can break the consumer.

### Consumer groups

Consumers read data as a consumer group.
Each consumer in a group read from an exclusive partition.
Two consumers do not read from the same partition.
Standby consumers are acceptable.
Multiple consumer groups for the same topic. 
A partition can have multiple readers if they belong to different consumer groups.

Consumers know to which group they belong due to the **group.id**.

#### Offsets

Commit offset to know from where to start reading again. (offsets per group???) 
Java consumers commit offsets automatically, but you can commit manually:
- At least once - after the message is processed
- At most once - when the message is received 
- Exactly once - ...???

### Brokers

A kafka cluster is composed of multiple brokers.
A broker is identified by its id.
Brokers have certain topic partitions. A broker can cover multiple topics.
After connecting to any broker you will be connected to the entire cluster.
Each broker is a bootstrap server.

Kafka client --> Connect (using Metadata)           --> Broker A
Broker A     --> List of all brokers                --> Kafka Client
Kafka client --> Connects to a broker from the lsit --> Broker B 

## Other Kafkas

# References

- https://kafka.apache.org/documentation/
- https://udemy.com/course/apache-kafka
- https://medium.com/@aliarslan10/apache-kafka-configuration-in-spring-boot-with-producer-and-consumer-example-621adf2fd78b
- https://github.com/aliarslan10/spring-for-kafka
- https://www.confluent.io/blog/5-things-every-kafka-developer-should-know/
- https://reflectoring.io/spring-boot-kafka/
- https://www.baeldung.com/ops/kafka-docker-setup
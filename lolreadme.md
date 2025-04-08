<h2> Description </h2>
<p>
1.	server software – Broker
2.	client API – java library producer: api and consumer api
3.	kafka connect
4.	kafka streams
5.	ksql

terminology
producer
consumer
broker
cluster
topic=table
partitions
offset-> unique sequence ID of a message in the partition.
consumer groups

to know topic name->partition number->offset number

kafka connect sits between datasource and cluster like a producer
database->kafka connect/source connector ->brokers/ cluster-> sink connector / kafka connect->snowflakes

kafka could be JDBC conector or snowflake connector
1.	worker (self managed; fault tolerant; scalability; load balancing)
2.	connector
3.	task

what is kafka stream?
Java scala library
Input data must be kafka topic


Ksql
Ksql engine
Rest interface
Ksql client
</p>
<h2> Set up kafka </h2>
<p>
<h3> activate the kafka broker</h3>
"D:\confluent-7.9.0\confluent-7.9.0\bin\windows\zookeeper-server-start.bat" "D:\confluent-7.9.0\confluent-7.9.0\etc\kafka\server.properties"
<h3> create kafka topics / tables test</h3>
bin\windows\kafka-topics.bat --create --topic test --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
<h3> sending files to the topics </h3>
bin\windows\kafka-console.producer.bat --topic test --broker-list localhost:9092 < ..\data\sample1.csv
<h3> read from topics test using consumer </h3>
bin\windows\kafka-console-consumer.bat --topic test --bootstrap-server localhost:9092 --from-beginning

<h5>Notes for running new</h5>
for running different kafka, broker id, listener port, log.dirs need to be changed.


<h3>set up</h3>
setx KAFKA_HOME C:\demo\confluent-5.4.0



</p>

<h2>Kafka storage arc</h2>
<p>
what is kafka?
1.receive messages form the producers and acknowledge the successful receipt.
2.strore the messages in a log file to safeguard it from potential loss.
3.deliver the messages to the consumers when the requrest it.

replication factor is number of copies for each partition
Topics ->Logfiles ->partitions ->replicas->segments
partition is folder under the topics
numbers of replicas (15)=partitions(5) X replication (3)

invoice->invoice0->invoice0_1, invoice0_2
->invoice1->invoice1_1, invoice1_2
->invoice2->invoice2_1, invoice2_2
->invoice3->invoice3_1, invoice3_2
->invoice4->invoice4_1, invoice4_2

every partition will create the first log segment file , index file and timeindex (for searching).
one segment file is 1GB or 1 week of data
To identify one log file: 1.topic name 2. partition number 3.offset number
kafka is a master less cluster and the list of active broker is maintained in the zookeeper. zookeepers/brokers/ids/... /controller
controler -》 act as broker 1st broker

Command:
kafka-topics.bat --describe --zookeeper localhost:2181 --topic invoices
ls /
get /controller
</p>




<h2>Producer</h2>

message timestamp : 1.create time default 2.Log append time

How to achieve exactly once? not sending duplicates.
set enable.idempotence=true
1.internal ID for producer instance
2.message sequence number
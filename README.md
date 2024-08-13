# spring-kafka-app

The "spring-kafka-app" project is a Spring Boot application that demonstrates the integration of Apache Kafka with Spring Kafka for building scalable and reactive messaging systems. It showcases how to produce and consume messages asynchronously using Kafka topics and Spring Kafka's template and listener components. This project highlights the benefits of event-driven architecture and real-time data processing using Kafka within a Spring Boot environment, making it suitable for building robust and efficient microservices and streaming applications.

Kafka application using spring boot

# Using Docker we can run the Kafka: to configure below setup in docker compose.yml in your project<br/>
<img src="kafka-images/Screenshot 2024-08-12 180659.png" alt="error"/>

It will configured and pull the images and create the containers in docker Desktop<br/>


Next you must connect docker desktop before running this command:<br/>
==> docker-compose up<br/>

<img src="" alt="error"/>

You can see the running containers on docker: command is:<br/>
==> docker ps (actively running)<br/>

To create topic in the Kafka: use this command:<br/>
	==> docker-compose exec broker kafka-topics --create --topic my_topic --partitions 1 --replication-factor 1 --bootstrap-server broker:9092<br/>
	
To get list of topics use this command:<br/>
	==> docker-compose exec broker kafka-topics --list --bootstrap-server broker:9092<br/>
	
TO Consume the events or messages from your topic producer use this command:<br/>
	==> docker-compose exec broker kafka-console-consumer --topic my_topic --from-beginning --bootstrap-server broker:9092<br/>
	
To Produce the events or messages in your topic from using this command:<br/>
	==> docker-compose exec broker kafka-console-consumer --topic my_topic --from-beginning --bootstrap-server broker:9092<br/>

 To Run the spring boot application using maven library use this command:<br/>
	==> ./mvnw spring-boot:run<br/>

Then configure your application with java with required dependencies in pom or gradle.<br/>

# The Cloned Application must build as a project in your familiar IDE.
Thank You.
Prabhakar-Naik.

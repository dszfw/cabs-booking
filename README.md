# Cabs booking backend
Simple backend for managing bookings. Booking producer service, REST layer, booking consumer service and RabbitMQ as message broker.

## Getting Started

**build.sh** - compile and install modules, build docker images

**run.sh** - run services in docker containers, docker-compose is used

Booking REST API is available on port 8080, endpoint **/booking**

Swagger UI API documentation: http://localhost:8080/swagger-ui.html

H2 console (user sa, empty password): http://localhost:8081/h2-console

JDBC URL: jdbc:h2:mem:booking

Rabbit web (guest/guest): http://localhost:15672

## Demo

[![IMAGE ALT TEXT](http://img.youtube.com/vi/2r6nt129eho/0.jpg)](http://www.youtube.com/watch?v=2r6nt129eho "demo backend - Spring boot, RabbitMQ, docker compose, H2")


## Project Modules

* **booking-producer-service**

    Microservice responsible for REST layer and pushing bookings to the Message Broker

* **booking-consumer-service**

    This microservice listens to booking messages and persist bookings to database

* **booking-database**

    Simple H2 server

* **booking-dao**

    Spring Data repositories for bookings

* **booking-dto**

    Domain transfer objects and related mappers

* **booking-domain**
    
    Entities

* **booking-messaging**

    Spring boot starter with RabbitMQ messaging configuration

* **booking-dependencies**

    Project parent for dependency management
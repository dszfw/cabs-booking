#!/bin/bash
./mvnw clean install
docker build -t booking/database ./booking-database
docker build -t booking/producer-service ./booking-producer-service
docker build -t booking/consumer-service ./booking-consumer-service

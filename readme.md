# RealTime Chat Backend

A **real-time messaging backend** built with **Spring Boot**, **RabbitMQ**, **WebSocket (STOMP)**, and **JWT**.  
This project demonstrates asynchronous messaging, real-time delivery, and persistence in a relational database.

---

## 🚀 Features

- User authentication with **JWT**
- Send and receive messages via **REST API**
- Real-time message delivery with **STOMP over WebSocket**
- Message persistence with **PostgreSQL**
- RabbitMQ **topic/fanout exchanges** for routing messages
- Optional: group chat, typing indicators, read receipts

---

## 🏗️ Tech Stack

- **Backend:** Java 17, Spring Boot
- **Messaging:** RabbitMQ (AMQP)
- **Database:** PostgreSQL + JPA/Hibernate
- **Security:** Spring Security + JWT
- **Realtime:** WebSocket + STOMP
- **Documentation:** Swagger/OpenAPI
- **Build & Deployment:** Maven, Docker

---

## 🗂️ Project Structure

```text
com.realtimechat
├── config
│   ├── rabbitmq
│   │   ├── MessageProducer.java
│   │   ├── MessageConsumer.java
│   │   ├── data/
│   │   │   └── QueueData.java
│   │   └── init/
│   │       ├── ExchangeInit.java
│   │       ├── QueueInit.java
│   │       └── BindingInit.java
│   └── auth/
├── controller/
├── entity/
├── service/
└── repository/
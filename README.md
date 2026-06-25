# Helpdesk — Back-end

REST API for a helpdesk/support ticket system built with **Java**, **Spring Boot**, and **Docker**.

> Front-end repo: [helpdesk-front](https://github.com/andremendoncaolv/helpdesk-front)

---

## Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)

## Features

- Domain-driven design with entity modeling
- RESTful API endpoints for ticket/support management
- Dockerized for easy deployment
- Maven build system with Spring Boot

## How to Run

**Option 1 — Maven**

```bash
git clone https://github.com/andremendoncaolv/helpdesk-back.git
cd helpdesk-back
./mvnw spring-boot:run
```

**Option 2 — Docker**

```bash
docker build -t helpdesk-back .
docker run -p 8080:8080 helpdesk-back
```

API available at `http://localhost:8080`.

## Author

**André Mendonça** — [LinkedIn](https://www.linkedin.com/in/andr%C3%A9-mendon%C3%A7a-301b6338/) · [GitHub](https://github.com/andremendoncaolv)

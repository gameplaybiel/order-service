# Order Service

Microsserviço responsável pela gestão de pedidos no sistema de e-commerce.

## Tecnologias

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA gi(Hibernate)
- PostgreSQL
- RabbitMQ
- Maven

## Funcionalidades

- Criar, consultar e atualizar pedidos
- Comunicação via RabbitMQ para eventos do sistema
- Persistência dos dados no PostgreSQL

## Como rodar localmente

### Pré-requisitos

- Java 17 instalado
- Docker (para PostgreSQL e RabbitMQ)
- Maven

### Passos

1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd order-service

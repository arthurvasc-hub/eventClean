# 📅 EventClean API

Este projeto é uma API RESTful para gerenciamento de eventos, desenvolvida em Java com Spring Boot, utilizando a **arquitetura limpa (Clean Architecture)** para separar as responsabilidades de forma clara e escalável.

## 🧱 Sobre o projeto

A EventClean API permite criar e consultar eventos, com um identificador único gerado automaticamente para cada novo evento. O identificador possui o formato de **3 letras + 3 números**, garantindo unicidade além do `id` gerado pelo banco de dados.

### ✨ Principais funcionalidades

- ✅ Criação de eventos com identificador automático
- 🔍 Busca de eventos por identificador
- 📋 Listagem de todos os eventos cadastrados

## ⚙️ Tecnologias e arquitetura

- Java 17+
- Spring Boot
- Clean Architecture
- Maven
- PostgreSQL (ou outro banco relacional)
- RESTful API

## 🧭 Estrutura de diretórios

src/
└── main/
├── core/ # Camada de domínio (Entidades e Casos de Uso)
├── infra/ # Infraestrutura (Controladores, Mappers, Exceptions, DTOs)
└── EventCleanApplication # Classe principal


## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/eventclean.git
   cd eventclean
2. Configure o application.properties com as credenciais do seu banco de dados.

3. Rode o projeto com sua IDE ou via terminal:
   ```bash
   ./mvnw spring-boot:run
   
🔌 Endpoints disponíveis
Criar um novo evento
POST /api/v1/event

Requisição:
   ```bash
{
  "name": "Workshop de Spring Boot",
  "description": "Aprenda a desenvolver APIs RESTful com Spring Boot.",
  "startOfTheEvent": "2025-11-05T14:00:00",
  "endOfEvent": "2025-11-05T17:00:00",
  "capacity": 50,
  "eventLocation": "Auditório Tech Hub, Curitiba",
  "organizer": "DevCommunity Brasil",
  "eventType": "WORKSHOP"
 }
```
Listar todos os eventos
GET /api/v1/event

Buscar evento por identificador
GET /api/v1/event/{identifier}



🧠 Sobre o identificador automático
Embora o cliente possa informar o identifier manualmente, o sistema pode ser facilmente adaptado para gerar automaticamente um identificador aleatório no formato LLLDDD (ex: ABC123) no momento da criação do evento.

📌 Padrões adotados
DTOs para entrada e saída (camada infra.request e infra.response)

Mappers para conversão entre entidades e DTOs

Validação de dados e tratamento de exceções customizadas

Casos de uso isolados na camada de domínio (core.useCases)

👨‍💻 Autor
Arthur [@arthurvasc-hub]


Sinta-se à vontade para abrir issues ou contribuir com sugestões e melhorias! 🚀

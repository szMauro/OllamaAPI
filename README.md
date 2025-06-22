# 🦙 Ollama API - Spring Boot + Spring AI

This is a simple REST API built with **Spring Boot** and **Spring AI** that integrates with **Ollama**, a local LLM runtime, to generate natural language responses from a selected model (e.g., `tinyllama`, `llama3`, etc.).

## 🛠 Features

- Integration with [Spring AI](https://docs.spring.io/spring-ai/reference/index.html) and [Ollama](https://ollama.com/)
- Exposes a RESTful endpoint to send prompts and receive LLM-generated responses
- Swagger UI documentation
- Input validation and error handling
- Docker and Docker Compose support

---

## 📦 Requirements

- Java 21+
- Maven 3+
- Docker
- Git

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/ollama_api.git
cd ollama_api
```

### 2. Pull an Ollama model

You must have Ollama installed or use the Docker container.

Example (inside a Docker container):
```bash
docker exec -it ollama ollama pull tinyllama
```

Or change the model in application.properties:
```properties
ollama.model=llama3
```

Then:
```bash
docker exec -it ollama ollama pull llama3
```

### 3. Start the app using Docker Compose

```bash
docker-compose up --build
```

The API will be available at:
📍 http://localhost:8080/api/v1/generate

Swagger UI at:
📘 http://localhost:8080/swagger-ui.html

---

## 🧪 Example Request

POST /api/v1/generate
```json
{
  "promptMessage": "Tell me a joke about computers."
}
```
Optional query param: raw=true will return the full response object.

---

## 🧰 Tech Stack
    Java 21
    Spring Boot 3.5
    Spring AI 1.0
    Ollama (LLM Runtime)
    Swagger / OpenAPI
    Docker

---

## 📂 Project Structure

```text
src/
├── controller/
├── service/
├── dto/
├── exceptions/
└── main/
```

## ⚠️ Notes
* Make sure the selected model is already pulled by Ollama before calling the API.
* If you get a 404 - model not found, run ollama pull <model> inside the ollama container.

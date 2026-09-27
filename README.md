<div align="center">

# 🚀 App Grupo 5 Consumidor RabbitMQ

### Sistema de procesamiento y ordenamiento de números mediante mensajería distribuida

<p>
  <img src="https://img.shields.io/badge/Java-25-orange?logo=openjdk" alt="Java 25">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/RabbitMQ-3.13-ff6600?logo=rabbitmq" alt="RabbitMQ">
  <img src="https://img.shields.io/badge/Grupo-5-blue" alt="Grupo 5">
</p>

</div>

---

## 📌 Descripción

Este proyecto corresponde al *consumidor RabbitMQ* de la evaluación T1 del curso *Desarrollo de Aplicaciones Web II – Cibertec*.

El sistema recibe una cadena de números enteros, la convierte en un arreglo, espera 20 segundos y aplica el algoritmo *Merge Sort* para mostrar la lista ordenada.



## 🧰 Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 25 |
| Spring Boot | 4.1.1 |
| Spring Cloud | 2025.1.3 |
| RabbitMQ | 3.13 |
| Maven | 3.9+ |

## 🐇 Configuración RabbitMQ

| Elemento | Valor |
|---|---|
| Queue | Grupo5Queue |
| Exchange | Grupo5Exchange |
| Routing Key | Grupo5Routing |
| Host | localhost |
| Puerto | 5672 |
| Usuario | guest |
| Contraseña | guest |

## ▶️ Ejecución

### 1. Iniciar RabbitMQ

Desde el repositorio del productor:

bash
docker compose up -d


### 2. Ejecutar el consumidor

bash
mvn spring-boot:run


El consumidor estará disponible en:

text
http://localhost:8082


## 🧪 Prueba del flujo completo

Con el productor ejecutándose en el puerto 8081, realiza esta petición:

cmd
curl "http://localhost:8081/api/numbers?numbers=9%3B3%3B15%3B1%3B8"


El productor responderá:

text
Lista enviada a RabbitMQ correctamente.


Después de 20 segundos, el consumidor mostrará:

text
Lista ordenada: [1, 3, 8, 9, 15]


## 🧩 Componentes principales

### NumberParserService

Se encarga de:

- Separar los números usando ;.
- Eliminar espacios innecesarios.
- Convertir los valores a Integer.
- Rechazar valores vacíos o no numéricos.

### NumbersListener

Escucha los mensajes enviados a Grupo5Queue, utiliza el parser y coordina el procesamiento de la lista.

### MergeSortService

Implementa el algoritmo *Merge Sort* para ordenar los números recibidos.

## ✅ Pruebas unitarias

Ejecutar:

bash
mvn test


Las pruebas verifican:

- Conversión correcta de números.
- Manejo de espacios.
- Cadenas vacías.
- Valores null.
- Valores no numéricos.

## 📁 Estructura principal

text
src
├── main
│   ├── java
│   │   └── pe.cibertec.grupo5.consumidor
│   │       ├── config
│   │       ├── listener
│   │       └── service
│   └── resources
└── test
    └── java
        └── pe.cibertec.grupo5.consumidor.service


## 👥 Aporte del equipo Grupo 5

- Configuración de RabbitMQ.
- Implementación del consumidor.
- Implementación del algoritmo Merge Sort.
- Creación de NumberParserService.
- Desarrollo de pruebas unitarias.
- Integración y validación del flujo productor-consumidor.

---

<div align="center">

### 💙 Grupo 5 — Desarrollo de Aplicaciones Web II

</div>

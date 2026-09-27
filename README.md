# Consumidor RabbitMQ - Grupo 5

## Descripción

Este proyecto implementa el consumidor RabbitMQ correspondiente a la evaluación T1 del curso *Desarrollo de Aplicaciones Web II – Cibertec*.

El consumidor recibe una cadena de números enteros desde RabbitMQ, la convierte en un arreglo Integer[], espera 20 segundos y aplica el algoritmo *Merge Sort* para mostrar la lista ordenada en los registros de la aplicación.

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 25 |
| Spring Boot | 4.1.1 |
| Spring Cloud | 2025.1.3 |
| Spring AMQP | Compatible con Spring Boot |
| RabbitMQ | 3.13 |
| Maven | 3.9+ |
| Docker Compose | 2.x |

## Arquitectura del flujo

text
Productor REST
      |
      v
RabbitMQ Exchange: Grupo5Exchange
      |
      v
Queue: Grupo5Queue
      |
      v
NumbersListener
      |
      v
NumberParserService
      |
      v
Espera de 20 segundos
      |
      v
MergeSortService
      |
      v
Lista ordenada en los logs


## Configuración de RabbitMQ

| Elemento | Valor |
|---|---|
| Queue | Grupo5Queue |
| Exchange | Grupo5Exchange |
| Routing Key | Grupo5Routing |
| Tipo de Exchange | Direct |
| Host | localhost |
| Puerto | 5672 |
| Usuario | guest |
| Contraseña | guest |

## Requisitos

Antes de ejecutar el proyecto, es necesario tener instalado:

- Java 25.
- Maven 3.9 o superior.
- Docker Desktop.
- Acceso al repositorio del productor.

## Ejecución

### 1. Iniciar RabbitMQ

Desde el repositorio del productor:

bash
docker compose up -d


Verificar que el contenedor esté activo:

bash
docker compose ps


El panel de administración de RabbitMQ estará disponible en:

text
http://localhost:15672


Credenciales:

text
Usuario: guest
Contraseña: guest


### 2. Ejecutar el consumidor

Desde la carpeta raíz de este proyecto:

bash
mvn spring-boot:run


El consumidor funciona como un listener de RabbitMQ y no expone endpoints REST.

## Prueba del flujo completo

Con RabbitMQ y el consumidor ejecutándose, iniciar también el productor y realizar la siguiente petición desde Windows CMD:

cmd
curl "http://localhost:8081/api/numbers?numbers=9%3B3%3B15%3B1%3B8"


Respuesta del productor:

text
Lista enviada a RabbitMQ correctamente.


Después de aproximadamente 20 segundos, el consumidor mostrará en los logs:

text
Lista ordenada: [1, 3, 8, 9, 15]


## Componentes principales

### RabbitMqConfig

Define la cola, el exchange, la clave de enrutamiento y la relación entre estos componentes.

### NumbersListener

Escucha los mensajes enviados a Grupo5Queue, recibe la cadena de números y coordina el procesamiento.

### NumberParserService

Se encarga de:

- Separar los números utilizando ;.
- Eliminar espacios innecesarios.
- Convertir los valores a Integer.
- Rechazar cadenas vacías.
- Rechazar valores nulos.
- Rechazar valores no numéricos.

### MergeSortService

Implementa el algoritmo Merge Sort para ordenar los números recibidos.

## Pruebas unitarias

Ejecutar:

bash
mvn test


Las pruebas verifican:

- Conversión correcta de cadenas numéricas.
- Manejo de espacios.
- Rechazo de valores vacíos.
- Rechazo de valores nulos.
- Rechazo de valores no numéricos.




## Contribuciones del equipo

- Configuración de RabbitMQ.
- Implementación del consumidor.
- Implementación del algoritmo Merge Sort.
- Desarrollo de NumberParserService.
- Creación de pruebas unitarias.
- Integración y validación del flujo productor-consumidor.

## Detener RabbitMQ

Cuando finalicen las pruebas, detener los servicios desde el repositorio del productor:

bash
docker compose down


## Grupo 5

Desarrollo de Aplicaciones Web II  
Cibertec

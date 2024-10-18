# API CRUD Reactiva con Spring WebFlux y PostgreSQL

Este proyecto es una **API CRUD Reactiva** desarrollada utilizando **Spring WebFlux** y **PostgreSQL** como base de datos. La aplicación sigue una arquitectura no bloqueante y orientada a eventos, lo que permite manejar una gran cantidad de solicitudes concurrentes de manera eficiente.

## Características

- **Programación Reactiva**: Desarrollada con Spring WebFlux para gestionar operaciones asincrónicas y no bloqueantes, mejorando el rendimiento y la escalabilidad.
- **Operaciones CRUD**: Crear, Leer, Actualizar y Eliminar datos de una entidad.
- **Integración con PostgreSQL**: Utiliza PostgreSQL como base de datos relacional para persistir los datos.
- **Repositorio Reactivo**: Se utiliza `R2dbcRepository` de Spring Data para interacciones reactivas con la base de datos.
- **Respuestas en Streaming**: Respuesta de datos en tiempo real gracias a WebFlux, asegurando tiempos de respuesta rápidos.

## Tecnologías Utilizadas

- **Spring Boot**: Para la configuración de la aplicación y gestión de dependencias.
- **Spring WebFlux**: Para habilitar la programación reactiva y construir una API no bloqueante.
- **Spring Data R2DBC**: Para la conectividad reactiva con bases de datos relacionales como PostgreSQL.
- **PostgreSQL**: Como base de datos relacional para el almacenamiento de entidades.
- **Project Reactor**: Para el procesamiento asincrónico y orientado a eventos.
- **Docker**: Configuración disponible para ejecutar PostgreSQL en un contenedor.

## Requisitos Previos

- **Java 17**
- **Maven 3.x**
- **PostgreSQL** (localmente o a través de Docker)

## Ejecutar Localmente

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-repositorio/reactive-crud-webflux
    ```

2. Configura PostgreSQL localmente o usa Docker:
    ```bash
    docker-compose up
    ```

3. Ejecuta la aplicación con Maven:
    ```bash
    mvn spring-boot:run
    ```

## Endpoints

- `GET /cars/` - Obtener todas las entidades de tipo coche.
- `POST /cars/` - Crear una nueva entidad de tipo coche.
- `GET /cars/{id}` - Obtener un coche por ID.
- `PUT /cars/{id}` - Actualizar un coche existente.
- `DELETE /cars/{id}` - Eliminar un coche por ID.

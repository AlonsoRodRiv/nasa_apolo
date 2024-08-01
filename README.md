# NASA Backend Java

Este proyecto es una prueba técnica para la posición de Desarrollador Backend Junior en ORIGENCORP. La prueba consiste en desarrollar un aplicacion que consuma datos de una API de la NASA y los almacene en una base de datos, además de proporcionar una API para acceder a esos datos.

## Requisitos

- Java 17 o Superior
- PostgreSQL
- PGADMIN o tu cliente de base de datos favorito
- POSTMAN o tu cliente API favorito
- Spring Tool Suite 4 (recomendado) o tu IDE favorito
- GIT
- Spring Boot 3

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/AlonsoRodRiv/nasa_apolo.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd NasaApolo
    ```
3. Configura la base de datos PostgreSQL y actualiza el archivo `application.properties` con tus credenciales de base de datos.
4. Compila y ejecuta el proyecto:
    ```bash
    ./mvnw spring-boot:run
    ```

## Estructura del Proyecto

El proyecto sigue la arquitectura hexagonal y DDD (Domain-Driven Design). Los paquetes principales son:

- **clienterest**: Código para consumir el servicio externo de la NASA.
- **dto**: Modelos de datos.
- **services**: Logica del Negocio de la App.
- **entities**: Clases que representan las tablas de la base de datos.
- **config**: Configuracion de la app.
- **repository**: Código para la persistencia de datos.
- **restcontroller**: Controladores y APIs que serán consumidas por POSTMAN.
- **taskscheduler**: Código para ejecutar tareas automáticas de forma asíncrona.

## Objetivos

1. Desarrollar un aplicativo que ejecute una tarea automática cada minuto y consuma datos de la API de la NASA, almacenándolos en la base de datos.
2. Desarrollar una API que permita consumir los datos almacenados y mostrarlos en un cliente como POSTMAN.

## Uso

1. Ejecuta el proyecto.
2. Utiliza POSTMAN para consumir la API y verificar los datos almacenados.
3. Obtener los resultados en base de datos: `http://localhost:8080/data`
4. Buscar por nombre : `http://localhost:8080/search/apolo 11`


## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.


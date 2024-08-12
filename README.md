# Proyecto de Microservicios con Spring Boot, Eureka

Este proyecto contiene varios microservicios que se comunican entre sí utilizando Spring Boot, Eureka para el registro de servicios y Zuul como puerta de enlace (gateway).

## Instrucciones de configuración

1. **Eureka Server (Registro de Servicios)**
    - Ve al directorio `servicio-eureka-server`.
    - Ejecuta el siguiente comando para iniciar el servidor Eureka:
      ```
      docker-compose up -d
      ```

2. **Clientes Servicio**
    - Asegúrate de que el servidor Eureka esté en funcionamiento.
    - Ve al directorio `servicio-clientes`.
    - Ejecuta el microservicio de clientes.

3. **Cuentas Servicio**
    - Asegúrate de que el servidor Eureka esté en funcionamiento.
    - Ve al directorio `servicios-cuentas`.
    - Ejecuta el microservicio de cuentas.

4. **Gateway (Zuul)**
    - Asegúrate de que los otros microservicios estén en funcionamiento.
    - Ve al directorio `gateway`.

## Acceso a la aplicación

Una vez que todos los servicios estén en funcionamiento, puedes acceder a la aplicación a través de la siguiente URL:

http://localhost:8090/


¡Listo! Ahora deberías tener tu entorno de microservicios configurado y funcionando correctamente. Si encuentras algún problema, no dudes en preguntar. 😊



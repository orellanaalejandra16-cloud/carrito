# CarritoGT - Proyecto Integrador (PHP a Spring Boot API REST)

Proyecto desarrollado para el curso de **Programación II** de la Facultad de Ingeniería en Sistemas de Información y Ciencias de la Computación[cite: 82].

## Descripción del Proyecto
CarritoGT es una aplicación web estructurada en dos fases:
1. **Fase 1:** Backend en PHP 7 orientado a objetos ejecutado en un entorno virtualizado Linux (Lubuntu) con Apache y MySQL, utilizando un Virtual Host[cite: 88, 91].
2. **Fase 2:** Migración del backend hacia una arquitectura monolítica por capas (`Controller`, `Service`, `Repository`, `Entity`) utilizando **Spring Boot (Java 17)**, manteniendo la persistencia en MySQL y desacoplando el frontend mediante peticiones asíncronas con JavaScript (`fetch`)[cite: 88, 93].

---

## Tecnologías Utilizadas
* **Backend:** Java 17, Spring Boot (Spring Data JPA, Web, Test), Maven[cite: 75, 83].
* **Base de Datos:** MySQL / MariaDB[cite: 91].
* **Frontend:** HTML5, CSS3, JavaScript (Vanilla / Fetch API)[cite: 91, 94].
* **Pruebas Automatizadas:** JUnit 5 y Mockito[cite: 83].
* **Control de Versiones:** Git[cite: 88].

---

## Estructura de Capas (Spring Boot)
* `com.carrito.carrito.controller`: Controladores REST expuestos (`/api/products`, `/api/cart`)[cite: 22, 25].
* `com.carrito.carrito.service`: Lógica de negocio de la tienda y el carrito[cite: 86].
* `com.carrito.carrito.repository`: Interfaces de Spring Data JPA para la persistencia[cite: 75].
* `com.carrito.carrito.entity`: Clases modelo mapeadas a las tablas de la base de datos (`Product`, `CartItem`)[cite: 75, 91].

---

## Instrucciones de Ejecución (Fase 2 - Spring Boot)

### Requisitos Previos
* JDK 17 instalado[cite: 83].
* Servidor MySQL ejecutándose localmente con la base de datos configurada[cite: 91].

### Pasos de Configuración y Ejecución
1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd carrito
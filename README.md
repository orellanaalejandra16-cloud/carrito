### CarritoGT - Proyecto Integrador (PHP a Spring Boot API REST)

Proyecto desarrollado para el curso de Programación II de la Facultad de Ingeniería en Sistemas de Información y Ciencias de la Computación[cite: 5, 8, 12].

#### Descripción del proyecto
CarritoGT es una tienda en línea desarrollada en dos fases acumulativas[cite: 11, 14]:
1. **Fase 1:** Backend en PHP 7 orientado a objetos corriendo sobre un entorno virtualizado Linux (Lubuntu) con servidor Apache (XAMPP/LAMP), MySQL y Virtual Host personalizado (`carrito-compra.localhost`)[cite: 12, 14, 16].
2. **Fase 2:** Migración y reestructuración hacia una API REST monolítica con **Spring Boot (Java 17)** organizada en capas (`Controller`, `Service`, `Repository`, `Entity`)[cite: 10, 14, 17]. Se mantiene la persistencia en MySQL y se desacopla el frontend consumiendo endpoints JSON mediante JavaScript asíncrono (`fetch`)[cite: 14, 17].

---

#### Tecnologías utilizadas
- **Backend:** Java 17, Spring Boot, Maven[cite: 6, 13, 14].
- **Base de datos:** MySQL / MariaDB[cite: 14, 17].
- **Frontend:** HTML5, CSS3, JavaScript (Vanilla / Fetch API)[cite: 6, 17].
- **Pruebas automatizadas:** JUnit 5 y Mockito[cite: 6].
- **Control de versiones:** Git[cite: 13, 14].

---

#### Estructura de capas (Spring Boot)
- `com.carrito.carrito.controller`: Manejo de endpoints HTTP y peticiones JSON (`/api/products`, `/api/cart`)[cite: 15, 17].
- `com.carrito.carrito.service`: Reglas y lógica de negocio del carrito de compras[cite: 9, 17].
- `com.carrito.carrito.repository`: Interfaces JPA para comunicación con la base de datos[cite: 15, 17].
- `com.carrito.carrito.entity`: Clases modelo que mapean las tablas relacionales (`Product`, `CartItem`)[cite: 17].

---

#### Instrucciones de ejecución

##### Requisitos previos
- JDK 17 o superior instalado[cite: 6].
- Servidor MySQL/MariaDB activo con el script de base de datos importado[cite: 14, 17].

##### Pasos de instalación y despliegue
1. Clonar el repositorio desde la terminal:
   ```bash
   git clone [https://github.com/orellanaalejandra16-cloud/carrito.git](https://github.com/orellanaalejandra16-cloud/carrito.git)
   cd carrito
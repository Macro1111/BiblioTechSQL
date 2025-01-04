# BiblioTechSQL

BiblioTechSQL es una aplicación basada en Java y Spring Boot que permite gestionar información de libros y autores, interactuando con una base de datos relacional y una API externa. Este proyecto proporciona funcionalidades como búsqueda, almacenamiento, y análisis de datos sobre libros y autores.

## Características

- **Buscar libros por nombre:** Consulta libros en la base de datos local o a través de la API externa Gutendex.
- **Listar libros y autores:** Muestra todos los registros de libros y autores en la base de datos.
- **Filtrar autores vivos por año:** Encuentra autores vivos en un año específico.
- **Buscar libros por idioma:** Filtra libros según su idioma (Español, Inglés, Portugués).
- **Persistencia en base de datos:** Guarda y gestiona datos de libros y autores en una base de datos SQL.

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Hibernate (JPA)**
- **Jakarta Transactions**
- **PostgreSQL**
- **Gutendex API** (para búsqueda externa)
- **Maven**

---

## Requisitos previos

1. **Java Development Kit (JDK)** versión 17 o superior.
2. **PostgreSQL** como base de datos relacional.
3. **Maven** para gestionar las dependencias del proyecto.
4. Conexión a internet para acceder a la API externa.

---

## Configuración

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/BiblioTechSQL.git
   cd BiblioTechSQL
   ```

2. Configura la base de datos en el archivo `application.properties`:
   ```properties
   No olvides definir las variables de entorno
   spring.application.name=biblioTechSQL
    spring.datasource.url = jdbc:postgresql://${DB_HOST}/marco_biblioTech //recueda cambiar marco_biblioTech por el nombre de tu base de datos en postgres
    spring.datasource.username = ${DB_USER}
    spring.datasource.password = ${DB_PASSWORD}
    spring.datasource.driver-class-name = org.postgresql.Driver
    hibernate.dialect = org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto = update

   ```

3. Asegúrate de que la base de datos `bibliotech` esté creada:
   ```sql
   CREATE DATABASE bibliotech;
   ```

4. Compila y ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

---

## Uso

Al ejecutar la aplicación, aparecerá un menú interactivo en la consola con las siguientes opciones:

1. **Buscar un libro específico:** Ingresa el nombre del libro para buscarlo en la base de datos o en Gutendex.
2. **Lista de libros:** Muestra todos los libros almacenados en la base de datos.
3. **Lista de autores:** Muestra todos los autores y sus libros correspondientes.
4. **Autores vivos por año:** Ingresa un año para listar los autores que estaban vivos en ese periodo.
5. **Libros por idioma:** Selecciona un idioma (Español, Portugués o Inglés) para filtrar libros por idioma.

---

## Estructura del proyecto

- **`principal`**: Contiene el punto de entrada de la aplicación y la lógica del menú.
- **`service`**: Contiene la lógica de negocio y las operaciones relacionadas con libros y autores.
- **`model`**: Clases que representan las entidades de la base de datos.
- **`repository`**: Interfaces para la interacción con la base de datos utilizando JPA.

---

## Contribuir

1. Haz un fork del repositorio.
2. Crea una nueva rama para tus cambios:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y súbelos al fork:
   ```bash
   git commit -m "Descripción de los cambios"
   git push origin feature/nueva-funcionalidad
   ```
4. Abre un pull request en el repositorio principal.

---

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---



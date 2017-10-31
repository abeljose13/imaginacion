# imaginacion
Demo project 

- Entorno de desarrollo:
	
	- Sistema operativo: Linux Debian Jessie
	- JDK: 1.8
	- MySQL Server: 5.5
	- MySQL Workbench: 6.3.6
	- Spring Boot: 1.5.2.RELEASE
	- Maven: 3.3.9
	- Git: 2.8.0
	- IDE Spring Tool Suite: 3.8.3
	- Swagger2: 2.3.0
	- Postman: 5.1.3


- Pasos para correr el poryecto: 
(Se asume que estan previamnete instaladas las herramientas minimas basicas: JDK, Maven, MySQL Server, Git y Postman)

	- Clonar el codigo del proyecto desde github a un directorio local:

		$ glit clone https://github.com/abeljose13/imaginacion.git


	- Crear un esquema de base de datos MySQL:

		$ CREATE SCHEMA `imaginaciondb` DEFAULT CHARACTER SET utf8;


	- Desde la raiz del proyecto:

		$ cd imaginacion/

		$ mvn clean install


	- Arrancar el proyecto:

		$ mvn spring-boot:run


	- Importar Postman collection:

		- Importar a Postman el archivo: Imaginacion.postman_collection.json desde la ruta: imaginacion/src/test/postman


	- Acceder a Swagger:

		http://localhost:8080/imaginacion/swagger-ui.html


	- Nota: Una vez creado el esquema de datos al arrancar el proyecto por primera vez, modificamos
  la propiedad "spring.jpa.hibernate.ddl-auto" en el archivo application.properties al valor: "update"
  

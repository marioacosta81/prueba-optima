# prueba-optima
prueba para Optima

Explicacion de la solucion

Se desarrollaron los siguientes 3 proyectos Maven:

1. optima-commos:
Es un alibreria y se utiliza para centralizar artefactos comunes, como por ejemplo: las Excepciones

2. optima-persistence:
Es un microservicio que guarda la informacion ingresada por el usuario 
El microservicio utiliza Spring Data JPA, Spring Web, base de datos H2, 
El microservicio expone un endpoint rest que le permite recibir peticiones de guardado
La base de datos H2 está embebida en el microservicio y permite mayor portabilidad, facilitando la prueba al evitar instalar motores de bases de dtaos
La base de datos H2 es volatil y se borra cada vez que se da de baja el microservicio. 
La base de datos H2 expone una consola web que permite validar la persistencia de los datos
La URL de la consola de la base de datos H2 es : http://localhost:9294/h2-console . Debe estar arriba el microservicio 
El microservicio se ejecuta por el puerto: 9294
El microservicio implementa una arquitectura multicapas
El microservicio implemnta control de excepciones

3. optima-view:
Es un microservicio contiene vistas que permite la interfaz de usuario final 
El microservicio utiliza Spring Web, Spring Web MVC, Thymeleaf y valicaiones con JQuery 
El microservicio lista la consulta del endpoint (https://api.coingecko.com/api/v3/coins/list?include_platform=true) .
El microservicio lista la consulta de manera paginada
El microservicio permite el ingreso de datos para el guardado
El microservicio se comunica con el microserviucio de optima-persistencia via rest
El microservicio requiere que el microserviucio de optima-persistencia se este ejecutando
El microservicio se ejecuta por el puerto: 9293
El microservicio implementa una arquitectura multicapas
El microservicio implemnta control de excepciones

GitHub
los microservicios son compartidos en GitHub en el siguiente link:



Ejecucion:

Para la correcta ejecución de los microservicios se deben ejecutar los siguientes comando por consola en la ruta donde se encuentra el archivo POM de cada uno de los microservicios

1. constriur libreria commons. Ejemplo:
workSpace\optima-commons>mvn clean install -e
 
2. constriur microservicio de persistencia. Ejemplo:
workSpace\optima-persistence>mvn clean install -e

3. ejecutar microservicio de persistencia. Ejemplo:
workSpace\optima-persistence>java -jar target\optima-persistence-0.0.1-SNAPSHOT.jar
 
4. constriur microservicio de vista. Ejemplo:
workSpace\optima-view>mvn clean install -e

5. ejecutar microservicio de vista. Ejemplo:
workSpace\optima-view>java -jar target\optima-view-0.0.1-SNAPSHOT.jar


6. Despues de tener arriba los microservicios se ingresa por navegador al siguiente link:
http://localhost:9293/list



Muchas gracias por la atención prestada

# Desafio-java-muruna
Desafio para muruna de Gonzalo Quintana

# README

## Instrucciones de Construcción y Ejecución del Proyecto

### 1. Crear el archivo Jar

Para construir el archivo JAR del proyecto, ejecuta el siguiente comando en la línea de comandos:

```
gradle clean build
```

El archivo JAR generado estará en el directorio **_target_** con un nombre similar a demo-[VERSION].jar.

### 2. Despliegue en el Servidor

Para Deplegar el servicio, ejecuta el siguente comando en la línea de comandos:

```
java -jar target/demo-[VERSION].jar
```

### 3. Acceder a la Aplicación

Abre Postman y accede a la siguiente ruta: **_localhost:9090/_**.

### 4. Endpoints Disponibles

Los endpoints disponibles son:

- localhost:9090/auth/login (POST): Utilizado para obtener el Token que se utilizará para los siguientes servicios.
En donde se ejecutará el body de la siguiente manera:
{
    "username": "jperez@muruna.com",
    "password": "Password24"
}

- localhost:9090/auth/findAllUsers (GET): obtiene el listado de usuarios
- localhost:9090/auth/createuser (POST):  para generar un nuevo usuario. De la siguiente manera:
  {
    "nombre": "Po Panda",
    "correo": "popasd@muruna.com",
    "password": "Password14",
    "phones": [
          {
          "number": "7649938",
          "cityCode": "1",
          "countryCode": "+562"
          }
    ]

  }
- localhost:9090/auth/modifyUser (PATCH):  para Modificar un usuario. De la siguiente manera:
  {
  "nombre": "Po Panda",
  "correo": "popasd@muruna.com",
  "password": "Password12",
  "phones": [
  {
  "number": "88993472",
  "cityCode": "1",
  "countryCode": "+562"
  }
  ]
}
- localhost:9090/auth/deleteUser/{idUsuario} (DELETE):  para eliminar un usuario. Como en el siguiente ejemplo:
  localhost:9090/auth/deleteUser/2


## Sobre la Aplicacion:

### Base de Datos

Al momento de correr la aplicación, se crea una base de datos en memoria [h2](http://localhost:8080/h2-console), cuya
credenciales son:

```
username=gq
password=12345
```

Las tablas de esta aplicación son:

- **USUARIOS**
  ~~~
  ID NUMERIC AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    CORREO VARCHAR(255) NOT NULL,
    USERNAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    FECHA_CREACION DATETIME NOT NULL,
    FECHA_ACTUALIZACION DATETIME,
    ULTIMO_INGRESO DATETIME,
    USUARIO_ACTIVO BOOLEAN
  ~~~

  Tabla que contiene los usuarios de la Aplicación cuya password se guarda encriptada.


- **PHONES**
  ~~~
  ID_PHONES NUMERIC AUTO_INCREMENT PRIMARY KEY,
  NUMBER VARCHAR(255) NOT NULL ,
  CITY_CODE VARCHAR(5) NOT NULL,
  COUNTRY_CODE VARCHAR(5),
  ID_USUARIO NUMERIC,
  FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID)
  ~~~

  Tabla que contiene los Telefonos disponible para los usuarios.

### Security

La aplicación tiene una capa de seguridad con Spring Security utilizando JWT.


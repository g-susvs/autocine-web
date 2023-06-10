# Autocine-web

## Configuración

Crear un archivo **application.properties** en la ruta **src/main/resources**

En esa carpeta existe un archivo de ejemplo con todos los valores que debe tener application.properties

```properties
# example.application.properties
# crear base de datos autocine

spring.output.ansi.enabled=ALWAYS

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
```

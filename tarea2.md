# Tarea 2

## Sección 1: Introducción a Servicios en Quarkus

@ApplicationScoped es una anotación en Quarkus que indica que un bean o servicio debe ser único y compartido a lo largo de toda la aplicación. Esto significa que solo una instancia del bean será creada y reutilizada durante el ciclo de vida completo de la aplicación. Es útil para servicios que deben mantener un estado global o compartido.
**¿Qué es @ApplicationScoped en Quarkus?**

**¿Cómo funciona la inyección de dependencias en Quarkus?**

**¿Cuál es la diferencia entre @ApplicationScoped, @RequestScoped, y @Singleton en Quarkus?**

**¿Cómo se define un servicio en Quarkus utilizando @ApplicationScoped?**

**¿Por qué es importante manejar correctamente los alcances (scopes) en Quarkus al crear servicios?**

## Sección 2: Creación de un ApiResponse Genérico

**¿Qué es un ApiResponse genérico y cuál es su propósito en un servicio REST?**

**¿Cómo se implementa una clase ApiResponse genérica en Quarkus?**

**¿Cómo se modifica un recurso REST en Quarkus para que utilice un ApiResponse genérico?**

**¿Qué beneficios ofrece el uso de un ApiResponse genérico en términos de mantenimiento y consistencia de código?**

**¿Cómo manejarías diferentes tipos de respuestas (éxito, error, etc.) utilizando la clase ApiResponse?**

## Sección 3: Integración y Buenas Prácticas

**¿Qué consideraciones se deben tener al inyectar servicios en un recurso REST en Quarkus?**

**¿Cómo se pueden manejar excepciones en un servicio REST utilizando ApiResponse?**

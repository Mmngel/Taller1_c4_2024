# Conceptos Fundamentales

## ¿Qué es un servicio REST?
Un servicio REST (Representational State Transfer) es una arquitectura para diseñar servicios web que permite la comunicación entre sistemas utilizando el protocolo HTTP. REST se basa en recursos y utiliza métodos estándar de HTTP para realizar operaciones sobre ellos.

## ¿Cuáles son los principios del diseño RESTful?
Los principios del diseño RESTful incluyen:
- **Identificación de recursos**: Los recursos se identifican mediante URIs.
- **Representación de recursos**: Los recursos pueden representarse en diferentes formatos como JSON, XML, etc.
- **Interacción a través de interfaces estándar**: Se utilizan métodos HTTP estándar (GET, POST, PUT, DELETE).
- **Sin estado**: Cada solicitud del cliente al servidor debe contener toda la información necesaria para entender y procesar la solicitud.
- **Caché**: Las respuestas deben indicar si pueden ser almacenadas en caché.
- **Sistema en capas**: La arquitectura REST debe permitir el uso de capas de intermediarios entre el cliente y el servidor.

## ¿Qué es HTTP y cuáles son los métodos HTTP más comunes?
HTTP (Hypertext Transfer Protocol) es un protocolo utilizado para la transferencia de datos a través de la web. Los métodos HTTP más comunes son:
- **GET**: Recupera un recurso.
- **POST**: Envía datos al servidor para crear un nuevo recurso.
- **PUT**: Actualiza un recurso existente.
- **DELETE**: Elimina un recurso existente.

## ¿Qué es un recurso en el contexto de un servicio REST?
Un recurso en un servicio REST es cualquier dato o entidad que se puede identificar y manipular, como un usuario, un producto, un artículo, etc. Los recursos se representan a través de URIs y se manipulan utilizando métodos HTTP.

## ¿Qué es un endpoint?
Un endpoint es una URL específica en un servidor que representa un recurso o una colección de recursos. Es el punto de acceso al servicio REST donde se pueden realizar operaciones.

# Estructura de un Servicio REST

## ¿Qué es un URI y cómo se define?
Un URI (Uniform Resource Identifier) es una cadena de caracteres que identifica de manera única un recurso en la web. Un URI se define utilizando un esquema (como `http` o `https`), seguido de un nombre de dominio y un camino que apunta al recurso específico.

## ¿Qué es una API RESTful?
Una API RESTful es una interfaz de programación de aplicaciones que sigue los principios de la arquitectura REST. Permite que diferentes sistemas se comuniquen entre sí mediante operaciones HTTP sobre recursos representados como URIs.

## ¿Qué son los códigos de estado HTTP y cómo se usan en REST?
Los códigos de estado HTTP son respuestas estándar emitidas por el servidor para indicar el resultado de una solicitud HTTP. En REST, estos códigos se utilizan para informar al cliente si la operación solicitada fue exitosa, si hubo un error, o si se requiere alguna acción adicional.

### Códigos de Estado HTTP Comunes

| Código | Significado                       |
|--------|-----------------------------------|
| 200    | OK - La solicitud se completó con éxito. |
| 201    | Created - Se creó un nuevo recurso. |
| 204    | No Content - La solicitud fue exitosa, pero no hay contenido para enviar en la respuesta. |
| 400    | Bad Request - La solicitud es incorrecta o no se puede procesar. |
| 401    | Unauthorized - Autenticación requerida o fallida. |
| 403    | Forbidden - El servidor entiende la solicitud, pero se niega a autorizarla. |
| 404    | Not Found - El recurso solicitado no se encuentra. |
| 500    | Internal Server Error - Ocurrió un error en el servidor. |

## ¿Qué es JSON y por qué se usa comúnmente en APIs REST?
JSON (JavaScript Object Notation) es un formato ligero de intercambio de datos, fácil de leer y escribir para humanos, y fácil de parsear y generar para las máquinas. Es ampliamente utilizado en APIs REST debido a su simplicidad, eficiencia y capacidad de representar estructuras de datos complejas.

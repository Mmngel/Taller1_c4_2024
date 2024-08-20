# Tarea 2

## Sección 1: Introducción a Servicios en Quarkus

**¿Qué es @ApplicationScoped en Quarkus?**
@ApplicationScoped es una anotación en Quarkus que indica que un bean o servicio debe ser único y compartido a lo largo de toda la aplicación. Esto significa que solo una instancia del bean será creada y reutilizada durante el ciclo de vida completo de la aplicación. Es útil para servicios que deben mantener un estado global o compartido.

**¿Cómo funciona la inyección de dependencias en Quarkus?**
La inyección de dependencias en Quarkus se basa en el estándar CDI (Contexts and Dependency Injection). Utiliza anotaciones como @Inject para inyectar beans en clases que los necesitan. Quarkus se encarga de resolver las dependencias y proporcionar las instancias adecuadas en tiempo de ejecución, permitiendo que los desarrolladores se centren en la lógica de negocio sin preocuparse por la creación y gestión manual de dependencias.

**¿Cuál es la diferencia entre @ApplicationScoped, @RequestScoped, y @Singleton en Quarkus?**
@ApplicationScoped: Define un bean con un único ciclo de vida que dura toda la vida de la aplicación. Es similar a un singleton pero gestionado por el contenedor CDI.
@RequestScoped: Define un bean que se crea y se destruye con cada solicitud HTTP. Es útil para manejar datos específicos de una única solicitud.
@Singleton: Similar a @ApplicationScoped, pero gestionado directamente por el contenedor de la aplicación (como EJB o JAX-RS). Un bean con esta anotación es único dentro de la JVM y se utiliza a lo largo de toda la aplicación.

**¿Cómo se define un servicio en Quarkus utilizando @ApplicationScoped?**
Para definir un servicio en Quarkus utilizando @ApplicationScoped, se debe crear una clase anotada con @ApplicationScoped. Luego, el servicio puede ser inyectado en otras partes de la aplicación utilizando la anotación @Inject. 

Por ejemplo:
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MiServicio {
    public String procesar() {
        return "Servicio Procesado";
    }
}

**¿Por qué es importante manejar correctamente los alcances (scopes) en Quarkus al crear servicios?**
Manejar correctamente los alcances (scopes) en Quarkus es crucial para asegurar que los beans tengan el ciclo de vida adecuado según su uso previsto. Si no se elige el alcance correcto, se puede incurrir en problemas de concurrencia, consumo innecesario de recursos o fallos en la lógica de la aplicación debido a la reutilización inapropiada de estados entre solicitudes o usuarios. Además, gestionar correctamente los scopes puede mejorar el rendimiento de la aplicación al evitar la creación innecesaria de instancias.

## Sección 2: Creación de un ApiResponse Genérico

**¿Qué es un ApiResponse genérico y cuál es su propósito en un servicio REST?**
Un ApiResponse genérico es una clase de contenedor que encapsula la respuesta de un servicio REST. Su propósito es estandarizar la estructura de las respuestas devueltas por el servicio, lo que facilita el manejo de respuestas exitosas y errores de manera consistente. Un ApiResponse genérico típicamente incluye campos como el estado (éxito o error), un mensaje, y los datos devueltos en la respuesta.

**¿Cómo se implementa una clase ApiResponse genérica en Quarkus?**
Una clase ApiResponse genérica puede implementarse de la siguiente manera:

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    // Constructor
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Getters y Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

**¿Cómo se modifica un recurso REST en Quarkus para que utilice un ApiResponse genérico?**
Para modificar un recurso REST y que utilice un ApiResponse genérico, se debe ajustar el método del recurso para que retorne un ApiResponse en lugar del tipo de dato original. Por ejemplo:

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mi-recurso")
public class MiRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<String> obtenerDatos() {
        String datos = "Hola Mundo";
        return new ApiResponse<>(true, "Datos obtenidos exitosamente", datos);
    }
}

**¿Qué beneficios ofrece el uso de un ApiResponse genérico en términos de mantenimiento y consistencia de código?**
El uso de un ApiResponse genérico ofrece varios beneficios:

Consistencia: Estandariza la estructura de las respuestas, facilitando el manejo uniforme de éxitos y errores.
Mantenimiento: Centraliza la lógica de respuesta, haciendo que los cambios en la estructura de las respuestas solo requieran modificaciones en un lugar.
Claridad: Hace más fácil para los consumidores del API entender y manejar las respuestas, ya que siempre recibirán un formato consistente.

**¿Cómo manejarías diferentes tipos de respuestas (éxito, error, etc.) utilizando la clase ApiResponse?**
Se puede manejar diferentes tipos de respuestas instanciando la clase ApiResponse con los parámetros adecuados. 
Por ejemplo:

// Respuesta exitosa
ApiResponse<String> respuestaExitosa = new ApiResponse<>(true, "Operación exitosa", "Datos");

// Respuesta de error
ApiResponse<String> respuestaError = new ApiResponse<>(false, "Error al procesar la solicitud", null);

Además, se pueden crear métodos estáticos en la clase ApiResponse para facilitar la creación de respuestas comunes:

public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(true, "Operación exitosa", data);
}

public static <T> ApiResponse<T> error(String message) {
    return new ApiResponse<>(false, message, null);
}

## Sección 3: Integración y Buenas Prácticas

**¿Qué consideraciones se deben tener al inyectar servicios en un recurso REST en Quarkus?**
Al inyectar servicios en un recurso REST en Quarkus, es importante considerar:

Scope: Asegurarse de que el scope del servicio es adecuado para su uso en el recurso. Por ejemplo, @RequestScoped para servicios que deben ser específicos de cada solicitud.

Ciclo de vida: Entender cómo interactúan los ciclos de vida del recurso y los servicios inyectados, para evitar problemas como la fuga de memoria o estados inconsistentes.

Excepciones: Manejar adecuadamente las excepciones que puedan ser lanzadas por los servicios inyectados para proporcionar respuestas HTTP adecuadas.

**¿Cómo se pueden manejar excepciones en un servicio REST utilizando ApiResponse?**
Para manejar excepciones en un servicio REST utilizando ApiResponse, se pueden emplear interceptores de excepciones o capturar las excepciones directamente en los métodos del recurso y retornar una instancia de ApiResponse que indique un error:
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;

@Provider
public class MiExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        ApiResponse<String> apiResponse = new ApiResponse<>(false, exception.getMessage(), null);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(apiResponse)
                       .build();
    }
}

# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```

Diagrama del programa finalizado

```mermaid
sequenceDiagram
    participant App
    participant View
    participant Controller
    participant Model
    participant Coche
    
    App->>View: Ejecuta menú principal
    activate View
    View->>Controller: Solicita crear coche
    deactivate View
    
    activate Controller
    Controller->>Model: Pide crear nuevo coche
    deactivate Controller
    
    activate Model
    Model->>Coche: Instancia nuevo coche
    Coche-->>Model: Coche creado
    Model-->>Controller: Confirmación creación
    deactivate Model
    
    activate Controller
    Controller->>Model: Solicita modificar velocidad
    deactivate Controller
    
    activate Model
    Model->>Coche: Actualiza velocidad
    Coche-->>Model: Velocidad actualizada
    Model-->>Controller: Confirmación velocidad
    deactivate Model
    
    activate Controller
    Controller->>View: Pide mostrar velocidad
    deactivate Controller
    
    activate View
    View->>View: Muestra velocidad en pantalla
    View-->>Controller: Confirmación visualización
    deactivate View
    
    Controller->>Model: Solicita aumentar velocidad
    activate Model
    Model->>Coche: Incrementa velocidad
    Coche-->>Model: Velocidad aumentada
    Model-->>Controller: Confirmación aumento
    deactivate Model
    
    Controller->>Model: Solicita disminuir velocidad
    activate Model
    Model->>Coche: Reduce velocidad
    Coche-->>Model: Velocidad disminuida
    Model-->>Controller: Confirmación reducción
    deactivate Model
```
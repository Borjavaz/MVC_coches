# Examen 3º TRIMESTRE

Este proyecto simula un parking de coches. Se han añadido dos nuevas funciones: **avanzarCoche** y **echarGasolina**.

---

## Implementación de `avanzarCoche`

- En la clase **`Coche`** se crea el método `avanzarCoche(int tiempo)`, que calcula la distancia con la fórmula:


- Si el coche no tiene gasolina suficiente, no avanza y devuelve `-1`.

- En la clase **`Controller`** se crean métodos para buscar el coche por matrícula y llamarlo.

- En **`View`** se añade una opción en el menú para que el usuario introduzca el tiempo y se intente avanzar el coche.

---

##  Implementación de `echarGasolina`

- En la clase **`Coche`** se añade una variable `gasolina` y el método `echarGasolina(double litros)` para sumar gasolina al coche.

- En **`Controller`** se crean métodos para buscar el coche y asignarle los litros indicados.

- En **`View`** se añade una opción al menú para introducir matrícula y cantidad de gasolina que se quiere echar.

---

##  Comprobación

- Al echar gasolina, se actualiza correctamente.
- Al avanzar, si hay gasolina suficiente, recorre la distancia y se descuenta el consumo.
- Si no hay gasolina suficiente, no avanza y se muestra un mensaje.










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

Diagrama con los metodos y funciones de mi programa

```mermaid
sequenceDiagram
    participant App
    participant View
    participant Controller
    participant Model

    App->>View: menu()
    activate View
    View->>Controller: crearCoche("Mercedes", "BXK 1234")
    activate Controller
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model

    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View

    Controller->>Model: cambiarVelocidad("BXK 1234", 150)
    activate Model
    Model-->>Controller: Velocidad
    deactivate Model

    Controller->>+View: muestraVelocidad("BXK 1234", 150)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View

    Controller->>Model: obtenerCoches()
    activate Model
    Model-->>Controller: Lista de coches
    deactivate Model

    Controller->>+View: muestraCoches(Lista de coches)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean(Parking)
    deactivate View
```

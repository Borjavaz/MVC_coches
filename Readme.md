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

### Comprobación

- Al echar gasolina, se actualiza correctamente.
- Al avanzar, si hay gasolina suficiente, recorre la distancia y se descuenta el consumo.
- Si no hay gasolina suficiente, no avanza y se muestra un mensaje.


## Implementación del patrón Observer

- Se crea una interfaz `AlertaObserver` con el método `actualizar(String mensaje)`.
- La clase `AlertaConsola` implementa esta interfaz y muestra el mensaje por pantalla. ***En el mermaind es el observer***
- La clase `Coche` registra observadores y los notifica cuando la gasolina cae por debajo de 10 litros.

### Comprobación

Lo que hacemos aquí es:
1 -> `crear un coche`
2 -> `ver los coches que hay en el parking`
3 -> `modificar la velocidad a 100km/h`


![coche1](https://github.com/user-attachments/assets/a94a48a3-8db7-4db1-b1e0-eb30636e88f7)


A continuación: 
1 -> `le ponemos 55 litros de gasolina al coche`
2 -> `avanzamos 4 horas (400km), el coche se queda con 15 litros`
3 -> `Vuelvo a avanzar 1 hora (100km), y me salta la alerta ya que me quedan menos de 10 litros`


![coche3](https://github.com/user-attachments/assets/eeed3939-db28-4214-a634-5d2bf9d14781)



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

## Diagrama con los metodos y funciones de mi programa

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
## Diagrama de Secuencia con el observer

```mermaid
sequenceDiagram
    
    participant View
    participant Controller
    participant Model
    participant Coche
    participant Observer

    View->>Controller: avanzarCoche(matrícula, tiempo)
    Controller->>Model: getCoche(matrícula)
    Model-->>Controller: devuelve Coche
    Controller->>Coche: avanzarCoche(tiempo)
    Coche->>Coche: calcula consumo y reduce gasolina
    Coche->>Coche: notificarAlerta()
    Coche->>AlertaConsola: actualizar("Alerta: Repostar")
    Observer->>View: mostrarMensaje("Alerta: Repostar")
```

# Saludtools Fullstack Challenge


## Creacion de pacientes:

| Campo                 | Descripcion                             |
| ----------------------|:---------------------------------------:|
| nombre                | alfabético menor que 100 caracteres     |
| apellido              | alfabético menor que 100 caracteres     |
| fecha nacimiento      |                                         |
| genero                | Hombre, Mujer                           |

#### Reglas de negocio: 

    -   Todos los campos son obligatorios
    
## Creacion de medicamentos (Definido por un JSON en la carpeta raiz):

| Campo                 | Descripcion                             |
| ----------------------|:---------------------------------------:|
| nombre                |                                         |
| Edad mínima de consumo|                                         |
| Edad máxima de consumo|                                         |
| Uso exclusivo         |                                         |


## Aplicar prescripción:

| Campo                 | Descripcion                             |
| ----------------------|:---------------------------------------:|
| Fecha de prescripción | alfabético menor que 100 caracteres     |
| Paciente              | alfabético menor que 100 caracteres     |
| Medicamento           |                                         |
| genero                | Hombre, Mujer                           |

#### Reglas de negocio: 

    -   El medicamento solo puede ser prescrito al género  correspondiente
    -   No se puede prescribir más de 3 medicamentos por mes
    -   No se puede prescribir el mismo medicamento dentro del mismo mes
    -   Considerar la edad de consumo para la prescripción
    

### Solución

Se deberá crear una aplicación con un backend y frontend por separado, en la cual se tendrá que poder crear, editar, eliminar pacientes. Además se tendrá que poder prescribir a los distintos pacientes.

Se deberá contar con una pantalla de pacientes, en la cual se podrá:

    -   Listar pacientes (nombre y apellido, edad, género)
    -   Crear, editar y eliminar
    -   Prescribir medicamentos
    -   Ver prescripciones
    -   El boton de prescribir dentro de la tabla se deberá deshabilitar en caso de que tenga ya prescrito los 3 medicamentos mensuales, tomando como referencia el mes actual
    -   Mostrar el contenido en un modal
    -   Tener la posibilidad de filtrar por nombre y género
    -   La lista deberá estar paginada por cada 10 elementos
    -   Solo se podrá prescribir un medicamento si se cumplen con las reglas de negocio descritas anteriormente.



#### Backend:
Se deberá crear una API REST (recomendamos hacer la aplicación con Java + Spring Boot, siguiendo la arquitectura MVC, para la base de datos utilizar una de tipo SQL)


#### Frontend:
Se deberá crear una aplicación de tipo SPA la cual tiene que ser responsive (recomendamos hacerla con Vue,  utilizar axios como cliente HTTP para la comunicación con el backend y alguna librería de componente de su gusto).


**Nota**: Se evaluará buenas prácticas de programación, uso de principios SOLID, patrones de diseño y test unitarios.

---

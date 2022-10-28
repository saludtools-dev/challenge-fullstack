# Saludtools Fullstack Challenge

### Objetivo
Diseñar una aplicación por medio de la cual se le puedan prescribir medicamentos a pacientes registrados teninedo en cuenta ciertas variasbles que se describirán a continuación:

## Creación de pacientes:

| Campo                 | Descripción                             |
| ----------------------|:---------------------------------------:|
| Nombre                | Alfabético menor que 100 caracteres     |
| Apellido              | Alfabético menor que 100 caracteres     |
| Fecha nacimiento      |                                         |
| Género                | Hombre, Mujer                           |

#### Reglas de negocio: 

    -   Todos los campos son obligatorios
    
    
## Creación de medicamentos (Definido por un JSON en la carpeta raiz):

| Campo                 | Descripción                             |
| ----------------------|:---------------------------------------:|
| Nombre                |                                         |
| Edad mínima de consumo|                                         |
| Edad máxima de consumo|                                         |
| Uso exclusivo         |                                         |

## Aplicar prescripción:

| Campo                 | Descripciȯn                             |
| ----------------------|:---------------------------------------:|
| Fecha de prescripción |                                         |
| Paciente              | Alfabético menor que 100 caracteres     |
| Medicamento           |                                         |
| Género                | Hombre, Mujer                           |

#### Reglas de negocio: 

    -   El medicamento solo puede ser prescrito al género correspondiente.
    -   No se puede prescribir más de 3 medicamentos por mes al mismo paciente.
    -   No se puede prescribir el mismo medicamento dentro del mismo mes al mismo paciente.
    -   Considerar la edad de consumo para la prescripción (descrita en el json de medicamentos).
    

### Solución

Se deberá crear una aplicación con un backend y frontend por separado, en la cual se tendrá que poder crear, editar y eliminar pacientes. Además se tendrá que poder prescribir medicamentos a los distintos pacientes teniendo en cuenta las especificaciones ya mencionadas.

Se deberá contar con una pantalla de pacientes, en la cual se podrá:

    -   Listar pacientes (nombre y apellido, edad, género).
    -   La lista deberá estar paginada por cada 10 elementos.
    -   Crear, editar y eliminar pacientes.
    -   Prescribir medicamentos.
    -   Ver prescripciones.
    -   El botón de prescribir dentro de la tabla se deberá deshabilitar en caso de que el paciente ya tenga prescrito los 3 medicamentos mensuales, tomando como referencia el mes actual.
    -   Tener la posibilidad de filtrar la lista por nombre y género.
    -   Solo se podrá prescribir un medicamento si se cumplen con las reglas de negocio descritas anteriormente.
    

#### Backend:
Se deberá crear una API REST (recomendamos hacer la aplicación con Java + Spring Boot, siguiendo la arquitectura MVC, para la base de datos utilizar una de tipo SQL).


#### Frontend:
Se deberá crear una aplicación de tipo SPA la cual debe ser responsive (recomendamos hacerla con Vue, utilizar axios como cliente HTTP para la comunicación con el backend y alguna librería de componente de su gusto).


**Nota**: Se evaluará buenas prácticas de programación, uso de principios SOLID, patrones de diseño y test unitarios.

---

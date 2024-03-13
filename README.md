Integrantes: Camilo Eduardo Muñóz Duque
             Jazmín Andrea Saleh Peña
             Juanita Sanabria Sáenz

Api : https://taller-d4cu.onrender.com/api-docs/

La API  a utilizar contiene la información de empleados y departamentos, permite las funciones de CRUD para cada uno de los modelos planteados y los endpoints corresponden a los siguientes: 

EMPLOYEES:

GET -> /employees -> Encuentra todos los empleados
POST-> /employees/{id} -> Agrega un nuevo empleado a un departamento 
  Body:
  {
    "name": "nombre",
    "lastName": "apellido",
    "role": "Count"
  }
GET -> /employess/{id} ->Encuentra un empleado a través de su ID
PUT -> /employees/{id} -> Actualiza el empleado por ID
DELETE -> /employees/{id} -> Elimina un empleado a través de su ID

DEPARTMENTS:

GET -> /departments -> Encuentra todos los departamentos
POST-> /departments/{id} -> Agrega un nuevo departamento
  Body: 
  {
    "department_name": "nombre del departemnto",
    "description": "Descripción del departamento",
    "employees": []
  }
GET -> /departments/{id} ->Encuentra un departamento a través de su ID
PUT -> /departments/{id} -> Actualiza el departamento por ID
DELETE -> /departments/{id} -> Elimina un departamento a través de su ID



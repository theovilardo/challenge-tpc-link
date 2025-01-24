# MVP para Consulta de Préstamos Disponibles

Este proyecto es un **MVP** desarrollado para **Red Link**, con el objetivo de ofrecer a empleados de empresas clientes del banco **TuPlataCrece** la posibilidad de consultar préstamos disponibles. La solución incluye un login básico basado en **DNI** y una API que permite gestionar y consultar la información de los préstamos.

## **Descripción del Proyecto**

La aplicación tiene las siguientes funcionalidades principales:

1. **Inicio de Sesión**:  
   El usuario ingresa su **DNI** para acceder a la aplicación.

2. **Consulta de Préstamos Disponibles**:  
   - Si el DNI no pertenece a un empleado elegible: se notifica que no tiene acceso.  
   - Si el DNI pertenece a un empleado sin préstamo disponible: se informa que no tiene préstamos.  
   - Si el DNI pertenece a un empleado con préstamo disponible: se muestra el importe disponible.

3. **Carga y Procesamiento de Archivos**:  
   - **Importación de Datos**: Se procesan diariamente archivos enviados por el banco con la relación **DNI - Importe**.  
   - **Generación de Reportes**: Se crea un reporte diario de los usuarios que visualizaron los préstamos.

## **Tecnologías Utilizadas**

- **Lenguaje**: Java 17  
- **Framework**: Spring Boot  
- **Base de Datos**: H2 (en memoria para facilidad de pruebas)  
- **Testing**: JUnit, Mockito  
- **Herramientas de Desarrollo**: Maven, Postman  
- **Gestión de Dependencias**: Spring Boot Starter

## **Cómo Levantar el Proyecto**

1. **Requisitos Previos**:
   - Java 17+
   - Maven 3.8+
   - (Opcional) Docker para despliegue en contenedor

2. **Ejecución Local**:
   - Clonar el repositorio:
     ```bash
     git clone https://github.com/tu-usuario/tu-repo.git
     cd tu-repo
     ```
   - Construir el proyecto:
     ```bash
     mvn clean install
     ```
   - Ejecutar la aplicación:
     ```bash
     mvn spring-boot:run
     ```
   - La aplicación estará disponible en: `http://localhost:8080`

3. **Pruebas**:
   - Ejecutar los tests:
     ```bash
     mvn test
     ```

## **Endpoints Principales**

- **POST /login**:  
  Inicio de sesión del usuario con su **DNI**.  

- **GET /prestamo**:  
  Consulta del importe del préstamo disponible para el usuario autenticado.  

- **POST /archivo/importar**:  
  Carga de archivo con datos de relación **DNI - Importe**.  

- **GET /reporte/generar**:  
  Generación del reporte diario.

## **Estrategia para la Gestión de Archivos**

1. **Recepción de Archivos**:  
   Los archivos enviados por el banco se procesan y almacenan en la base de datos.  

2. **Generación de Reportes**:  
   Se genera un reporte en formato `.csv` con los datos de los usuarios que visualizaron los préstamos.

## **Autor**

Desarrollado por: [Tu Nombre]  
Correo: [tu-email@example.com]  

---

¡Gracias por revisar el proyecto! 🚀

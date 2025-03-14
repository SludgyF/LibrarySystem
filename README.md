# Equipo 46

## Integrantes:
- **Carlos Iván Armenta Naranjo** - A01643070
- **Jorge Javier Blásquez Gonzalez** - A01637706
- **Adolfo Hernández Signoret** - A01637184
- **Arturo Ramos Martínez** - A01643269
- **Moisés Adrián Cortés Ramos** - A01642492
- **Bryan Ithan Landín Lara** - A01636271
**Descripcion del codigo**
Este sistema es para gestionar una libreria, con las siguientes features:
Book Management: Tenemos metodos para agregar libros, remover libros en base a una cantidad, mostrar los libros existentes y editar un libro (Puede ser cantidad, nombre, y autor)
Patron Management: Se pueden registrar usuarios (patrons), ver los patrones existente y editarlos (Se puede editar nombre y contacto)
Borrowing and Returning Books: Se pueden pedir prestados libros a traves del id de un usuario, ese usuario puede regresar los libros que pidio prestado, ademas de pueden ver los libros que un usuario a rentado
Search Functionality: Tenemos dos busquedas, una de libro (Por autor, nombre, isbn) y la busqueda de un usuario la cual te muestra que libros ha pedido prestado


## Cómo ejecutar el proyecto

Sigue estos pasos para compilar y ejecutar el proyecto:

```sh
cd src
javac LibrarySystem.java
java LibrarySystem

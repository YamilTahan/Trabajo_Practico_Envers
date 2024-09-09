# Trabajo_Practico_Envers

Pasos para la ejecución:

1- Ejecutar el main con la conexión con H2 funcionando, para que se creen las tablas con sus relaciones, y se le añadan algunas filas u objetos.

2- Comentar desde la línea 15 hasta la 122, y descomentar desde la línea 124 a la 131.

3- En la línea 15 del archivo Persistence.xml, cambiar el value de "Create" a "Update".

4- Ejecutar el main nuevamente.

Luego de esta secuencia, debería verse un cambio en la tabla CLIENTE, en las columnas "Apellido" y "Nombre". En la tabla CLIENTE_AUD, deberia observarse
un nuevo registro, por la modificacion anterior. Tambien, en la tabla FACTURA, debería eliminarse su único registro, al igual que los DETALLEFACTURA que 
la componen, viendose tambien todos estos cambios en FACTURA_AUD y DETALLEFACTURA_AUD.

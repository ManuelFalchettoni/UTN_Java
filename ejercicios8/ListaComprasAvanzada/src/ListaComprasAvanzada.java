/* Leer el CSV línea por línea (saltando la primera línea de headers) 
Para cada producto calcular el subtotal (precio × cantidad) 
Agrupar productos por categoría y calcular totales por categoría 

Generar archivo resumen_compra.txt con: 
Lista completa de productos con subtotales 
Total de productos por categoría 
Total de dinero por categoría 
Total general de la compra Categoría más cara y más barata 


AYUDAS:::

Saltar la primera línea del archivo (readLine()) porque tiene los encabezados y no representa un producto real.

Usar split(",") para dividir cada línea en campos separados por comas. (metodo de string)

Aplicar trim() a cada campo para eliminar espacios innecesarios que pueden causar errores.

Usar Double.parseDouble() y Integer.parseInt() para convertir los valores de texto en números (precio y cantidad).

Utilizar Categoria.valueOf() para transformar el texto leído en una constante del enum Categoria.

Guardar los totales por categoría en estructuras Map<Categoria, Integer> y Map<Categoria, Double> para contar productos y acumular subtotales.

getOrDefault() permite obtener un valor del mapa o usar uno por defecto si la clave aún no existe.

Para mostrar precios con dos decimales, usar String.format("%.2f", valor). */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.EnumMap;

public class ListaComprasAvanzada {
    public static void main(String[] args) {
        //Declaro mis dos archivos
        String archivoEntrada = "archivos/productos.csv";
        String archivoSalida = "archivos/resumen_compra.txt";

        //Array para guardar los productos
        ArrayList<Producto> productos = new ArrayList<>();

        //Map para agrupar por categoria
        Map<Categoria,> agrupados = new EnumMap<>(Categoria.class);

        // Leer el archivo CSV y cargar los productos en la lista
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            //Declaro un String que es donde se va a ir guardando la linea actual
            String linea;
            // Saltar la primera línea de encabezados
            lector.readLine();

            //Guardamos todo el txt en una arrayList de tipo Producto en sus respectivos atributos
            while ((linea = lector.readLine()) != null) {
                //Variables auxiliares
                String nombreAux;
                Categoria categoriaAux;
                Double precioAux;
                Integer cantidadAux;
                
                String[] lineaAux = linea.split(",");//Divido el TXT en un array de Strings
                //Guardo los strings y transformo determinados valores
                nombreAux = lineaAux[0];
                categoriaAux = Categoria.valueOf(lineaAux[1]);
                precioAux = Double.parseDouble(lineaAux[2]);
                cantidadAux = Integer.parseInt(lineaAux[3]);

                //Con esos valores ya transformados creo un nuevo producto con sus atributos
                Producto producto = new Producto(nombreAux, categoriaAux, precioAux, cantidadAux);
                //Guardo ese producto en my ArrayList de Productos
                productos.add(producto);
            }
            
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }



    }
}

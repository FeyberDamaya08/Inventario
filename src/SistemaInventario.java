
import java.util.Scanner;

public class SistemaInventario {

    public static void main(String[] args) {
        // Scanner para leer datos
        Scanner input = new Scanner(System.in);

        // Categorías de productos
        String[] categorias = {"Electronica", "Alimentos", "Ropa", "Hogar", "Otros"};
        
        // Arrays para guardar los datos de productos
        String[] nombres = new String[100];      // Nombres de productos
        int[] cantidades = new int[100];         // Cantidades disponibles
        double[] precios = new double[100];      // Precios 
        int[] categoriasProductos = new int[100]; // Categoría de cada producto
        
        int totalProductos = 0;  // Contador de productos registrados
        boolean salir = false;   // Para controlar el ciclo principal

        // Bienvenida
        System.out.println("SISTEMA DE INVENTARIO");
        System.out.println("Debe ingresar 5 productos iniciales");
        
        // Pedir los 5 productos obligatorios
        while (totalProductos < 5) {
            System.out.println("PRODUCTO #" + (totalProductos + 1));
            
            // Pedir nombre
            System.out.print("Nombre: ");
            nombres[totalProductos] = input.nextLine();
            
            // Mostrar y elegir categoría
            System.out.println("Categorias disponibles:");
            for (int i = 0; i < categorias.length; i++) {
                System.out.println((i + 1) + ". " + categorias[i]);
            }
            
            System.out.print("Elija categoria:");
            int opcionCategoria = input.nextInt();
            input.nextLine(); 
            
            // Validar la categoría elegida
            if (opcionCategoria >= 1 && opcionCategoria <= 5) {
                categoriasProductos[totalProductos] = opcionCategoria - 1;
            } else {
                System.out.println("Categoria no valida");
                categoriasProductos[totalProductos] = 4;
            }
            
            // Pedir cantidad y precio
            System.out.print("Cantidad: ");
            cantidades[totalProductos] = input.nextInt();
            
            System.out.print("Precio: $");
            precios[totalProductos] = input.nextDouble();
            input.nextLine();
            totalProductos++;
            System.out.println("Producto guardado");
        }
        
        // Menú principal 
        while (!salir) {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Agregar producto");
            System.out.println("2. Reporte de inventario");
            System.out.println("3. Salir");
            System.out.print("Seleccione opcion: ");
    
            int opcion = input.nextInt();
            input.nextLine();
            
            switch (opcion) {
                case 1: // Agregar producto
                    if (totalProductos < 100) {
                        System.out.print("Nombre: ");
                        nombres[totalProductos] = input.nextLine();
                        
                        System.out.println("Categorias disponibles:");
                        for (int i = 0; i < categorias.length; i++) {
                            System.out.println( ". " + categorias[i]);
                        }
                        
                        System.out.print("Elija categoria:");
                        int opcionCategoria = input.nextInt();
                        input.nextLine();
                        
                        if (opcionCategoria >= 1 && opcionCategoria <= 5) {
                            categoriasProductos[totalProductos] = opcionCategoria - 1;
                        } else {
                            System.out.println("Categoria no valida");
                            categoriasProductos[totalProductos] = 4;
                        }
                        
                        System.out.print("Cantidad: ");
                        cantidades[totalProductos] = input.nextInt();
                        
                        System.out.print("Precio:");
                        precios[totalProductos] = input.nextDouble();
                        
                        
                        totalProductos++;
                        System.out.println("Producto agregado correctamente");
                    } else {
                        System.out.println("No se pueden agregar más productos");
                    }
                    break;
                    
                case 2: // Reporte de inventario
                    if (totalProductos == 0) {
                        System.out.println("No hay productos para mostrar");
                        break;
                    }
                    
                    System.out.println("REPORTE DE INVENTARIO");
                    
                    
                    double valorTotal = 0;
                    
                    // Recorrer todos los productos guardados
                    for (int i = 0; i < totalProductos; i++) {
                        double subtotal = cantidades[i] * precios[i];
                        
                        // Imprimir el resultado del reporte de inventario
                        System.out.println((i + 1)+"-" + "Producto:" +
                   nombres[i] + "  -Categoria:" +
                   categorias[categoriasProductos[i]] + "  -Cantidad:" +
                   cantidades[i] + "  -Precios: " +
                   "$" + precios[i] + "  -Total producto:" +
                   "$" + subtotal);

                        
                        valorTotal += subtotal;
                    }
                    
                    System.out.printf("VALOR TOTAL DEL INVENTARIO: "+ valorTotal);
                    break;
                    
                case 3: // Salir
                    salir = true;
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
            }
        }
        
        input.close();
    }
}

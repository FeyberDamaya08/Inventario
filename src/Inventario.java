import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        // Se crea un objeto Scanner llamado "miobj" para recibir entradas del usuario desde la consola
        Scanner miobj = new Scanner(System.in);

        String[] nombres = new String[100];
        int[] cantidades = new int[100];
        double[] precios = new double[100];

        int munProducto = 0;

        boolean salir = false;

        // Ciclo para ingresar los primeros 5 productos obligatorios
        while (munProducto < 5) {
            System.out.print("\ningrese el nombre del producto " + (munProducto + 1) + ": ");
            nombres[munProducto] = miobj.nextLine();

            System.out.print("ingrese la cantidad en inventario: ");
            cantidades[munProducto] = miobj.nextInt();

            System.out.print("ingrese el precio por unidad: ");
            precios[munProducto] = miobj.nextDouble();
            miobj.nextLine(); // Limpiar buffer

            munProducto++;
            System.out.println("producto agregado con éxito");
        }

        // Este es el bucle principal del programa que presenta el menú y ejecuta las opciones hasta que el usuario decida salir
        while (!salir) {
            System.out.print("¿desea agregar otro producto? (s/n): ");
            String respuesta = miobj.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                if (munProducto < nombres.length) {
                    System.out.print("\ningrese el nombre del producto " + (munProducto + 1) + ": ");
                    nombres[munProducto] = miobj.nextLine();

                    System.out.print("ingrese la cantidad en inventario: ");
                    cantidades[munProducto] = miobj.nextInt();

                    System.out.print("ingrese el precio por unidad: ");
                    precios[munProducto] = miobj.nextDouble();
                    miobj.nextLine();

                    munProducto++;
                    System.out.println("producto agregado con éxito");
                } else {
                    System.out.println("no se pueden agregar más productos límite alcanzado");
                }
            } else {
                // Menú de opciones para el usuario
                System.out.println("  sistema de inventario ");
                System.out.println("1. agregar nuevo producto");
                System.out.println("2. actualizar cantidad de producto");
                System.out.println("3. generar reporte de inventario");
                System.out.println("4. salir");

                System.out.print("seleccione una opción: ");
                int opcion = miobj.nextInt();
                miobj.nextLine();

                // Este bloque decide qué acción ejecutar según la opción seleccionada del menú
                switch (opcion) {
                    case 1:
                        if (munProducto < nombres.length) {
                            System.out.print("\ningrese el nombre del producto " + (munProducto + 1) + ": ");
                            nombres[munProducto] = miobj.nextLine();

                            System.out.print("ingrese la cantidad en inventario: ");
                            cantidades[munProducto] = miobj.nextInt();

                            System.out.print("ingrese el precio por unidad: ");
                            precios[munProducto] = miobj.nextDouble();
                            miobj.nextLine();

                            munProducto++;
                            System.out.println("producto agregado con éxito");
                        } else {
                            System.out.println("no se pueden agregar más productos límite alcanzado");
                        }
                        break;

                    case 2:
                        if (munProducto == 0) {
                            System.out.println("no hay productos registrados");
                            break;
                        }

                        System.out.println("lista de productos:");
                        for (int i = 0; i < munProducto; i++) {
                            System.out.println((i + 1) + ". " + nombres[i]);
                        }

                        System.out.print("seleccione el producto a actualizar: ");
                        int seleccion = miobj.nextInt() - 1;
                        miobj.nextLine();

                        if (seleccion >= 0 && seleccion < munProducto) {
                            System.out.print("ingrese la nueva cantidad para " + nombres[seleccion] + ": ");
                            cantidades[seleccion] = miobj.nextInt();
                            miobj.nextLine();
                            System.out.println("cantidad actualizada con éxito");
                        } else {
                            System.out.println("selección inválida");
                        }
                        break;

                    case 3:
                        // Esta sección imprime un reporte del inventario actual
                        if (munProducto == 0) {
                            System.out.println("no hay productos registrados");
                            break;
                        }

                        System.out.println("reporte final de inventario");
                        double valorTotalInventario = 0;

                        for (int i = 0; i < munProducto; i++) {
                            double valorTotalProducto = cantidades[i] * precios[i];

                            // Se imprime la información de cada producto en un formato claro
                            System.out.printf("Producto: %s | Cantidad: %d | Precio Unitario: %.2f | Valor Total: %.2f%n",
                                    nombres[i], cantidades[i], precios[i], valorTotalProducto);

                            valorTotalInventario += valorTotalProducto;
                        }

                        System.out.printf("valor total del inventario: %.2f%n", valorTotalInventario);
                        break;

                    case 4:
                        salir = true;
                        System.out.println("saliendo del sistema");
                        break;

                    default:
                        System.out.println("opción inválida intente nuevamente");
                }
            }
        }
    }
}
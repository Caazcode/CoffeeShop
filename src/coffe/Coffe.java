/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Alex Rodriguez
 */
public class Coffe {

    static int totalClientes = 0;
    static int cafesChicosVendidos = 0;
    static int cafesMedianosVendidos = 0;
    static int cafesGrandesVendidos = 0;
    static double ingresosTotales = 0;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean seguirAtendiendo = true;

        while (seguirAtendiendo) {
            atenderCliente(entrada);

            System.out.print("¿Desea atender a otro cliente? (S/N): ");
            char opcion = entrada.next().toUpperCase().charAt(0);
            seguirAtendiendo = opcion == 'S';
        }

        mostrarReporteDelDia();
    }

    public static void atenderCliente(Scanner entrada) {
        System.out.println("¡Bienvenido a Tu Café Favorito!");

        System.out.println("Por favor, elija el tamaño del café:");
        System.out.println("1. Chico (Lps. 45)");
        System.out.println("2. Mediano (Lps. 56)");
        System.out.println("3. Grande (Lps. 65)");
        int eleccionCafe = entrada.nextInt();
        double costoCafe = calcularPrecioCafe(eleccionCafe);

        System.out.println("Seleccione el complemento:");
        System.out.println("1. Leche (Lps. 5)");
        System.out.println("2. Cremora (Lps. 8)");
        System.out.println("3. Sin complemento (Lps. 0)");
        int eleccionComplemento = entrada.nextInt();
        double costoComplemento = calcularPrecioComplemento(eleccionComplemento);

        System.out.print("¿Es mayor de edad? (S/N): ");
        char edad = entrada.next().toUpperCase().charAt(0);
        boolean descuento = edad == 'S';

        double total = calcularPago(costoCafe, costoComplemento, descuento);
        System.out.printf("El monto total es: Lps. %.2f%n", total);

        actualizarEstadisticas(eleccionCafe, total);
        totalClientes++;
    }

    public static double calcularPrecioCafe(int eleccion) {
        switch (eleccion) {
            case 1:
                cafesChicosVendidos++;
                return 45;
            case 2:
                cafesMedianosVendidos++;
                return 56;
            case 3:
                cafesGrandesVendidos++;
                return 65;
            default:
                System.out.println("Opción inválida, se asignará tamaño chico por defecto.");
                cafesChicosVendidos++;
                return 45;
        }
    }

    public static double calcularPrecioComplemento(int eleccion) {
        switch (eleccion) {
            case 1:
                return 5;
            case 2:
                return 8;
            case 3:
                return 0;
            default:
                System.out.println("Opción inválida, se asignará sin complemento por defecto.");
                return 0;
        }
    }

    public static double calcularPago(double costoCafe, double costoComplemento, boolean descuento) {
        double subtotal = costoCafe + costoComplemento;
        if (descuento) {
            subtotal *= 0.90;
        }
        return subtotal;
    }

    public static void actualizarEstadisticas(int eleccionCafe, double total) {
        ingresosTotales += total;
    }

    public static void mostrarReporteDelDia() {
        System.out.println("\nReporte Final:");
        System.out.println("Clientes atendidos: " + totalClientes);
        System.out.println("Cafés chicos vendidos: " + cafesChicosVendidos);
        System.out.println("Cafés medianos vendidos: " + cafesMedianosVendidos);
        System.out.println("Cafés grandes vendidos: " + cafesGrandesVendidos);
        System.out.printf("Ingresos totales: Lps. %.2f%n", ingresosTotales);
    }

}


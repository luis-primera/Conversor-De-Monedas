package vista;

import controlador.Conversor;
import java.util.Scanner;

public class ConversorMonedasApp {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in); // Para leer entrada usuario.
        Conversor conversor = new Conversor(); // Se crea objeto "convertidor".
        boolean continuar = true;

        do {
            opcionesMenu();
            int opcion = scanner.nextInt(); // Se crea int "opcion" para obtener entrada de usuario según opción elegida.

            if (opcion ==7){
                continuar = false;
                System.out.println("SALISTE DEL PROGRAMA");
            } else if (opcion >= 1 && opcion <=6){ // Elige solo entre opción 1 y 6.
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                conversor.convertirMoneda(opcion, cantidad);
            } else {
                System.out.println("INGRESE UNA OPCIÓN VÁLIDA");
            }
        }
        while (continuar); // Si usuario elige opcón 7 sale del programa.
    }

    public static void opcionesMenu(){
        System.out.println("== Sea bienvenido/a al CONVERSOR DE MONEDAS ==");
        System.out.println("1: Dólar (USD) → Peso Chileno (CLP)");
        System.out.println("2: Peso Chileno (CLP) → Dólar (USD)");
        System.out.println("3: Dólar (USD) → Bolívar (VES)");
        System.out.println("4: Bolívar (VES) → Dólar (USD)");
        System.out.println("5: Dólar (USD) → Real Brasileño (BRL)");
        System.out.println("6: Real Brasileño (BRL) → Dólar (USD)");
        System.out.println("7: Salir");
        System.out.print("Selecciona una opción (1-7): ");
    }
}

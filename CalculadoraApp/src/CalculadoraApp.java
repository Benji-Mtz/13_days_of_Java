import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        // Objeto consola de tipo Scanner que regresa string
        Scanner consola = new Scanner(System.in);

        while (true){
            System.out.println("**** Application Calculator ****");
            // Mostramos el menu
            mostrarMenu();
            try {
                // var para tipo de dato dinamico
                var operacion = Integer.parseInt(consola.nextLine());

                // Revisar que la variable operacion este dentro de las opciones mencionadas
                if (operacion >= 1 && operacion <= 4){
                    ejecutarOperacion(operacion, consola);
                } else if (operacion == 5) { // Salir
                    System.out.println("Hasta pronto...");
                    // break rompera nuestro ciclo while infinito
                    break;
                } else {
                    System.out.printf("La opción %s no existe.\n", operacion);
                }
                // imprimimos un salto antes de repetir el ciclo
                System.out.println();
            } // fin try
            catch (Exception e) {
                // Exception es una excepcion generica para errores de tipo int, string etc
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        } // fin while
    } // fin main

    // Funciones
    // private: para que se use solo en esta clase, static: para que se pueda usar en el static main, void: porque no retorna algo
    private static void mostrarMenu() {
        // System.out.println("1. Suma \n2. Resta \n3. Multiplicacion\n4. División\5. Exit\n");
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
        System.out.println("Operación a realizar?: ");
    }

    private static void ejecutarOperacion(int operacion, Scanner consola) {
        System.out.println("Proporciona el primer operando: ");
        var operando1 = Double.parseDouble(consola.nextLine());

        System.out.println("Proporciona el segundo operando: ");
        var operando2 = Double.parseDouble(consola.nextLine());

        double resultado;

        switch (operacion){
            case 1 -> { // Suma
                resultado = operando1 + operando2;
                System.out.println("Resultado Suma = " + resultado);
            }
            case 2 -> {
                resultado = operando1 - operando2;
                System.out.println("Resultado Resta = " + resultado);
            }
            case 3 -> {
                resultado = operando1 * operando2;
                System.out.println("Resultado Multiplicación = " + resultado);
            }
            case 4 -> {
                if (operando2 == 0){
                    System.out.println("La division por 0 no es posible :(");
                } else {
                    resultado = operando1 / operando2;
                    System.out.println("Resultado Division = " + resultado);
                }
            }
            default -> System.out.printf("La opción %s no existe.\n", operacion);
        }
    }

} // fin class

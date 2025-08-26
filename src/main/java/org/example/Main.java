package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\u001B[34m Sistema de registro de pedidos 🍗🥖🥐🧀");
        System.out.println("\u001B[34m===================================================");

        HashMap<String, Double> platos = new HashMap<>();
        platos.put("Pasta a la boloñesa", 2000.0);
        platos.put("Pollo al curry", 3000.0);
        platos.put("Helado de fresa", 4000.0);
        platos.put("Pan integral", 7000.0);
        platos.put("Pie de manzana", 6000.0);
        platos.put("Pizza napolitana", 10000.0);

        // Mostrar menú
        System.out.println("\nMenú del restaurante:");
        for (String menu : platos.keySet()) {
            System.out.println( menu + platos.get(menu));
        }

        ArrayList<String> pedidos = new ArrayList<>();

        System.out.println("\n¿De qué te antojaste? Escribe 'FIN' para terminar");

        try {
            while (true) {
                System.out.print(" Tu pedido: ");
                String pedido = sc.nextLine();

                if (pedido.equalsIgnoreCase("fin")) {
                    System.out.println("\n Gracias por tu visita.");
                    break;
                }

                if (platos.containsKey(pedido)) {
                    pedidos.add(pedido);
                    System.out.println("Pedido agregado: " + pedido + " - $" + platos.get(pedido));
                } else {
                    System.out.println("Plato no encontrado en el menú.");
                }
            }

        } catch (InputMismatchException error) {
            System.out.println(" Dato inválido");
        } catch (IllegalStateException no) {
            System.out.println("No hay platos");
        } catch (Exception e) {
            System.out.println(" plato no encontrado " + e.getMessage());
        }

        double total = Funciones.calcularTotal(pedidos, platos);
        System.out.println("Total sin descuento: $" + total);

        double totalConDescuento = Funciones.aplicarDescuento(total);
        System.out.println("Total con 10% de descuento: $" + totalConDescuento);

        double promedio = Funciones.calcularPromedio(pedidos, platos);
        System.out.println("El promedio es: " + promedio);




        sc.close();
    }
}


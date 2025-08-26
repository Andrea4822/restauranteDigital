package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Funciones {

    public static double calcularTotal(ArrayList<String> pedidos, HashMap<String, Double> platos) {
        double total = 0;
        for (String pedido : pedidos) {
            total += platos.getOrDefault(pedido, 0.0);
        }
        return total;
    }

    public static double aplicarDescuento(double total) {
        return total * 0.90;
    }

    public static double calcularPromedio(ArrayList<String> pedidos, HashMap<String, Double> platos) {
        double suma = 0;
        int cantidad = pedidos.size();

        if (cantidad == 0) {
            return 0;
        }

        for (String pedido : pedidos) {
            if (platos.containsKey(pedido)) {
                suma += platos.get(pedido);
            }
        }
        return suma / cantidad;
    }
}


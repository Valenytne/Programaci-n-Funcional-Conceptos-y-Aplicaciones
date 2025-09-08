/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {
        List<Tarea> tareas = new ArrayList<>();

        Tarea t1 = new Tarea("Hacer profiles Unosquare", "Hacer las CVs en Word", Prioridad.ALTA);
        Tarea t2 = new Tarea("Ir al gimnasio", "Entrenamiento de pierna", Prioridad.MEDIA);
        Tarea t3 = new Tarea("Llamar a mamá", "Hablar sobre el viaje", Prioridad.BAJA);

        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);

        System.out.println("=== Todas las tareas ===");
        GestorTareas.imprimirRecursivo(tareas, 0);

        System.out.println("\n=== Tareas con prioridad ALTA===");
        tareas.stream()
              .filter(t -> t.getPrioridad() == Prioridad.ALTA)
              .forEach(System.out::println);
        
        System.out.println("\n=== Conteo de tareas por prioridad ===");
Map<Prioridad, Long> conteo = tareas.stream()
    .collect(Collectors.groupingBy(Tarea::getPrioridad, Collectors.counting()));

conteo.forEach((prioridad, cantidad) -> 
    System.out.println(prioridad + ": " + cantidad));
  }
}

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

        // Crear algunas tareas iniciales
        Tarea t1 = new Tarea("Hacer profiles Unosquare", "Hacer las CVs en Word", Prioridad.ALTA);
        Tarea t2 = new Tarea("Ir al gimnasio", "Entrenamiento de pierna", Prioridad.MEDIA);
        Tarea t3 = new Tarea("Llamar a mama", "Hablar sobre el viaje", Prioridad.BAJA);

        tareas.add(t1);
        tareas.add(t2);
        tareas.add(t3);

        // 1) Imprimir todas las tareas
        System.out.println("=== Todas las tareas ===");
        GestorTareas.imprimirRecursivo(tareas, 0);

        // 2) Filtrar por prioridad ALTA
        System.out.println("\n=== Tareas con prioridad ALTA ===");
        tareas.stream()
              .filter(t -> t.getPrioridad() == Prioridad.ALTA)
              .forEach(System.out::println);

        // 3) Conteo de tareas por prioridad
        System.out.println("\n=== Conteo de tareas por prioridad ===");
        Map<Prioridad, Long> conteo = tareas.stream()
            .collect(Collectors.groupingBy(Tarea::getPrioridad, Collectors.counting()));
        conteo.forEach((prioridad, cantidad) -> 
            System.out.println(prioridad + ": " + cantidad));

        // 4) Ordenar tareas por prioridad (ALTA > MEDIA > BAJA)
        System.out.println("\n=== Tareas ordenadas por prioridad ===");
        tareas.stream()
              .sorted((a, b) -> b.getPrioridad().ordinal() - a.getPrioridad().ordinal())
              .forEach(System.out::println);

        // 5) Map + Reduce: concatenar nombres de todas las tareas
        String nombresConcatenados = tareas.stream()
            .map(Tarea::getNombre)
            .reduce((n1, n2) -> n1 + ", " + n2)
            .orElse("");

        // 6) Conteo de tareas completadas y no completadas
        System.out.println("\n=== Conteo de tareas completadas y no completadas ===");
        long completadas = tareas.stream().filter(t -> t.isCompletada()).count(); 
        long noCompletadas = tareas.size() - completadas;
        System.out.println("Completadas: " + completadas);
        System.out.println("No completadas: " + noCompletadas);

        // 7) Filtrar solo tareas no completadas
        System.out.println("\n=== Tareas no completadas ===");
        tareas.stream()
              .filter(t -> !t.isCompletada())
              .forEach(System.out::println);

        // 8) Mostrar todos los nombres concatenados
        System.out.println("\n=== Nombres de todas las tareas concatenadas ===");
        System.out.println(nombresConcatenados);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorTareas {
  private GestorTareas() {} // no instanciable

    // 1) AGREGAR (función pura: devuelve nueva lista)
    public static List<Tarea> agregarTarea(List<Tarea> tareas, Tarea nueva) {
        List<Tarea> copia = new ArrayList<>(tareas);
        copia.add(nueva);
        return copia;
    }

    // 2) ELIMINAR por nombre (recursivo, devuelve nueva lista)
    public static List<Tarea> eliminarTareaRec(List<Tarea> tareas, String nombre) {
        if (tareas == null || tareas.isEmpty()) return new ArrayList<>();
        Tarea head = tareas.get(0);
        List<Tarea> resto = eliminarTareaRec(tareas.subList(1, tareas.size()), nombre);
        if (head.getNombre().equals(nombre)) {
            return resto; // omitimos esta tarea
        } else {
            List<Tarea> res = new ArrayList<>();
            res.add(head);
            res.addAll(resto);
            return res;
        }
    }

    // 3) ACTUALIZAR prioridad por nombre (recursivo, devuelve nueva lista)
    public static List<Tarea> actualizarPrioridadRec(List<Tarea> tareas, String nombre, Prioridad nuevaPrioridad) {
        if (tareas == null || tareas.isEmpty()) return new ArrayList<>();
        Tarea head = tareas.get(0);
        List<Tarea> resto = actualizarPrioridadRec(tareas.subList(1, tareas.size()), nombre, nuevaPrioridad);

        List<Tarea> res = new ArrayList<>();
        if (head.getNombre().equals(nombre)) {
            // Como Tarea es inmutable, creamos una nueva con la prioridad actualizada
            Tarea actualizada = new Tarea(head.getNombre(), head.getDescripcion(), nuevaPrioridad);
            res.add(actualizada);
        } else {
            res.add(head);
        }
        res.addAll(resto);
        return res;
    }

    // 4) IMPRIMIR recursivo (útil para demostrar recursión)
    public static void imprimirRecursivo(List<Tarea> tareas, int index) {
        if (tareas == null || index >= tareas.size()) return;
        System.out.println(tareas.get(index));
        imprimirRecursivo(tareas, index + 1);
 
    }    

    // 5) Mostrar análisis con streams (nuevo método)
    public static void mostrarAnalisis(List<Tarea> tareas) {
        System.out.println("\n=== Tareas con prioridad ALTA ===");
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

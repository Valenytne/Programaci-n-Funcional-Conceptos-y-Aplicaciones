/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopf;

/**
 *
 * @author varga
 */
public class Tarea {
    private final String nombre;
    private final String descripcion;
    private final Prioridad prioridad;

    public Tarea(String nombre, String descripcion, Prioridad prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + " | Descripcion: " + descripcion + " | Prioridad: " + prioridad;
    }
  }


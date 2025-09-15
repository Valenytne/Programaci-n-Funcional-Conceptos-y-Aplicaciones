/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopf;

/**
 *
 * @author varga
 */
public class ProyectoPFAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Tarea t1 = new Tarea("Estudiar programacion funcional", "Hacer la tarea en Java", Prioridad.ALTA);
      Tarea t2 = new Tarea("Ir al gimnasio", "Entrenamiento de pierna", Prioridad.MEDIA);
      Tarea t3 = new Tarea("Llamar a mama", "Hablar sobre el viaje", Prioridad.BAJA);
      
System.out.println(t1);
System.out.println(t2);
System.out.println(t3);
    }  
}

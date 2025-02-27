package es.test.tres;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas {
    private List<Tarea> tareas;

    public GestorDeTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        if (tarea == null ) {
            throw new IllegalArgumentException("Tarea inválida");
        }
        tareas.add(tarea);
    }

    public boolean completarTarea(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                return true;
            }
        }
        return false;
    }

    public List<Tarea> obtenerTareasPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletada()) {
                pendientes.add(tarea);
            }
        }
        return pendientes;
    }

    public List<Tarea> loadAll(){
        return new ArrayList<>(tareas);
    }
}
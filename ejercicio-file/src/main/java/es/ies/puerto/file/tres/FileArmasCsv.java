package es.ies.puerto.file.tres;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public class FileArmasCsv extends TxtOperationsArm{

    private Set<Arma> armas = readFileSet();
    
    /**
     * Muestra el contenido de la lista.
     * @return retorna el contenido de la lista.
     */
    public List<Arma> obtenerArmas() {
        return new ArrayList<>(armas);
    }

    /**
     * Muestra un objeto de la lista.
     * @param arma objeto a mostrar de la lista.
     * @return retorna el objeto buscado.
     */
    public Arma obtenerArma(Arma arma) {
        if(arma == null) return null;
        if(arma.getId() == null || arma.getId().isEmpty()) return null;
        for (Arma a : armas) {
            if(a.getId().equals(arma.getId())) {
                return a;
            }
        }
        return null;
    }

    /**
     * Agrega un objeto a la lista.
     * @param arma objeto a agregar a la lista.
     */
    public void addArma(Arma arma) {
        if(arma == null) return;
        if(arma.getId() == null || arma.getId().isEmpty()) return;
        armas.add(arma);
        updateFileSet(armas);
    }

    /**
     * Elimina un objeto de la lista.
     * @param arma objeto a eliminar de la lista.
     */
    public void deleteArma(Arma arma) {
        if(arma == null) return;
        if(arma.getId() == null || arma.getId().isEmpty()) return;
        if(armas.removeIf(a -> a.getId().equals(arma.getId()))) {
            updateFileSet(armas);
        }
    }

    /**
     * Actualiza un objeto de la lista.
     * @param arma objeto a actualizar de la lista.
     */
    public void updateArma(Arma arma) {
        if(arma == null) return;
        if(arma.getId() == null || arma.getId().isEmpty()) return;
        if(armas.removeIf(a -> a.getId().equals(arma.getId()))) {
            addArma(arma);
        }
    }

}
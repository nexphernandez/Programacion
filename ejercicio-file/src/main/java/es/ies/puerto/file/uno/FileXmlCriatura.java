package es.ies.puerto.file.uno;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
import java.util.List;



public class FileXmlCriatura extends OperacionesCriaturasXml{
    List<Criatura> criaturas = leerFicheroCriaturas();

    /**
     * Funcion que devuelve una lista de criaturas
     * @return lista de criaturas
     */
    public List<Criatura> obtenerCriaturas() {
        return criaturas;
    }

    /**
     * Funcion que obtiene una criatura del fichero
     * @param criatura criatura a buscar
     * @return criatura buscada con toda la informacion
     */
    public Criatura obtener(Criatura criatura) {
        if (criatura == null) {
            return null;
        }
        for (Criatura criaturaBuscar : criaturas) {
            if (criaturaBuscar.equals(criatura)) {
                return criaturaBuscar;
            }
        }
        return null;
    }
    /**
     * Funcion que agrega una criatura en el fichero
     * @param criatura a aniadir
     */
    public void addCriatura(Criatura criatura) {
        if (criatura == null) {
            return;
        }
        criaturas.add(criatura);
        escribirEnXml(criaturas);
    }
    
    /**
     * Funcion que elimina una criatura del fichero
     * @param criatura a eliminar
     */
    public void deleteCriatura(Criatura criatura) {
        if (criatura == null) {
            return;
        }
        criaturas.remove(criatura);
        escribirEnXml(criaturas);
    }

    /**
     * Funcion que actualiza los datos de una criatura
     * @param criatura con los datos actualizados 
     */
    public void updateCriatura(Criatura criatura) {
        if (criatura == null) {
            return;
        }
        int indice = criaturas.indexOf(criatura);
        criaturas.set(indice, criatura);
        escribirEnXml(criaturas);
    }
}

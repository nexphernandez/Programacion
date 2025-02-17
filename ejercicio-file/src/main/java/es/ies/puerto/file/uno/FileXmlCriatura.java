package es.ies.puerto.file.uno;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
import java.util.List;

import es.ies.puerto.file.OperacionesXml;

public class FileXmlCriatura extends OperacionesXml{
    List<Criatura> criaturas = leerFicheroCriaturas();

    /**
     * Constructor que verifica si el archivo existe el fichero
     */
    public FileXmlCriatura(){
        super();
    }

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
    public void addCriatura(Criatura criatura) {
    }
    public void deleteCriatura(Criatura criatura) {

    }
    public void updateCriatura(Criatura criatura) {

    }
}

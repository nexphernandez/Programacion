package es.ies.puerto.file.tres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
public abstract class TxtOperationsArm {

    private static String path = "src/main/resources/tres.csv";
    
    /**
     * Toma los datos de un txt y los pasa a un Set.
     * @return el Set con los datos del txt.
     */
    protected Set<Arma> readFileSet() {
        Set<Arma> armas = new HashSet<>();
        try (BufferedReader reader = new BufferedReader((new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] datos = line.split(",");
                if(datos.length == 5) {
                    Arma arma = new Arma(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
                    armas.add(arma);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return armas;
    }

    /**
     * Toma los datos de un Set y los pasa a un txt.
     * @param criaturas criaturas es el Set del que extrae los datos.
     */
    protected boolean updateFileSet(Set<Arma> armas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Arma arma : armas) {
                writer.write(arma.toString());
                writer.newLine();                
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
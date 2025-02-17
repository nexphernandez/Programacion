package es.ies.puerto.file.uno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import static utilidades.UtilClassTest.MESSAGE_ERROR;

class FileXmlCriaturaTest {
    Criatura criatura;
    FileXmlCriatura persistencia;

    List<Criatura> criaturas;

    @BeforeEach
void beforeEach() throws ParserConfigurationException, SAXException, IOException {
        persistencia = new FileXmlCriatura();
        criaturas = persistencia.obtenerCriaturas();
        criatura = new Criatura();
    }

    @Test
void obtenerCriaturasTest() {
        Assertions.assertFalse(criaturas.isEmpty(),
                MESSAGE_ERROR);
        Assertions.assertEquals(5,criaturas.size(),
                MESSAGE_ERROR);
    }

    @Test
void obtenerCriaturaTest() throws ParserConfigurationException, SAXException, IOException {
        String idBuscar = "GF003";
        Criatura critaturaBuscar = new Criatura(idBuscar);
        critaturaBuscar = persistencia.obtener(critaturaBuscar);
        Assertions.assertEquals(critaturaBuscar.getId(),idBuscar,
                MESSAGE_ERROR);
        Assertions.assertNotNull(critaturaBuscar.getNombre(),
                MESSAGE_ERROR);
        Assertions.assertTrue (critaturaBuscar.getCategoria().equals("Grifos"),
                MESSAGE_ERROR);
        Assertions.assertNotNull(critaturaBuscar.getDescripcion().equals("Un poderoso grifo con cuerpo de león y alas de águila."),
                MESSAGE_ERROR);
    }

    @Test
void addDeleteCriaturaTest() throws ParserConfigurationException, SAXException, IOException {

        int numCriaturasInicial = criaturas.size();
        Criatura criaturaInsertar = new Criatura("12345h","Elfo Arquero","Un poderoso arquero elfo que dispara una flecha y da en el blanco a 100 kilometros de distancia","Elfos");

        persistencia.addCriatura(criaturaInsertar);
        criaturas = persistencia.obtenerCriaturas();
        int numCriaturasInsertar = criaturas.size();
        Assertions.assertTrue(criaturas.contains(criaturaInsertar),
                MESSAGE_ERROR);
        Assertions.assertEquals(numCriaturasInicial +1 ,
                numCriaturasInsertar, MESSAGE_ERROR);
        persistencia.deleteCriatura(criaturaInsertar);
        criaturas = persistencia.obtenerCriaturas();
        int numCritaturasBorrado = criaturas.size();
        Assertions.assertEquals(numCriaturasInicial ,
                numCritaturasBorrado,
                MESSAGE_ERROR);
    }

    @Test
void actualizarCriatura() throws ParserConfigurationException, SAXException, IOException {
        String idActualizar = "EL004";
        Criatura CriaturaBuscar = new Criatura(idActualizar);
        Criatura CriaturaActualizar = persistencia.obtener(CriaturaBuscar);
        Criatura CriaturaBackup = persistencia.obtener(CriaturaBuscar);
        CriaturaActualizar.setNombre("Pegassus");
        CriaturaActualizar.setDescripcion("Caballo magico con alas que puede volar grandes distancias");
        CriaturaActualizar.setCategoria("Otras Criaturas");
        persistencia.updateCriatura(CriaturaActualizar);

        CriaturaBuscar = persistencia.obtener(CriaturaBuscar);
        Assertions.assertEquals(CriaturaBuscar.toString(), CriaturaActualizar.toString(),
                MESSAGE_ERROR);
        persistencia.updateCriatura(CriaturaBackup);

    }



}

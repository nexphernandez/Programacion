package es.test.tres;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TareaTest {
    Tarea tarea;
    @BeforeEach
    void beforeEach(){
        tarea = new Tarea(1, "Ingles");
    }

    @Test
    void tareaEqualTest(){
        Tarea tarea2 = new Tarea(1, "Lengua");
        Assertions.assertEquals(tarea, tarea2);
    }

    @Test
    void tareaEqualObjectTest(){
        Assertions.assertEquals(tarea, tarea);
    }

    @Test
    void tareaDiferentObjectTest(){
        Assertions.assertFalse(tarea.equals("tarea"));
    }

    @Test
    void tareaConstructorIllegalArgumentExceptionTest(){
        try {
            Tarea tarea2 = new Tarea(-1, "matematicas");
            Assertions.fail("Se ha producido un error no esperado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no esperado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void tareaConstructorIllegalArgumentException2Test(){
        try {
            Tarea tarea2 = new Tarea(2, "");
            Assertions.fail("Se ha producido un error no esperado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no esperado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void tareaConstructorIllegalArgumentException3Test(){
        try {
            Tarea tarea2 = new Tarea(2, null);
            Assertions.fail("Se ha producido un error no esperado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no esperado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void isCompletadaFalseTest(){
        Assertions.assertFalse(tarea.isCompletada());
        tarea.setCompletada(true);
    }

    @Test
    void isCompletadaTrueTest(){
        tarea.setCompletada(true);
        Assertions.assertTrue(tarea.isCompletada());
    }

    @Test
    void verificarDescripcionTest(){
        Assertions.assertEquals(tarea.getDescripcion(), tarea.getDescripcion());
    }
}

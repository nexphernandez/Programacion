package es.test.tres;




import org.junit.jupiter.api.*;

class GestorDeTareasTest {
    GestorDeTareas gestorDeTareas;
    Tarea tarea1;
    Tarea tarea2;
    
    @BeforeEach
    void beforeEach(){
        tarea1 = new Tarea(1, "Matematicas");
        tarea2 = new Tarea(2, "Lengua");
        gestorDeTareas = new GestorDeTareas();
        gestorDeTareas.agregarTarea(tarea1);
        gestorDeTareas.agregarTarea(tarea2);
    }

    @Test
    void agregarTareaTest(){
        Assertions.assertEquals(2, gestorDeTareas.loadAll().size());
    }

    @Test
    void agregarTareaIllegalArgumentExceptionsTest(){
        Tarea tarea3 = null;
        try {
            gestorDeTareas.agregarTarea(tarea3);
            Assertions.fail("Error no controlado");
            
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Tarea inválida"));
        }
    }

    @Test
    void completarTareaTrueTest(){
        boolean variante = gestorDeTareas.completarTarea(1);
        Assertions.assertTrue(variante);
    }

    @Test
    void completarTareaFalseTest(){
        boolean variante = gestorDeTareas.completarTarea(558);
        Assertions.assertFalse(variante);
    }

    @Test
    void obtenerTareasPendientesTest(){
        int tamanio = gestorDeTareas.loadAll().size();
        int tamanio2 = gestorDeTareas.obtenerTareasPendientes().size();
        Assertions.assertEquals(tamanio, tamanio2);
        gestorDeTareas.completarTarea(tarea1.getId());
        tamanio2 = gestorDeTareas.obtenerTareasPendientes().size();
        Assertions.assertNotEquals(tamanio, tamanio2);
    }
}

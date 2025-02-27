package es.test.dos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProductoTest {
    Producto producto;
    @BeforeEach
    void beforeEach() {
        producto = new Producto(1, "Papas", 10);
    }

    @Test
    void productoEqualsTest() {
        Producto producto2 = new Producto(1,"Papas fritas", 20); 
        Assertions.assertEquals(producto, producto2);
    }

    @Test
    void productoEqualsObjectTest() {
        Assertions.assertEquals(producto, producto);
    }

    @Test
    void productoDiferentObjectTest() {
        Assertions.assertFalse(producto.equals("producto"));
    }

    @Test
    void productoCosntructorIllegalArgumentExectionTest() {
        try {
            Producto producto2 = new Producto(-1,"Papas fritas", 20); 
            Assertions.fail("Se ha producido un error no controlado");
    
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
        
    }

    @Test
    void productoCosntructorIllegalArgumentExection2Test() {
        try {
            Producto producto2 = new Producto(0,"Papas fritas", -1); 
            Assertions.fail("Se ha producido un error no controlado");
    
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
        
    }

    @Test
    void productoCosntructorIllegalArgumentExection3Test() {
        try {
            Producto producto2 = new Producto(1,null, 20); 
            Assertions.fail("Se ha producido un error no controlado");
    
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void productoCosntructorIllegalArgumentExection4Test() {
        try {
            Producto producto2 = new Producto(0,"", 20); 
            Assertions.fail("Se ha producido un error no controlado");
    
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
        
    }
}

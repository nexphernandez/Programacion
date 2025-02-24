package es.test.uno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoTest {
    Pedido pedido;
    @BeforeEach
    void beforeEach() {
        pedido = new Pedido(1, 1, "Juan");
    }

    @Test
    void pedidoEqualTest() {
        Pedido pedido2 = new Pedido(1, 10,"jUAN");
        Assertions.assertEquals(pedido, pedido2);
    }

    @Test
    void pedidoEqualObjectTest() {
        Assertions.assertEquals(pedido, pedido);
    }

    @Test
    void pedidoDiferentObjectTest() {
        Assertions.assertFalse(pedido.equals("pedido"));
    }

    @Test
    void pedidoConstructorIllegalArgmentExceptionTest() {
        try {
            Pedido pedido2 = new Pedido(0, 0,"jUAN");
            Assertions.fail("Se ha producido un error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void pedidoConstructorIllegalArgmentException2Test() {
        try {
            Pedido pedido2 = new Pedido(-2, 10,"jUAN");
            Assertions.fail("Se ha producido un error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void pedidoConstructorIllegalArgmentException3Test() {
        try {
            Pedido pedido2 = new Pedido(1, 2,null);
            Assertions.fail("Se ha producido un error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }

    @Test
    void pedidoConstructorIllegalArgmentException4Test() {
        try {
            Pedido pedido2 = new Pedido(1, 2,"");
            Assertions.fail("Se ha producido un error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("Se ha producido un error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Detalles"));
        }
    }
}

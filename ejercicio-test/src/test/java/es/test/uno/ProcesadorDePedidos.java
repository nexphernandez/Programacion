package es.test.uno;

import org.junit.jupiter.api.*;

class ProcesadorDePedidosTest {

    ProcesadorDePedidos procesadorDePedidos;
    Pedido pedido1;
    Pedido pedido2;
    
    @BeforeEach
    void beforeEach() {
        pedido1 = new Pedido(1, 10, "Juan");
        pedido2 = new Pedido(2, 20, "Nico");
        procesadorDePedidos = new ProcesadorDePedidos();
        procesadorDePedidos.agregarPedido(pedido1);
        procesadorDePedidos.agregarPedido(pedido2);
    }

    @Test
    void agregarpedidoTest() {
        Assertions.assertEquals(2, procesadorDePedidos.obtenerPedidos().size());
    }


    @Test
    void agregarpedidoIllegalArgumentExceptionTest() {
        Pedido pedido3 = null;
        try {
            procesadorDePedidos.agregarPedido(pedido3);
            Assertions.fail("error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Pedido"));
        }
    }
}

package es.test.dos;


import org.junit.jupiter.api.*;

class InventarioTest {
    Inventario inventario;
    Producto producto1;
    Producto producto2;

    @BeforeEach
    void beforeEach() {
        producto1 = new Producto(1, "Papas", 10);
        producto2 = new Producto(1, "Papas fritas", 20);
        inventario = new Inventario();
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
    }

    @Test
    void agregarProductoTest() {
        Assertions.assertEquals(2, inventario.obtenerProductos().size());
    }
}

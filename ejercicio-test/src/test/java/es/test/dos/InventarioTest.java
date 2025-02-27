package es.test.dos;


import org.junit.jupiter.api.*;

class InventarioTest {
    Inventario inventario;
    Producto producto1;
    Producto producto2;

    @BeforeEach
    void beforeEach() {
        producto1 = new Producto(1, "Papas", 10);
        producto2 = new Producto(2, "Papas fritas", 20);
        inventario = new Inventario();
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
    }

    @Test
    void agregarProductoTest() {
        Assertions.assertEquals(2, inventario.obtenerProductos().size());
    }

    @Test
    void agregarProductoNullTest() {
        Producto producto =null;
        try {
            inventario.agregarProducto(producto);
            Assertions.fail("error no controlado");
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException)) {
                Assertions.fail("error no controlado");
            }
            Assertions.assertTrue(e.getMessage().contains("Producto inválido"));
        }
    }

    @Test
    void eliminarProductoTest() {
        Producto producto3 = new Producto(3, "ghf", 12);
        inventario.agregarProducto(producto3);
        inventario.eliminarProducto(3);
        Assertions.assertEquals(2, inventario.obtenerProductos().size());
    }

    @Test
    void obtenerProductoPorIdTest() {
        Producto productoNuevo = inventario.obtenerProductoPorId(1);
        Producto productoNuevo2 = inventario.obtenerProductoPorId(2);
        Assertions.assertNotNull(productoNuevo);
        Assertions.assertEquals(producto1, productoNuevo);
        Assertions.assertNotEquals(producto1, productoNuevo2);
        Assertions.assertEquals(producto1.getId(), productoNuevo.getId());
        Assertions.assertEquals(producto1.getNombre(), productoNuevo.getNombre());
        Assertions.assertEquals(producto1.getStock(), productoNuevo.getStock());
    }
}

package es.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

class ProductoServiceTest {
    private ProductoRepository productoRepository;
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        productoRepository = new ProductoRepository();
        productoService = new ProductoService(productoRepository);
    }

    @Test
    void testCrearProducto() {
        Producto producto = productoService.crearProducto(1, "Laptop", 1200.50);

        assertNotNull(producto);
        assertEquals(1, producto.getId());
        assertEquals("Laptop", producto.getNombre());
        assertEquals(1200.50, producto.getPrecio());
    }

    @Test
    void productoEqualsTest(){
        Producto producto1 = productoService.crearProducto(1,"Pan",10);
        Producto producto2 = productoService.crearProducto(1,"Jamon",1);
        assertEquals(producto1, producto2);
    }
}
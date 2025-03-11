package es.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
        Assertions.assertEquals(producto1, producto2);
    }

    @Test
    void productoNotEqualsTest(){
        Producto producto1 = productoService.crearProducto(1,"Pan",10);
        Producto producto2 = productoService.crearProducto(2,"Jamon",1);
        Assertions.assertNotEquals(producto1, producto2);
    }

    @Test
    void productoEqualsObjectsTest(){
        Producto producto = productoService.crearProducto(1,"Pan",10);
        Assertions.assertEquals(producto, producto);
    }

    @Test
    void productoDifferentObjectsTest(){
        Producto producto = productoService.crearProducto(1,"Pan",10);
        Assertions.assertFalse(producto.equals("producto"));
    }

    @Test
    void obtenerTodosLosProductoTest(){
        List<Producto> productos =  new ArrayList<>();
        Producto producto1 = productoService.crearProducto(1,"Pan",10);
        Producto producto2 = productoService.crearProducto(2,"Jamon",1);
        productos.add(producto1);
        productos.add(producto2);
        List<Producto> productos2 = productoService.obtenerTodosLosProductos();
        Assertions.assertEquals(productos, productos2);
    }

    @Test
    void deleteTest(){
        List<Producto> productos =  new ArrayList<>();
        Producto producto1 = productoService.crearProducto(1,"Pan",10);
        Producto producto2 = productoService.crearProducto(2,"Jamon",1);
        productos.add(producto1);
        productos.add(producto2);
        Assertions.assertTrue(productoService.eliminarProducto(2));
    }

    @Test
    void obtenerProductoTest(){
        List<Producto> productos =  new ArrayList<>();
        Producto producto1 = productoService.crearProducto(1,"Pan",10);
        Producto producto2 = productoService.crearProducto(2,"Jamon",1);
        productos.add(producto1);
        productos.add(producto2);
        Optional<Producto> optional = productoService.obtenerProducto(1);
        Assertions.assertEquals(producto1.getId(), optional.get().getId());
    }

}
package es.test.dos;

import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private int stock;

    public Producto(int id, String nombre, int stock) {
        if (id < 0 || nombre == null || nombre.isEmpty() || stock < 0) {
            throw new IllegalArgumentException("Detalles del producto inválidos");
        }
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this) 
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.getId());
    }
}

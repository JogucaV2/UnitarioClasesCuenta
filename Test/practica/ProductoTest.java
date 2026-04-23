package practica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void constructorConDatosValidos() {
        Producto producto = new Producto("Laptop", 1000, 5);
        assertEquals("Laptop", producto.getNombre());
        assertEquals(1000, producto.getPrecio());
        assertEquals(5, producto.getUnidades());
    }

    @Test
    void constructorConPrecioCero() {
        Producto producto = new Producto("Mouse", 0, 10);
        assertEquals(0, producto.getPrecio());
    }

    @Test
    void constructorConUnidadesCero() {
        Producto producto = new Producto("Teclado", 50, 0);
        assertEquals(0, producto.getUnidades());
    }

    @Test
    void setNombreConNombreValido() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setNombre("Notebook");
        assertEquals("Notebook", producto.getNombre());
    }

    @Test
    void setNombreConNullNoModifica() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setNombre(null);
        assertEquals("Laptop", producto.getNombre());
    }

    @Test
    void setNombreConEspaciosVaciosNoModifica() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setNombre("   ");
        assertEquals("Laptop", producto.getNombre());
    }

    @Test
    void setNombreConCadenaVaciaNoModifica() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setNombre("");
        assertEquals("Laptop", producto.getNombre());
    }

    @Test
    void setPrecioConValorPositivo() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setPrecio(1500);
        assertEquals(1500, producto.getPrecio());
    }

    @Test
    void setPrecioConCero() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setPrecio(0);
        assertEquals(0, producto.getPrecio());
    }

    @Test
    void setPrecioConValorNegativoNoModifica() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setPrecio(-100);
        assertEquals(1000, producto.getPrecio());
    }

    @Test
    void setUnidadesConValorPositivo() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setUnidades(10);
        assertEquals(10, producto.getUnidades());
    }

    @Test
    void setUnidadesConCero() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setUnidades(0);
        assertEquals(0, producto.getUnidades());
    }

    @Test
    void setUnidadesConValorNegativoNoModifica() {
        Producto producto = new Producto("Laptop", 1000, 5);
        producto.setUnidades(-5);
        assertEquals(5, producto.getUnidades());
    }
}


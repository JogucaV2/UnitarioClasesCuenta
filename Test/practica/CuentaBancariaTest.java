package practica;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {

    private CuentaBancaria cuenta ;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria("Ana Garcia", 1000);
        System.out.println("Instancia de CuentaBancaria creada para cada test");

    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando pruebas de CuentaBancaria");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("Pruebas de CuentaBancaria finalizadas");
    }

    @Test
    void setTitular() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Garcia", 1000);
        cuenta.setTitular("Andres Jimenez");
        assertEquals("Andres Jimenez", cuenta.getTitular());

        cuenta.setTitular(null);
        assertEquals("Andres Jimenez", cuenta.getTitular());

        cuenta.setTitular("   ");
        assertEquals("Andres Jimenez", cuenta.getTitular());
    }

    @Test
    void getSaldo() {

    }

    @Test
    void setSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Garcia", 1000);
        cuenta.setSaldo(100);
        assertEquals(100, cuenta.getSaldo());
        cuenta.setSaldo(-100);
        assertEquals(100, cuenta.getSaldo());

    }

    @Test
    void isBloqueada() {
    }

    @Test
    void setBloqueada() {
        cuenta.setBloqueada(true);
        assertTrue(cuenta.isBloqueada());

        cuenta.setBloqueada(false);
        assertFalse(cuenta.isBloqueada());

    }

    @Test
    void getTotalCuentasCreadas() {
    }

    @Test
    void reiniciarContador() {
    }

    @Test
    void ingresar() {
        double saldo =cuenta.getSaldo();
        assertTrue(cuenta.ingresar(200));
        assertEquals(saldo +200 , cuenta.getSaldo());
       assertFalse(cuenta.ingresar(-300));
       assertEquals(saldo +200 , cuenta.getSaldo());


        cuenta.setBloqueada(true);
        assertFalse(cuenta.ingresar(500));
        assertEquals(saldo +200 , cuenta.getSaldo());


    }


    @Test
    void retirar() {
        double saldo =cuenta.getSaldo();
        assertTrue(cuenta.retirar(200));
        assertEquals(saldo - 200 , cuenta.getSaldo());
        assertFalse(cuenta.retirar(-300));
        assertEquals(saldo - 200 , cuenta.getSaldo());
        assertTrue(cuenta.retirar(5000));
        assertEquals(saldo - 200 , cuenta.getSaldo());

        cuenta.setBloqueada(true);
        assertFalse(cuenta.retirar(500));
        assertEquals(800 , cuenta.getSaldo());



    }

    @Test
    void aplicarComisionMensual() {
        assertEquals(998, cuenta.aplicarComisionMensual());
        assertEquals(998, cuenta.getSaldo());

        assertEquals(993, cuenta.aplicarComisionMensual());
        assertEquals(993, cuenta.getSaldo());

        cuenta.setSaldo(3);
        assertEquals(0, cuenta.aplicarComisionMensual());
        assertEquals(0, cuenta.getSaldo());
        cuenta.setSaldo(8000);
        assertEquals(8000, cuenta.aplicarComisionMensual());
        assertEquals(8000, cuenta.getSaldo());

        cuenta.setSaldo(3000);

        cuenta.setBloqueada(true);
        assertEquals(3000, cuenta.aplicarComisionMensual());
        assertEquals(3000, cuenta.getSaldo());

    }



    @Test
    void bloquearSiSaldoCero() {
        assertFalse(cuenta.bloquearSiSaldoCero());
        cuenta.setSaldo(0);
        assertTrue(cuenta.bloquearSiSaldoCero());
    }

    @Test
    void testConstructor() {
        assertEquals("Ana Garcia ", cuenta.getTitular());
        assertEquals(1000, cuenta.getSaldo());
        assertFalse(cuenta.isBloqueada());


        CuentaBancaria cuentaNegativa = new CuentaBancaria("Ana Garcia", -300);
        assertEquals(0, cuentaNegativa.getSaldo());
    }

}

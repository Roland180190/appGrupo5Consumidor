package pe.cibertec.grupo5.consumidor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberParserServiceTest {

    private final NumberParserService service = new NumberParserService();

    @Test
    void convierteCadenaEnNumeros() {
        assertArrayEquals(
                new Integer[]{9, 3, 15, 1, 8},
                service.parse("9;3;15;1;8")
        );
    }

    @Test
    void rechazaValorVacio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.parse("9;;8")
        );
    }
}
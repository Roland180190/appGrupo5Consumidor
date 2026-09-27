package pe.cibertec.grupo5.consumidor.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class NumberParserService {

    public Integer[] parse(String cadenaNumeros) {
        if (cadenaNumeros == null || cadenaNumeros.isBlank()) {
            throw new IllegalArgumentException("La lista no puede estar vacía");
        }

        return Arrays.stream(cadenaNumeros.split(";", -1))
                .map(String::trim)
                .map(this::parseNumber)
                .toArray(Integer[]::new);
    }

    private Integer parseNumber(String valor) {
        if (valor.isBlank()) {
            throw new IllegalArgumentException("La lista contiene un valor vacío");
        }

        try {
            return Integer.valueOf(valor);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Valor inválido: " + valor, exception);
        }
    }
}
package es.ies.puerto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Ejercicio1Test {
    
    @Test
    void testReplaceMinimum_withPositiveNumbers() {
        List<Integer> list = new ArrayList<>(List.of(10, 5, 7, 3, 8));
        int newValue = 20;

        List<Integer> result = Ejercicio1.replaceMinimum(list, newValue);

        assertEquals(List.of(10, 5, 7, 20, 8), result);
    }

    @Test
    void testReplaceMinimum_withSingleElement() {
        List<Integer> list = new ArrayList<>(List.of(10));
        int newValue = 15;

        List<Integer> result = Ejercicio1.replaceMinimum(list, newValue);

        assertEquals(List.of(15), result);
    }

    @Test
    void testReplaceMinimum_withNegativeNumbers() {
        List<Integer> list = new ArrayList<>(List.of(-1, -3, -5, -2));
        int newValue = -10;

        List<Integer> result = Ejercicio1.replaceMinimum(list, newValue);

        assertEquals(List.of(-1, -3, -10, -2), result);
    }

    @Test
    void testReplaceMinimum_withMultipleOccurrencesOfMin() {
        List<Integer> list = new ArrayList<>(List.of(2, 2, 3, 4, 2));
        int newValue = 5;

        List<Integer> result = Ejercicio1.replaceMinimum(list, newValue);

        assertEquals(List.of(5, 2, 3, 4, 2), result);
    }

    @Test
    void testReplaceMinimum_withEmptyList() {
        List<Integer> list = new ArrayList<>();
        int newValue = 10;

        List<Integer> result = Ejercicio1.replaceMinimum(list, newValue);

        assertTrue(result.isEmpty());
    }

    @Test
    void testReplaceMinimum_withNull() {
        // Caso con lista nula
        List<Integer> list = null;
        int newValue = 100;

        assertEquals(null,Ejercicio1.replaceMinimum(list, newValue));
    }
}

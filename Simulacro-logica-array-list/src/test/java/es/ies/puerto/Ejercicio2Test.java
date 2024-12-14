package es.ies.puerto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Ejercicio2Test {
    
    @Test
    void testAllEven_withAllEvenNumbers() {
        List<Integer> list = new ArrayList<>(List.of(2, 4, 6, 8));
        boolean result = Ejercicio2.allEven(list);
        assertTrue(result);
    }

    @Test
    void testAllEven_withOddNumber() {
        List<Integer> list = new ArrayList<>(List.of(2, 4, 6, 7));
        boolean result = Ejercicio2.allEven(list);
        assertFalse(result);
    }

    @Test
    void testAllEven_withEmptyList() {
        List<Integer> list = new ArrayList<>();
        boolean result = Ejercicio2.allEven(list);
        assertTrue(result);
    }

    @Test
    void testAllEven_withSingleEvenNumber() {
        List<Integer> list = new ArrayList<>(List.of(2));
        boolean result = Ejercicio2.allEven(list);
        assertTrue(result);
    }

    @Test
    void testAllEven_withSingleOddNumber() {
        List<Integer> list = new ArrayList<>(List.of(3));
        boolean result = Ejercicio2.allEven(list);
        assertFalse(result);
    }

    @Test
    void testAllEven_withNegativeNumbers() {
        List<Integer> list = new ArrayList<>(List.of(-2, -4, -6));
        boolean result = Ejercicio2.allEven(list);
        assertTrue(result);
    }

    @Test
    void testAllEven_withNegativeOddNumber() {
        List<Integer> list = new ArrayList<>(List.of(-2, -4, -7));
        boolean result = Ejercicio2.allEven(list);
        assertFalse(result);
    }
}

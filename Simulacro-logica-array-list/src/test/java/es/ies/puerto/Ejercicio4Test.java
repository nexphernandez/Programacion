package es.ies.puerto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Ejercicio4Test {
    
    @Test
    void testReduceToSizeN_withLargeList() {
        List<Integer> list = new ArrayList<>(List.of(5, 1, 8, 3, 2));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 3);
        assertEquals(List.of(5, 8, 3), result);
    }

    @Test
    void testReduceToSizeN_withEqualElements() {
        List<Integer> list = new ArrayList<>(List.of(2, 2, 2, 2));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 2);
        assertEquals(List.of(2, 2), result);
    }

    @Test
    void testReduceToSizeN_withAlreadySmallerSize() {
        List<Integer> list = new ArrayList<>(List.of(4, 5, 6));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 5);
        assertEquals(List.of(4, 5, 6), result);
    }

    @Test
    void testReduceToSizeN_withEmptyList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 3);
        assertEquals(List.of(), result);
    }

    @Test
    void testReduceToSizeN_withSingleElement() {
        List<Integer> list = new ArrayList<>(List.of(10));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 1);
        assertEquals(List.of(10), result);
    }

    @Test
    void testReduceToSizeN_withAllIdenticalElements() {
        List<Integer> list = new ArrayList<>(List.of(1, 1, 1, 1, 1));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 3);
        assertEquals(List.of(1, 1, 1), result);
    }

    @Test
    void testReduceToSizeN_withLargerNThanListSize() {
        List<Integer> list = new ArrayList<>(List.of(7, 8, 9));
        List<Integer> result = Ejercicio4.reduceToSizeN(list, 5);
        assertEquals(List.of(7, 8, 9), result);
    }

}

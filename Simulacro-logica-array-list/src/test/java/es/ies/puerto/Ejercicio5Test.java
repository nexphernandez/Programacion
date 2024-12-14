package es.ies.puerto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Ejercicio5Test {
    @Test
    void testReverseList_withMultipleElements() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(5, 4, 3, 2, 1), result);
    }

    @Test
    void testReverseList_withSingleElement() {
        List<Integer> list = new ArrayList<>(List.of(1));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(1), result);
    }

    @Test
    void testReverseList_withEmptyList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(), result);
    }

    @Test
    void testReverseList_withNegativeNumbers() {
        List<Integer> list = new ArrayList<>(List.of(-1, -2, -3, -4, -5));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(-5, -4, -3, -2, -1), result);
    }

    @Test
    void testReverseList_withAllIdenticalElements() {
        List<Integer> list = new ArrayList<>(List.of(7, 7, 7, 7));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(7, 7, 7, 7), result);
    }

    @Test
    void testReverseList_withEvenNumberOfElements() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(4, 3, 2, 1), result);
    }

    @Test
    void testReverseList_withOddNumberOfElements() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(30, 20, 10), result);
    }

    @Test
    void testReverseList_withLargeList() {
        List<Integer> list = new ArrayList<>(List.of(100, 200, 300, 400, 500, 600, 700));
        List<Integer> result = Ejercicio5. reverseList(list);
        assertEquals(List.of(700, 600, 500, 400, 300, 200, 100), result);
    }
}

package es.ies.puerto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Ejercicio3Test {
    @Test
    void testWordLengths_withMultipleWords() {
        List<String> words = new ArrayList<>(List.of("Hola", "Mundo", "Java"));
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(4, 5, 4), result);
    }

    @Test
    void testWordLengths_withSingleWord() {
        List<String> words = new ArrayList<>(List.of("Java"));
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(4), result);
    }

    @Test
    void testWordLengths_withEmptyList() {
        List<String> words = new ArrayList<>();
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(), result);
    }

    @Test
    void testWordLengths_withEmptyString() {
        List<String> words = new ArrayList<>(List.of("Hello", ""));
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(5, 0), result);
    }

    @Test
    void testWordLengths_withNumbersAsStrings() {
        List<String> words = new ArrayList<>(List.of("123", "4567", "89"));
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(3, 4, 2), result);
    }

    @Test
    void testWordLengths_withMixedWordsAndNumbers() {
        List<String> words = new ArrayList<>(List.of("abc123", "hello", "42"));
        List<Integer> result = Ejercicio3.wordLengths(words);
        assertEquals(List.of(6, 5, 2), result);
    }
}

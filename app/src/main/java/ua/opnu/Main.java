package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 3: Printer ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        System.out.println("Друк чисел:");
        myPrinter.printArray(intArray);

        System.out.println("Друк рядків:");
        myPrinter.printArray(stringArray);


        System.out.println("\n=== ЗАВДАННЯ 4: Generic Filter ===");
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] evens = filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(evens));

        String[] words = {"apple", "banana", "pear", "kiwi"};
        String[] longWords = filter(words, s -> s.length() > 4);
        System.out.println("Довгі слова: " + Arrays.toString(longWords));

        System.out.println("\n=== ЗАВДАННЯ 5: Generic Contains ===");
        String[] names = {"Alex", "Bob", "Charlie"};

        boolean hasBob = contains(names, "Bob");
        boolean hasDave = contains(names, "Dave");

        System.out.println("Array has Bob? " + hasBob);
        System.out.println("Array has Dave? " + hasDave);

        System.out.println("\n=== ЗАВДАННЯ 6: Generic Tuples ===");
        GenericTwoTuple<String, Integer> studentGrade = new GenericTwoTuple<>("Демешко", 95);
        System.out.println("TwoTuple: " + studentGrade);
        System.out.println("Прізвище: " + studentGrade.first + ", Бал: " + studentGrade.second);

        GenericThreeTuple<String, Double, Boolean> productInfo = new GenericThreeTuple<>("Laptop", 25000.00, true);
        System.out.println("ThreeTuple: " + productInfo);
        System.out.println("Товар: " + productInfo.tuple2.first +
                ", Ціна: " + productInfo.tuple2.second +
                ", Є в наявності: " + productInfo.three);
    }

    // Реалізація методу для завдання 4
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = Arrays.copyOf(input, input.length);

        int counter = 0;
        for (T i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }

    // Реалізація методу для завдання 5
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }
}

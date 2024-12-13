package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int[] multiples = new int[30 + 1];
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;


    public int[] generatePrimes(int numberOfNumbers) {
        int[] numbers = new int[numberOfNumbers + 1];
        numbers[1] = 2;
        int numberOfPrimes = 0;

        while (numberOfPrimes < numberOfNumbers) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = numbers[ord] * numbers[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += numbers[n] + numbers[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);


            numberOfPrimes++;
            numbers[numberOfPrimes] = candidate;
        }
        return numbers;
    }
}

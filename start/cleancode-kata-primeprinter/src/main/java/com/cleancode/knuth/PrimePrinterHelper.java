package com.cleancode.knuth;

import java.io.PrintStream;

public class PrimePrinterHelper {

    private final int[] multiples = new int[30 + 1];
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;
    private final int linesPerPage = 50;
    private final int columns = 4;

    // Méthode pour générer les nombres premiers et retourner un tableau de nombres
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

    // Méthode pour imprimer les nombres
    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pageoffset = 1;
        int pagenumber = 1;

        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");

            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
}

package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfNumbers = 1000;

    public static void main(String[] args) {

        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();


        int[] numbers = primePrinterHelper.generatePrimes(numberOfNumbers);


        NumberPrinter numberPrinter = new NumberPrinter(50, 4);


        numberPrinter.printNumbers(numbers, numberOfNumbers);
    }
}

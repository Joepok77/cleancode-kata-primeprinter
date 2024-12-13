package com.cleancode.knuth;

public class PrimePrinter {

    // Déplacer la variable numberOfPrimes ici et la rendre statique
    private static final int numberOfNumbers = 1000;

    public static void main(String[] args) {
        // Créer une instance de PrimePrinterHelper
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();

        // Appeler la méthode generatePrimes pour générer les nombres
        int[] numbers = primePrinterHelper.generatePrimes(numberOfNumbers);

        // Appeler la méthode printNumbers pour imprimer les nombres
        primePrinterHelper.printNumbers(numbers, numberOfNumbers);
    }
}

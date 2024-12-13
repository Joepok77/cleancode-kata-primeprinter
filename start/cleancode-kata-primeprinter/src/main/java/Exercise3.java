public class Exercise3 {
    /**
     * @param amount price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return THE PRICE
     */
    public double calculate(double amount, int type, int years) {
        double discount = (years > 5) ? 0.05 : years / 100.0;
        double discountFactor = 1 - discount;
    // pas de break car chaque case retourne directement le calcul du prix.
        switch (type) {
            case 1: return amount;
            case 2: return amount * 0.9 * discountFactor;
            case 3: return amount * 0.7 * discountFactor;
            case 4: return amount * 0.5 * discountFactor;
            default: return amount;
        }
    }
}

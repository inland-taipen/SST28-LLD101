public class discount {
    double calculate(String customerType, double subtotal, int lines){
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines);
        return discount;
    }
}

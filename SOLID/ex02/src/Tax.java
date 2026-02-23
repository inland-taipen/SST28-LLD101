public class Tax {
    double calc(String customerType,double subtotal,double taxPct){

        double tax = subtotal * (taxPct / 100.0);
        return tax;
    }
}

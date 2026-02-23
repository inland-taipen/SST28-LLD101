public class DoubleRoom extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(15000.0);
    }
}

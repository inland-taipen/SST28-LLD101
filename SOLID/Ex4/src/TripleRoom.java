public class TripleRoom extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(12000.0);
    }
}

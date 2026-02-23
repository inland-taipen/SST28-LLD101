public class SingleRoom extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(14000.0);
    }
}

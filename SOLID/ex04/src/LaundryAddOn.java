public class LaundryAddOn extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(500.0);
    }
}

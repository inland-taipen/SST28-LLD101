public class MessAddOn extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(1000.0);
    }
}

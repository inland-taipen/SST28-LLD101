public class DeluxeRoom extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(16000.0);
    }
}

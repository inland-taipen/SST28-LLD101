public class GymAddOn extends PricingComponent {
    @Override
    public Money monthlyFee() {
        return new Money(300.0);
    }
}

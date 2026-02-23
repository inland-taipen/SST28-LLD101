import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req, List<PricingComponent> components) {
        // Loop over all components (room + add-ons) and sum monthly fees
        Money monthly = new Money(0.0);
        for (PricingComponent c : components) {
            monthly = monthly.plus(c.monthlyFee());
        }

        // Deposit is always 5000 — no need to loop for this
        Money deposit = new Money(5000.0);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}

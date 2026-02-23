import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        BookingRequest req = new BookingRequest(
                LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        // Wire up: room type + each add-on as pricing components
        List<PricingComponent> components = List.of(
                new DoubleRoom(), // the room
                new LaundryAddOn(), // add-on 1
                new MessAddOn() // add-on 2
        );

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        calc.process(req, components);
    }
}

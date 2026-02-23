import java.util.*;

public class Pricing {
    private final Menu menu;  // ← depend on YOUR Menu class, not Map

    public Pricing(Menu menu) {
        this.menu = menu;     // ← receive a Menu object
    }

    double calculate(List<OrderLine> lines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);  // ← use Menu's method
            subtotal += item.price * l.qty;
        }
        return subtotal;
    }
}

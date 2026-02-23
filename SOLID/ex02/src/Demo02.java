import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        Menu menu = new Menu();
        menu.add(new MenuItem("M1", "Veg Thali", 80.00));
        menu.add(new MenuItem("C1", "Coffee", 30.00));
        menu.add(new MenuItem("S1", "Sandwich", 60.00));

        Pricing pricing  = new Pricing(menu);
        Tax tax          = new Tax();
        discount dis     = new discount();

        CafeteriaSystem sys = new CafeteriaSystem(menu, dis, pricing, tax);

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
    }
}

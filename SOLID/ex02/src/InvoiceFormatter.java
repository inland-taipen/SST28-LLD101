import java.util.List;

public class InvoiceFormatter {
    public String format(String invId, List<OrderLine> lines, Menu menu,
                         double subtotal, double taxPct, double tax,
                         double discount, double total) {

        StringBuilder sb = new StringBuilder();

        // Header
        sb.append("Invoice# ").append(invId).append("\n");

        // Item lines
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            sb.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, item.price * l.qty));
        }

        // Totals
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        sb.append(String.format("Discount: -%.2f\n", discount));
        sb.append(String.format("TOTAL: %.2f\n", total));

        return sb.toString();
    }
}

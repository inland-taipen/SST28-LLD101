import java.util.*;

public class CafeteriaSystem {
    private final FileStore store = new FileStore();
    private final InvoiceFormatter formatter = new InvoiceFormatter();
    private int invoiceSeq = 1000;
    private discount dis;
    private Pricing pricing;
    private Tax tax;
    private Menu menu;

    public CafeteriaSystem(Menu menu, discount dis, Pricing pricing, Tax tax) {
        this.menu = menu;
        this.dis = dis;
        this.pricing = pricing;
        this.tax = tax;
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal  = pricing.calculate(lines);
        double taxPct    = TaxRules.taxPercent(customerType);
        double t         = tax.calc(customerType, subtotal, taxPct);
        double disc      = dis.calculate(customerType, subtotal, lines.size());
        double total     = subtotal + t - disc;

        // InvoiceFormatter does ALL the formatting
        String printable = formatter.format(invId, lines, menu, subtotal, taxPct, t, disc, total);

        System.out.print(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}

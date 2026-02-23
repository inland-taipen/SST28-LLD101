public class Demo06 {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender email = new EmailSender(audit);
        NotificationSender sms = new SmsSender(audit);
        NotificationSender wa = new WhatsAppSender(audit);

        SendResult r;
        r = email.send(n);
        r = sms.send(n);
        r = wa.send(n);
        if (!r.isSuccess()) {
            System.out.println("WA ERROR: " + r.getMessage());
            audit.add("WA failed");
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}

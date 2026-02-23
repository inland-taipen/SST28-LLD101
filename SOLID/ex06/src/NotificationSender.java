/**
 * Base contract: send(n) never throws; returns SendResult.
 * Subtypes must not tighten preconditions — invalid channel data
 * is reported via SendResult.failure(...), not exceptions.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract SendResult send(Notification n);
}

/**
 * Result of a send attempt. Base contract: send() never throws;
 * callers check success/message for failures (LSP-friendly).
 */
public final class SendResult {
    private final boolean success;
    private final String message;

    private SendResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static SendResult ok() {
        return new SendResult(true, null);
    }

    public static SendResult failure(String message) {
        return new SendResult(false, message);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}

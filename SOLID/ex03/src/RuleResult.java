public class RuleResult {
    boolean passed;
    String reason;

    public RuleResult(boolean passed, String reason) {
        this.passed = passed;
        this.reason = reason;
    }

    // static: can call RuleResult.pass() without creating an object
    static RuleResult pass() {
        return new RuleResult(true, null);
    }

    // static + reason: fail() must carry the reason message
    static RuleResult fail(String reason) {
        return new RuleResult(false, reason);
    }
}

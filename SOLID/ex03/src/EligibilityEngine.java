import java.util.*;

public class EligibilityEngine {
    private final List<EligibilityRules> rules; // holds all the rule objects
    private final FakeEligibilityStore store;

    public EligibilityEngine(List<EligibilityRules> rules, FakeEligibilityStore store) {
        this.rules = rules;
        this.store = store;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();

        // OCP fix: no if/else chain — just loop over all rules
        for (EligibilityRules rule : rules) {
            RuleResult result = rule.eval(s);
            if (!result.passed) {
                reasons.add(result.reason);
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;

    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}

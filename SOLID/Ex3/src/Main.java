import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);

        // Wire up all rules — add a new rule here, NOWHERE else needs to change
        List<EligibilityRules> rules = List.of(
                new Disciplinary(),
                new Cgr(),
                new Attendance(),
                new credits());

        EligibilityEngine engine = new EligibilityEngine(rules, new FakeEligibilityStore());
        engine.runAndPrint(s);
    }
}

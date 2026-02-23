public class Attendance extends EligibilityRules{
    @Override
    RuleResult eval(StudentProfile s) {
        RuleResult result = new RuleResult(true, null);
        if (s.attendancePct < 75) {
            return new RuleResult(false, "attendance below 75");
        }

        return result;
    }
}

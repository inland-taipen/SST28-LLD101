public class Cgr extends EligibilityRules{
    @Override
    RuleResult eval(StudentProfile s){
        RuleResult result = new RuleResult(true, null);
        if (s.cgr < 8.0) {
            return new RuleResult(false, "CGR below 8.0");}
        return result;
    }
}

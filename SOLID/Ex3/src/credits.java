public class credits extends EligibilityRules{
    @Override
    RuleResult eval(StudentProfile s){
        RuleResult result = new RuleResult(true, null);
        if (s.earnedCredits < 20) {
            return new RuleResult(false, "credits below 20");}
        return result;
    }
}

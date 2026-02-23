public class Disciplinary extends EligibilityRules {
    @Override
    RuleResult eval(StudentProfile profile) {
        if (profile.disciplinaryFlag != LegacyFlags.NONE)
           return new RuleResult(false,"disciplinary flag present" );
        return new RuleResult(true, "");
    }
}

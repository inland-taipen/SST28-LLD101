import java.util.ArrayList;
import java.util.List;

public class validation {
    public List<String> validate(StudentData student) {
        List<String> errors = new ArrayList<>();
        if (student.name.isBlank())
            errors.add("name is required");
        if (student.email.isBlank() || !student.email.contains("@"))
            errors.add("email is invalid");
        if (student.phone.isBlank() || !student.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");
        if (!(student.program.equals("CSE") || student.program.equals("AI") || student.program.equals("SWE")))
            errors.add("program is invalid");

       return errors;

    }
}

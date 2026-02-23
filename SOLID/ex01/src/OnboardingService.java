import java.util.*;

public class OnboardingService {
    private final parseFromRaw parser;
    private final Printer print;
    private final validation val;
    private final StudentRpo rpo;

    public OnboardingService(parseFromRaw parser, Printer print, validation val, StudentRpo rpo) {
        this.parser = parser;
        this.print = print;
        this.val = val;
        this.rpo = rpo;
    }
    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        StudentData data = parser.parse(raw);
        List<String> errors = val.validate(data);
        if (!errors.isEmpty()) {
            print.printError(errors);
            return;
        }

        String id = IdUtil.nextStudentId(rpo.count());
        StudentRecord rec = new StudentRecord(id, data.name, data.email, data.phone, data.program);

        rpo.save(rec);

        print.confirm(rec,rpo.count());
    }
}

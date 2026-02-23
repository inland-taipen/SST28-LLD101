import java.util.List;

public class Printer {
    void confirm(StudentRecord data,int total){
        System.out.println("OK: created student " + data.id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(data);
    }
    void printError(List<String> errors){
        System.out.println("ERROR: cannot register");
        for (String e : errors)
            System.out.println("- " + e);
    }
}

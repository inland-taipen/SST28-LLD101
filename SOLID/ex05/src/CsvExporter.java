import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        // LSP issue: changes meaning by lossy conversion

        String csv = "title,body\n" + csvField(req.title) + "," + csvField(req.body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String csvField(String s) {
        if (s == null) {
            return "";
        }
        if (s.contains(",") || s.contains("\n"))
            return "\"" + s.replace("\"", "\"\"") + "\"";
        return s;
    }
}

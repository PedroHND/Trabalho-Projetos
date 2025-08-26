package log;

import java.io.FileWriter;
import java.io.IOException;

public class JsonLogWriter implements LogWriter {

    public JsonLogWriter() {
    }

    @Override
    public void writeLog(LogEntry entry) throws IOException {
        String json = "{"
                + "\"timestamp\":\"" + entry.getTimestamp().toString() + "\","
                + "\"id-c\":\"" + escape(entry.getIdc()) + "\","
                + "\"operação\":\"" + escape(entry.getOperacao()) + "\""
                + "\"nome\":\"" + escape(entry.getNome()) + "\""
                + "}";

        try (FileWriter writer = new FileWriter("Operações de Log.json", true)) {
            writer.write(json + System.lineSeparator());
        }
    }

    // Escapa aspas e caracteres especiais básicos
    private String escape(String text) {
        return text.replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r");
    }
}

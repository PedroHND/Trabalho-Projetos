package log;

import java.io.FileWriter;
import java.io.IOException;

public class CsvLogWriter implements LogWriter {

    public CsvLogWriter() {
    }

    @Override
    public void writeLog(LogEntry entry) throws IOException {
        try (FileWriter writer = new FileWriter("Operações de Log.csv", true)) {
            writer.append(entry.getTimestamp().toString())
                  .append(",")
                  .append(entry.getIdc())
                  .append(",")
                  .append(entry.getOperacao())
                  .append(",")
                  .append(entry.getNome())
                  .append("\n");
                  
        }
    }
}

package log;

import java.io.IOException;

public interface LogWriter {
    void writeLog(LogEntry entry) throws IOException;
}
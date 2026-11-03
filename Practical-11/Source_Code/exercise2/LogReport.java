package exercise2;

import java.nio.file.Path;

/**
 * Encapsulates NIO file inspection metrics and keyword frequency data.
 *
 * @author Krupal Parmar (25CS057)
 */
public class LogReport {
    private final Path filePath;
    private final long fileSizeBytes;
    private final int totalLines;
    private final int matchingLines;

    public LogReport(Path filePath, long fileSizeBytes, int totalLines, int matchingLines) {
        this.filePath = filePath;
        this.fileSizeBytes = fileSizeBytes;
        this.totalLines = totalLines;
        this.matchingLines = matchingLines;
    }

    public Path getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return filePath.getFileName().toString();
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public int getMatchingLines() {
        return matchingLines;
    }
}


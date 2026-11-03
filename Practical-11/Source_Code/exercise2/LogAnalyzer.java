package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * NIO-based log analyzer inspecting files line-by-line and reading filesystem attributes.
 *
 * @author Krupal Parmar (25CS057)
 */
public class LogAnalyzer {

    /**
     * Generates realistic sample log files for demonstration.
     */
    public static void createSampleLogFiles(Path logDir) throws IOException {
        if (!Files.exists(logDir)) {
            Files.createDirectories(logDir);
        }

        Path authLog = logDir.resolve("auth.log");
        Path transLog = logDir.resolve("transaction.log");
        Path sysLog = logDir.resolve("system.log");

        Files.write(authLog, List.of(
                "[2026-11-03 10:00:15] INFO  User 'kparmar' login successful from 192.168.1.10",
                "[2026-11-03 10:02:44] WARN  Invalid password attempt for user 'guest'",
                "[2026-11-03 10:05:12] ERROR Authentication service connection timeout on port 8443",
                "[2026-11-03 10:07:01] INFO  User 'admin' initiated privilege elevation",
                "[2026-11-03 10:08:33] ERROR Brute force pattern detected; blocking IP 203.0.113.42"
        ));

        Files.write(transLog, List.of(
                "[2026-11-03 10:01:00] INFO  TXN-1001 Deposit INR 25,000 processed to AC001",
                "[2026-11-03 10:03:15] INFO  TXN-1002 Transfer INR 5,000 AC001 -> AC002 success",
                "[2026-11-03 10:04:50] ERROR TXN-1003 Database lock conflict during account ledger update",
                "[2026-11-03 10:06:18] INFO  TXN-1004 Withdrawal INR 2,000 processed from AC003",
                "[2026-11-03 10:09:20] WARN  TXN-1005 High value transaction triggered compliance review",
                "[2026-11-03 10:11:05] ERROR TXN-1006 Payment gateway returned HTTP 503 Service Unavailable",
                "[2026-11-03 10:12:40] INFO  TXN-1007 Reversal completed for TXN-1006"
        ));

        Files.write(sysLog, List.of(
                "[2026-11-03 09:55:00] INFO  System kernel initialized on node cluster-depstar-01",
                "[2026-11-03 10:00:00] INFO  Scheduled background health check completed successfully",
                "[2026-11-03 10:10:00] WARN  Memory utilization reached 84% threshold",
                "[2026-11-03 10:15:22] ERROR Disk I/O subsystem reported degraded write performance on /dev/sda2",
                "[2026-11-03 10:20:00] INFO  Garbage collection freed 420 MB heap memory"
        ));
    }

    /**
     * Inspects a single log file using java.nio.file APIs.
     * Reads line-by-line using BufferedReader and queries BasicFileAttributes for size.
     */
    public static LogReport analyzeFile(Path filePath, String keyword) throws IOException {
        // Read file size attributes using NIO
        BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
        long sizeBytes = attrs.size();

        int totalLines = 0;
        int matchingLines = 0;
        String lowerKeyword = keyword.toLowerCase();

        // Read line by line with BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                if (line.toLowerCase().contains(lowerKeyword)) {
                    matchingLines++;
                }
            }
        }

        return new LogReport(filePath, sizeBytes, totalLines, matchingLines);
    }
}


package exercise2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Driver executing NIO-based batch log file analysis and filesystem attribute reporting.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final String LOG_DIRECTORY = "sample_logs";
    private static final String SEARCH_KEYWORD = "ERROR";

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 11 - Exercise 2: NIO File Attributes & Log Analyzer");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        Path logDirPath = Paths.get(LOG_DIRECTORY);

        try {
            // 1. Create sample log files using Files and Path
            System.out.printf("Creating sample log files in '%s/' using java.nio.file.Files...%n", LOG_DIRECTORY);
            LogAnalyzer.createSampleLogFiles(logDirPath);
            System.out.println("Sample log files created successfully.\n");

            // 2. Discover all .log files in directory using DirectoryStream
            List<Path> logFiles = new ArrayList<>();
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(logDirPath, "*.log")) {
                for (Path entry : stream) {
                    logFiles.add(entry);
                }
            }
            logFiles.sort(Comparator.comparing(Path::getFileName));

            System.out.printf("--- Analyzing %d Log Files for Target Keyword: '%s' ---%n",
                    logFiles.size(), SEARCH_KEYWORD);
            System.out.printf("%-18s | %-12s | %-12s | %-14s%n",
                    "File Name", "Total Lines", "Matches (" + SEARCH_KEYWORD + ")", "Size on Disk");
            System.out.println("----------------------------------------------------------------------");

            long grandTotalLines = 0;
            long grandTotalMatches = 0;
            long grandTotalBytes = 0;

            for (Path logFile : logFiles) {
                LogReport report = LogAnalyzer.analyzeFile(logFile, SEARCH_KEYWORD);
                grandTotalLines += report.getTotalLines();
                grandTotalMatches += report.getMatchingLines();
                grandTotalBytes += report.getFileSizeBytes();

                System.out.printf("%-18s | %10d   | %12d   | %10d B%n",
                        report.getFileName(),
                        report.getTotalLines(),
                        report.getMatchingLines(),
                        report.getFileSizeBytes());
            }

            System.out.println("----------------------------------------------------------------------");
            System.out.printf("%-18s | %10d   | %12d   | %10d B%n%n",
                    "TOTAL SUMMARY", grandTotalLines, grandTotalMatches, grandTotalBytes);

            System.out.println("----------------------------------------------------------------------");
            System.out.println("  NIO Analysis Verification Summary");
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("  Total Files Inspected       : %d files%n", logFiles.size());
            System.out.printf("  Total Lines Processed       : %d lines%n", grandTotalLines);
            System.out.printf("  Keyword Occurrences ('%s')  : %d lines matched%n", SEARCH_KEYWORD, grandTotalMatches);
            System.out.printf("  Total Storage Footprint     : %d bytes (retrieved via BasicFileAttributes)%n", grandTotalBytes);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("  Status: SUCCESS (NIO line-by-line reading & attribute inspection verified)");
            System.out.println("======================================================================");

            // Cleanup sample files and directory
            for (Path logFile : logFiles) {
                Files.deleteIfExists(logFile);
            }
            Files.deleteIfExists(logDirPath);

        } catch (IOException e) {
            System.err.println("NIO Log Analysis failed with I/O error: " + e.getMessage());
        }
    }
}


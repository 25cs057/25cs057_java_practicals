package exercise1;

import java.io.Serializable;

/**
 * Serializable student entity demonstrating persistent state and transient exclusion.
 *
 * @author Krupal Parmar (25CS057)
 */
public class StudentRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String studentId;
    private final String name;
    private final double gpa;

    // Transient field: explicitly excluded from Java serialization stream
    private transient String sessionToken;

    public StudentRecord(String studentId, String name, double gpa, String sessionToken) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
        this.sessionToken = sessionToken;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return String.format("StudentRecord [ID=%s, Name=%-14s, GPA=%.2f, sessionToken=%s]",
                studentId, name, gpa, (sessionToken != null ? "'" + sessionToken + "'" : "null (transient reset)"));
    }
}


package exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Driver demonstrating serialization of object arrays and transient field behavior.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final String DATA_FILE = "student_records.ser";

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 11 - Exercise 1: Object Serialization & Transient Fields");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        // 1. Create original array of objects
        StudentRecord[] originalStudents = new StudentRecord[] {
                new StudentRecord("25CS057", "Krupal Parmar", 3.92, "SESSION-TOKEN-90812-LIVE"),
                new StudentRecord("25CS058", "Aarav Patel",   3.78, "SESSION-TOKEN-44129-LIVE"),
                new StudentRecord("25CS059", "Diya Sharma",   3.85, "SESSION-TOKEN-81273-LIVE")
        };

        System.out.println("--- 1. Original Records Before Serialization ---");
        for (StudentRecord s : originalStudents) {
            System.out.println("  " + s);
        }
        System.out.println("  Notice: All records have active sessionToken values populated.\n");

        // 2. Save array to file using ObjectOutputStream
        System.out.printf("--- 2. Serializing Object Array to File: '%s' ---%n", DATA_FILE);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(originalStudents);
            System.out.println("  Successfully written " + originalStudents.length + " StudentRecord objects via ObjectOutputStream.");
        } catch (IOException e) {
            System.err.println("  Serialization failed: " + e.getMessage());
            return;
        }

        File fileOnDisk = new File(DATA_FILE);
        System.out.printf("  Serialized File Size on Disk: %d bytes%n%n", fileOnDisk.length());

        // 3. Read back array from file using ObjectInputStream into fresh objects
        System.out.printf("--- 3. Deserializing Object Array from File: '%s' ---%n", DATA_FILE);
        StudentRecord[] deserializedStudents = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            deserializedStudents = (StudentRecord[]) ois.readObject();
            System.out.println("  Successfully deserialized object array from file stream.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("  Deserialization failed: " + e.getMessage());
            return;
        }

        // 4. Verification and Confirmation
        System.out.println("--- 4. Verification of Deserialized State ---");
        boolean allPersistentSurvived = true;
        boolean allTransientNull = true;

        for (int i = 0; i < deserializedStudents.length; i++) {
            StudentRecord loaded = deserializedStudents[i];
            StudentRecord orig = originalStudents[i];

            System.out.println("  " + loaded);

            boolean idMatches = loaded.getStudentId().equals(orig.getStudentId());
            boolean nameMatches = loaded.getName().equals(orig.getName());
            boolean gpaMatches = Double.compare(loaded.getGpa(), orig.getGpa()) == 0;

            if (!idMatches || !nameMatches || !gpaMatches) {
                allPersistentSurvived = false;
            }
            if (loaded.getSessionToken() != null) {
                allTransientNull = false;
            }
        }

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("  Serialization Integrity & Transient Behavior Summary");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Persistent Fields Survived (ID, Name, GPA) : %s%n",
                allPersistentSurvived ? "CONFIRMED (100% Data Integrity Preserved)" : "FAILED");
        System.out.printf("  Transient Field Omitted (sessionToken)      : %s%n",
                allTransientNull ? "CONFIRMED (Excluded from stream, loaded as null)" : "FAILED");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Final Status : %s%n",
                (allPersistentSurvived && allTransientNull)
                        ? "SUCCESS (Serializable & Transient mechanics fully verified)"
                        : "FAIL");
        System.out.println("======================================================================");

        // Cleanup temporary serialization artifact
        if (fileOnDisk.exists()) {
            fileOnDisk.delete();
        }
    }
}


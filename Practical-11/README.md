# Practical 11: Object Serialization, I/O Streams & NIO File Processing

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab11](https://github.com/25cs057/25cs057_java_practicals/tree/lab11)

---

## Practical Overview

This practical covers object persistence, stream serialization protocols, and modern NIO filesystem operations:
1. **Java Object Serialization:** Implementing `java.io.Serializable` and establishing class versioning via `serialVersionUID`. Writing arrays of complex object models to persistent binary files via `ObjectOutputStream` and reconstructing them via `ObjectInputStream`.
2. **Transient Field Exclusion:** Using the `transient` keyword to prevent sensitive or ephemeral runtime data (e.g., authentication tokens) from being written to byte streams, demonstrating its automatic default initialization (`null`) upon deserialization.
3. **Modern Java NIO File Processing:** Utilizing `java.nio.file.Path`, `Files`, and `BasicFileAttributes` to inspect directories, read text files line-by-line via `BufferedReader`, match keyword patterns, and query filesystem metadata (such as exact byte size) programmatically.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Object Serialization & Transient Fields (`StudentRecord.java` + `Driver.java`)
- **Problem Statement:**
  - Make a small class `Serializable`, save an array of its objects to a file with `ObjectOutputStream`, then read it back into fresh objects and confirm the values survived. Mark one field `transient` and show it is not saved.
- **Source Files:**
  - [`Source_Code/exercise1/StudentRecord.java`](Source_Code/exercise1/StudentRecord.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P11_Program01_Output.png`](Screenshots/P11_Program01_Output.png)

### Exercise 2: NIO File Attributes & Log Analyzer (`LogReport.java` + `LogAnalyzer.java` + `Driver.java`)
- **Problem Statement:**
  - Create a few text files, then use `Path`/`Files` to read each line by line and count the total lines and how many contain a keyword across all files; also print each file's size from its attributes.
- **Source Files:**
  - [`Source_Code/exercise2/LogReport.java`](Source_Code/exercise2/LogReport.java)
  - [`Source_Code/exercise2/LogAnalyzer.java`](Source_Code/exercise2/LogAnalyzer.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P11_Program02_Output.png`](Screenshots/P11_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-11\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Object Serialization & Transient Fields)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (NIO File Attributes & Log Analyzer)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical11.docx`](25CS057_KrupalParmar_Practical11.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab11 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab11)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical11.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


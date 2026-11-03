# Practical 12: Java Collections Framework

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab12](https://github.com/25cs057/25cs057_java_practicals/tree/lab12)

---

## Practical Overview

This practical explores core interfaces and concrete implementations of the Java Collections Framework:
1. **Associative Storage with `HashMap`:** Using hash-table backed key-value maps to tokenize text paragraphs, clean punctuation, and accumulate word frequency distributions with $O(1)$ average complexity.
2. **Custom Ordering via `Comparator`:** Defining custom `Comparator<Map.Entry<String, Integer>>` lambdas to sort entries descending by occurrence count, with secondary lexicographical tie-breaking.
3. **Set Implementations (`HashSet` vs `LinkedHashSet`):** Contrasting `HashSet` (bucket hashing with arbitrary iteration order) against `LinkedHashSet` (doubly-linked hash table maintaining deterministic first-seen insertion order) for visitor deduplication.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Word Frequency Counter (`WordFrequencyCounter.java` + `Driver.java`)
- **Problem Statement:**
  - Split a paragraph into words, count each in a `HashMap`, and print the words sorted by frequency (highest first) using a `Comparator`.
- **Source Files:**
  - [`Source_Code/exercise1/WordFrequencyCounter.java`](Source_Code/exercise1/WordFrequencyCounter.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P12_Program01_Output.png`](Screenshots/P12_Program01_Output.png)

### Exercise 2: Unique Visitors (`VisitorTracker.java` + `Driver.java`)
- **Problem Statement:**
  - From a list of login names with repeats, use a `HashSet` to count unique users and a `LinkedHashSet` to keep first-seen order; print the unique count and the first three distinct names.
- **Source Files:**
  - [`Source_Code/exercise2/VisitorTracker.java`](Source_Code/exercise2/VisitorTracker.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P12_Program02_Output.png`](Screenshots/P12_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-12\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Word Frequency Counter)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Unique Visitors)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical12.docx`](25CS057_KrupalParmar_Practical12.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab12 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab12)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical12.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


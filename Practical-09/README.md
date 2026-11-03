# Practical 09: Multithreading Basics, Race Conditions & Thread Synchronization

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab9](https://github.com/25cs057/25cs057_java_practicals/tree/lab9)

---

## Practical Overview

This practical explores concurrent programming in Java, thread lifecycle coordination, and data race prevention:
1. **Thread Instantiation & Coordination:** Creating and spawning concurrent worker threads via `Runnable` lambda implementations, executing them asynchronously with `Thread.start()`, and ensuring barrier synchronization using `Thread.join()`.
2. **Race Conditions & Memory Inconsistency:** Investigating how non-atomic read-modify-write sequences (such as `count++`) and unsynchronized check-then-act operations cause severe runtime failures like lost updates and inventory overselling.
3. **Mutual Exclusion via Synchronization:** Enforcing thread safety using Java's intrinsic monitor locks (`synchronized` methods) to guarantee mutual exclusion in critical sections, eliminating data races and achieving 100% computational accuracy.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Shared Counter Race Condition (`Counter.java` + `Driver.java`)
- **Problem Statement:**
  - Counter race: several threads each increment a shared counter many times. Run it without synchronization to watch the total come out too low, then make the increment synchronized and confirm it is exactly right every run.
- **Source Files:**
  - [`Source_Code/exercise1/Counter.java`](Source_Code/exercise1/Counter.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P09_Program01_Output.png`](Screenshots/P09_Program01_Output.png)

### Exercise 2: Shared Seat Booking Race Condition (`BookingSystem.java` + `Driver.java`)
- **Problem Statement:**
  - Seat booking race: a shared seatsLeft of 5 with about 10 threads each trying to book one seat. Without synchronization show that more than 5 can succeed (oversell); with a synchronized book() exactly 5 do.
- **Source Files:**
  - [`Source_Code/exercise2/BookingSystem.java`](Source_Code/exercise2/BookingSystem.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P09_Program02_Output.png`](Screenshots/P09_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-09\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Counter Race Condition & Synchronization)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Seat Booking Race Condition & Synchronized Booking)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical09.docx`](25CS057_KrupalParmar_Practical09.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab9 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab9)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical09.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


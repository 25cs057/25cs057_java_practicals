# Practical 10: Thread Pools & Inter-thread Communication

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab10](https://github.com/25cs057/25cs057_java_practicals/tree/lab10)

---

## Practical Overview

This practical covers managed multi-threaded task scheduling and thread synchronization protocols:
1. **Thread Pools (`ExecutorService`):** Managing concurrency with a bounded pool of reusable worker threads created via `Executors.newFixedThreadPool(3)`, minimizing thread instantiation overhead and memory consumption.
2. **Orderly Pool Termination:** Initiating graceful shutdown via `shutdown()` and coordinating waiting for task completion with `awaitTermination(long, TimeUnit)`.
3. **Inter-Thread Coordination (Producer-Consumer):** Coordinating worker threads using monitor condition variables (`wait()` and `notifyAll()`) over a bounded buffer to ensure serialized item exchanges in strict FIFO order with zero data loss or race conditions.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Thread-Pool Runner (`TaskWorker.java` + `Driver.java`)
- **Problem Statement:**
  - With a fixed pool of 3 (`ExecutorService`), submit about 10 `Runnable` tasks that print their id and sleep briefly; shut down and await completion, observing the few threads being reused.
- **Source Files:**
  - [`Source_Code/exercise1/TaskWorker.java`](Source_Code/exercise1/TaskWorker.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P10_Program01_Output.png`](Screenshots/P10_Program01_Output.png)

### Exercise 2: Producer-Consumer with `wait()` / `notifyAll()` (`SharedBuffer.java` + `Producer.java` + `Consumer.java` + `Driver.java`)
- **Problem Statement:**
  - One thread adds numbers to a small shared buffer and another removes them, coordinated with `wait()`/`notify()`; produce and consume a fixed number of items in order with none lost.
- **Source Files:**
  - [`Source_Code/exercise2/SharedBuffer.java`](Source_Code/exercise2/SharedBuffer.java)
  - [`Source_Code/exercise2/Producer.java`](Source_Code/exercise2/Producer.java)
  - [`Source_Code/exercise2/Consumer.java`](Source_Code/exercise2/Consumer.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P10_Program02_Output.png`](Screenshots/P10_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-10\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Thread-Pool Runner)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Producer-Consumer with wait/notifyAll)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical10.docx`](25CS057_KrupalParmar_Practical10.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab10 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab10)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical10.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


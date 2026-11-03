# Practical 08: Exception Handling

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab8](https://github.com/25cs057/25cs057_java_practicals/tree/lab8)

---

## Practical Overview

This practical covers robust runtime error handling using Java's exception mechanism:
1. **Custom Checked Exceptions:** Defining checked exception classes subclassing `Exception` to represent domain-specific fault conditions (`DivideByZeroException`, `OutOfStockException`, `InvalidQuantityException`).
2. **Deterministic Resource Management (`try-catch-finally`):** Using `finally` blocks for unconditional cleanup and logging tasks regardless of whether an exception occurs or is caught.
3. **Resilient User Input Loop:** Implementing retry control flow that catches formatting errors (`NumberFormatException`), reports user-friendly diagnostic messages, and prompts again without crashing the application.
4. **Non-Terminating Batch Processing:** Processing a sequence of batch transactions where exceptions on individual items are caught, logged, and isolated, allowing subsequent valid transactions to proceed to completion.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Guarded Calculator (`DivideByZeroException.java` + `GuardedCalculator.java` + `Driver.java`)
- **Problem Statement:**
  - Define a custom checked exception `DivideByZeroException`.
  - Write a method `divide(double a, double b) throws DivideByZeroException` that validates the denominator against zero (`b == 0.0`) and returns the quotient.
  - Implement a `finally` block printing a log message verifying that cleanup or audit execution occurs on both normal returns and exception flows.
  - Wrap division invocations in a driver reading user input in a loop, gracefully prompting again if invalid numbers or zero division are entered.
- **Source Files:**
  - [`Source_Code/exercise1/DivideByZeroException.java`](Source_Code/exercise1/DivideByZeroException.java)
  - [`Source_Code/exercise1/GuardedCalculator.java`](Source_Code/exercise1/GuardedCalculator.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P08_Program01_Output.png`](Screenshots/P08_Program01_Output.png)

### Exercise 2: Warehouse Stock Manager (`OutOfStockException.java` + `InvalidQuantityException.java` + `Warehouse.java` + `Driver.java`)
- **Problem Statement:**
  - Create custom exceptions:
    - `OutOfStockException`: carries available quantity, requested quantity, and calculated shortfall metadata.
    - `InvalidQuantityException`: thrown when requested quantity is non-positive (`<= 0`).
  - Write a `Warehouse` class managing item inventories with an `issue(String item, int qty)` method throwing the appropriate checked exceptions.
  - Drive a batch of issue requests where errors on individual items are caught, logged, and processing continues for remaining transactions without halting the batch run.
- **Source Files:**
  - [`Source_Code/exercise2/OutOfStockException.java`](Source_Code/exercise2/OutOfStockException.java)
  - [`Source_Code/exercise2/InvalidQuantityException.java`](Source_Code/exercise2/InvalidQuantityException.java)
  - [`Source_Code/exercise2/Warehouse.java`](Source_Code/exercise2/Warehouse.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P08_Program02_Output.png`](Screenshots/P08_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-08\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Guarded Calculator)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Warehouse Stock Manager)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical08.docx`](25CS057_KrupalParmar_Practical08.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab8 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab8)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical08.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


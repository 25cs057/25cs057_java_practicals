# Practical 14: Layered Architecture Application & Automated Unit Testing

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab14](https://github.com/25cs057/25cs057_java_practicals/tree/lab14)

---

## Practical Overview

This practical represents the capstone integration exercise synthesizing core object-oriented principles:
1. **Three-Tier Layered Architecture:** Decoupling software components into distinct architectural tiers:
   - **Domain Model Layer (`model.Item`):** Strongly-typed entity representing inventory items.
   - **Business Logic / Service Layer (`service.ItemService`):** Manages dynamic collections with `ArrayList`, validates data invariants, and raises domain checked exceptions (`InvalidItemException`).
   - **Presentation Layer (`ui.MenuApp`):** Interactive console interface handling user inputs, navigation, and service orchestration.
2. **Automated Unit Testing (JUnit Pattern):** Designing a self-contained unit testing subsystem with custom `@Test` metadata annotations, asserting count increments on insertion, verifying exception throwing on invalid actions (blank names, negative prices, duplicate IDs), and executing test suites via reflective introspection (`test.TestRunner`).

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Assemble and Test Layered Application
- **Problem Statement:**
  - Build a tiny layered app (a model, a service using an `ArrayList`, and a menu main), then write two or three JUnit `@Test` methods checking that adding increases the count and an invalid action throws - practice before testing MiniBank.
- **Source Files:**
  - **Model Layer:** [`Source_Code/model/Item.java`](Source_Code/model/Item.java)
  - **Service Layer:**
    - [`Source_Code/service/InvalidItemException.java`](Source_Code/service/InvalidItemException.java)
    - [`Source_Code/service/ItemService.java`](Source_Code/service/ItemService.java)
  - **Presentation Layer:** [`Source_Code/ui/MenuApp.java`](Source_Code/ui/MenuApp.java)
  - **Testing Layer:**
    - [`Source_Code/test/Test.java`](Source_Code/test/Test.java)
    - [`Source_Code/test/ItemServiceTest.java`](Source_Code/test/ItemServiceTest.java)
    - [`Source_Code/test/TestRunner.java`](Source_Code/test/TestRunner.java)
- **Execution Screenshots:**
  - [`Screenshots/P14_Program01_Output.png`](Screenshots/P14_Program01_Output.png) (Menu Application Execution)
  - [`Screenshots/P14_Program02_Output.png`](Screenshots/P14_Program02_Output.png) (Automated Unit Test Runner)

---

## Compilation & Execution Guide

### Compiling the Complete System
```powershell
cd Practical-14\Source_Code
javac model\*.java service\*.java test\*.java ui\*.java
```

### Running the Interactive Menu Application
```powershell
java -ea ui.MenuApp
```

### Running the Automated Unit Test Suite
```powershell
java -ea test.TestRunner
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical14.docx`](25CS057_KrupalParmar_Practical14.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab14 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab14)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical14.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


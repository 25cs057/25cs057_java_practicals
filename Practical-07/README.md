# Practical 07: Standard & Custom Annotations, Reflection API

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab7](https://github.com/25cs057/25cs057_java_practicals/tree/lab7)

---

## Practical Overview

This practical explores custom runtime metadata annotations and programmatic introspection via the Java Reflection API:
1. **Custom Annotations (`@interface`):** Declaring custom annotations with meta-annotations (`@Retention(RetentionPolicy.RUNTIME)` and `@Target(...)`) to decorate fields and methods with descriptive metadata.
2. **Field Reflection & Dynamic Validation:** Inspecting private class fields at runtime using `Class.getDeclaredFields()`, altering visibility via `field.setAccessible(true)`, and validating constraints declared in `@NotBlank` and `@MaxLength`.
3. **Method Reflection & Mini Test Runner:** Discovering annotated methods dynamically with `Class.getDeclaredMethods()` and `method.isAnnotationPresent(Run.class)`, and executing them programmatically with `method.invoke()` — illustrating the core architectural mechanism powering JUnit and modern testing frameworks.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Form Validator (`NotBlank.java` + `MaxLength.java` + `SignupForm.java` + `FormValidator.java` + `Driver.java`)
- **Problem Statement:**
  - Define `@NotBlank` and `@MaxLength(int)` for fields and annotate a `SignupForm`.
  - Write a checker that uses reflection to read each field’s annotations and returns the list of validation errors for a given object.
- **Source Files:**
  - [`Source_Code/exercise1/NotBlank.java`](Source_Code/exercise1/NotBlank.java)
  - [`Source_Code/exercise1/MaxLength.java`](Source_Code/exercise1/MaxLength.java)
  - [`Source_Code/exercise1/SignupForm.java`](Source_Code/exercise1/SignupForm.java)
  - [`Source_Code/exercise1/FormValidator.java`](Source_Code/exercise1/FormValidator.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P07_Program01_Output.png`](Screenshots/P07_Program01_Output.png)

### Exercise 2: Mini Test Runner (`Run.java` + `SampleTestSuite.java` + `MiniTestRunner.java` + `Driver.java`)
- **Problem Statement:**
  - Define a `@Run` annotation and mark some no-arg methods of a class with it.
  - Use reflection to find and invoke only the `@Run` methods and report how many ran — the idea behind how JUnit finds `@Test` methods.
- **Source Files:**
  - [`Source_Code/exercise2/Run.java`](Source_Code/exercise2/Run.java)
  - [`Source_Code/exercise2/SampleTestSuite.java`](Source_Code/exercise2/SampleTestSuite.java)
  - [`Source_Code/exercise2/MiniTestRunner.java`](Source_Code/exercise2/MiniTestRunner.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P07_Program02_Output.png`](Screenshots/P07_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-07\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Form Validator)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Mini Test Runner)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical07.docx`](25CS057_KrupalParmar_Practical07.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab7 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab7)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical07.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


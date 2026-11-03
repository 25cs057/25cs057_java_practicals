# Practical 13: Generic Classes, Bounded Type Parameters & Type Safety

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab13](https://github.com/25cs057/25cs057_java_practicals/tree/lab13)

---

## Practical Overview

This practical explores Java Generics, parameterized types, compile-time type verification, and bounded wildcards:
1. **Generic Container Classes (`Box<T>`, `Pair<A, B>`):** Parameterizing classes to hold arbitrary reference types safely, eliminating explicit downcasting `(T)` and preventing runtime `ClassCastException`.
2. **Generic Methods & Type Inference:** Writing generic algorithms (`<E> E getFirstElement(E[] array)`) operating polymorphically on arrays of any reference type with compiler type inference.
3. **Bounded Type Parameters (`<N extends Number>`):** Restricting generic type parameters using upper bounds to safely invoke methods defined in a superclass hierarchy (`doubleValue()`), while enforcing static compile-time rejection on non-compliant types (such as `String[]`).

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Generic Containers (`Box.java` + `Pair.java` + `ArrayUtils.java` + `Driver.java`)
- **Problem Statement:**
  - A generic `Box<T>` with get/set and a `Pair<A,B>`; use them with different types to show type safety without casts, and write a generic method that returns the first element of any array.
- **Source Files:**
  - [`Source_Code/exercise1/Box.java`](Source_Code/exercise1/Box.java)
  - [`Source_Code/exercise1/Pair.java`](Source_Code/exercise1/Pair.java)
  - [`Source_Code/exercise1/ArrayUtils.java`](Source_Code/exercise1/ArrayUtils.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P13_Program01_Output.png`](Screenshots/P13_Program01_Output.png)

### Exercise 2: Bounded Stats (`BoundedStats.java` + `Driver.java`)
- **Problem Statement:**
  - A generic method `<N extends Number> double average(N[] values)` that works for `Integer[]`, `Double[]` and `Long[]`; note why it refuses non-Number types.
- **Source Files:**
  - [`Source_Code/exercise2/BoundedStats.java`](Source_Code/exercise2/BoundedStats.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P13_Program02_Output.png`](Screenshots/P13_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-13\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Generic Containers)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Bounded Stats)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical13.docx`](25CS057_KrupalParmar_Practical13.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab13 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab13)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical13.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


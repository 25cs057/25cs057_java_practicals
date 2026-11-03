# Practical 05: Inheritance, Abstract Classes & Dynamic Method Dispatch (Polymorphism)

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab5](https://github.com/25cs057/25cs057_java_practicals/tree/lab5)

---

## Practical Overview

This practical explores core object-oriented inheritance and polymorphism mechanisms in Java:
1. **Abstract Base Classes (`abstract class`):** Declaring common template properties and contract methods (such as `abstract double area()` and `abstract double monthlySalary()`) that enforce implementation in concrete subclasses.
2. **Dynamic Method Dispatch (Runtime Polymorphism):** Processing mixed arrays of heterogeneous subclass objects through base class references (`Shape[]` and `Employee[]`), allowing Java to dynamically invoke the correct overridden subclass implementation at runtime.
3. **Subclass Constructor Chaining (`super(...)`):** Reusing base class constructors to initialize inherited fields (`name`, `id`).
4. **Type Inspection (`instanceof`):** Utilizing the `instanceof` operator to conditionally execute subtype-specific logic (e.g., adding a special note for intern employees).

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Shape Areas Polymorphism (`Shape.java` + Subclasses + `Driver.java`)
- **Problem Statement:**
  - An abstract `Shape` with `abstract area()`; subclasses `Circle`, `Rectangle`, `Triangle`.
  - Put a mix in a `Shape[]` and loop once to print each area and the running total, tracking the largest — one loop handling every shape through polymorphism.
- **Source Files:**
  - [`Source_Code/exercise1/Shape.java`](Source_Code/exercise1/Shape.java)
  - [`Source_Code/exercise1/Circle.java`](Source_Code/exercise1/Circle.java)
  - [`Source_Code/exercise1/Rectangle.java`](Source_Code/exercise1/Rectangle.java)
  - [`Source_Code/exercise1/Triangle.java`](Source_Code/exercise1/Triangle.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P05_Program01_Output.png`](Screenshots/P05_Program01_Output.png)

### Exercise 2: Polymorphic Payroll System (`Employee.java` + Subclasses + `Driver.java`)
- **Problem Statement:**
  - An abstract `Employee` with `abstract monthlySalary()`; `FullTime` (fixed), `PartTime` (hours × rate) and `Intern` (stipend), each calling `super` for the shared name/id.
  - Loop a mixed array to print each salary and the total; use `instanceof` to add a note only for interns.
- **Source Files:**
  - [`Source_Code/exercise2/Employee.java`](Source_Code/exercise2/Employee.java)
  - [`Source_Code/exercise2/FullTimeEmployee.java`](Source_Code/exercise2/FullTimeEmployee.java)
  - [`Source_Code/exercise2/PartTimeEmployee.java`](Source_Code/exercise2/PartTimeEmployee.java)
  - [`Source_Code/exercise2/InternEmployee.java`](Source_Code/exercise2/InternEmployee.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P05_Program02_Output.png`](Screenshots/P05_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-05\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Shape Areas)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Payroll System)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical05.docx`](25CS057_KrupalParmar_Practical05.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab5 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab5)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical05.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


# Practical 03: Object Class Methods (equals, hashCode, toString) & Object Arrays

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab3](https://github.com/25cs057/25cs057_java_practicals/tree/lab3)

---

## Practical Overview

This practical covers fundamental methods inherited from `java.lang.Object` and their proper overrides:
1. **`toString()` Override:** Providing meaningful, readable text representations for objects instead of the default `ClassName@HexHashCode`.
2. **`equals(Object)` and `hashCode()` Contract:** Enforcing value-based equality where two distinct memory instances with identical coordinates or card attributes evaluate as equal, ensuring compatibility with Java Collections and uniqueness algorithms.
3. **Array Deduplication & Object Searching:** Iterating object arrays and comparing items sequentially using `.equals()` to identify duplicates and count unique instances.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Distinct Points (`Point.java` + `Driver.java`)
- **Problem Statement:**
  - Create class `Point` with `private int x, y` and a constructor.
  - Override `toString()` to return `"(x, y)"`.
  - Override `equals(Object)` to be true when both `x` and `y` match, and `hashCode()` to agree (`Objects.hash(x, y)`).
  - In `Driver.main`: build a `Point[]` with some repeated coordinates.
  - Count distinct points: for each point, use `equals()` to check whether it already appeared earlier; count those that did not.
  - Print `"Distinct: N"`.
- **Expected Output:**
  - 5 points with 2 repeats -> `"Distinct: 3"`.
- **Source Files:**
  - [`Source_Code/exercise1/Point.java`](Source_Code/exercise1/Point.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P03_Program01_Output.png`](Screenshots/P03_Program01_Output.png)

### Exercise 2: Duplicate Card Check (`Card.java` + `Driver.java`)
- **Problem Statement:**
  - Create class `Card` with `private String rank, suit` and a constructor.
  - Override `toString()` to return `rank + " of " + suit` (e.g. `"Queen of Hearts"`).
  - Override `equals()/hashCode()` by rank + suit.
  - In `Driver.main`: add cards to a `Card[]` one at a time; before adding each, use `equals()` to check it against the earlier cards.
  - Print `"Duplicate found: <card>"` the first time a repeat appears.
- **Expected Output:**
  - A second `"Ace of Spades"` -> `"Duplicate found: Ace of Spades"`.
- **Source Files:**
  - [`Source_Code/exercise2/Card.java`](Source_Code/exercise2/Card.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P03_Program02_Output.png`](Screenshots/P03_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-03\Source_Code
javac exercise1\Point.java exercise1\Driver.java exercise2\Card.java exercise2\Driver.java
```

### Running Exercise 1 (Distinct Points)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Duplicate Card Check)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical03.docx`](25CS057_KrupalParmar_Practical03.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab3 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab3)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical03.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


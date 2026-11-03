# Practical 01: Java Fundamentals, Enums, Records & Switch Expressions

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab1](https://github.com/25cs057/25cs057_java_practicals/tree/lab1)

---

## Practical Overview

This practical focuses on core modern Java features introduced in Java 14+ / 17 LTS:
1. **Enums & Switch Expressions:** Using strongly-typed enumerations with modern, expression-based pattern switches that yield values directly.
2. **Records & Aggregation:** Utilizing Java records for compact, immutable data modelling without boilerplate getters/constructors/equals/hashCode methods.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Vending Machine (`VendingMachine.java`)
- **Problem Statement:**
  - Define an enum `Coin` with constants `ONE`, `TWO`, `FIVE`, `TEN`.
  - In `main`, set a snack price of 15 and a running total of 0; create a `Scanner`.
  - Loop: read a coin name, use a switch expression to convert the `Coin` to its value (`ONE->1`, `TWO->2`, `FIVE->5`, `TEN->10`), add it to the total, and print the total so far.
  - Stop the loop once the total reaches 15 or more.
  - Print the change to return (`total - 15`).
- **Expected Output:**
  - `TEN` then `FIVE` -> `Paid. Change: 0`
  - `TEN` then `TEN` -> `Paid. Change: 5`
- **Source File:** [`Source_Code/VendingMachine.java`](Source_Code/VendingMachine.java)
- **Execution Screenshot:** [`Screenshots/P01_Program01_Output.png`](Screenshots/P01_Program01_Output.png)

### Exercise 2: Toll Booth (`TollBooth.java`)
- **Problem Statement:**
  - Define a record `Vehicle(String number, String type)`.
  - In `main`, keep a running toll total and three counters (`bike`, `car`, `truck`).
  - Loop until the user types `done` for the number: build a `Vehicle`, use a switch expression on its type for the toll (`bike->20`, `car->50`, `truck->150`), add to the total, and increment that type's counter.
  - After the loop, print the total toll and the type with the highest count.
- **Expected Output:**
  - Two cars + one bike -> `Total toll: 120`, `Most frequent: car`
- **Source File:** [`Source_Code/TollBooth.java`](Source_Code/TollBooth.java)
- **Execution Screenshot:** [`Screenshots/P01_Program02_Output.png`](Screenshots/P01_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
Navigate to the source code folder and compile using JDK 17+:
```powershell
cd Practical-01\Source_Code
javac VendingMachine.java TollBooth.java
```

### Running Exercise 1 (Vending Machine)
```powershell
java VendingMachine
```
*Sample Interactive Inputs:*
- Input `TEN` followed by `FIVE` -> output confirms total 15 and `Paid. Change: 0`.
- Input `TEN` followed by `TEN` -> output confirms total 20 and `Paid. Change: 5`.

### Running Exercise 2 (Toll Booth)
```powershell
java TollBooth
```
*Sample Interactive Inputs:*
- Vehicle 1: `GJ01AB1234`, type `car` (toll: 50)
- Vehicle 2: `GJ01CD5678`, type `car` (toll: 50)
- Vehicle 3: `GJ01EF9012`, type `bike` (toll: 20)
- Number: `done`
- Output: `Total toll: 120`, `Counts -> Bike: 1, Car: 2, Truck: 0`, `Most frequent: car`.

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical01.docx`](25CS057_KrupalParmar_Practical01.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab1 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab1)
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


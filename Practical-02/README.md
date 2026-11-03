# Practical 02: Class Design, Constructors, Encapsulation & Static Members

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab2](https://github.com/25cs057/25cs057_java_practicals/tree/lab2)

---

## Practical Overview

This practical reinforces foundational Object-Oriented Programming concepts in Java:
1. **Encapsulation & Access Modifiers:** Restricting direct state mutation with `private` instance fields and controlling state updates exclusively via validated public mutator methods.
2. **Constructor Overloading & Constructor Chaining (`this()`):** Implementing multiple constructors with sensible defaults by delegating calls using `this(...)`.
3. **Static vs Instance Members:** Utilizing `static` fields and methods for global class counters and constants (`MIN`, `MAX`, `activeCount`, `totalBooked`).
4. **Immutability with `final`:** Enforcing fixed properties like cinema screen capacity with the `final` keyword.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Smart Thermostat (`Thermostat.java`)
- **Problem Statement:**
  - Create class `Thermostat` with `private String location`, `private int temperature`, `private static final int MIN=16` and `MAX=30`, and `private static int activeCount=0`.
  - `Constructor(location, startTemp)`: store location; set temperature to `startTemp` if within `MIN..MAX` else `22`; increment `activeCount`.
  - `Constructor(location)`: chain with `this(location, 22)`.
  - `raise()`: if `temperature < MAX` add 1, else print `"Already at maximum (30)"`.
  - `lower()`: if `temperature > MIN` subtract 1, else print `"Already at minimum (16)"`.
  - Add `getTemperature()` (no setter) and static `getActiveCount()`.
  - In `main`: create two thermostats, call `raise()` 10 times then `lower()` 20 times in loops (printing the temperature each time), then print `getActiveCount()`.
- **Expected Output:**
  - Temperature rises to 30 then `"Already at maximum"`, falls to 16 then `"Already at minimum"`, count 2.
- **Source File:** [`Source_Code/Thermostat.java`](Source_Code/Thermostat.java)
- **Execution Screenshot:** [`Screenshots/P02_Program01_Output.png`](Screenshots/P02_Program01_Output.png)

### Exercise 2: Cinema Show (`CinemaShow.java`)
- **Problem Statement:**
  - Create class `CinemaShow` with `private String title`, `private int seatsAvailable`, `private final int capacity`, and `private static int totalBooked=0`.
  - `Constructor(title, capacity)`: set both and `seatsAvailable = capacity`.
  - `Constructor(title)`: chain with `this(title, 100)`.
  - `book(int n)`: if `n <= seatsAvailable`, reduce `seatsAvailable` by `n`, add `n` to `totalBooked`, return `true`; else return `false` unchanged.
  - `cancel(int n)`: increase `seatsAvailable` by `n` but never above `capacity`.
  - Add `getSeatsAvailable()` and static `getTotalBooked()`.
  - In `main`: run a sequence of `book` and `cancel` calls, printing the result and seats after each, then print `getTotalBooked()`.
- **Expected Output:**
  - Booking more than available prints `false` and leaves seats unchanged; `totalBooked` equals the successful bookings.
- **Source File:** [`Source_Code/CinemaShow.java`](Source_Code/CinemaShow.java)
- **Execution Screenshot:** [`Screenshots/P02_Program02_Output.png`](Screenshots/P02_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
Navigate to the source code folder and compile using JDK 17+:
```powershell
cd Practical-02\Source_Code
javac Thermostat.java CinemaShow.java
```

### Running Exercise 1 (Smart Thermostat)
```powershell
java Thermostat
```

### Running Exercise 2 (Cinema Show)
```powershell
java CinemaShow
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical02.docx`](25CS057_KrupalParmar_Practical02.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab2 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab2)
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


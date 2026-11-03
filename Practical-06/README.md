# Practical 06: Interfaces, Default Methods, Functional Interfaces, Lambdas & Marker Interfaces

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab6](https://github.com/25cs057/25cs057_java_practicals/tree/lab6)

---

## Practical Overview

This practical covers modern Java interface features and functional programming constructs:
1. **Interfaces with Default Methods (`default`):** Providing default method bodies directly within interfaces (`default void toggle()`) allowing classes to inherit standard behavior without breaking backward compatibility.
2. **Functional Interfaces (`@FunctionalInterface`):** Defining single abstract method (SAM) contracts (`DeviceScheduler`, `Notifier`) eligible for lambda expressions and anonymous class implementations.
3. **Lambda Expressions:** Passing concise behavior as data (`(device, hour) -> ...`, `message -> ...`).
4. **Marker Interfaces:** Using tag interfaces without methods (`interface Urgent`) to mark specific classes for specialized runtime handling via `instanceof`.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Remote Control Devices (`Switchable.java` + `Fan.java` + `Light.java` + `DeviceScheduler.java` + `Driver.java`)
- **Problem Statement:**
  - An interface `Switchable` with `on()/off()` and a default `toggle()`; `Fan` and `Light` implement it.
  - Loop over a `Switchable[]` toggling each.
  - Add a functional interface that decides, given a device and an hour, whether it may switch on, and supply it once as an anonymous class and once as a lambda.
- **Source Files:**
  - [`Source_Code/exercise1/Switchable.java`](Source_Code/exercise1/Switchable.java)
  - [`Source_Code/exercise1/Fan.java`](Source_Code/exercise1/Fan.java)
  - [`Source_Code/exercise1/Light.java`](Source_Code/exercise1/Light.java)
  - [`Source_Code/exercise1/DeviceScheduler.java`](Source_Code/exercise1/DeviceScheduler.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P06_Program01_Output.png`](Screenshots/P06_Program01_Output.png)

### Exercise 2: Notification Broadcast System (`Notifier.java` + `Urgent.java` + `UrgentPushNotifier.java` + `Driver.java`)
- **Problem Statement:**
  - A functional interface `Notifier` with `send(String)`; make email and SMS senders as lambdas, hold them in an array, and broadcast one message through all.
  - Add a marker interface `Urgent` and send twice for senders marked urgent.
- **Source Files:**
  - [`Source_Code/exercise2/Notifier.java`](Source_Code/exercise2/Notifier.java)
  - [`Source_Code/exercise2/Urgent.java`](Source_Code/exercise2/Urgent.java)
  - [`Source_Code/exercise2/UrgentPushNotifier.java`](Source_Code/exercise2/UrgentPushNotifier.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P06_Program02_Output.png`](Screenshots/P06_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-06\Source_Code
javac exercise1\*.java exercise2\*.java
```

### Running Exercise 1 (Remote Control)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Notification Broadcast)
```powershell
java exercise2.Driver
```

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical06.docx`](25CS057_KrupalParmar_Practical06.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab6 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab6)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical06.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


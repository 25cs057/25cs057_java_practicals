# Practical 04: Strings, Regular Expressions & Text Parsing

**Course:** CEUE203 - Object-Oriented Programming (Java)  
**Semester:** 3 (A.Y. 2026–27)  
**Student Name:** Krupal Parmar  
**Student ID:** 25CS057  
**Department:** Computer Science & Engineering, DEPSTAR, CHARUSAT  
**GitHub Branch:** [lab4](https://github.com/25cs057/25cs057_java_practicals/tree/lab4)

---

## Practical Overview

This practical focuses on advanced string processing, regular expressions, and parsing techniques in Java:
1. **Regular Expression Validation (`matches()`):** Applying regex character classes and quantifiers to validate security rules:
   - Length check: `length() >= 8`
   - Uppercase letter check: `.*[A-Z].*`
   - Numeric digit check: `.*[0-9].*`
   - Special character check: `.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*`
2. **String Tokenization (`split(delimiter, limit)`):** Splitting formatted log records into exact fixed-count tokens while safely skipping malformed lines.
3. **Efficient String Concatenation (`StringBuilder`):** Dynamically accumulating text reports in mutable buffers to prevent excessive garbage collection overhead.

---

## Exercise Details (Part A - Regular Exercises)

### Exercise 1: Password Strength Evaluator (`PasswordChecker.java` + `Driver.java`)
- **Problem Statement:**
  - In `PasswordChecker`, check four rules — length >= 8, contains an uppercase letter, contains a digit, contains a special character — using regex or String methods.
  - Write `strength(String pw)` that counts how many rules pass and returns `"Weak"` (0–1), `"Medium"` (2–3) or `"Strong"` (4).
  - In `Driver.main`: test several passwords; for each, print which rules passed and the final label.
- **Expected Output:**
  - `"abc"` -> Weak; `"Abcd1234!"` -> Strong.
- **Source Files:**
  - [`Source_Code/exercise1/PasswordChecker.java`](Source_Code/exercise1/PasswordChecker.java)
  - [`Source_Code/exercise1/Driver.java`](Source_Code/exercise1/Driver.java)
- **Execution Screenshot:** [`Screenshots/P04_Program01_Output.png`](Screenshots/P04_Program01_Output.png)

### Exercise 2: Chat-Log Filter (`ChatFilter.java` + `Driver.java`)
- **Problem Statement:**
  - In `Driver.main`, define a `String[]` of log lines like `"10:05 alice Hello there"` (include one malformed line with fewer than 3 parts).
  - Read a keyword from the user.
  - For each line, split into time/user/message with `split(" ", 3)`; skip lines that do not have 3 parts.
  - If the message contains the keyword (case-insensitive), increment a counter and append `"time user: message"` to a `StringBuilder`.
  - Print `"Matches: N"` and the built report.
- **Expected Output:**
  - Keyword `"hello"` over 3 lines (1 malformed) -> `"Matches: 1"` and the matching line.
- **Source Files:**
  - [`Source_Code/exercise2/ChatFilter.java`](Source_Code/exercise2/ChatFilter.java)
  - [`Source_Code/exercise2/Driver.java`](Source_Code/exercise2/Driver.java)
- **Execution Screenshot:** [`Screenshots/P04_Program02_Output.png`](Screenshots/P04_Program02_Output.png)

---

## Compilation & Execution Guide

### Compiling the Programs
```powershell
cd Practical-04\Source_Code
javac exercise1\PasswordChecker.java exercise1\Driver.java exercise2\ChatFilter.java exercise2\Driver.java
```

### Running Exercise 1 (Password Strength)
```powershell
java exercise1.Driver
```

### Running Exercise 2 (Chat-Log Filter)
```powershell
java exercise2.Driver
```
*Input:* Type `hello` when prompted for keyword.

---

## Submission Artifacts

- **Word Document (.docx):** [`25CS057_KrupalParmar_Practical04.docx`](25CS057_KrupalParmar_Practical04.docx)
  - Contains complete official problem statements, formatted source code, and embedded screenshots.
  - Embedded footer link: [Official GitHub Repository (lab4 branch)](https://github.com/25cs057/25cs057_java_practicals/tree/lab4)
- **Local PC Backup Copy:** `D:\java\25cs057_java_practicals\All_Word_Documents\25CS057_KrupalParmar_Practical04.docx`
- **Screenshots Directory:** [`Screenshots/`](Screenshots/)


README Template:


# My Accounting Ledger App

This is a simple accounting ledger application built in Java. It allows users to add, view, and manage financial transactions via a text-based menu.

## 💻 Screenshots

### Main Menu
![Main Menu](screenshots/main-menu.png)

### Add Transaction
![Add Transaction](screenshots/add-transaction.png)

> 📸 Place your screenshots in a `screenshots/` folder in your repo and link to them like above.

## 🧠 Interesting Code Snippet

Here’s one part of the project I’m proud of—how transactions are parsed from a line in a CSV file:

```java
double amount = Double.parseDouble(parts[4].trim()); // Parse the amount

This line safely extracts the transaction amount from a CSV line after trimming whitespace. If the data format is off, it throws a clear NumberFormatException, which helps with debugging.

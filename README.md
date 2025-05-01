<h1 align="center">Brenda's Accounting Ledger App</h1>

This is a simple accounting ledger application built in Java. It allows users to add, view, and manage financial transactions via a text-based menu.

### Home Screen

<table>
  <tr>
    <td align="center" width="1000">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_HomeScreen.png?raw=true" width="380"/><br/>
      <sub><i>Displays home screen options</i></sub>
</table>

### Ledger Screen

<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_LedgerScreen.png?raw=true" width="450" height=300"/><br/>
      <sub><i>Displays the Ledger options</i></sub>
    </td>
<td align="center" width="500">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_LedgerScreen_AllOption.png?raw=true" width="450"/><br/>
      <sub><i>Displays the ALL of the Ledger entries</i></sub>
   </td>
  </tr>
</table>


### Transactions Screens


<table>
  <tr>
    <td align="center" width="500">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_LedgerScreen_DepositOption.png?raw=true" width="450"/><br/>
      <sub><i>Displays all of the deposits only</i></sub>
    </td>
<td align="center" width="500">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_LedgerScreen_PaymentOption.png?raw=true" width="450" height="455"/><br/>
      <sub><i>Displays all of the payments only</i></sub>
   </td>
  </tr>
</table>


### Report Screen

<table>
  <tr>
    <td align="center" width="1000">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_ReportScreen.png?raw=true" width="380"/><br/>
      <sub><i>Displays report menu options</i></sub>
</table>

### Exit System

<table>
  <tr>
    <td align="center" width="1000">
      <img src="https://github.com/brendavvng/AccountingLedger/blob/main/images/AccountingLedger_ExitSystem.png?raw=true" width="380"/><br/>
      <sub><i>Displays the exit screen when user decides to exit the system</i></sub>
</table>


## Interesting Code Snippet

Here’s one part of the project I’m proud of—how transactions are parsed from a line in a CSV file:

private static void generateMonthToDateReport() {
    System.out.println("\nMonth To Date Report:");
    LocalDate now = LocalDate.now();

    List<Transactions> mtdTransactions = loadTransactions().stream()
        .filter(transaction -> transaction.getDate().getYear() == now.getYear()
            && transaction.getDate().getMonth() == now.getMonth())
        .collect(Collectors.toList());

    displayTransactions(mtdTransactions);
}


## This explains:

loadTransactions() loads all the transactions from a file.

.stream() turns the list into a stream for processing.

.filter(...) narrows the results to only the current month and year.

.collect(Collectors.toList()) converts the stream back into a List for display.

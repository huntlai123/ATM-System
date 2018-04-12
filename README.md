# ATM-System

Summary of files:

src/Account.java
  Class that holds an account number, balance, CashCard, and password. 
  The account class is in charge of checking to see if a password matches, withdrawing, and
  calling the CashCard class to see if a CashCard is valid
  
src/ATM.java
  This class holds the bank that it belongs to and is in charge of making sure the withdrawl is
  within the range for that ATM

src/ATMSystem.java
  This class is the main tester class, and brings all the classes together. It initializes banks, ATMs,
  and accounts, and controls the user input and output.
  
src/Bank.java
  This class holds a list of ATMs and Accounts, and will find Accounts based on account numbers and
  find ATMs based on ATM names

src/CashCard.java
  This class holds the expiration date, and will check to see if the card is expired.

src/input.txt
  Example input to run on the program
  
src/output.txt
  The place where the output is stored from the input.txt file.

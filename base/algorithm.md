# Algorithm 7

## Goals -
    - Create a simple ATM program
    - Be able to create a file to read and write out to
    - Data must be persistent
    - Make multiple classes and use inheritence

## Input -
    - .dat file
    - ArrayList of Customers, Savings Accounts, and Checking Accounts

## Output -
    - File to store all Customer Account data (account.dat)
    - Menu system

### get/set() methods
    - get/set the value of requested data type

### getUser(<Customer>, <Savings>, <Checking>): void
    - for every Customer in the ArrayList
        - Print the user's ID and PIN
        - Print the user's Savings and Checking balance

### addUser(<Customer>, <Savings>, <Checking>, String, String, double): void
    - Ask admin for new user ID and PIN
    - The account balances will always start $0.00

### delUser(<Customer>, <Savings>, <Checking>, String): void
    - Check every customer's ID and if it matches with the one input by the Admin
        - As long as the Customer's account balences are empty
            - Remove Customer's ID, PIN, Savings account and Checking account from corresponding ArrayList

### addInterest(<Savings>, int): void
    - Get the balance of the Savings account
    - Use intrest formula: I = P(1 + rt)
        - I = interest
        - P = principle
        - r = rate
        - t = time(months)

### withdraw(double): void
    - if the amount requested if higher than tell the user they can not withdraw that amount
    - otherwise remove the amount from balance

### deposit(double): void
    - add the amount to the balance

### main(): void
    - create a .dat file to read and write to
    - read the file and create Customers, Savings, and Checking objects into their respective ArrayList
    - ask for user input for simple menuing
    - write the adjusted account info into the .dat file
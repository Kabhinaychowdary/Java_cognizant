CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'Ramesh Kumar', TO_DATE('1963-05-15', 'YYYY-MM-DD'), 12000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Priya Sharma', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 8000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 5, SYSDATE, SYSDATE + 25);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Lakshmi Iyer', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Karthik Raja', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;

ALTER TABLE Customers ADD IsVIP CHAR(1);

SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur IS
        SELECT CustomerID, DOB FROM Customers;
    age NUMBER;
BEGIN
    FOR rec IN cur LOOP
        age := MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12;

        IF age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ' interest rate decreased by 1%.');
        END IF;
    END LOOP;
END;
/

DECLARE
    CURSOR cur IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR rec IN cur LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ' promoted to VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ' not VIP.');
        END IF;
    END LOOP;
END;
/

DECLARE
    CURSOR cur IS
        SELECT CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN cur LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || ' for CustomerID: ' || rec.CustomerID);
    END LOOP;
END;
/

SELECT * FROM Customers;
SELECT * FROM Loans;
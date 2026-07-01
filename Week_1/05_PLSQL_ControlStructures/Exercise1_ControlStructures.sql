BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate 
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;
    COMMIT;
END;
/

BEGIN
    FOR rec IN (
        SELECT CustomerID 
        FROM Customers 
        WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;
    COMMIT;
END;
/

BEGIN
    FOR rec IN (
        SELECT c.Name, l.LoanID, l.DueDate 
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ', Loan ID ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.DueDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/

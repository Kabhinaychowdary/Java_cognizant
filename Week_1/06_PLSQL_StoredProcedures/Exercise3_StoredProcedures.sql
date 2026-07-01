CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN INT,
    p_target_account IN INT,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_balance 
    FROM Accounts 
    WHERE AccountID = p_source_account 
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts 
    SET Balance = Balance - p_amount 
    WHERE AccountID = p_source_account;

    UPDATE Accounts 
    SET Balance = Balance + p_amount 
    WHERE AccountID = p_target_account;

    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for the transfer.');
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/

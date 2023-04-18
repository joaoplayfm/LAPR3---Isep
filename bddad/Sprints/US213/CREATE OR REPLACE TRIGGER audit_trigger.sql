CREATE OR REPLACE TRIGGER audit_trigger
AFTER INSERT OR UPDATE OR DELETE ON Operacao
    FOR EACH ROW
DECLARE
v_operation VARCHAR2(20);
BEGIN
  -- Store information about the operation in variables
  IF INSERTING THEN
    v_operation := 'INSERT';
  ELSIF UPDATING THEN
    v_operation := 'UPDATE';
ELSE
    v_operation := 'DELETE';
END IF;

  -- Insert a record in the audit table
INSERT INTO audit_table (username, operation, timestamp)
VALUES (USER,  v_operation, SYSTIMESTAMP);
END;
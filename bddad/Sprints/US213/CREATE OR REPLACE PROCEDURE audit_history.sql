CREATE OR REPLACE PROCEDURE audit_history (p_username IN VARCHAR2) AS
BEGIN
SELECT * FROM audit_table
WHERE username = p_username
ORDER BY operation_timestamp ASC;
END;

DECLARE
v_username VARCHAR2(30) := 'Gestor Agricola';
BEGIN
  audit_history(v_username);
END;

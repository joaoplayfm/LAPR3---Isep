CREATE OR REPLACE PROCEDURE prc_registar_encomendas(id_encomenda NUMBER , quantidade NUMBER , produtos VARCHAR, data_encomenda DATE , endereco VARCHAR2, estado_encomenda VARCHAR2, p_nifCliente NUMBER)
AS
    pragma autonomous_transaction;
BEGIN
    INSERT INTO Encomenda VALUES(id_encomenda, quantidade, produtos, data_encomenda, endereco, estado_encomenda, p_nifCliente);
    COMMIT;
END;
/


CREATE OR REPLACE PROCEDURE prc_delete_registo_encomenda(p_del INTEGER)
AS
    pragma autonomous_transaction;
BEGIN
    DELETE FROM Encomenda;
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE alterar_hub_por_defeito (
    p_nif_cliente IN VARCHAR2,
    p_id_hub IN INTEGER
)
AS
BEGIN
    UPDATE Cliente
    SET hub_por_defeito = p_id_hub  --  o identificador do hub que deve ser atribuído como o hub por defeito do cliente.
    WHERE nif = p_nif_cliente;  -- o NIF do cliente cujo hub por defeito deve ser alterado.
END;
/
BEGIN
    alterar_hub_por_defeito('123456789', 1);
END;
/

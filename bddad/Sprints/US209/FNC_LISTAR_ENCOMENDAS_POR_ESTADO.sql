CREATE OR REPLACE FUNCTION listar_encomendas_por_estado (id_encomenda NUMBER , quantidade NUMBER , produtos VARCHAR, data_encomenda DATE , endereco VARCHAR2, estado_encomenda VARCHAR2, p_nifCliente NUMBER, preco NUMBER) 
RETURN SYS_REFCURSOR

IS
    v_estadoList SYS_REFCURSOR;
BEGIN
OPEN v_estadoList FOR   
SELECT e.estado_encomenda AS "ESTADO", e.id_encomenda AS "ID", e.endereco AS "Endereco" , e.clientenif AS "nif", e.quantidade AS "QUANTIDADE" , e.preco AS "preco" , e.data_pagamento AS " data" ,e.produtos AS "produtos"
INTO t_estado ,t_quantidade, t_id_encomenda , t_endereco, t_clientenif, t_preco ,  t_data_pagamento, t_produtos
FROM gestor_agricula g, quinta q, cliente c, encomenda e
ORDER BY estado_encomenda DESC  
RETURN v_estadoList;
END;
/

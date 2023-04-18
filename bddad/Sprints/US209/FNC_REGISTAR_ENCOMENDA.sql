CREATE OR REPLACE FUNCTION registar_pedidos_clientes( p_nifCliente Cliente.nif%type, id_encomenda Encomenda.id_encomenda%type , quantidade Encomenda.quantidade%type , produtos Encomenda.produtos%type , data Encomenda.data_encomenda%type , enderecoEnt Encomenda.endereco%type , estado Encomenda.estado_encomenda%type , preco Encomenda.preco , dataPag Encomenda.data_pagamento%type ,  dataEnt Encomenda.data_entrega%type, plafond Cliente.plafond%type, enderecoCliente Cliente_corresp.endereco%type) RETURN VARCHAR
IS
 v_client_count int;
 v_data_count int;
 v_plafond_count int;

BEGIN

 SELECT COUNT(*) 
 INTO v_client_count
 FROM gestor_agricula g, quinta q, cliente c, encomenda e
 WHERE e.nif = p_nifCliente
    IF v_client_count = 0
    THEN raise_application_error(-20010, ' Invalid Cliente NIF');
    prc_delete_registo_encomenda(0);
 RETURN v_client_count;
 

SELECT COUNT(*) 
INTO v_data_count 
FROM gestor_agricula g, quinta q, cliente c, encomenda e
WHERE e.enderecoEnt = enderecoCliente;
    IF v_data_count = 0
    THEN raise_application_error(-20011, 'Morada de Entrega diferente de morada de cliente');
    prc_delete_registo_encomenda(0);
    RETURN v_data_count;


SELECT COUNT(*) 
INTO v_plafond_count 
FROM gestor_agricula g, quinta q, cliente c, encomenda e
WHERE e.plafond = preco;
    IF v_plafond_count = 0
    THEN raise_application_error(-20012, 'Cliente nao tem plafond suficiente para encomendar produtos');
    prc_delete_registo_encomenda(0);
 RETURN v_plafond_count;
 prc_registar_encomendas(id_encomenda , quantidade , produtos , data_encomenda , endereco , estado_encomenda , p_nifCliente)
 end;
 /


 
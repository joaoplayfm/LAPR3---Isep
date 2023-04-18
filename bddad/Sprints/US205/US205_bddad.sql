CREATE OR REPLACE FUNCTION func_register_client(nome Cliente.nome%type,nif Cliente.nif%type, email Cliente.email%type, codigo_interno Cliente.codigo_interno%type, morada_corresp Cliente.morada_corresp%type, morada_entrega Cliente.morada_entrega%type,plafond Cliente.plafond%type)
RETURN Cliente.id%type
IS
Cliente_id Cliente.id%type;
rep number;
emailErro EXCEPTION;
nifErro EXCEPTION;
BEGIN
    SELECT count(*) INTO rep FROM Cliente WHERE Cliente.nif = nif;
    IF rep>0 THEN
        RAISE nifErro;
    END IF;
    SELECT count(*) INTO rep FROM Cliente WHERE Cliente.email = email;
    IF rep>0 THEN
        RAISE emailErro;
    END IF;
        INSERT INTO Cliente(nome,nif,email,morada_corresp,morada_entrega,plafond) VALUES(nome,nif,email,morada_corresp, morada_entrega, plafond);
        SELECT Max(id) INTO Cliente_id
        FROM Cliente;
        dbms_output.put_line('Cliente criado com sucesso! ID: ' || Cliente_id);
        RETURN Cliente_id;
    EXCEPTION
    WHEN nifErro THEN
        dbms_output.put_line('NIF pertence a outro cliente!');
        RETURN NULL;
    WHEN emailErro THEN
        dbms_output.put_line('Email pertence a outro cliente');
        RETURN NULL;
END;

CREATE OR REPLACE PROCEDURE prc_update_client AS
BEGIN
UPDATE Cliente cli
SET cli.num_ecomendas = (SELECT COUNT(Clientenif) FROM   Encomenda where Clientenif = cli.nif and data_encomenda>(SELECT current_date-365 FROM dual)),
cli.valor_total = (SELECT sum(valor) FROM Encomenda where Clientenif=cli.nif and data_encomenda>(SELECT current_date-365 FROM dual)),
cli.nr_incidentes  = (SELECT count(Clientenif) FROM Encomenda WHERE Clientenif = cli.nif and (data_pagamento IS NULL AND data_entrega IS NOT NULL) and data_vencimento>(SELECT current_date-365 FROM dual))
where nif = cli.nif;
UPDATE Cliente cli
set cli.nivel = 'B'
Where valor_total >= 5000 and nif = cli.nif;
UPDATE Cliente cli
set cli.nivel = 'A'
WHERE valor_total >= 10000 and nif = cli.nif;
UPDATE Cliente cli
SET cli.nivel = 'C'
WHERE nr_incidentes != 0;
END;

EXECUTE prc_update_client;

CREATE OR REPLACE VIEW vw_cliente AS
SELECT cli.nif as Clientenif, (SELECT COUNT(Clientenif) FROM Encomenda where Clientenif = cli.nif and estado_encomenda = 'paga' and data_encomenda >= add_months(sysdate, -12)) as "Vendas pagas",
(SELECT COUNT(Clientenif) FROM Encomenda WHERE Clientenif = cli.nif and estado_encomenda = 'entrgue') "Entregues e Por Pagar",
(SELECT nvl(TO_CHAR(MAX(i.data_ocorrencia), 'DD/MM/YYYY'), 'Sem incidentes à data') FROM Incidentes i,Encomenda e1 WHERE cli.nif =e1.Clientenif AND e1.id_encomenda = i.id_incidente) "Ultimo Incidentes" , nivel
FROM Cliente cli;

CREATE OR REPLACE FUNCTION func_get_risk(nif IN Cliente.nif%TYPE)
RETURN NUMBER
IS
    nome Cliente.nome%type;
    num_enco_pos NUMBER;
    valor_total_incid NUMBER;
    risk_factor NUMBER;
    data_ultim_incid DATE;
BEGIN
    SELECT nome into nome
    FROM  Cliente
    WHERE Cliente.nif = nif;
    SELECT SUM(Incidentes.valor) INTO valor_total_incid
    FROM Incidentes, Encomenda
    WHERE Encomenda.Clientenif=nif  AND Encomenda.id_encomenda = Incidentes.id_incidente AND data_ocorrencia >= add_months(sysdate, -12);
    SELECT MAX(data_ocorrencia) INTO data_ultim_incid
    FROM Incidentes,Encomenda
    WHERE Encomenda.Clientenif=nif AND Encomenda.id_encomenda= Incidentes.id_incidente;
    SELECT COUNT(*) INTO num_enco_pos
    FROM Encomenda
    WHERE Encomenda.Clientenif = client_id AND data_encomenda > data_ultim_incid and Pagamento = 'não paga';
    IF num_enco_pos = 0 THEN
        DBMS_OUTPUT.PUT_LINE('O fator de risco é 0');
    ELSE
        risk_factor :=  valor_total_incid / num_enco_pos;
        DBMS_OUTPUT.PUT_LINE('O fator de risco é: ' ||risk_factor);
    END IF;
    RETURN risk_factor;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Sem incidentes');
        RETURN NULL;
END;


declare
fatorRisco NUMBER;
begin
fatorRisco := func_get_risk(8);
end;

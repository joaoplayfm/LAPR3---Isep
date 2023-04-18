Create or Replace Procedure delete_ops (data_sem_ant in Date, id NUMBER)
    As
        l_count number;
        data_op Operacao.data_operacao%type;
        tipo_op Operacao.tipo_operacao%type;
        forma_apl Operacao.forma_aplicacao%type;
        id_op Operacao.id_operacao%type;
        nome_prod Operacao.nome_produto%type;
        quant Operacao.quantidade%type;
        parc Operacao.ParcelasId_parcelas%type;
        new_date Date;
    Cursor list_ops IS
    Select id_operacao, tipo_operacao,  data_operacao, nome_produto, ParcelasId_parcelas
    From Operacao;
    Begin
    Open list_ops;
    Loop
    Fetch list_ops Into id_op, tipo_op, data_op, nome_prod,  parc;
        Exit When list_ops%notfound;
            IF id = id_op then
                if data_sem_ant < data_op then
                delete from operacao op where op.id_operacao = id;
                DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_op || ' foi eliminada.');
                end if;
            end if;
    End Loop;
    Close list_ops;
    End;

Call delete_ops(Date '2020-05-05',901);

CREATE OR REPLACE PROCEDURE alter_ops (data_sem_ant IN DATE, id_op IN NUMBER, data_op_alt IN DATE,tipo_op_alt IN VARCHAR2, forma_apl_alt IN VARCHAR2, nome_produto_alt IN VARCHAR2, quant_alt IN NUMBER) 
    AS
    l_count NUMBER;
    data_op Operacao.data_operacao%type;
    tipo_op Operacao.tipo_operacao%type;
    forma_apl Operacao.forma_aplicacao%type;
    id_operacao Operacao.id_operacao%type;
    nome_prod Operacao.nome_produto%type;
    quantidade Operacao.quantidade%type;
    new_date DATE;
    Cursor list_ops IS
    SELECT id_operacao, tipo_operacao, data_operacao, nome_produto, quantidade
    FROM Operacao;
BEGIN
    OPEN list_ops;
    LOOP
        FETCH list_ops INTO id_operacao, tipo_op, data_op, nome_prod, quantidade;
        EXIT WHEN list_ops%NOTFOUND;
        IF id_op = id_operacao THEN
            IF data_sem_ant < data_op THEN
                IF data_op_alt IS NOT NULL THEN
                    UPDATE Operacao op SET op.data_operacao = data_op_alt WHERE op.id_operacao = id_op;
                    DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_operacao || ' foi alterada a data para ' || data_op_alt);
                END IF;
                IF tipo_op_alt IS NOT NULL THEN
                    UPDATE Operacao op SET op.tipo_operacao = tipo_op_alt WHERE op.id_operacao = id_op;
                    DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_operacao || ' foi alterado o tipo de operação para ' || tipo_op_alt);
                END IF;
                IF forma_apl_alt IS NOT NULL THEN
                    UPDATE Operacao op SET op.forma_aplicacao = forma_apl_alt WHERE op.id_operacao = id_op;
                    DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_operacao || ' foi alterada a forma de aplicação para ' || forma_apl_alt);
                END IF;
                IF nome_produto_alt IS NOT NULL THEN
                    UPDATE Operacao op SET op.nome_produto = nome_produto_alt WHERE op.id_operacao = id_op;
                    DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_operacao || ' foi alterada a a forma de aplicao para ' || forma_apl_alt);
                end if;
                if quant_alt is not null then
                    update operacao op set op.quantidade = quant_alt where op.id_operacao = id_op;
                    DBMS_OUTPUT.PUT_LINE('Operação de id ' || id_operacao  || ' foi alterado a quantidade do produto para ' || quant_alt);
                end if;

                end if;
    end if;
    End Loop;
    Close list_ops;
    End;


Call alter_ops(Date '2020-04-01', 900, Date '2020-04-11', 'irrigacao', 'solo', 'kils', 2);
select * from operacao;

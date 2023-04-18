-- US214 6a)--
Create Or Replace Procedure comparar_vendas(ano1 number, ano2 number)
As 
    Cursor lista_ano1 is
    select vendas_milhares_euros
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1));
    CURSOR Lista_ano2 is
    Select vendas_milhares_euros
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano2));
    vendas1 Data_Warehouse.vendas_milhares_euros%type;
    vendas2 Data_Warehouse.vendas_milhares_euros%type;
    soma1 number :=0;
    soma2 number :=0;

BEGIN 
    OPEN Lista_ano1;
        Loop
            Fetch Lista_ano1 into vendas1;
            Exit when lista_ano1%notfound;
            soma1:=soma1+vendas1;
        end loop;
    Close Lista_ano1;
    Open Lista_ano2;
    Loop
            Fetch Lista_ano2 into vendas2;
            Exit when lista_ano2%notfound;
            soma2:=soma2+vendas2;
        end loop;
    Close Lista_ano2;
    
    DBMS_OUTPUT.put_line('Ano 1: ' || soma1 || ' || Ano 2: ' || soma2);

End;

Call comparar_vendas(2017, 2018);

-- US214 6b) --
Create Or Replace Procedure comparar_producao(ano1 NUMBER, cultura VARCHAR)
As 
    Cursor lista_ano1 is
    select producao_toneladas
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1) AND produtoid_produto IN (SELECT id_produto FROM produto_star WHERE culturaid_cultura IN(Select id_cultura From cultura WHERE nome_cultura IN (cultura))));
    CURSOR Lista_ano2 is
    Select producao_toneladas
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1 + 1) AND produtoid_produto IN (SELECT id_produto FROM produto_star WHERE culturaid_cultura IN(Select id_cultura From cultura WHERE nome_cultura IN (cultura))));
    CURSOR lista_ano3 is
    Select producao_toneladas
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1 + 2) AND produtoid_produto IN (SELECT id_produto FROM produto_star WHERE culturaid_cultura IN(Select id_cultura From cultura WHERE nome_cultura IN (cultura))));
    CURSOR lista_ano4 is
    Select producao_toneladas
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1 + 3) AND produtoid_produto IN (SELECT id_produto FROM produto_star WHERE culturaid_cultura IN(Select id_cultura From cultura WHERE nome_cultura IN (cultura))));
    CURSOR lista_ano5 is
    Select producao_toneladas
    From Data_Warehouse
    Where Tempoid_tempo IN (Select id_tempo FRom tempo WHERE ano IN (ano1 + 4) AND produtoid_produto IN (SELECT id_produto FROM produto_star WHERE culturaid_cultura IN(Select id_cultura From cultura WHERE nome_cultura IN (cultura))));
    producao1 Data_Warehouse.producao_toneladas%type;
    producao2 Data_Warehouse.producao_toneladas%type;
    producao3 Data_Warehouse.producao_toneladas%type;
    producao4 Data_Warehouse.producao_toneladas%type;
    producao5 Data_Warehouse.producao_toneladas%type;
    soma1 number :=0;
    soma2 number :=0;
    soma3 number :=0;
    soma4 number :=0;
    soma5 number :=0;

BEGIN 
    OPEN Lista_ano1;
        Loop
            Fetch Lista_ano1 into producao1;
            Exit when lista_ano1%notfound;
            soma1:=soma1+producao1;
        end loop;
    Close Lista_ano1;
    Open Lista_ano2;
    Loop
            Fetch Lista_ano2 into producao2;
            Exit when lista_ano2%notfound;
            soma2:=soma2+producao2;
        end loop;
        Close Lista_ano2;
    Open Lista_ano3;
    Loop
            Fetch Lista_ano3 into producao3;
            Exit when lista_ano3%notfound;
            soma3:=soma3+producao3;
        end loop;
        Close Lista_ano3;
        Open Lista_ano4;
    Loop
            Fetch Lista_ano4 into producao4;
            Exit when lista_ano4%notfound;
            soma4:=soma4+producao4;
        end loop;
        Close Lista_ano4;
    Open Lista_ano5;
    Loop
            Fetch Lista_ano5 into producao5;
            Exit when lista_ano5%notfound;
            soma5:=soma5+producao5;
        end loop;
        Close Lista_ano5;

    
    DBMS_OUTPUT.put_line('Ano 1: ' || soma1 || ' || Ano 2: ' || soma2 || ' || Ano 3: ' || soma3 || ' || Ano 4: ' || soma4 || ' || Ano 5: ' || soma5);

End;

call comparar_producao(2017, 'macieira');

-- US214 6c --
CREATE OR REPLACE VIEW analisar_vendas_mensais AS
    SELECT tipo_cultura_nome, t.ano, t.mes, SUM(vendas_milhares_euros) AS total_vendas
    FROM Data_Warehouse dw
    INNER JOIN Produto p ON dw.Produtoid_produto = p.id_produto
    INNER JOIN Tipo_Cultura tc ON p.Tipo_Culturaid_tipo_cultura = tc.id_tipo_cultura
    INNER JOIN Tempo t ON dw.Tempoid_tempo = t.id_tempo
    GROUP BY tipo_cultura_nome, t.ano, t.mes
    ORDER BY tipo_cultura_nome, t.ano, t.mes ASC;

SELECT * FROM  analisar_vendas_mensais;

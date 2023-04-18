-- US208 --

CREATE OR REPLACE PROCEDURE prc_insert_fat(id_fat_producao NUMBER, classificacao VARCHAR, nome VARCHAR, formulacao VARCHAR, id_armazem NUMBER)
AS
    pragma autonomous_transaction;
BEGIN
    INSERT INTO fatores_producao VALUES(id_fat_producao, classificacao, nome, formulacao, id_armazem);
    COMMIT;
END;

call prc_insert_fat(112, 'adubos', 'adub', 'po', 80);
SELECT * FROM fatores_producao;

CREATE OR REPLACE PROCEDURE prc_update_fat(id_fat_producao NUMBER, classificacao VARCHAR, nome VARCHAR, formulacao VARCHAR)
AS
    pragma autonomous_transaction;
BEGIN
    UPDATE  fatores_producao ft SET ft.classificacao = classificacao, ft.nome = nome, ft.formulacao = formulacao WHERE ft.id_fat_producao = id_fat_producao; 
    COMMIT;
END;

call prc_update_fat(112, 'fertilizantes', 'adub', 'po');
SELECT * FROM fatores_producao;



CREATE OR REPLACE PROCEDURE pcr_del_fat(id_fat NUMBER)
AS
    ids NUMBER;
    pragma autonomous_transaction;
    CURSOR  apagar IS
    Select id_ficha_tecnica
    From ficha_tecnica
    Where Fatores_Producaoid_fat_producao = id_fat;
BEGIN
    OPEN apagar;
        Loop
            Fetch apagar INTO ids;
            EXIT when apagar%notfound;
           DELETE FROM ficha_tecnica fe WHERE fe.id_ficha_tecnica = ids; 
        end loop;
    Close apagar;
    
    DELETE FROM fatores_producao ft WHERE ft.id_fat_producao = id_fat;
    COMMIT;
END;

call pcr_del_fat(110);
SELECT * FROM fatores_producao;
------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE prc_insert_tec(id_fi NUMBER, n NUMBER, p2o5 NUMBER, k2o NUMBER, cao NUMBER,  mgo NUMBER,  toc NUMBER,  mat_org NUMBER,  hum NUMBER,  fulv NUMBER, humd NUMBER, ph NUMBER, peso VARCHAR, formu VARCHAR, id_fat NUMBER )
AS
    pragma autonomous_transaction;
BEGIN
    INSERT INTO ficha_tecnica VALUES(id_fi, n, p2o5, k2o, cao, mgo, toc, mat_org, hum, fulv, humd, ph, peso, formu, id_fat);
    COMMIT;
END;
call prc_insert_tec(211, 15, 25, 35, 45, 55, 65, 75, 85, 95, 105, 115, '12kg/l', '2mm', 110);
SELECT * FROM ficha_tecnica;

CREATE OR REPLACE PROCEDURE prc_update_tec(id_fi NUMBER, n NUMBER, p2o5 NUMBER, k2o NUMBER, cao NUMBER,  mgo NUMBER,  toc NUMBER,  mat_org NUMBER,  hum NUMBER,  fulv NUMBER, humd NUMBER, ph NUMBER, peso VARCHAR, formu VARCHAR)
AS
    pragma autonomous_transaction;
BEGIN
    UPDATE ficha_tecnica fi SET fi.n = n, fi.p2o5 = p2o5, fi.k2o = k2o, fi.cao = cao, fi.mgo = mgo, fi.toc = toc, fi.mat_org = mat_org, fi.acidos_humidos = hum, fi.acidos_fulvicos = fulv, fi.humidade = humd, fi.ph = ph, fi.peso_especifico = peso, fi.formulacao = formu WHERE fi.id_ficha_tecnica = id_fi; 
    COMMIT;
END;
call prc_update_tec(211, 15, 25, 35, 45, 55, 65, 75, 85, 95, 105, 115, '12kg/l', '2mm');
SELECT * FROM ficha_tecnica;

CREATE OR REPLACE PROCEDURE pcr_del_tec(id_fi NUMBER)
AS
    pragma autonomous_transaction;
BEGIN
    DELETE FROM ficha_tecnica ft WHERE ft.id_ficha_tecnica = id_fi;
    COMMIT;
END;
call pcr_del_tec(210);
SELECT * FROM ficha_tecnica;
-- DROP TABLE --
DROP TABLE Armazem CASCADE CONSTRAINTS;
DROP TABLE Caderno_Campo CASCADE CONSTRAINTS;
DROP TABLE Cliente CASCADE CONSTRAINTS;
DROP TABLE Colheita_Produto CASCADE CONSTRAINTS;
DROP TABLE Colheitas CASCADE CONSTRAINTS;
DROP TABLE Condutor CASCADE CONSTRAINTS;
DROP TABLE Controlador CASCADE CONSTRAINTS;
DROP TABLE Dados_Recolhidos CASCADE CONSTRAINTS;
DROP TABLE Edificios CASCADE CONSTRAINTS;
DROP TABLE Encomenda CASCADE CONSTRAINTS;
DROP TABLE Estabulo CASCADE CONSTRAINTS;
DROP TABLE Estacao_Meteorologica CASCADE CONSTRAINTS;
DROP TABLE Fatores_Producao CASCADE CONSTRAINTS;
DROP TABLE Garagens CASCADE CONSTRAINTS;
DROP TABLE Gestor_Agricula CASCADE CONSTRAINTS;
DROP TABLE Gestor_Distribuicao CASCADE CONSTRAINTS;
DROP TABLE Parcelas CASCADE CONSTRAINTS;
DROP TABLE Produto CASCADE CONSTRAINTS;
DROP TABLE Quinta CASCADE CONSTRAINTS;
DROP TABLE Quinta_Edificios CASCADE CONSTRAINTS;
DROP TABLE Quinta_Parcelas CASCADE CONSTRAINTS;
DROP TABLE Racao CASCADE CONSTRAINTS;
DROP TABLE Rega CASCADE CONSTRAINTS;
DROP TABLE Sensor CASCADE CONSTRAINTS;
DROP TABLE Sistema_Rega CASCADE CONSTRAINTS;
DROP TABLE Ficha_Tecnica CASCADE CONSTRAINTS;
DROP TABLE Incidentes CASCADE CONSTRAINTS;

-- CREATE TABLE--
CREATE TABLE Armazem (
    id_armazem number(10), 
    Edificiostipo_edificio number(10) NOT NULL, 
    PRIMARY KEY (id_armazem)
);
CREATE TABLE Caderno_Campo (
    id_caderno number(10), 
    fertilizacoes number(10) NOT NULL,
    Gestor_Agriculanum_cc number(8) NOT NULL,
    PRIMARY KEY (id_caderno)
);
CREATE TABLE Cliente (
    nif number(9), 
    nome varchar2(20) NOT NULL, 
    num_encomendas number(10) NOT NULL,
    email varchar2(20) NOT NULL, 
    codigo_interno number(10) NOT NULL, 
    morada_corresp varchar2(20) NOT NULL, 
    morada_entrega varchar2(20) NOT NULL,
    plafond number(10, 4) NOT NULL,
    num_incidentes number(10) NOT NULL,
    data_ultim_incid date, 
    nivel varchar(1) NOT NULL,
    PRIMARY KEY (nif),
    CONSTRAINT Cliente1_ck CHECK (nivel = 'A' OR nivel = 'B' OR nivel = 'C'),
    CONSTRAINT Cliente_ck CHECK (nif IS NULL OR LENGTH(TRIM(nif)) IN (9))
);    
CREATE TABLE Colheita_Produto (
    id_colheita number(10),
    Armazemid_armazem number(10) NOT NULL,
    PRIMARY KEY (id_colheita)
);
CREATE TABLE Colheitas (
    id_colheitas number(10), 
    quantidade number(10, 4) NOT NULL, 
    data date NOT NULL, 
    num_colheitas number(10) NOT NULL,
    Caderno_Campoid_caderno number(10) NOT NULL, 
    ParcelasId_parcelas number(10) NOT NULL, 
    PRIMARY KEY (id_colheitas)
);
CREATE TABLE Condutor (
    num_carta number(9), 
    nome varchar2(20), 
    idade number(10),
    num_cc number(8) NOT NULL, 
    QuintaId_quinta number(10) NOT NULL, 
    PRIMARY KEY (num_carta),
    CONSTRAINT Condutor_ck CHECK (num_carta IS NULL OR LENGTH(TRIM(num_carta)) IN (9))
);
CREATE TABLE Controlador (
    id_controlador number(10), 
    periodicidade varchar2(20) NOT NULL, 
    tempo_rega number(10,4) NOT NULL, 
    ordem_rega varchar2(20) NOT NULL, 
    Sistema_Regaid_rega number(10) NOT NULL, 
    PRIMARY KEY (id_controlador)
);
CREATE TABLE Dados_Recolhidos (
    id_dados number(10),
    vento number(10, 4) NOT NULL, 
    temperatura number(10, 4) NOT NULL, 
    humidade number(10, 4) NOT NULL, 
    radiacao number(10, 4) NOT NULL, 
    pressao number(10, 4) NOT NULL, 
    Caderno_Campoid_caderno number(10) NOT NULL, 
    PRIMARY KEY (id_dados)
);
CREATE TABLE Edificios (
    tipo_edificio number(10), 
    PRIMARY KEY (tipo_edificio)
);

CREATE TABLE Encomenda (
    id_encomenda number(10), 
    quantidade number(10, 4) NOT NULL, 
    data_encomenda date NOT NULL, 
    endereco varchar2(20) NOT NULL, 
    produtos varchar2(30) NOT NULL, 
    preco_encomenda number(10) NOT NULL, 
    estado_encomenda varchar2(20) NOT NULL, 
    data_pagamento date, 
    data_entrega date, 
    Clientenif number(9) NOT NULL, 
    PRIMARY KEY (id_encomenda),
    CONSTRAINT Encomenda_ck CHECK(estado_encomenda = 'entregue' OR estado_encomenda = 'registada' OR estado_encomenda = 'paga')
);
CREATE TABLE Estabulo (
    id_estabulo number(10) , 
    Edificiostipo_edificio number(10) NOT NULL, 
    PRIMARY KEY (id_estabulo)
    );
CREATE TABLE Estacao_Meteorologica (
    id_estacao number(10), 
    Sistema_Regaid_rega number(10) NOT NULL, 
    PRIMARY KEY (id_estacao)
);
CREATE TABLE Fatores_Producao (
    id_fat_producao number(10), 
    classificacao varchar2(20) NOT NULL, 
    nome varchar2(20) NOT NULL, 
    formulacao varchar2(20) NOT NULL, 
    Armazemid_armazem number(10) NOT NULL, 
    PRIMARY KEY (id_fat_producao),
    CONSTRAINT Fatores_Prducao_ck CHECK(formulacao = 'po' OR formulacao = 'liquilo' OR formulacao = 'granulado')
);
CREATE TABLE Ficha_Tecnica (
    id_ficha_tecnica number(10), 
    N number(10, 4) NOT NULL,
    P2O5 number(10, 4) NOT NULL, 
    K2O number(10, 4) NOT NULL, 
    CaO number(10, 4) NOT NULL, 
    MgO number(10, 4) NOT NULL, 
    TOC number(10, 4) NOT NULL,
    mat_org number(10, 4) NOT NULL, 
    acidos_humidos number(10, 4) NOT NULL, 
    acidos_fulvicos number(10, 4) NOT NULL, 
    humidade number(10, 4) NOT NULL,
    pH number(10, 4) NOT NULL, 
    peso_especifico varchar2(20) NOT NULL, 
    formulacao varchar2(20) NOT NULL, 
    Fatores_Producaoid_fat_producao number(10) NOT NULL, 
    PRIMARY KEY (id_ficha_tecnica)
);
CREATE TABLE Garagens (
    id_garagens number(10), 
    Edificiostipo_edificio number(10) NOT NULL, 
    PRIMARY KEY (id_garagens)
);
CREATE TABLE Gestor_Agricula (
    num_cc number(8), 
    idade number(10), 
    nome varchar2(20), 
    QuintaId_quinta number(10) NOT NULL, 
    PRIMARY KEY (num_cc),
    CONSTRAINT Gestor_Agricula_ck CHECK (num_cc IS NULL OR LENGTH(TRIM(num_cc)) IN (8))
);
CREATE TABLE Incidentes (
    id_incidente number(10), 
    valor number(10, 4), 
    data_ocorrencia date, 
    data_sanado date, 
    Clientenif number(9), 
    PRIMARY KEY (id_incidente)
);
CREATE TABLE Gestor_Distribuicao (
    num_cc number(8), 
    idade number(10), 
    nome varchar2(20), 
    QuintaId_quinta number(10) NOT NULL, 
    PRIMARY KEY (num_cc),
    CONSTRAINT Gestor_Distribuicao_ck CHECK (num_cc IS NULL OR LENGTH(TRIM(num_cc)) IN (8))
);
CREATE TABLE Parcelas (
    Id_parcelas number(10),
    area number(10, 4) NOT NULL, 
    designacao varchar2(20) NOT NULL, 
    tipo_cultura varchar2(20) NOT NULL,
    cultura varchar2(20) NOT NULL, 
    PRIMARY KEY (Id_parcelas),
    CONSTRAINT Parcelas_ck CHECK(tipo_cultura = 'temporario' OR tipo_cultura = 'permanente')
);
CREATE TABLE Produto (
    nome_produto varchar2(20) NOT NULL, 
    preco_produto number(10, 4) NOT NULL, 
    Colheitasid_colheitas number(10) NOT NULL, 
    Encomendaid_encomenda number(10) NOT NULL, 
    PRIMARY KEY (nome_produto)
);
CREATE TABLE Quinta (
    Id_quinta number(10), 
    PRIMARY KEY (Id_quinta)
);
CREATE TABLE Quinta_Edificios (
    QuintaId_quinta number(10) NOT NULL, 
    Edificiostipo_edificio number(10) NOT NULL, 
    PRIMARY KEY (QuintaId_quinta, Edificiostipo_edificio)
);
CREATE TABLE Quinta_Parcelas (
    QuintaId_quinta number(10) NOT NULL, 
    ParcelasId_parcelas number(10) NOT NULL, 
    PRIMARY KEY (QuintaId_quinta, ParcelasId_parcelas)
);
CREATE TABLE Racao (
    id_racao number(10), 
    Armazemid_armazem number(10) NOT NULL, 
    PRIMARY KEY (id_racao)
);
CREATE TABLE Rega (
    id_rega_diaria number(10), 
    data date NOT NULL, 
    quantidade number(10, 4) NOT NULL, 
    Caderno_Campoid_caderno number(10) NOT NULL, 
    ParcelasId_parcelas number(10) NOT NULL, 
    PRIMARY KEY (id_rega_diaria)
);
CREATE TABLE Sensor (
    tipo_sensor varchar2(20), 
    Estacao_Meteorologicaid_estacao number(10) NOT NULL,
    PRIMARY KEY (tipo_sensor),
    CONSTRAINT sensor_ck CHECK(tipo_sensor = 'pluviosidade' OR tipo_sensor = 'temperatura do solo' OR tipo_sensor = 'humidade do solo' OR tipo_sensor = 'velocidade do vento' OR tipo_sensor = 'temp, humi, pressao')
);
CREATE TABLE Sistema_Rega (
    id_rega number(10), 
    dimensao_exploracao number(10, 4) NOT NULL, 
    modo_rega varchar2(20) NOT NULL, 
    num_parcelas_culturas number(10) NOT NULL, 
    variedade_fatores_producao number(10) NOT NULL,
    qualidade_agua varchar2(20) NOT NULL,
    quantidade_agua number(10, 4) NOT NULL,
    tipo_distribuicao varchar2(20) NOT NULL, 
    Edificiostipo_edificio number(10) NOT NULL, 
    PRIMARY KEY (id_rega),
    CONSTRAINT Sistema_Rega_ck CHECK(modo_rega = 'gravidade' OR modo_rega = 'bombeada'),  
    CONSTRAINT Sistema_Rega2_ck CHECK(tipo_distribuicao = 'aspresao' OR tipo_distribuicao = 'gotejamento' OR tipo_distribuicao = 'pulverizacao')
);

-- ALTER TABLE--
ALTER TABLE Quinta_Parcelas ADD CONSTRAINT FKQuinta_Par789304 FOREIGN KEY (QuintaId_quinta) REFERENCES Quinta (Id_quinta);
ALTER TABLE Quinta_Parcelas ADD CONSTRAINT FKQuinta_Par368736 FOREIGN KEY (ParcelasId_parcelas) REFERENCES Parcelas (Id_parcelas);
ALTER TABLE Quinta_Edificios ADD CONSTRAINT FKQuinta_Edi265891 FOREIGN KEY (QuintaId_quinta) REFERENCES Quinta (Id_quinta);
ALTER TABLE Quinta_Edificios ADD CONSTRAINT FKQuinta_Edi435977 FOREIGN KEY (Edificiostipo_edificio) REFERENCES Edificios (tipo_edificio);
ALTER TABLE Fatores_Producao ADD CONSTRAINT FKFatores_Pr265311 FOREIGN KEY (Armazemid_armazem) REFERENCES Armazem (id_armazem);
ALTER TABLE Armazem ADD CONSTRAINT FKArmazem303690 FOREIGN KEY (Edificiostipo_edificio) REFERENCES Edificios (tipo_edificio);
ALTER TABLE Estabulo ADD CONSTRAINT FKEstabulo125262 FOREIGN KEY (Edificiostipo_edificio) REFERENCES Edificios (tipo_edificio);
ALTER TABLE Racao ADD CONSTRAINT FKRacao879 FOREIGN KEY (Armazemid_armazem) REFERENCES Armazem (id_armazem);
ALTER TABLE Colheita_Produto ADD CONSTRAINT FKColheita_P264846 FOREIGN KEY (Armazemid_armazem) REFERENCES Armazem (id_armazem);
ALTER TABLE Garagens ADD CONSTRAINT FKGaragens793280 FOREIGN KEY (Edificiostipo_edificio) REFERENCES Edificios (tipo_edificio);
ALTER TABLE Sistema_Rega ADD CONSTRAINT FKSistema_Re54231 FOREIGN KEY (Edificiostipo_edificio) REFERENCES Edificios (tipo_edificio);
ALTER TABLE Controlador ADD CONSTRAINT FKControlado775986 FOREIGN KEY (Sistema_Regaid_rega) REFERENCES Sistema_Rega (id_rega);
ALTER TABLE Estacao_Meteorologica ADD CONSTRAINT FKEstacao_Me155156 FOREIGN KEY (Sistema_Regaid_rega) REFERENCES Sistema_Rega (id_rega);
ALTER TABLE Sensor ADD CONSTRAINT FKSensor363888 FOREIGN KEY (Estacao_Meteorologicaid_estacao) REFERENCES Estacao_Meteorologica (id_estacao);
ALTER TABLE Gestor_Distribuicao ADD CONSTRAINT FKGestor_Dis463458 FOREIGN KEY (QuintaId_quinta) REFERENCES Quinta (Id_quinta);
ALTER TABLE Condutor ADD CONSTRAINT FKCondutor965725 FOREIGN KEY (QuintaId_quinta) REFERENCES Quinta (Id_quinta);
ALTER TABLE Gestor_Agricula ADD CONSTRAINT FKGestor_Agr865477 FOREIGN KEY (QuintaId_quinta) REFERENCES Quinta (Id_quinta);
ALTER TABLE Caderno_Campo ADD CONSTRAINT FKCaderno_Ca598636 FOREIGN KEY (Gestor_Agriculanum_cc) REFERENCES Gestor_Agricula (num_cc);
ALTER TABLE Dados_Recolhidos ADD CONSTRAINT FKDados_Reco576828 FOREIGN KEY (Caderno_Campoid_caderno) REFERENCES Caderno_Campo (id_caderno);
ALTER TABLE Colheitas ADD CONSTRAINT FKColheitas115220 FOREIGN KEY (Caderno_Campoid_caderno) REFERENCES Caderno_Campo (id_caderno);
ALTER TABLE Rega ADD CONSTRAINT FKRega725332 FOREIGN KEY (Caderno_Campoid_caderno) REFERENCES Caderno_Campo (id_caderno);
ALTER TABLE Encomenda ADD CONSTRAINT FKEncomenda267516 FOREIGN KEY (Clientenif) REFERENCES Cliente (nif);
ALTER TABLE Colheitas ADD CONSTRAINT FKColheitas260677 FOREIGN KEY (ParcelasId_parcelas) REFERENCES Parcelas (Id_parcelas);
ALTER TABLE Produto ADD CONSTRAINT FKProduto204956 FOREIGN KEY (Colheitasid_colheitas) REFERENCES Colheitas (id_colheitas);
ALTER TABLE Rega ADD CONSTRAINT FKRega129210 FOREIGN KEY (ParcelasId_parcelas) REFERENCES Parcelas (Id_parcelas);
ALTER TABLE Ficha_Tecnica ADD CONSTRAINT FKFicha_Tecn804780 FOREIGN KEY (Fatores_Producaoid_fat_producao) REFERENCES Fatores_Producao (id_fat_producao);
ALTER TABLE Incidentes ADD CONSTRAINT FKIncidentes437738 FOREIGN KEY (Clientenif) REFERENCES Cliente (nif);
ALTER TABLE Produto ADD CONSTRAINT FKProduto368760 FOREIGN KEY (Encomendaid_encomenda) REFERENCES Encomenda (id_encomenda);

-- INSERTS --
INSERT INTO Parcelas VALUES(1, 15.5, 'QUINTA', 'temporario', 'macieira');
INSERT INTO Parcelas VALUES(2, 16.5, 'QUINTA', 'temporario', 'pereira');
INSERT INTO Parcelas VALUES(3, 17.5, 'QUINTA', 'permanente', 'macieira');
INSERT INTO Parcelas VALUES(4, 18.5, 'QUINTA', 'permanente', 'macieira');
INSERT INTO Parcelas VALUES(5, 21.5, 'QUINTA', 'temporario', 'macieira');
SELECT * FROM parcelas;

INSERT INTO quinta Values(20);
INSERT INTO quinta Values(21);
INSERT INTO quinta Values(22);
INSERT INTO quinta Values(23);
INSERT INTO quinta Values(24);
SELECT * FROM quinta;

INSERT INTO gestor_agricula Values(12345678 , NULL, NULL, 20);
INSERT INTO gestor_agricula Values(12345679 , 18, 'JOAO', 21);
INSERT INTO gestor_agricula Values(12345670 , 19, 'JORGE', 22);
INSERT INTO gestor_agricula Values(12345671 , 10, NULL, 23);
INSERT INTO gestor_agricula Values(12345672 , 11, NULL, 24);
SELECT * FROM gestor_agricula;

INSERT INTO caderno_campo VALUES(30, 24, 12345678);
INSERT INTO caderno_campo VALUES(31, 29, 12345679);
INSERT INTO caderno_campo VALUES(32, 31, 12345670);
INSERT INTO caderno_campo VALUES(33, 34, 12345671);
INSERT INTO caderno_campo VALUES(34, 36, 12345672);
SELECT * FROM caderno_campo;

INSERT INTO Colheitas VALUES(11, 16.5, DATE '2000-04-12', 1, 30, 1);
INSERT INTO Colheitas VALUES(12, 16.5, DATE '2003-04-23', 1, 30, 2);
INSERT INTO Colheitas VALUES(13, 16.5, DATE '2011-04-01', 2, 32, 3);
INSERT INTO Colheitas VALUES(14, 16.5, DATE '2008-04-30', 3, 33, 4);
INSERT INTO Colheitas VALUES(15, 16.5, DATE '2010-04-02', 4, 34, 5);
SELECT * FROM colheitas;

INSERT INTO quinta_parcelas VALUES(20 ,1); 
INSERT INTO quinta_parcelas VALUES(21 ,2);
INSERT INTO quinta_parcelas VALUES(22 ,3);
INSERT INTO quinta_parcelas VALUES(23 ,4);
INSERT INTO quinta_parcelas VALUES(24 ,5);
SELECT * FROM quinta_parcelas;

INSERT INTO Condutor VALUES(123456789, NULL, NULL, 21345678,20);
INSERT INTO Condutor VALUES(123456780, NULL, NULL, 21345679,21);
INSERT INTO Condutor VALUES(123456781, NULL, NULL, 21345670,22);
INSERT INTO Condutor VALUES(123456782, NULL, NULL, 21345671,23);
INSERT INTO Condutor VALUES(123456783, NULL, NULL, 21345672,24);
SELECT * FROM condutor;

INSERT INTO Cliente VALUES(223456789, 'JOAO', 5, 'j.12@gmail.com', 14, 'porto', 'penafiel', 123.4, 0, NULL, 'A');
INSERT INTO Cliente VALUES(323456789, 'JOAO', 5, 'j.12@gmail.com', 14, 'porto', 'penafiel', 123.4, 0, NULL, 'A');
INSERT INTO Cliente VALUES(423456789, 'JOAO', 5, 'j.12@gmail.com', 14, 'porto', 'penafiel', 123.4, 0, NULL, 'A');
INSERT INTO Cliente VALUES(523456789, 'JOAO', 5, 'j.12@gmail.com', 14, 'porto', 'penafiel', 123.4, 0, NULL, 'A');
INSERT INTO Cliente VALUES(623456789, 'JOAO', 5, 'j.12@gmail.com', 14, 'porto', 'penafiel', 123.4, 0, NULL, 'A');
SELECT * FROM cliente;

INSERT INTO Encomenda VALUES(40, 12.5, DATE '2010-10-10', 'rua','maca', 12.5, 'entregue', DATE '2010-10-15', DATE '2010-10-25', 223456789);
INSERT INTO Encomenda VALUES(41, 13.5, DATE '2011-10-10', 'rua','pera', 13.5, 'registada', NULL, NULL, 323456789);
INSERT INTO Encomenda VALUES(42, 14.5, DATE '2010-10-20', 'rua','maca', 10.5, 'entregue', DATE '2010-10-21', DATE '2010-10-30',423456789);
INSERT INTO Encomenda VALUES(43, 15.5, DATE '2010-11-10', 'rua','pera', 11.5,'paga', DATE '2010-11-15', DATE '2010-11-25',523456789);
INSERT INTO Encomenda VALUES(44, 11.5, DATE '2010-01-10', 'rua','maca', 14.5,'entregue', DATE '2010-12-15', DATE '2010-12-25',623456789);
SELECT * FROM encomenda;

INSERT INTO edificios VALUES(50);
INSERT INTO edificios VALUES(51);
INSERT INTO edificios VALUES(52);
INSERT INTO edificios VALUES(53);
INSERT INTO edificios VALUES(54);
INSERT INTO edificios VALUES(55);
SELECT * FROM edificios;

INSERT INTO quinta_edificios VALUES(20, 50);
INSERT INTO quinta_edificios VALUES(20, 51);
INSERT INTO quinta_edificios VALUES(20, 52);
INSERT INTO quinta_edificios VALUES(20, 53);
INSERT INTO quinta_edificios VALUES(20, 54);
INSERT INTO quinta_edificios VALUES(20, 55);
SELECT * FROM quinta_edificios;

INSERT INTO estabulo VALUES(60, 51);
SELECT * FROM estabulo;

INSERT INTO garagens VALUES(70,52);
SELECT * FROM garagens;

INSERT INTO armazem VALUES(80, 54);
INSERT INTO armazem VALUES(81, 55);
INSERT INTO armazem VALUES(82, 53);
SELECT * FROM armazem;

INSERT INTO incidentes VALUES(200, NULL, NULL, NULL, 223456789);
SELECT * FROM incidentes;

INSERT INTO fatores_producao VALUES(110, 'adubos', 'adub', 'po', 82);
SELECT * FROM fatores_producao;

INSERT INTO ficha_tecnica VALUES(210, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5, 11.5, '12kg/l', '2mm', 110);
SELECT * FROM ficha_tecnica;

INSERT INTO Colheita_Produto VALUES(90, 80);
SELECT * FROM colheita_produto;

INSERT INTO racao VALUES(100, 81);
SELECT * FROM racao;

INSERT INTO sistema_rega VALUES(120, 1.8, 'gravidade', 1, 3, 'luso', 13.2, 'aspresao', 50);
SELECT * FROM sistema_rega;

INSERT INTO controlador VALUES(130, '2m', 12.5, 'parcela1', 120);
SELECT * FROM controlador;

INSERT INTO estacao_meteorologica VALUES(140, 120);
SELECT * FROM estacao_meteorologica;

INSERT INTO sensor VALUES('pluviosidade', 140);
INSERT INTO sensor VALUES('temperatura do solo', 140);
INSERT INTO sensor VALUES('humidade do solo', 140);
INSERT INTO sensor VALUES('velocidade do vento', 140);
INSERT INTO sensor VALUES('temp, humi, pressao', 140);
SELECT * FROM sensor;

INSERT INTO gestor_distribuicao VALUES(87654321, 45, 'manuel', 20);
INSERT INTO gestor_distribuicao VALUES(97654321, 49, 'ze', 21);
INSERT INTO gestor_distribuicao VALUES(37654321, 2, 'toninho', 22);
INSERT INTO gestor_distribuicao VALUES(17654321, 24, 'rafa', 23);
INSERT INTO gestor_distribuicao VALUES(27654321, 37, 'papai cris', 24);
SELECT * FROM gestor_distribuicao;

INSERT INTO dados_recolhidos VALUES(150, 23.5, 10.2, 50.4, 3.5, 123.4, 30);
SELECT * FROM dados_recolhidos;

INSERT INTO rega VALUES(160, DATE '2022-11-12', 12.5, 32, 2);
INSERT INTO rega VALUES(161, DATE '2021-11-12', 12.5, 30, 1);
INSERT INTO rega VALUES(162, DATE '2020-11-12', 12.5, 31, 3);
INSERT INTO rega VALUES(163, DATE '2015-11-12', 12.5, 33, 4);
INSERT INTO rega VALUES(164, DATE '1950-11-12', 12.5, 34, 5);
SELECT * FROM rega;

INSERT INTO produto VALUES('pera', 1.8, 11, 40);
INSERT INTO produto VALUES('maca', 3.8, 12, 41);
SELECT * FROM produto;

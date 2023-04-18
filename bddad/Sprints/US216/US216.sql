CREATE TABLE Dimensao_Hub (
  id_hub number(10) NOT NULL,
  tipo_hub varchar2(1) NOT NULL,
  hub varchar2(20) NOT NULL,
  PRIMARY KEY (id_hub)
);

INSERT INTO Dimensao_Hub (id_hub, tipo_hub, hub)
VALUES (1, 'A', 'Hub A');

INSERT INTO Dimensao_Hub (id_hub, tipo_hub, hub)
VALUES (2, 'B', 'Hub B');

INSERT INTO Dimensao_Hub (id_hub, tipo_hub, hub)
VALUES (3, 'C', 'Hub C');

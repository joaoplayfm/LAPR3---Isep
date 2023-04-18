CREATE OR REPLACE PROCEDURE atualizar_hubs
AS
BEGIN
    DELETE FROM Hub;

    INSERT INTO hub (loc_id, latitude, longitude)
    SELECT loc_id, latitude, longitude
    FROM input_hub
    WHERE clientes_produtores NOT LIKE 'C%';
END;
/
BEGIN
    atualizar_hubs;
END;
/
--US207 a)---
SELECT
    caderno_campoid_caderno,
    gestor_agriculanum_cc,
    parcelasid_parcelas,
    quantidade,
    area,
    quantidade / area
FROM
         colheitas
    INNER JOIN parcelas ON parcelasid_parcelas = parcelas.id_parcelas
    INNER JOIN caderno_campo ON caderno_campoid_caderno = caderno_campo.id_caderno AND gestor_agriculanum_cc = 12345678
    WHERE colheitas.num_colheitas = 1
ORDER BY
    quantidade / area DESC;
    
--US207 b)--
SELECT
    caderno_campoid_caderno,
    gestor_agriculanum_cc,
    parcelasid_parcelas,
    quantidade,
    area,
    preco_produto,
    preco_produto * quantidade / area
FROM
         colheitas
    INNER JOIN parcelas ON parcelasid_parcelas = parcelas.id_parcelas
    INNER JOIN caderno_campo ON caderno_campoid_caderno = caderno_campo.id_caderno AND gestor_agriculanum_cc = 12345678
    INNER JOIN produto ON colheitasid_colheitas = colheitas.id_colheitas
    WHERE colheitas.num_colheitas = 1
ORDER BY
    preco_produto * quantidade / area DESC;
END;
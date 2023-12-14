--ES 01
SELECT DISTINCT aereoporto."CITTÃ€" AS CittaPartenza
FROM volo 
JOIN aereoporto  ON volo.id_aeroporto_origine = aereoporto.id_aereoporto
WHERE volo.id_aeroporto_destinazione IN (
    SELECT id_aereoporto
    FROM aereoporto
    WHERE cittÃ  = 'Madrid'
)
ORDER BY CittaPartenza ASC;

--ES 02
SELECT cittÃ 
FROM aereoporto
WHERE piste IS NULL OR TO_NUMBER(piste) IS NULL;

--ES 03
SELECT v.id_volo, v.id_aeroporto_origine, v.id_aeroporto_destinazione, v.id_aeroporto_scalo, v.id_aereo,
       v.posti_prenotati, v.posti_disponibili, v.costo_base,
       a.modello AS modello_aereo,
       a.posti_totali, a.capienza_merci
FROM volo v
JOIN aereo a ON v.id_aereo = a.id_aereo
WHERE a.posti_totali IS NOT NULL AND a.capienza_merci IS NOT NULL;

--ES 04
SELECT
    v.id_volo,
    origine.nome_aereoporto AS origine_nome,
    origine.stato_cittÃ  AS origine_stato,
    destinazione.nome_aereoporto AS destinazione_nome,
    destinazione.stato_cittÃ  AS destinazione_stato
FROM
    volo v
JOIN
    aereoporto origine ON v.id_aeroporto_origine = origine.id_aereoporto
JOIN
    aereoporto destinazione ON v.id_aeroporto_destinazione = destinazione.id_aereoporto
WHERE
    v.id_volo = 'AZ278';
    
--ES 05
SELECT *
FROM (
    SELECT *
    FROM aereoporto
    WHERE stato_cittÃ  = 'Spain'
    ORDER BY TO_NUMBER(piste) DESC
)
WHERE ROWNUM = 1;

--ES 06
SELECT
    a.id_aereoporto,
    a.nome_aereoporto,
    a.cittÃ ,
    a.piste,
    a."STATO_CITTÃ€"
FROM aereoporto a
JOIN (
    SELECT
        stato_cittÃ ,
        MAX(CAST(piste AS INT)) AS max_piste
    FROM
        aereoporto
    GROUP BY
        stato_cittÃ 
) b ON a."STATO_CITTÃ€" = b.stato_cittÃ  AND CAST(a.piste AS INT) = b.max_piste;

--ES 07 WHERE
SELECT
    stato_cittÃ  AS NAZIONE,
    nome_aereoporto AS NOME_AEREOPORTO,
    TO_NUMBER(piste) AS PISTE
FROM (
    SELECT
        a.*,
        RANK() OVER (PARTITION BY stato_cittÃ  ORDER BY TO_NUMBER(piste) DESC) AS rnk
    FROM
        aereoporto a
) ranked
WHERE
    rnk = 1 AND TO_NUMBER(piste) >= 3;
    
--ES 07 HAVING
SELECT
    stato_cittÃ  AS NAZIONE,
    nome_aereoporto AS NOME_AEREOPORTO,
    MAX(TO_NUMBER(piste)) AS PISTE
FROM
    aereoporto
GROUP BY
    stato_cittÃ , nome_aereoporto
HAVING
    MAX(TO_NUMBER(piste)) >= 3;

--ES 08
WITH RankedAirports AS (
    SELECT
        stato_cittÃ  AS NAZIONE,
        cittÃ  AS CITTÃ ,
        nome_aereoporto AS NOME_AEREOPORTO,
        TO_NUMBER(piste) AS PISTE,
        RANK() OVER (PARTITION BY stato_cittÃ  ORDER BY TO_NUMBER(piste) DESC) AS rnk
    FROM
        aereoporto
)
SELECT
    NAZIONE,
    CITTÃ ,
    NOME_AEREOPORTO,
    PISTE
FROM
    RankedAirports
WHERE
    rnk = 1 AND PISTE IS NOT NULL;

--ES 09
SELECT DISTINCT
    a.id_aereoporto,
    a.nome_aereoporto,
    a.cittÃ ,
    a.piste,
    a.stato_cittÃ 
FROM
    aereoporto a
JOIN
    volo v ON a.id_aereoporto = v.id_aeroporto_origine
WHERE
    a.stato_cittÃ  != (SELECT stato_cittÃ  FROM aereoporto WHERE id_aereoporto = v.id_aeroporto_destinazione);
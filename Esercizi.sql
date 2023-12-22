--1)Trovare le città da cui partono voli diretti a Madrid, ordinate alfabeticamente 
SELECT DISTINCT aeroporto."CITTÀ" AS CittaPartenza
FROM volo 
JOIN aeroporto  ON volo.id_aeroporto_origine = aeroporto.id_aeroporto
WHERE volo.id_aeroporto_destinazione IN (
    SELECT id_aeroporto
    FROM aeroporto
    WHERE città = 'Madrid'
)
ORDER BY CittaPartenza ASC;

--2)Trovare le città con un aeroporto di cui non è noto il numero di piste 
SELECT città
FROM aeroporto
WHERE numero_piste IS NULL OR TO_NUMBER(numero_piste) IS NULL;

--3)Di ogni volo misto (merci e passeggeri) estrarre il codice e i dati relativi al trasporto 
SELECT v.id_volo, v.id_aeroporto_origine, v.id_aeroporto_destinazione, v.id_aeroporto_scalo, v.id_aereo,
v.posti_prenotati, v.posti_disponibili, v.costo_base,
a.modello AS modello_aereo,
a.posti_totali, a.capienza_merci
FROM volo v
JOIN aereo a ON v.id_aereo = a.id_aereo
WHERE a.posti_totali IS NOT NULL AND a.capienza_merci IS NOT NULL;

--4)Le nazioni di partenza e arrivo del volo AZ278 
SELECT vo.id_volo, ao_partenza.nazione AS nazione_partenza, ao_destinazione.nazione AS nazione_destinazione
FROM volo vo
JOIN aeroporto ao_partenza ON vo.id_aeroporto_origine = ao_partenza.id_aeroporto
JOIN aeroporto ao_destinazione ON vo.id_aeroporto_destinazione = ao_destinazione.id_aeroporto
WHERE vo.id_volo = 'AZ278';

--5)Trovare l’aeroporto spagnolo con il maggior numero di piste 
SELECT *
FROM (
    SELECT *
    FROM aeroporto
    WHERE nazione = 'Spagna'
    ORDER BY TO_NUMBER(numero_piste) DESC
)
WHERE ROWNUM = 1; --(se togli questa riga puoi ottenere la "classifica")


--6)Per ogni nazione, trovare quante piste ha l’aeroporto con più piste.
SELECT
a.id_aeroporto,
a.nome_aeroporto,
a.città,
a.numero_piste,
a."NAZIONE"
FROM aeroporto a
JOIN (
    SELECT nazione,
	MAX(CAST(numero_piste AS INT)) AS max_numero_piste
    FROM aeroporto
    GROUP BY nazione
) b ON a."NAZIONE" = b.nazione AND CAST(a.numero_piste AS INT) = b.max_numero_piste;

--7)Per ogni nazione, trovare quante piste ha l’aeroporto con più piste (purché almeno 3). 
--WHERE
SELECT nazione, nome_aeroporto, TO_NUMBER(numero_piste)
FROM (
    SELECT a.*,
	RANK() OVER (PARTITION BY nazione ORDER BY TO_NUMBER(numero_piste) DESC) AS rnk
    FROM aeroporto a) ranked
WHERE rnk = 1 AND TO_NUMBER(numero_piste) >= 3;

--7)Per ogni nazione, trovare quante piste ha l’aeroporto con più piste (purché almeno 3). 
--HAVING
SELECT nazione, nome_aeroporto, MAX(TO_NUMBER(numero_piste))
FROM aeroporto
GROUP BY nazione, nome_aeroporto
HAVING MAX(TO_NUMBER(numero_piste)) >= 3;

--8)Trovare le città in cui si trovano gli aeroporti con più piste di ogni nazione  
WITH RankedAirports AS (
    SELECT nazione, città, nome_aeroporto, TO_NUMBER(numero_piste) AS numero_piste,
        DENSE_RANK() OVER (PARTITION BY nazione, città ORDER BY TO_NUMBER(numero_piste) DESC) AS rnk
    FROM aeroporto)
SELECT nazione, città, nome_aeroporto, numero_piste
FROM RankedAirports
WHERE rnk = 1 AND numero_piste IS NOT NULL;

--9)Trovare gli aeroporti da cui partono voli internazionali  
SELECT DISTINCT
a.id_aeroporto,
a.nome_aeroporto,
a.città,
a.numero_piste,
a.nazione
FROM
aeroporto a
JOIN
volo v ON a.id_aeroporto = v.id_aeroporto_origine
WHERE
a.nazione != (SELECT nazione FROM aeroporto WHERE id_aeroporto = v.id_aeroporto_destinazione);

--10)Trovare il numero totale di partenze internazionali (del venerdì) da tutti gli aeroporti  
SELECT COUNT(*) AS totale_partenze_internazionali
FROM volo v
JOIN aeroporto ao_origine ON v.id_aeroporto_origine = ao_origine.id_aeroporto
JOIN aeroporto ao_destinazione ON v.id_aeroporto_destinazione = ao_destinazione.id_aeroporto
JOIN prenotazione p ON v.id_volo = p.id_volo
WHERE nome_giorno = 'VENERDÌ'
AND ao_origine."NAZIONE" != ao_destinazione."NAZIONE";

--11)Le città francesi da cui ogni settimana partono più di 20 voli diretti per la Germania 
SELECT DISTINCT a.città
FROM volo v
JOIN aeroporto a ON v.id_aeroporto_origine = a.id_aeroporto
WHERE v.posti_disponibili > 20
AND a.nazione = 'Francia'
AND v.id_aeroporto_destinazione IN (
	SELECT id_aeroporto
	FROM aeroporto
WHERE nazione = 'Germania'
);
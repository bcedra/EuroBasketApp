
# Procedura 1 pt adaugarea tarilor
DELIMITER //
CREATE PROCEDURE ADAUGARE_ECHIPA(in id int, nume varchar(10))
BEGIN
DECLARE idg INT;
DECLARE j1 varchar(20);
DECLARE j2 VARCHAR(20);
DECLARE j3 VARCHAR(20);
DECLARE j4 varchar(20);
SELECT 
    idGRUPA
INTO idg FROM
    grupa
WHERE
    `ECHIPA 1` = nume OR `ECHIPA 2` = nume
        OR `ECHIPA 3` = nume
        OR `ECHIPA 4` = nume;
       
SELECT  j.Nume INTO  j1 from jucator j where j.idJUCATOR=1 and j.Tara=nume;   
SELECT  j.Nume INTO  j2 from jucator j where j.idJUCATOR=2 and j.Tara=nume;
SELECT  j.Nume INTO  j3 from jucator j where j.idJUCATOR=3 and j.Tara=nume;
SELECT  j.Nume INTO  j4 from jucator j where j.idJUCATOR=4 and j.Tara=nume;

INSERT INTO tara (idTARA,NUME,Nume_juc1,Nume_juc2,Nume_juc3,Nume_juc4,GRUPA_idGRUPA,NrVic,Stadiu)
VALUES (id,nume,j1,j2,j3,j4,idg,0,'Grupe');        
END //


DELIMITER //
CREATE PROCEDURE MECI_GRUPA(in idM int ,in idg int,in team1 varchar(20),in team2 varchar(20))
BEGIN

DECLARE scor_1 int;
DECLARE scor_2 int;
DECLARE winner varchar(20);
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_1;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_2;

IF scor_1 >= scor_2 then
   UPDATE tara SET NrVic = NrVic +  1 WHERE NUME=team1;
else
   UPDATE tara SET NrVic = NrVic + 1 WHERE NUME=team2;
END IF;

IF scor_1 >= scor_2 then
   SET winner = team1;
   else 
   SET winner = team2;
   end if;
   
   INSERT INTO meciuri_grupe(idMeci,GRUPA_idGRUPA,echipa1,echipa2,scor1,scor2,winner)
   VALUES (idM,idg,team1,team2,scor_1,scor_2,winner);
END//



DROP PROCEDURE CALIFICARE_GRUPA;
DELIMITER // 
CREATE PROCEDURE CALIFICARE_GRUPA(in id int)
BEGIN
DECLARE nr int;
DECLARE winner varchar(25);
DECLARE runnerup varchar(25);
DECLARE loc3 varchar(25);
DECLARE loc4 varchar(25);

select MAX(NrVic) into nr from tara where GRUPA_idGRUPA= id;


if nr >= 3 then
   select t.NUME into winner from tara t where t.GRUPA_idGRUPA= id and t.NrVic=3;
   select t.NUME into runnerup from tara t where t.GRUPA_idGRUPA= id and t.NrVic=2;
else 
   select t.NUME into winner from tara t where t.GRUPA_idGRUPA= id and t.NrVic=2 LIMIT 1;
   select t.NUME into runnerup from tara t where t.GRUPA_idGRUPA= id and (t.NrVic=2 or t.NrVic=1) and t.NUME!=winner LIMIT 1;   
end if;
INSERT INTO sferturi(echipa) values(winner);
INSERT INTO sferturi(echipa) values(runnerup);
UPDATE tara SET Stadiu = 'Sferturi' WHERE NUME=winner;
UPDATE tara SET Stadiu = 'Sferturi' WHERE NUME=runnerup;
END // 



select * from sferturi;
DROP PROCEDURE MECIURI_ELIMINATORII_SFERTURI;
DELIMITER // 

CREATE PROCEDURE MECIURI_ELIMINATORII_SFERTURI(in id1 int, in id2 int)
BEGIN
DECLARE team1 varchar(20);
DECLARE team2 varchar(20);
DECLARE scor_1 int;
DECLARE scor_2 int;
DECLARE winner varchar(20);

SELECT echipa INTO team1 FROM sferturi where id = id1;
SELECT echipa INTO team2 FROM sferturi where id = id2;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_1;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_2;

IF scor_1 >= scor_2 then
   SET winner = team1;
   else 
   SET winner = team2;
   end if;
   
   INSERT INTO meciuri_eliminatorii(echipa1,echipa2,scor1,scor2,winner,faza)
   VALUES (team1,team2,scor_1,scor_2,winner,'Sferturi');

   INSERT INTO semifinale(echipa) VALUES (winner);
   UPDATE tara SET Stadiu = 'Semifinale' WHERE NUME=winner;


END //


DROP PROCEDURE MECIURI_ELIMINATORII_SEMIFINALE;
DELIMITER // 

CREATE PROCEDURE MECIURI_ELIMINATORII_SEMIFINALE(in id1 int, in id2 int)
BEGIN
DECLARE team1 varchar(20);
DECLARE team2 varchar(20);
DECLARE scor_1 int;
DECLARE scor_2 int;
DECLARE winner varchar(20);
DECLARE lost varchar(20);


SELECT echipa INTO team1 FROM semifinale where  `id1/2 FINALA`= id1;
SELECT echipa INTO team2 FROM semifinale where `id1/2 FINALA` = id2;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_1;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_2;

IF scor_1 >= scor_2 then
   SET winner = team1;
   SET lost = team2;
   else 
   SET winner = team2;
   SET lost = team2;
   end if;
   
   INSERT INTO meciuri_eliminatorii(echipa1,echipa2,scor1,scor2,winner,faza)
   VALUES (team1,team2,scor_1,scor_2,winner,'Semifinale');

   INSERT INTO final(echipa) VALUES (winner);
   UPDATE tara SET Stadiu = 'Finala' WHERE NUME=winner;
   INSERT INTO smallfinal(echipa) VALUES (lost);

END //


DELIMITER //
CREATE PROCEDURE MECIURI_ELIMINATORII_LOCUL3(in id1 int, in id2 int)
BEGIN
DECLARE team1 varchar(20);
DECLARE team2 varchar(20);
DECLARE scor_1 int;
DECLARE scor_2 int;
DECLARE winner varchar(20);

SELECT echipa INTO team1 FROM smallfinal where  idFINALA= id1;
SELECT echipa INTO team2 FROM smallfinal where  idFINALA= id2;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_1;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_2;

IF scor_1 >= scor_2 then
   SET winner = team1;
   else 
   SET winner = team2;
   end if;
   
   INSERT INTO meciuri_eliminatorii(echipa1,echipa2,scor1,scor2,winner,faza)
   VALUES (team1,team2,scor_1,scor_2,winner,'Finala loc 3');

   INSERT INTO thirdplace(echipa) VALUES (winner);


END //



DROP PROCEDURE MECIURI_ELIMINATORII_FINAL;
DELIMITER // 

CREATE PROCEDURE MECIURI_ELIMINATORII_FINAL(in id1 int, in id2 int)
BEGIN
DECLARE team1 varchar(20);
DECLARE team2 varchar(20);
DECLARE scor_1 int;
DECLARE scor_2 int;
DECLARE winner varchar(20);
DECLARE runner_up varchar(20);

SELECT echipa INTO team1 FROM final where  idFINALA= id1;
SELECT echipa INTO team2 FROM final where  idFINALA = id2;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_1;
SELECT FLOOR(RAND()*(100-60)+60) INTO scor_2;

IF scor_1 >= scor_2 then
   SET winner = team1;
   SET runner_up = team2;
   else 
   SET winner = team2;
   SET runner_up = team1;
   end if;
   
   INSERT INTO meciuri_eliminatorii(echipa1,echipa2,scor1,scor2,winner,faza)
   VALUES (team1,team2,scor_1,scor_2,winner,'FINAL!!');

   INSERT INTO winner(echipa) VALUES (winner);
   INSERT INTO runnerup(echipa) VALUES (runner_up); 

END //
select * from final;


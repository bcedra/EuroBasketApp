CALL ADAUGARE_ECHIPA(1,'Spania');
CALL ADAUGARE_ECHIPA(2,'Romania');
CALL ADAUGARE_ECHIPA(3,'Ungaria');
CALL ADAUGARE_ECHIPA(4,'Letonia');
CALL ADAUGARE_ECHIPA(5,'Franta');
CALL ADAUGARE_ECHIPA(6,'Lituania');
CALL ADAUGARE_ECHIPA(7,'Italia');
CALL ADAUGARE_ECHIPA(8,'Ucraina');
CALL ADAUGARE_ECHIPA(9,'Serbia');
CALL ADAUGARE_ECHIPA(10,'Grecia');
CALL ADAUGARE_ECHIPA(11,'Croatia');
CALL ADAUGARE_ECHIPA(12,'Russia');
CALL ADAUGARE_ECHIPA(13,'Turcia');
CALL ADAUGARE_ECHIPA(14,'Germania');
CALL ADAUGARE_ECHIPA(15,'Israel');
CALL ADAUGARE_ECHIPA(16,'Cehia');




CALL MECI_GRUPA(120,1,'Romania','Spania');
CALL MECI_GRUPA(121,1,'Letonia','Ungaria');
CALL MECI_GRUPA(122,1,'Romania','Ungaria');
CALL MECI_GRUPA(123,1,'Spania','Letonia');
CALL MECI_GRUPA(124,1,'Romania','Letonia');
CALL MECI_GRUPA(125,1,'Spania','Ungaria');

select * from tara where GRUPA_idGRUPA= 1 ORDER BY NrVic DESC;


CALL MECI_GRUPA(200,2,'Franta','Lituania');
CALL MECI_GRUPA(201,2,'Italia','Ucraina');
CALL MECI_GRUPA(202,2,'Franta','Italia');
CALL MECI_GRUPA(203,2,'Lituania','Ucraina');
CALL MECI_GRUPA(204,2,'Franta','Ucraina');
CALL MECI_GRUPA(205,2,'Lituania','Italia');

select * from tara where GRUPA_idGRUPA= 2 ORDER BY NrVic DESC;

CALL MECI_GRUPA(300,3,'Serbia','Grecia');
CALL MECI_GRUPA(301,3,'Croatia','Russia');
CALL MECI_GRUPA(302,3,'Serbia','Croatia');
CALL MECI_GRUPA(303,3,'Grecia','Russia');
CALL MECI_GRUPA(304,3,'Serbia','Russia');
CALL MECI_GRUPA(305,3,'Grecia','Croatia');

select * from tara where GRUPA_idGRUPA= 3 ORDER BY NrVic DESC;

CALL MECI_GRUPA(400,4,'Turcia','Germania');
CALL MECI_GRUPA(401,4,'Israel','Cehia');
CALL MECI_GRUPA(402,4,'Turcia','Israel');
CALL MECI_GRUPA(403,4,'Germania','Cehia');
CALL MECI_GRUPA(404,4,'Turcia','Cehia');
CALL MECI_GRUPA(405,4,'Germania','Israel');








CALL CALIFICARE_GRUPA(1);
CALL CALIFICARE_GRUPA(2);
CALL CALIFICARE_GRUPA(3);
CALL CALIFICARE_GRUPA(4);

select *from sferturi;

CALL MECIURI_ELIMINATORII_SFERTURI(34,37);
CALL MECIURI_ELIMINATORII_SFERTURI(36,35);
CALL MECIURI_ELIMINATORII_SFERTURI(38,41);
CALL MECIURI_ELIMINATORII_SFERTURI(39,40);

select * from semifinale;

CALL MECIURI_ELIMINATORII_SEMIFINALE(9,12);
CALL MECIURI_ELIMINATORII_SEMIFINALE(10,11);

CALL MECIURI_ELIMINATORII_LOCUL3(8,7);
CALL MECIURI_ELIMINATORII_FINAL(9,10);
#INTEROGARI

#1. Afisarea tuturor grupelor 
SELECT *
FROM GRUPA;

#2. Afisarea capilor de serie 
SELECT `ECHIPA 1`
FROM GRUPA;

#3. Afisarea shooterilor din fiecare grupa 
SELECT Nume,Tara
FROM jucator,grupa
WHERE idJUCATOR = 2 AND idGRUPA=1


#4 Afisarea dupa inaltime
SELECT Nume,Inaltime
FROM jucator
ORDER BY Inaltime DESC

#5 Afisarea dupa greutate
SELECT Nume,Greutate
FROM jucator
ORDER BY Greutate DESC


#6 afisarea echipelor eliminate
select `echipa 3`,`echipa 4`
from grupa;

#7 afisarea echipelor calificate
select echipa
from sferturi s; 




#8 afisare grupa 1
Select nume
from tara t
where t.grupa_idGRUPA = 1

#9 afisare grupa 2
Select nume
from tara t
where t.grupa_idGRUPA = 2

#10 afisare grupa 3
Select nume
from tara t
where t.grupa_idGRUPA = 3

#11 afisare grupa 4
Select nume
from tara t
where t.grupa_idGRUPA = 4

#12 Afisarea echipa castigatoare
SELECT `echipa`
FROM winner

#13

select * from meciuri_eliminatorii 
where faza = 'Sferturi';



#14 Tarile din finala

select *
from tara t
where t.Stadiu = 'Finala';





#15 Ora de rulare a programului

select login_date
from employeeinfo


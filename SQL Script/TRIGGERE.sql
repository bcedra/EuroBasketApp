# Trigger numarul 1

DELIMITER //
CREATE TRIGGER FAZA_INITIALE
AFTER INSERT 
ON grupa
FOR EACH ROW
BEGIN

UPDATE tara SET Stadiu = 'Grupe';
END //

drop trigger actualizare_faza


DROP TRIGGER WINNER2
#Trigger numarul 2 
DELIMITER //

CREATE TRIGGER WINNER2
AFTER INSERT  
ON winner 
for each row
BEGIN
UPDATE employeeinfo SET login_date=NOW();
END //


DROP TRIGGER LOGIN_TIME
#Trigger numarul 3
DELIMITER // 
CREATE TRIGGER END_TOURNAMENT
AFTER INSERT ON thirdplace
FOR EACH ROW
BEGIN
 
Drop VIEW romanasii;
 
END //







CREATE DATABASE IF NOT EXISTS baschet;
USE baschet ;




CREATE TABLE IF NOT EXISTS EmployeeInfo(
EID int auto_increment,
Username text ,
parola text , 
login_date time,
primary key(EID)



)
-- -----------------------------------------------------
-- Table `mydb`.`JUCATOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Jucator (
    `idJUCATOR` INT NOT NULL,
    `Nume` VARCHAR(45) NOT NULL,
    `Inaltime` VARCHAR(10) NOT NULL,
    `Greutate` INT NOT NULL,
    `Tara` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`Nume`)
)  ENGINE=INNODB;


-- -----------------------------------------------------
-- Table `mydb`.`GRUPA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Grupa (
  `idGRUPA` INT NOT NULL,
  `ECHIPA 1` VARCHAR(45) NOT NULL,
  `ECHIPA 2` VARCHAR(45) NOT NULL,
  `ECHIPA 3` VARCHAR(45) NOT NULL,
  `ECHIPA 4` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGRUPA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`1/4 FINALA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Sferturi(
  id INT NOT null AUTO_INCREMENT,
  echipa varchar(20) not null , 
  PRIMARY KEY (id),
  FOREIGN KEY(echipa) references tara(NUME))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`1/2 FINALA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Semifinale (
  `id1/2 FINALA` INT NOT NULL AUTO_INCREMENT,
  `echipa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id1/2 FINALA`),
  FOREIGN KEY(echipa) references sferturi(echipa)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FINALA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Final (
  `idFINALA` INT NOT NULL AUTO_INCREMENT,
  echipa varchar(20),
  PRIMARY KEY (`idFINALA`),
  FOREIGN KEY(echipa) references semifinale(echipa)
  )
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS SmallFinal (
  `idFINALA` INT NOT NULL AUTO_INCREMENT,
  echipa varchar(20),
  PRIMARY KEY (`idFINALA`),
  FOREIGN KEY(echipa) references semifinale(echipa)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`TARA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Tara (
  `idTARA` INT,
  `NUME` VARCHAR(45) NOT NULL,
  `Nume_juc1` varchar(20) not null,
  `Nume_juc2` varchar(20) not null,
  `Nume_juc3` varchar(20) not null,
  `Nume_juc4` varchar(20) not null,
  `GRUPA_idGRUPA` INT NOT NULL,
  `NrVic` int default null,
  `Stadiu` varchar(30) default 'Grupe',
  PRIMARY KEY (`NUME`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`WINNER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Winner(
     echipa varchar(20) not null,
     PRIMARY KEY(echipa),
     FOREIGN KEY(echipa) references final(echipa)
)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS Runnerup(
     echipa varchar(20) not null,
     PRIMARY KEY(echipa),
     FOREIGN KEY(echipa) references final(echipa)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS ThirdPlace(
     echipa varchar(20) not null,
     PRIMARY KEY(echipa),
     FOREIGN KEY(echipa) references smallfinal(echipa)
)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `mydb`.`REZULTATE GRUPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS meciuri_eliminatorii(
    idMeci int not null AUTO_INCREMENT,
    echipa1 varchar(20),
    echipa2 varchar(20),
    scor1 int,
    scor2 int,
    winner varchar(20),
    faza varchar(20),
    PRIMARY KEY(idMeci),
  FOREIGN KEY(echipa1) references sferturi(echipa),
  FOREIGN KEY(echipa2) references sferturi(echipa)
)
ENGINE = InnoDB;-- -----------------------------------------------------
-- Table `mydb`.`GRUPA_has_REZULTATE GRUPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS meciuri_grupe (
  `idMeci` int not null, 
  `GRUPA_idGRUPA` INT NOT NULL,
   `echipa1` varchar(20),
   `echipa2` varchar(20),
   scor1 int,
   scor2 int,
   winner varchar(20),
   PRIMARY KEY (`idMeci`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`REZULTATE GRUPE_has_1/4 FINALA`
-- -----------------------------------------------------

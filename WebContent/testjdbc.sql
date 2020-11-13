-- SIMPLON - Projet assisté JDBC
-- Version 1.0

SET NAMES utf8mb4;

DROP SCHEMA IF EXISTS testjdbc;
CREATE SCHEMA testjdbc;
USE testjdbc;

--
-- Create table strcuture for table `Pays`
--

CREATE TABLE Pays (
	id INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR( 200 ) NOT NULL,
    PRIMARY KEY( id )
) ENGINE=InnoDB;
   
--
-- Insert two record in table `Pays`
--
INSERT
	INTO Pays( nom )
    VALUES( "France"), ("Allemagne" );


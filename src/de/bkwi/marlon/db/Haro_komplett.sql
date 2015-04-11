-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema haro
--

CREATE DATABASE IF NOT EXISTS haro;
USE haro;

--
-- Definition of table `artikel`
--

DROP TABLE IF EXISTS `artikel`;
CREATE TABLE `artikel` (
  `artikelnr` varchar(5) NOT NULL,
  `bezeichnung` varchar(35) default NULL,
  `wgnr` varchar(1) default NULL,
  `teileart` varchar(1) default NULL,
  `ekpreis` decimal(10,2) default NULL,
  `vkpreis` decimal(10,2) default NULL,
  `bestand` int(11) default NULL,
  `meldebest` int(11) default NULL,
  `aktiv` tinyint(1) unsigned default NULL,
  PRIMARY KEY  (`artikelnr`),
  KEY `FK_artikel_1` (`wgnr`),
  CONSTRAINT `FK_artikel_1` FOREIGN KEY (`wgnr`) REFERENCES `warengruppen` (`wgnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artikel`
--

/*!40000 ALTER TABLE `artikel` DISABLE KEYS */;
INSERT INTO `artikel` (`artikelnr`,`bezeichnung`,`wgnr`,`teileart`,`ekpreis`,`vkpreis`,`bestand`,`meldebest`,`aktiv`) VALUES 
 ('10004','Handlupe 90 mm','4','E','9.59','18.22',300,200,0),
 ('10005','Lupe 90 mm','4','E','4.50','8.55',1010,500,0),
 ('10028','Abgleichschraubendreher-Satz','2','E','12.95','24.61',680,300,0),
 ('10030','Schraubendreher: 1,5 mm ','2','E','1.00','1.90',290,200,0),
 ('10031','Schraubendreher: 1,8 mm','2','E','1.00','1.90',220,200,0),
 ('10034','Schraubendreher: 3,0 mm ','2','E','1.00','1.90',300,200,0),
 ('10044','Stahllaubsäge ','3','E','5.45','10.36',1250,400,0),
 ('10049','Laubsägeblätter (12er Set)','3','E','2.35','4.47',2400,600,0),
 ('10050','Universal-Hobby-Säge','3','E','5.95','11.31',1350,200,0),
 ('10056','Isolier-Abstreifzängleinchen','1','E','13.57','19.95',2400,250,0),
 ('10057','Adernendhülsen-Zängle','1','E','16.50','31.35',1750,220,0),
 ('10058','Universal-Kabelzange','1','E','6.45','12.26',1900,300,0),
 ('10059','Schraubendreher-Set','2','E','11.20','21.28',1800,180,0),
 ('10062','Pozidriv-Schraubendreher','2','E','2.80','5.32',2850,200,0),
 ('10068','Elektronik-Seitenschneider','1','H','3.65','6.94',750,150,0),
 ('10069','Elektronik-Flachzange','1','H','3.65','6.94',2800,250,0),
 ('10070','Elektronik-Halbrundzange','1','H','3.65','6.94',1950,500,0),
 ('10071','Loch- und Ösenzange','1','E','12.95','24.61',2540,350,0),
 ('10075','Edelstahlzange flach','1','H','6.50','12.35',150,300,0),
 ('10076','Automatik-Abisolierzange','1','H','4.95','9.41',100,250,0),
 ('10080','Telefonzange 200 mm','1','H','5.90','11.21',1950,200,0),
 ('10081','Mehrzweckzange','1','H','18.50','35.15',4500,200,0),
 ('10086','Multifunktions-Crimpzange','1','E','39.50','75.05',1150,150,0),
 ('11058','Spezial-Bauschubkarren','4','E','59.90','113.81',450,250,0),
 ('11062','Durchwurfsieb verzinkt 100x60 cm','4','E','39.90','75.81',550,250,0),
 ('12345','Zange',NULL,NULL,'11.59','0.00',0,NULL,0),
 ('70001','Werkzeugkasten Universal','4','E','149.00','283.10',120,50,0),
 ('71001','Schlagbohrmaschine','4','H','63.00','119.70',155,50,0),
 ('71002','Bohrersatz für Holz/Metall/Stein','4','H','3.50','6.65',135,50,0),
 ('71003','Bit-Steckschlüsselsatz','4','H','3.20','6.08',124,50,0),
 ('71004','Schlosserhammer','4','H','3.50','6.65',90,80,0),
 ('72102','Wasserpumpenzange 240','1','E','3.65','6.94',122,20,0),
 ('72250','Wasserwaage 400 mm','4','H','4.40','8.36',90,40,0),
 ('72255','Universalsäge','3','E','5.20','9.88',95,40,0),
 ('72256','Sägeblatt Holz','3','H','0.55','1.05',124,40,0),
 ('72257','Sägeblatt Metall','3','H','1.50','2.85',132,40,0),
 ('74001','Kasten 75/45','4','E','6.90','13.11',105,50,0);
/*!40000 ALTER TABLE `artikel` ENABLE KEYS */;


--
-- Definition of table `auftragskoepfe`
--

DROP TABLE IF EXISTS `auftragskoepfe`;
CREATE TABLE `auftragskoepfe` (
  `aufnr` varchar(5) NOT NULL default '0',
  `aufdat` date default NULL,
  `kdnr` varchar(5) default NULL,
  `auftermin` date default NULL,
  `gebucht` tinyint(1) NOT NULL,
  PRIMARY KEY  (`aufnr`),
  KEY `FK_auftragskoepfe_1` (`kdnr`),
  CONSTRAINT `FK_auftragskoepfe_1` FOREIGN KEY (`kdnr`) REFERENCES `kunden` (`kdnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `auftragskoepfe`
--

/*!40000 ALTER TABLE `auftragskoepfe` DISABLE KEYS */;
INSERT INTO `auftragskoepfe` (`aufnr`,`aufdat`,`kdnr`,`auftermin`,`gebucht`) VALUES 
 ('22334','2009-01-26','24001','2009-02-18',0),
 ('22335','2009-01-27','24004','2009-02-27',0),
 ('22336','2009-01-31','24003','2009-03-02',0),
 ('22337','2009-02-12','24005','2009-03-11',0);
/*!40000 ALTER TABLE `auftragskoepfe` ENABLE KEYS */;


--
-- Definition of table `auftragspositionen`
--

DROP TABLE IF EXISTS `auftragspositionen`;
CREATE TABLE `auftragspositionen` (
  `aufposnr` varchar(5) NOT NULL,
  `aufnr` varchar(5) NOT NULL,
  `artikelnr` varchar(5) default NULL,
  `aufmenge` double(10,2) default NULL,
  PRIMARY KEY  (`aufposnr`),
  KEY `FK_auftragspositionen_1` (`aufnr`),
  KEY `FK_auftragspositionen_2` (`artikelnr`),
  CONSTRAINT `FK_auftragspositionen_1` FOREIGN KEY (`aufnr`) REFERENCES `auftragskoepfe` (`aufnr`),
  CONSTRAINT `FK_auftragspositionen_2` FOREIGN KEY (`artikelnr`) REFERENCES `artikel` (`artikelnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `auftragspositionen`
--

/*!40000 ALTER TABLE `auftragspositionen` DISABLE KEYS */;
INSERT INTO `auftragspositionen` (`aufposnr`,`aufnr`,`artikelnr`,`aufmenge`) VALUES 
 ('1','22334','10004',20.00),
 ('2','22334','10030',3.00),
 ('3','22335','10005',15.00),
 ('4','22335','10056',10.00),
 ('5','22335','10059',35.00),
 ('6','22336','10004',40.00),
 ('7','22337','10069',5.00),
 ('8','22337','10070',5.00);
/*!40000 ALTER TABLE `auftragspositionen` ENABLE KEYS */;


--
-- Definition of table `kunden`
--

DROP TABLE IF EXISTS `kunden`;
CREATE TABLE `kunden` (
  `kdnr` varchar(5) NOT NULL,
  `name` varchar(50) default NULL,
  `strasse` varchar(50) default NULL,
  `plz` varchar(5) default NULL,
  `ort` varchar(50) default NULL,
  `passwort` varchar(5) default NULL,
  `umsatz` double(10,2) default NULL,
  PRIMARY KEY  (`kdnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kunden`
--

/*!40000 ALTER TABLE `kunden` DISABLE KEYS */;
INSERT INTO `kunden` (`kdnr`,`name`,`strasse`,`plz`,`ort`,`passwort`,`umsatz`) VALUES 
 ('24001','Baumarkt Müller','Postfach 134','85579','Neubiberg','12345',959.30),
 ('24002','Friedrich Kunst','Mausweg 24','72510','Stetten a.k.M.','23456',45.17),
 ('24003','BAU MIT  GmbH','Im Grund 11','86657','Bissingen','34567',849.50),
 ('24004','Otto Weber','Postfach 888','78727','Oberndorf a.N.','45678',20000.70),
 ('24005','Peter Helferich','Stuttgarter Str. 44','75394','Oberreichenbach','56789',1120.91),
 ('24006','Bau und Ausbau GmbH','Postfach 8573','71106','Magstadt','98765',1120.80),
 ('24007','Hahn & Widmann','Postfach 2112','72336','Balingen','87654',8593.20),
 ('24008','Otto Huber','Kaiserstr. 33','78224','Singen','11111',859.19),
 ('24013','TOOM-Baumarkt','Im Lehen 20','78315','Radolfzell','12345',205.18);
/*!40000 ALTER TABLE `kunden` ENABLE KEYS */;


--
-- Definition of table `lieferer`
--

DROP TABLE IF EXISTS `lieferer`;
CREATE TABLE `lieferer` (
  `liefnr` varchar(5) NOT NULL,
  `name` varchar(25) default NULL,
  `plz` varchar(5) default NULL,
  `strasse` varchar(20) default NULL,
  `ort` varchar(50) default NULL,
  PRIMARY KEY  (`liefnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lieferer`
--

/*!40000 ALTER TABLE `lieferer` DISABLE KEYS */;
INSERT INTO `lieferer` (`liefnr`,`name`,`plz`,`strasse`,`ort`) VALUES 
 ('44001','Friedrich Walter AG','72072','Mhlstr. 8','Tbingen'),
 ('44002','Kugler und Grauer ','70173','Knigstr. 13','Stuttgart'),
 ('44003','Jonas Brauer Gmbh','72766','Hagenweg 12','Reutlingen'),
 ('44004','Ulmer Metallbau GmbH','72108','Am Marktplatz 1','Rottenburg'),
 ('44005','Georg Liebherr und Shne','72070','Goethestr. 5','Tbingen'),
 ('44006','Kaiser & Franz OHG','72108','Dorfstr. 1','Rottenburg'),
 ('44007','Weinmann GmbH','72379','Fliederstr. 35','Hechingen'),
 ('44008','Grauer Metallfrserei KG','72622','Brunnenstr. 56','Nrtingen'),
 ('44009','Richard Vollmer & Co KG','72766','Leharweg 13','Reutlingen'),
 ('44010','Wiedmeier & Shne','76532','Industriestrae 34','Rastatt'),
 ('44011','Lidl GmbH','72760','Goethestr. 13','Reutlingen');
/*!40000 ALTER TABLE `lieferer` ENABLE KEYS */;


--
-- Definition of table `liefermoeglichkeiten`
--

DROP TABLE IF EXISTS `liefermoeglichkeiten`;
CREATE TABLE `liefermoeglichkeiten` (
  `liefnr` varchar(5) NOT NULL,
  `artikelnr` varchar(5) NOT NULL,
  `preis` double(10,2) default NULL,
  PRIMARY KEY  (`liefnr`,`artikelnr`),
  KEY `FK_liefermoeglichkeiten_2` (`artikelnr`),
  CONSTRAINT `FK_liefermoeglichkeiten_1` FOREIGN KEY (`liefnr`) REFERENCES `lieferer` (`liefnr`),
  CONSTRAINT `FK_liefermoeglichkeiten_2` FOREIGN KEY (`artikelnr`) REFERENCES `artikel` (`artikelnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `liefermoeglichkeiten`
--

/*!40000 ALTER TABLE `liefermoeglichkeiten` DISABLE KEYS */;
INSERT INTO `liefermoeglichkeiten` (`liefnr`,`artikelnr`,`preis`) VALUES 
 ('44001','10004',20.00),
 ('44001','10005',8.55),
 ('44001','10028',12.95),
 ('44001','10050',11.31),
 ('44001','10056',19.95),
 ('44002','10044',5.15),
 ('44003','10049',4.90),
 ('44004','10056',19.95),
 ('44005','10005',3.20),
 ('44006','10004',20.00),
 ('44006','10049',4.99),
 ('44006','10056',19.95);
/*!40000 ALTER TABLE `liefermoeglichkeiten` ENABLE KEYS */;


--
-- Definition of table `warengruppen`
--

DROP TABLE IF EXISTS `warengruppen`;
CREATE TABLE `warengruppen` (
  `wgnr` varchar(1) NOT NULL,
  `warengruppe` varchar(50) default NULL,
  PRIMARY KEY  (`wgnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `warengruppen`
--

/*!40000 ALTER TABLE `warengruppen` DISABLE KEYS */;
INSERT INTO `warengruppen` (`wgnr`,`warengruppe`) VALUES 
 ('1','Zangen'),
 ('2','Schraubendreher'),
 ('3','Saegen'),
 ('4','Sonstige Artikel');
/*!40000 ALTER TABLE `warengruppen` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

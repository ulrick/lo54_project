-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 29 Novembre 2013 à 23:13
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gesform_db`
--
CREATE DATABASE IF NOT EXISTS `gesform_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gesform_db`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `LASTNAME` varchar(50) NOT NULL,
  `FIRSTNAME` varchar(50) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL,
  `PHONE` varchar(15) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `SESSION_ID` int(5) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`ID`, `LASTNAME`, `FIRSTNAME`, `ADDRESS`, `PHONE`, `EMAIL`, `SESSION_ID`) VALUES
(1, 'MANASSE', 'Yawo', '6 rue de madrid, 90000 belfort', '0760797742', 'ymanasse@gmail.com', 1),
(2, 'ASSIH', 'Koboyo', '6 rue de madrid', '0699388631', '', 2),
(3, 'PANASSA', 'Yves', '6 rue de madrid 90000 belfort', '0650337404', '', 5),
(4, 'MESSAK', 'Salma', '10 rue de la gare', '0606000006', 's.messak@utbm.fr', 4),
(5, 'MANASSE', 'Franck', 'hedzranawoÃ©', '92605847', 'franck@hotmail.fr', 11),
(6, 'ASSIH', 'Koboyo', '6 rue de madrid', '0012457865', '', 9),
(7, 'KPOTOGBEY-MAKU', 'Shalom', 'lyon', '0658471697', '', 9);

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `CODE` varchar(5) NOT NULL,
  `TITLE` varchar(200) NOT NULL,
  PRIMARY KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `course`
--

INSERT INTO `course` (`CODE`, `TITLE`) VALUES
('BD40', 'Introduction aux Bases de données'),
('BD50', 'Base de données avancée'),
('BD51', 'Business intelligence & data warehouse'),
('GL52', 'Génie logiciel'),
('IA51', 'Intelligence Artificielle'),
('LE09', 'Communication orale en anglais'),
('LO44', 'Introduction à l''algorithme '),
('LO51', 'Administration des bases de données'),
('LO52', 'Programmation mobile Android'),
('LO54', 'Tools and methods for Java JEE applications development'),
('LP40', 'Développement web'),
('MT45', 'Mathématique fonction'),
('RE42', 'Réseaux ccna1 & ccna3'),
('RE53', 'Interconnexion réseau  ccna2'),
('SA01', 'Théatre'),
('SQ40', 'Statistique pour l''ingénieur'),
('XS09', 'Santé et sécurité au travail');

-- --------------------------------------------------------

--
-- Structure de la table `course_session`
--

CREATE TABLE IF NOT EXISTS `course_session` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `START` date NOT NULL,
  `END` date NOT NULL,
  `COURSE_CODE` varchar(5) NOT NULL,
  `LOCATION_ID` int(5) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LOCATION_ID` (`LOCATION_ID`),
  KEY `COURSE_CODE` (`COURSE_CODE`,`LOCATION_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `course_session`
--

INSERT INTO `course_session` (`ID`, `START`, `END`, `COURSE_CODE`, `LOCATION_ID`) VALUES
(1, '2013-09-09', '2014-01-01', 'LO54', 1),
(2, '2013-09-16', '2013-12-20', 'BD51', 3),
(3, '2014-03-02', '2014-11-03', 'GL52', 5),
(4, '2014-01-01', '2014-04-01', 'LO54', 1),
(5, '2013-09-02', '2013-12-31', 'LE09', 2),
(6, '2013-02-25', '2013-06-28', 'GL52', 2),
(7, '2014-02-06', '2014-06-18', 'GL52', 3),
(8, '2013-11-24', '2013-11-29', 'BD51', 2),
(9, '2013-12-02', '2014-01-01', 'SQ40', 4),
(10, '2013-12-19', '2014-02-04', 'BD40', 4),
(11, '2013-12-25', '2014-01-29', 'RE42', 2);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `location`
--

INSERT INTO `location` (`ID`, `CITY`) VALUES
(1, 'Belfort'),
(2, 'Paris'),
(3, 'Toulouse'),
(4, 'Bordeaux'),
(5, 'Nantes');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `course_session`
--
ALTER TABLE `course_session`
  ADD CONSTRAINT `COURSE_CODE` FOREIGN KEY (`COURSE_CODE`) REFERENCES `course` (`CODE`),
  ADD CONSTRAINT `LOCATION_ID` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

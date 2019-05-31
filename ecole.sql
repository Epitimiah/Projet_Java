-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 31 mai 2019 à 12:54
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `academicyear`
--

DROP TABLE IF EXISTS `academicyear`;
CREATE TABLE IF NOT EXISTS `academicyear` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `IDlevel` int(15) NOT NULL,
  `IDacademicYear` int(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDlevel` (`IDlevel`),
  KEY `IDacademicYear` (`IDacademicYear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDteacher` int(11) NOT NULL,
  `IDfield` int(11) NOT NULL,
  `IDclass` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDclass` (`IDclass`),
  KEY `IDfield` (`IDfield`),
  KEY `IDteacher` (`IDteacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `field`
--

DROP TABLE IF EXISTS `field`;
CREATE TABLE IF NOT EXISTS `field` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `Grade` int(15) NOT NULL,
  `GradeComment` varchar(255) NOT NULL,
  `IDreportCardDetail` int(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDreportCardDetail` (`IDreportCardDetail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

DROP TABLE IF EXISTS `level`;
CREATE TABLE IF NOT EXISTS `level` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reportcard`
--

DROP TABLE IF EXISTS `reportcard`;
CREATE TABLE IF NOT EXISTS `reportcard` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `GeneralComment` varchar(255) NOT NULL,
  `IDterm` int(15) NOT NULL,
  `IDstudent` int(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDstudent` (`IDstudent`),
  KEY `IDterm` (`IDterm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reportcarddetail`
--

DROP TABLE IF EXISTS `reportcarddetail`;
CREATE TABLE IF NOT EXISTS `reportcarddetail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDreportCard` int(11) NOT NULL,
  `IDcourse` int(11) NOT NULL,
  `Comment` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDcourse` (`IDcourse`),
  KEY `IDreportCard` (`IDreportCard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `FirstName` text NOT NULL,
  `LastName` text NOT NULL,
  `IDClass` int(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDClass` (`IDClass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `term`
--

DROP TABLE IF EXISTS `term`;
CREATE TABLE IF NOT EXISTS `term` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NOT NULL,
  `Start` date NOT NULL,
  `End` date NOT NULL,
  `IDacademicYear` int(15) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDacademicYear` (`IDacademicYear`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`IDlevel`) REFERENCES `level` (`ID`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`IDacademicYear`) REFERENCES `academicyear` (`ID`);

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`IDclass`) REFERENCES `class` (`ID`),
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`IDfield`) REFERENCES `field` (`ID`),
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`IDteacher`) REFERENCES `teacher` (`ID`);

--
-- Contraintes pour la table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`IDreportCardDetail`) REFERENCES `reportcarddetail` (`ID`);

--
-- Contraintes pour la table `reportcard`
--
ALTER TABLE `reportcard`
  ADD CONSTRAINT `reportcard_ibfk_1` FOREIGN KEY (`IDstudent`) REFERENCES `student` (`ID`),
  ADD CONSTRAINT `reportcard_ibfk_2` FOREIGN KEY (`IDterm`) REFERENCES `term` (`ID`);

--
-- Contraintes pour la table `reportcarddetail`
--
ALTER TABLE `reportcarddetail`
  ADD CONSTRAINT `reportcarddetail_ibfk_1` FOREIGN KEY (`IDcourse`) REFERENCES `course` (`ID`),
  ADD CONSTRAINT `reportcarddetail_ibfk_2` FOREIGN KEY (`IDreportCard`) REFERENCES `reportcard` (`ID`);

--
-- Contraintes pour la table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`IDClass`) REFERENCES `class` (`ID`);

--
-- Contraintes pour la table `term`
--
ALTER TABLE `term`
  ADD CONSTRAINT `term_ibfk_1` FOREIGN KEY (`IDacademicYear`) REFERENCES `academicyear` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

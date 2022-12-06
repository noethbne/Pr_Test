-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 06. Dez 2022 um 12:32
-- Server-Version: 10.4.25-MariaDB
-- PHP-Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `javafxfitness`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ecourse`
--

CREATE TABLE `ecourse` (
  `courseID` int(11) NOT NULL,
  `userID` int(11) NOT NULL COMMENT 'userID des Erstellers',
  `isPublic` tinyint(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `ecourse`
--

INSERT INTO `ecourse` (`courseID`, `userID`, `isPublic`, `name`, `description`, `deleted`) VALUES
(1, 1, 1, 'ABS', 'Anti Blockier System', 0),
(2, 2, 1, 'Test Kurs 2', 'Test Kurs 2', 0),
(3, 3, 0, 'Kurs ist Deleted', 'Kurs ist Deleted', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `eexcercise`
--

CREATE TABLE `eexcercise` (
  `excerciseID` int(11) NOT NULL,
  `userID` int(11) NOT NULL COMMENT 'UserID des erstellenden Users',
  `excerciseName` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `euser`
--

CREATE TABLE `euser` (
  `userID` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `euser`
--

INSERT INTO `euser` (`userID`, `userName`, `password`, `admin`, `deleted`) VALUES
(1, 'Armin', 'e10adc3949ba59abbe56e057f20f883e', 1, 0),
(2, 'Bene', 'e10adc3949ba59abbe56e057f20f883e', 1, 1),
(3, 'Roger', 'e10adc3949ba59abbe56e057f20f883e', 0, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rcourseexcercise`
--

CREATE TABLE `rcourseexcercise` (
  `excerciseID` int(11) NOT NULL COMMENT 'ID der speziellen Übung',
  `courseID` int(11) NOT NULL COMMENT 'ID des Kurses in dem die Übungen sind',
  `referenceNumber` int(11) NOT NULL COMMENT 'Gibt an an welcher Stelle im Kurs die Übung erscheint'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rprogresstracker`
--

CREATE TABLE `rprogresstracker` (
  `progressID` int(11) NOT NULL,
  `excerciseID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `test`
--

CREATE TABLE `test` (
  `userId` int(11) NOT NULL,
  `user` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL,
  `roll` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `test`
--

INSERT INTO `test` (`userId`, `user`, `password`, `roll`) VALUES
(1, 'root', 'test', 'admin');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `ecourse`
--
ALTER TABLE `ecourse`
  ADD PRIMARY KEY (`courseID`),
  ADD KEY `userID_FK_ecourse` (`userID`);

--
-- Indizes für die Tabelle `eexcercise`
--
ALTER TABLE `eexcercise`
  ADD PRIMARY KEY (`excerciseID`),
  ADD KEY `userID_FK_eexcercise` (`userID`);

--
-- Indizes für die Tabelle `euser`
--
ALTER TABLE `euser`
  ADD PRIMARY KEY (`userID`);

--
-- Indizes für die Tabelle `rcourseexcercise`
--
ALTER TABLE `rcourseexcercise`
  ADD PRIMARY KEY (`excerciseID`,`courseID`,`referenceNumber`),
  ADD KEY `courseID_FK_rcourseexcercise` (`courseID`);

--
-- Indizes für die Tabelle `rprogresstracker`
--
ALTER TABLE `rprogresstracker`
  ADD PRIMARY KEY (`progressID`),
  ADD KEY `courseID_FK_rprogresstracker` (`courseID`),
  ADD KEY `excerciseID_FK_rprogresstracker` (`excerciseID`),
  ADD KEY `userID_FK_rprogresstracker` (`userID`);

--
-- Indizes für die Tabelle `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `ecourse`
--
ALTER TABLE `ecourse`
  MODIFY `courseID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `eexcercise`
--
ALTER TABLE `eexcercise`
  MODIFY `excerciseID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT für Tabelle `euser`
--
ALTER TABLE `euser`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `test`
--
ALTER TABLE `test`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `ecourse`
--
ALTER TABLE `ecourse`
  ADD CONSTRAINT `userID_FK_ecourse` FOREIGN KEY (`userID`) REFERENCES `euser` (`userID`);

--
-- Constraints der Tabelle `eexcercise`
--
ALTER TABLE `eexcercise`
  ADD CONSTRAINT `userID_FK_eexcercise` FOREIGN KEY (`userID`) REFERENCES `euser` (`userID`);

--
-- Constraints der Tabelle `rcourseexcercise`
--
ALTER TABLE `rcourseexcercise`
  ADD CONSTRAINT `courseID_FK_rcourseexcercise` FOREIGN KEY (`courseID`) REFERENCES `ecourse` (`courseID`),
  ADD CONSTRAINT `excerciseID_FK_rcourseexcercise` FOREIGN KEY (`excerciseID`) REFERENCES `eexcercise` (`excerciseID`);

--
-- Constraints der Tabelle `rprogresstracker`
--
ALTER TABLE `rprogresstracker`
  ADD CONSTRAINT `courseID_FK_rprogresstracker` FOREIGN KEY (`courseID`) REFERENCES `ecourse` (`courseID`),
  ADD CONSTRAINT `excerciseID_FK_rprogresstracker` FOREIGN KEY (`excerciseID`) REFERENCES `eexcercise` (`excerciseID`),
  ADD CONSTRAINT `userID_FK_rprogresstracker` FOREIGN KEY (`userID`) REFERENCES `euser` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

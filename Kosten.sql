-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 22. Okt 2020 um 13:46
-- Server-Version: 10.4.14-MariaDB
-- PHP-Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `Kosten`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Kostenart`
--

CREATE TABLE `Kostenart` (
  `KostenartID` int(11) NOT NULL,
  `KostenArt` varchar(255) NOT NULL,
  `Kosten` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `Kostenart`
--

INSERT INTO `Kostenart` (`KostenartID`, `KostenArt`, `Kosten`) VALUES
(1, 'Tagegeld', 30),
(2, 'Übernachtung', 100),
(3, 'Fahrtkosten', 1),
(4, 'Sonstiges', 10);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Kunde`
--

CREATE TABLE `Kunde` (
  `KundeID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Vorname` varchar(255) NOT NULL,
  `Straße` varchar(255) NOT NULL,
  `PLZ` varchar(255) NOT NULL,
  `Ort` varchar(255) NOT NULL,
  `Rechnungsnummer` varchar(255) NOT NULL,
  `Datum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `Kunde`
--

INSERT INTO `Kunde` (`KundeID`, `Name`, `Vorname`, `Straße`, `PLZ`, `Ort`, `Rechnungsnummer`, `Datum`) VALUES
(30, 'Krause', 'Michael', 'Geranienweg 38b', '89264', 'Weißenhorn', 'REC21102020KM116', '21.10.2020'),
(31, 'Hans', 'Soundso', 'Gerhardstraße 21', '23113', 'Hanshausen', 'REC21102020HS435', '21.10.2020'),
(32, 'Michael', 'Krause', 'Geranienweg 23', '89212', 'Hannover', 'REC21102020MK36', '21.10.2020'),
(33, 'Michael', 'Krause', 'Geranienweg 23', '89212', 'Hannover', 'REC21102020MK485', '21.10.2020');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `KundeKostenGesamt`
--

CREATE TABLE `KundeKostenGesamt` (
  `KundeID` int(11) NOT NULL,
  `KostenartID` int(11) NOT NULL,
  `Anzahl` int(11) NOT NULL,
  `Gesamt` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `KundeKostenGesamt`
--

INSERT INTO `KundeKostenGesamt` (`KundeID`, `KostenartID`, `Anzahl`, `Gesamt`) VALUES
(30, 1, 1, 30),
(30, 2, 2, 200),
(30, 3, 3, 3),
(30, 4, 4, 40),
(31, 1, 1, 30),
(31, 2, 2, 200),
(31, 3, 3, 3),
(31, 4, 4, 40),
(32, 1, 0, 0),
(32, 2, 0, 0),
(32, 3, 0, 0),
(32, 4, 0, 0),
(33, 1, 2, 60),
(33, 2, 2, 200),
(33, 3, 2, 2),
(33, 4, 2, 20);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Kostenart`
--
ALTER TABLE `Kostenart`
  ADD PRIMARY KEY (`KostenartID`);

--
-- Indizes für die Tabelle `Kunde`
--
ALTER TABLE `Kunde`
  ADD PRIMARY KEY (`KundeID`);

--
-- Indizes für die Tabelle `KundeKostenGesamt`
--
ALTER TABLE `KundeKostenGesamt`
  ADD PRIMARY KEY (`KundeID`,`KostenartID`),
  ADD KEY `KostenartID` (`KostenartID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `Kostenart`
--
ALTER TABLE `Kostenart`
  MODIFY `KostenartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `Kunde`
--
ALTER TABLE `Kunde`
  MODIFY `KundeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

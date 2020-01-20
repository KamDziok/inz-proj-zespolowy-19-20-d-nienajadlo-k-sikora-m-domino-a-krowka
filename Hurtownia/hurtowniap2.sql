-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 13 Sty 2020, 22:43
-- Wersja serwera: 10.4.8-MariaDB
-- Wersja PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `hurtowniap2`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adresy`
--

DROP DATABASE IF EXISTS hurtownia;


CREATE DATABASE IF NOT EXISTS hurtownia;

USE hurtownia;


CREATE TABLE `adresy` (
  `KlientID` int(11) NOT NULL,
  `Kraj` varchar(30) NOT NULL,
  `Miasto` varchar(30) NOT NULL,
  `Ulica` varchar(30) NOT NULL,
  `NumerBudynku` varchar(30) NOT NULL,
  `NumerLokalu` int(11) DEFAULT NULL,
  `AdresID` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `adresy`
--

INSERT INTO `adresy` (`KlientID`, `Kraj`, `Miasto`, `Ulica`, `NumerBudynku`, `NumerLokalu`, `AdresID`, `Email`) VALUES
(1, 'PL', 'Rzeszow', 'Pigonia', '1', 1, 3, 'ur@stud.pl'),
(2, 'PL', 'Rzeszow', 'Jasionka', '1', 1, 10, 'myHurt@gmail.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hurtownia`
--

CREATE TABLE `hurtownia` (
  `HurtowniaID` int(11) NOT NULL,
  `Telefon` decimal(12,0) NOT NULL,
  `AdresID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `hurtownia`
--

INSERT INTO `hurtownia` (`HurtowniaID`, `Telefon`, `AdresID`) VALUES
(1, '123456789', 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategorie`
--

CREATE TABLE `kategorie` (
  `Nazwa` varchar(30) NOT NULL,
  `KategoriaID` int(11) NOT NULL,
  `Opis` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `kategorie`
--

INSERT INTO `kategorie` (`Nazwa`, `KategoriaID`, `Opis`) VALUES
('Żywność', 1, 'Produkty Spożywcze');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `KlientID` int(11) NOT NULL,
  `Imie` varchar(30) NOT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Telefon` decimal(12,0) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`KlientID`, `Imie`, `Nazwisko`, `Telefon`, `login`, `password`) VALUES
(1, 'Jan', 'Kowalski', '123123123', 'jankowalski', 'jankowalski'),
(2, 'Hurtownia', 'Hurtownia', '123456789', '1231234324123', '1231321231232123');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiegowosc`
--

CREATE TABLE `ksiegowosc` (
  `KsiegowoscID` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Przychody` float NOT NULL,
  `Koszty` float NOT NULL,
  `Aktywa` float NOT NULL,
  `Pasywa` float NOT NULL,
  `HurtowniaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE `magazyn` (
  `MagazynID` int(11) NOT NULL,
  `Ilosc` int(11) NOT NULL,
  `CenaSprzedazy` float NOT NULL,
  `ProduktID` int(11) NOT NULL,
  `HurtowniaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `magazyn`
--

INSERT INTO `magazyn` (`MagazynID`, `Ilosc`, `CenaSprzedazy`, `ProduktID`, `HurtowniaID`) VALUES
(1, 123, 2, 2, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE `pracownik` (
  `Imie` varchar(30) NOT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Placa` float NOT NULL,
  `PracownikID` int(11) NOT NULL,
  `Stanowisko` varchar(30) NOT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `pracownik`
--

INSERT INTO `pracownik` (`Imie`, `Nazwisko`, `Placa`, `PracownikID`, `Stanowisko`, `login`, `password`) VALUES
('Jan', 'Kowalski', 1222, 3, 'magazynier', 'JanKowal', 'password123'),
('Janusz', 'Polakowski', 1234, 7, 'kierownik', 'kierownik', 'kierownik'),
('Anna', 'Nowak', 2000, 8, 'ksiegowa', 'ksiegowa', 'ksiegowa');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkty`
--

CREATE TABLE `produkty` (
  `ProduktID` int(11) NOT NULL,
  `Nazwa` varchar(30) NOT NULL,
  `CenaKupna` float NOT NULL,
  `Opis` varchar(300) NOT NULL,
  `KategoriaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `produkty`
--

INSERT INTO `produkty` (`ProduktID`, `Nazwa`, `CenaKupna`, `Opis`, `KategoriaID`) VALUES
(2, 'Ziemniaki', 1, 'Najtańsze ziemniaki w Polsce', 1),
(4, 'banany', 2, 'Najzwyklejsze banany', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reklama`
--

CREATE TABLE `reklama` (
  `ReklamaID` int(11) NOT NULL,
  `Tytul` varchar(30) NOT NULL,
  `Data` date NOT NULL,
  `Opis` varchar(300) NOT NULL,
  `Grafika` varchar(100) NOT NULL,
  `ProduktID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `towaryzamowienie`
--

CREATE TABLE `towaryzamowienie` (
  `TowaryZamowienieID` int(11) NOT NULL,
  `Ilosc` int(11) NOT NULL,
  `ProduktID` int(11) NOT NULL,
  `ZamowienieID` int(11) NOT NULL,
  `Koszt` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `towaryzamowienie`
--

INSERT INTO `towaryzamowienie` (`TowaryZamowienieID`, `Ilosc`, `ProduktID`, `ZamowienieID`, `Koszt`) VALUES
(1, 123, 4, 1, 246);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wyplaty`
--

CREATE TABLE `wyplaty` (
  `WyplataID` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Kwota` float NOT NULL,
  `PracownikID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienie`
--

CREATE TABLE `zamowienie` (
  `ZamowienieID` int(11) NOT NULL,
  `KlientID` int(11) NOT NULL,
  `StatusZaplaty` varchar(30) NOT NULL,
  `StatusTransportu` varchar(30) NOT NULL,
  `Data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `zamowienie`
--

INSERT INTO `zamowienie` (`ZamowienieID`, `KlientID`, `StatusZaplaty`, `StatusTransportu`, `Data`) VALUES
(1, 1, 'nie zapłacone', ' przyjęte do realizacji', '2020-01-13');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `adresy`
--
ALTER TABLE `adresy`
  ADD PRIMARY KEY (`AdresID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `klient_adres` (`KlientID`);

--
-- Indeksy dla tabeli `hurtownia`
--
ALTER TABLE `hurtownia`
  ADD PRIMARY KEY (`HurtowniaID`),
  ADD KEY `hurtownia_ibfk_1` (`AdresID`);

--
-- Indeksy dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`KategoriaID`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD PRIMARY KEY (`KlientID`);

--
-- Indeksy dla tabeli `ksiegowosc`
--
ALTER TABLE `ksiegowosc`
  ADD PRIMARY KEY (`KsiegowoscID`),
  ADD KEY `ksiegowosc_fk-1` (`HurtowniaID`);

--
-- Indeksy dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD PRIMARY KEY (`MagazynID`),
  ADD KEY `magazyn_ibfk_1` (`ProduktID`),
  ADD KEY `magazyn_ibfk_2` (`HurtowniaID`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`PracownikID`);

--
-- Indeksy dla tabeli `produkty`
--
ALTER TABLE `produkty`
  ADD PRIMARY KEY (`ProduktID`),
  ADD KEY `kategorie_ibfk_1` (`KategoriaID`);

--
-- Indeksy dla tabeli `reklama`
--
ALTER TABLE `reklama`
  ADD PRIMARY KEY (`ReklamaID`),
  ADD KEY `ProduktID` (`ProduktID`);

--
-- Indeksy dla tabeli `towaryzamowienie`
--
ALTER TABLE `towaryzamowienie`
  ADD PRIMARY KEY (`TowaryZamowienieID`),
  ADD KEY `ZamowienieID` (`ZamowienieID`),
  ADD KEY `towaryzamowienie_ibfk_1` (`ProduktID`);

--
-- Indeksy dla tabeli `wyplaty`
--
ALTER TABLE `wyplaty`
  ADD PRIMARY KEY (`WyplataID`),
  ADD KEY `wyplaty_ibfk_1` (`PracownikID`);

--
-- Indeksy dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD PRIMARY KEY (`ZamowienieID`),
  ADD KEY `klient_ID` (`KlientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `adresy`
--
ALTER TABLE `adresy`
  MODIFY `AdresID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `hurtownia`
--
ALTER TABLE `hurtownia`
  MODIFY `HurtowniaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  MODIFY `KategoriaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `klient`
--
ALTER TABLE `klient`
  MODIFY `KlientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `ksiegowosc`
--
ALTER TABLE `ksiegowosc`
  MODIFY `KsiegowoscID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  MODIFY `MagazynID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  MODIFY `PracownikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT dla tabeli `produkty`
--
ALTER TABLE `produkty`
  MODIFY `ProduktID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `reklama`
--
ALTER TABLE `reklama`
  MODIFY `ReklamaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `towaryzamowienie`
--
ALTER TABLE `towaryzamowienie`
  MODIFY `TowaryZamowienieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `wyplaty`
--
ALTER TABLE `wyplaty`
  MODIFY `WyplataID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  MODIFY `ZamowienieID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2147483648;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `adresy`
--
ALTER TABLE `adresy`
  ADD CONSTRAINT `klient_adres` FOREIGN KEY (`KlientID`) REFERENCES `klient` (`KlientID`);

--
-- Ograniczenia dla tabeli `hurtownia`
--
ALTER TABLE `hurtownia`
  ADD CONSTRAINT `hurtownia_ibfk_1` FOREIGN KEY (`AdresID`) REFERENCES `adresy` (`AdresID`);

--
-- Ograniczenia dla tabeli `ksiegowosc`
--
ALTER TABLE `ksiegowosc`
  ADD CONSTRAINT `ksiegowosc_fk-1` FOREIGN KEY (`HurtowniaID`) REFERENCES `hurtownia` (`HurtowniaID`);

--
-- Ograniczenia dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD CONSTRAINT `magazyn_ibfk_1` FOREIGN KEY (`ProduktID`) REFERENCES `produkty` (`ProduktID`),
  ADD CONSTRAINT `magazyn_ibfk_2` FOREIGN KEY (`HurtowniaID`) REFERENCES `hurtownia` (`HurtowniaID`);

--
-- Ograniczenia dla tabeli `produkty`
--
ALTER TABLE `produkty`
  ADD CONSTRAINT `kategorie_ibfk_1` FOREIGN KEY (`KategoriaID`) REFERENCES `kategorie` (`KategoriaID`);

--
-- Ograniczenia dla tabeli `reklama`
--
ALTER TABLE `reklama`
  ADD CONSTRAINT `ProduktID` FOREIGN KEY (`ProduktID`) REFERENCES `produkty` (`ProduktID`);

--
-- Ograniczenia dla tabeli `towaryzamowienie`
--
ALTER TABLE `towaryzamowienie`
  ADD CONSTRAINT `towaryzamowienie_ibfk_1` FOREIGN KEY (`ProduktID`) REFERENCES `produkty` (`ProduktID`),
  ADD CONSTRAINT `towaryzamowienie_ibfk_2` FOREIGN KEY (`ZamowienieID`) REFERENCES `zamowienie` (`ZamowienieID`);

--
-- Ograniczenia dla tabeli `wyplaty`
--
ALTER TABLE `wyplaty`
  ADD CONSTRAINT `wyplaty_ibfk_1` FOREIGN KEY (`PracownikID`) REFERENCES `pracownik` (`PracownikID`);

--
-- Ograniczenia dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD CONSTRAINT `klient_ID` FOREIGN KEY (`KlientID`) REFERENCES `klient` (`KlientID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 21 Lis 2019, 20:43
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
-- Baza danych: `hurtownia`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `adresy`
--

CREATE TABLE `adresy` (
  `Kraj` varchar(30) NOT NULL,
  `Miasto` varchar(30) NOT NULL,
  `Ulica` varchar(30) NOT NULL,
  `NumerBudynku` varchar(30) NOT NULL,
  `NumerLokalu` int(11) NOT NULL,
  `AdresID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hurtownia`
--

CREATE TABLE `hurtownia` (
  `HurtowniaID` int(11) NOT NULL,
  `Telefon` decimal(12,0) NOT NULL,
  `AdresID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategorie`
--

CREATE TABLE `kategorie` (
  `Nazwa` varchar(30) NOT NULL,
  `KategoriaID` int(11) NOT NULL,
  `Opis` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE `klient` (
  `Imie` varchar(30) NOT NULL,
  `Nazwisko` varchar(30) NOT NULL,
  `Telefon` decimal(12,0) NOT NULL,
  `AdresID` int(11) NOT NULL,
  `login` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ksiegowosc`
--

CREATE TABLE `ksiegowosc` (
  `Data` date NOT NULL,
  `Przychody` float NOT NULL,
  `Koszty` float NOT NULL,
  `Aktywa` float NOT NULL,
  `Pasywa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE `magazyn` (
  `Ilosc` int(11) NOT NULL,
  `CenaSprzedazy` float NOT NULL,
  `ProduktID` int(11) NOT NULL,
  `HurtowniaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `login` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reklama`
--

CREATE TABLE `reklama` (
  `ReklamaID` int(11) NOT NULL,
  `Tytul` varchar(30) NOT NULL,
  `Data` date NOT NULL,
  `Opis` varchar(300) NOT NULL,
  `Grafika` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `towaryzamowienie`
--

CREATE TABLE `towaryzamowienie` (
  `TowaryZamowienieID` int(11) NOT NULL,
  `Ilosc` int(11) NOT NULL,
  `ProduktID` int(11) NOT NULL,
  `ZamowienieID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `login` varchar(30) NOT NULL,
  `haslo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `StatusZaplaty` varchar(30) NOT NULL,
  `StatusTransportu` varchar(30) NOT NULL,
  `Data` date NOT NULL,
  `Koszt` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `adresy`
--
ALTER TABLE `adresy`
  ADD PRIMARY KEY (`AdresID`);

--
-- Indeksy dla tabeli `hurtownia`
--
ALTER TABLE `hurtownia`
  ADD PRIMARY KEY (`HurtowniaID`),
  ADD KEY `AdresID` (`AdresID`);

--
-- Indeksy dla tabeli `kategorie`
--
ALTER TABLE `kategorie`
  ADD PRIMARY KEY (`KategoriaID`);

--
-- Indeksy dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD KEY `AdresID` (`AdresID`),
  ADD KEY `login` (`login`);

--
-- Indeksy dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD KEY `ProduktID` (`ProduktID`),
  ADD KEY `HurtowniaID` (`HurtowniaID`);

--
-- Indeksy dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD PRIMARY KEY (`PracownikID`),
  ADD KEY `login` (`login`);

--
-- Indeksy dla tabeli `produkty`
--
ALTER TABLE `produkty`
  ADD PRIMARY KEY (`ProduktID`),
  ADD KEY `KategoriaID` (`KategoriaID`);

--
-- Indeksy dla tabeli `towaryzamowienie`
--
ALTER TABLE `towaryzamowienie`
  ADD KEY `ProduktID` (`ProduktID`),
  ADD KEY `ZamowienieID` (`ZamowienieID`);

--
-- Indeksy dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`login`);

--
-- Indeksy dla tabeli `wyplaty`
--
ALTER TABLE `wyplaty`
  ADD KEY `PracownikID` (`PracownikID`);

--
-- Indeksy dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD PRIMARY KEY (`ZamowienieID`);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `hurtownia`
--
ALTER TABLE `hurtownia`
  ADD CONSTRAINT `hurtownia_ibfk_1` FOREIGN KEY (`AdresID`) REFERENCES `adresy` (`AdresID`);

--
-- Ograniczenia dla tabeli `klient`
--
ALTER TABLE `klient`
  ADD CONSTRAINT `klient_ibfk_1` FOREIGN KEY (`AdresID`) REFERENCES `adresy` (`AdresID`),
  ADD CONSTRAINT `klient_ibfk_2` FOREIGN KEY (`login`) REFERENCES `uzytkownicy` (`login`);

--
-- Ograniczenia dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD CONSTRAINT `magazyn_ibfk_1` FOREIGN KEY (`ProduktID`) REFERENCES `produkty` (`ProduktID`),
  ADD CONSTRAINT `magazyn_ibfk_2` FOREIGN KEY (`HurtowniaID`) REFERENCES `hurtownia` (`HurtowniaID`);

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `pracownik`
  ADD CONSTRAINT `pracownik_ibfk_1` FOREIGN KEY (`login`) REFERENCES `uzytkownicy` (`login`);

--
-- Ograniczenia dla tabeli `produkty`
--
ALTER TABLE `produkty`
  ADD CONSTRAINT `produkty_ibfk_1` FOREIGN KEY (`KategoriaID`) REFERENCES `kategorie` (`KategoriaID`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

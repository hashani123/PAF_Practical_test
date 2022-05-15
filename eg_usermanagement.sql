-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 04:40 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eg_usermanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uID` int(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uAddress` varchar(255) NOT NULL,
  `uEmail` varchar(255) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `Pno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uID`, `name`, `uAddress`, `uEmail`, `nic`, `Pno`) VALUES
(1, 'hashani', '34/2/AEM', 'hashani@gmail.com', '1998123456', '0771234567'),
(4, 'Perera', '34/2/AEM', 'perera@gmail.com', '1998123456', '0771234567'),
(5, 'nipuni', '44/3/BEM', 'nipuni@gmail.com', '1997123456', '0781234567'),
(6, 'supuni', '54/4/CEM', 'supuni@gmail.com', '1996123456', '0741234567'),
(7, 'Kumudu', '23/4KDM', 'kumudu@gmail.com', '1994123456', '0781234567'),
(8, 'nishan', '23/4KDM', 'nishan@gmail.com', '1994123456', '0781234567');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

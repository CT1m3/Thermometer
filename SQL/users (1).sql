-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 09:04 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thermometer`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `role`) VALUES
(1, 'simas@gmail.com', '$2a$10$xH.BrRUxTyEbnpag0SwbG.AoWnFgYwoT95EoBLgdP7pVd5OLbTsGq', 'ADMIN'),
(2, 'jonas@gmail.com', '$2a$10$4/ftrl/2z8nwGVYC/Dm/We8aelCeBBAS5sseQSeIumVILqIZ9tCAa', 'USER'),
(5, 'petras@gmail.com', '$2a$10$J7GMg2QdLQ0LIj/AwyT4fOMCu2dBpzwjeCo3iRcYTm2fS1K0/8f4q', 'USER'),
(6, 'antanas@gmail.com', '$2a$10$Zx7pC7.7P5ypVN5dT8P2eOT5hJBa/Cgh1AFcMhN4PNtQ8K1hN2OUa', 'USER'),
(7, 'mantas@gmail.com', '$2a$10$XObRn7.oApN2RZseHdfPD.vAhfZTqi2NDmQYr6cH2.j/ipd7YptJi', 'USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

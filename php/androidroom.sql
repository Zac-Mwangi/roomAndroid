-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2022 at 11:54 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `androidroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `notes_table`
--

CREATE TABLE `notes_table` (
  `note_id` int(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `priority` int(200) NOT NULL,
  `room_id` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notes_table`
--

INSERT INTO `notes_table` (`note_id`, `title`, `description`, `priority`, `room_id`) VALUES
(1, 'lewy', 'lewi ', 9, 6),
(2, 'Title3', 'Description3', 3, 3),
(3, 'Title4', 'Description3', 3, 3),
(4, 'Title5', 'Description3', 3, 3),
(5, 'Title3', 'Description3', 3, 3),
(6, 'Title2', 'Description2', 2, 2),
(7, 'Title3', 'Description3', 9, 3),
(8, 'Title2', 'Description2', 2, 2),
(9, 'Title3', 'Description3', 9, 3),
(10, 'Title2', 'Description2retrofit', 2, 2),
(11, 'order 2', 'o3', 10, 5),
(12, 'kabi', 'kabi Retrofit', 9, 4),
(13, 'zacky', 'zedy', 10, 6),
(14, 'delete', 'ola', 3, 7),
(15, 'food', 'o', 9, 9),
(16, 'milk', 'drink', 9, 10),
(17, 'title 50', 'ggg', 1, 8),
(18, 'NJORI', 'HGHGH', 1, 11),
(19, 'NJOR0', 'HGHGH', 1, 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notes_table`
--
ALTER TABLE `notes_table`
  ADD PRIMARY KEY (`note_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notes_table`
--
ALTER TABLE `notes_table`
  MODIFY `note_id` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

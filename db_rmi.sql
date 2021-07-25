-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 25, 2021 at 03:09 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rmi`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lot_no`
--

CREATE TABLE `tbl_lot_no` (
  `id` int(11) NOT NULL,
  `id_daily` int(11) DEFAULT NULL,
  `lot_no` varchar(60) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `box` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_lot_no`
--

INSERT INTO `tbl_lot_no` (`id`, `id_daily`, `lot_no`, `qty`, `box`, `total`) VALUES
(5, 1, 'TAUFIQ_311810321', 1, 1, 1),
(6, 2, 'TAUFIQ-311310300-UPB', 20, 2, 200),
(7, 1, 'TAUFIQ_311810321d', 1, 1, 1),
(8, 0, 'TAUFIQ-311310300-UPBu', 0, 0, 0),
(9, 0, 'TAUFIQ-311310300-UPB9', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_machine`
--

CREATE TABLE `tbl_machine` (
  `id` int(11) NOT NULL,
  `mc_no` int(11) DEFAULT NULL,
  `die_height` double DEFAULT NULL,
  `spm` int(11) DEFAULT NULL,
  `timing_id` int(11) DEFAULT NULL,
  `vorl_role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_material`
--

CREATE TABLE `tbl_material` (
  `id` int(11) NOT NULL,
  `berat` int(11) DEFAULT NULL,
  `tag_number` varchar(60) DEFAULT NULL,
  `start` time DEFAULT NULL,
  `finish` time DEFAULT NULL,
  `total_time` int(11) DEFAULT NULL,
  `result` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_material`
--

INSERT INTO `tbl_material` (`id`, `berat`, `tag_number`, `start`, `finish`, `total_time`, `result`) VALUES
(6, 800, '9837539384', '13:00:00', '14:00:00', 60, 120);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `full_name` text DEFAULT NULL,
  `nik` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `full_name`, `nik`, `email`, `password`, `role`) VALUES
(2, 'Indira', '94298347242', 'indira@rmi.com', '2fd1c63f744f8b08b5dbb42eb3180a64', 'administrator'),
(10, 'Riska', '2424823942', 'riska@rmi.com', 'fb059ad1c514876b15b3ec40df1acdac', 'riska'),
(11, 'Febiyani', '9827492742', 'febiyani@rmi.com', 'dc27277fcfe2a361be0a6b0a6de02e74', 'febiyani'),
(12, 'Asep Septiadi', '32192838488393', 'asep.septiadi.idn@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456'),
(13, 'Herlina', '747384884', 'herlina@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456'),
(14, 'Ida', '7474784', 'ida@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456'),
(15, 'Rudi', '73738383', 'rudi@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456'),
(16, 'Sofia', '63738383', 'sofia@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456'),
(17, 'Weni', '27383939', 'weni@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_lot_no`
--
ALTER TABLE `tbl_lot_no`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_machine`
--
ALTER TABLE `tbl_machine`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_material`
--
ALTER TABLE `tbl_material`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_lot_no`
--
ALTER TABLE `tbl_lot_no`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_machine`
--
ALTER TABLE `tbl_machine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_material`
--
ALTER TABLE `tbl_material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

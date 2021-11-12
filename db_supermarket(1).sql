-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 12, 2021 at 12:41 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_supermarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `danh_muc`
--

CREATE TABLE `danh_muc` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danh_muc`
--

INSERT INTO `danh_muc` (`id`, `ten`, `status`) VALUES
(1, 'Drink', 1),
(2, 'Snack', 1),
(8, 'Drinks', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nha_san_xuat`
--

CREATE TABLE `nha_san_xuat` (
  `id` int(11) NOT NULL,
  `ten_nha_san_xuat` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nha_san_xuat`
--

INSERT INTO `nha_san_xuat` (`id`, `ten_nha_san_xuat`, `status`) VALUES
(1, 'Ba dinh', 1),
(2, 'Hai Ba Trung', 1),
(4, 'adsds', 1),
(8, 'asd', 2);

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `id` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia_tien` float NOT NULL,
  `nha_san_xuat_id` int(11) NOT NULL,
  `danh_muc_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`id`, `ten`, `so_luong`, `gia_tien`, `nha_san_xuat_id`, `danh_muc_id`) VALUES
(1, 'Bim Bim', 20, 20000, 2, 2),
(2, 'cocaou', 300, 10000, 1, 1),
(3, 'biafd', 213, 20000, 1, 2),
(6, 'h', 12, 123457, 1, 1),
(7, 'asdfds', 12, 123456, 1, 2),
(8, '321', 12, 12345, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `_admin`
--

CREATE TABLE `_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `_admin`
--

INSERT INTO `_admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `_order`
--

CREATE TABLE `_order` (
  `id` int(11) NOT NULL,
  `tong_gia_tien` float NOT NULL,
  `tong_so_luong` int(11) NOT NULL,
  `ngay_mua` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `_order`
--

INSERT INTO `_order` (`id`, `tong_gia_tien`, `tong_so_luong`, `ngay_mua`) VALUES
(34, 60000, 3, '2021-11-01'),
(35, 180008, 5, '2021-11-01'),
(36, 220016, 3, '2021-11-01'),
(37, 44690, 3, '2021-11-01'),
(38, 40000, 2, '2021-11-04'),
(39, 60000, 3, '2021-11-05'),
(40, 590368, 14, '2021-11-05'),
(41, 257035, 14, '2021-11-05');

-- --------------------------------------------------------

--
-- Table structure for table `_order_details`
--

CREATE TABLE `_order_details` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `ten` varchar(100) NOT NULL,
  `gia_tien` float NOT NULL,
  `so_luong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `_order_details`
--

INSERT INTO `_order_details` (`id`, `order_id`, `ten`, `gia_tien`, `so_luong`) VALUES
(23, 34, 'Bim Bimm', 20000, 3),
(24, 35, 'Bim Bimm', 20000, 3),
(25, 35, 'cocao', 100008, 1),
(26, 35, 'biafd', 20000, 1),
(27, 36, 'Bim Bimm', 20000, 1),
(28, 36, 'cocao', 100008, 2),
(29, 37, 'biafd', 20000, 1),
(30, 37, 'asd', 12345, 1),
(31, 37, '321', 12345, 1),
(32, 38, 'Bim Bimm', 20000, 2),
(33, 39, 'Bim Bimm', 20000, 2),
(34, 39, 'biafd', 20000, 1),
(35, 40, 'Bim Bimm', 20000, 11),
(36, 40, 'asdfds', 123456, 3);

-- --------------------------------------------------------

--
-- Table structure for table `_user`
--

CREATE TABLE `_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ten` varchar(50) NOT NULL,
  `dien_thoai` varchar(20) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `role` int(11) NOT NULL DEFAULT 2,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `_user`
--

INSERT INTO `_user` (`id`, `username`, `password`, `ten`, `dien_thoai`, `dia_chi`, `role`, `status`) VALUES
(1, 'admin', '123', 'admin', '', '', 1, 1),
(2, 'tuan', '123', 'tuan', '', '', 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danh_muc`
--
ALTER TABLE `danh_muc`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ten` (`ten`);

--
-- Indexes for table `nha_san_xuat`
--
ALTER TABLE `nha_san_xuat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ten_nha_san_xuat` (`ten_nha_san_xuat`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ten` (`ten`),
  ADD KEY `fk_nha_san_xuat_id` (`nha_san_xuat_id`),
  ADD KEY `fk_danh_muc_id` (`danh_muc_id`);

--
-- Indexes for table `_admin`
--
ALTER TABLE `_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `_order`
--
ALTER TABLE `_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `_order_details`
--
ALTER TABLE `_order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_order_id` (`order_id`);

--
-- Indexes for table `_user`
--
ALTER TABLE `_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danh_muc`
--
ALTER TABLE `danh_muc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `nha_san_xuat`
--
ALTER TABLE `nha_san_xuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `_admin`
--
ALTER TABLE `_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `_order`
--
ALTER TABLE `_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `_order_details`
--
ALTER TABLE `_order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `_user`
--
ALTER TABLE `_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `fk_danh_muc_id` FOREIGN KEY (`danh_muc_id`) REFERENCES `danh_muc` (`id`),
  ADD CONSTRAINT `fk_nha_san_xuat_id` FOREIGN KEY (`nha_san_xuat_id`) REFERENCES `nha_san_xuat` (`id`);

--
-- Constraints for table `_order_details`
--
ALTER TABLE `_order_details`
  ADD CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `_order` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

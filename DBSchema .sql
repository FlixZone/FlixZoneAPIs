-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 29, 2021 at 03:10 AM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `V5d63Ll0j4`
--

-- --------------------------------------------------------

--
-- Table structure for table `episode`
--

CREATE TABLE `episode` (
  `id` bigint(20) NOT NULL,
  `air_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `episode_id` bigint(20) NOT NULL,
  `overview` varchar(1200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poster_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telegram_file_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vote_average` double NOT NULL,
  `vote_count` int(11) NOT NULL,
  `season_id` bigint(20) NOT NULL,
  `tv_show_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL,
  `genres` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `original_language` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `original_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `overview` varchar(1200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poster_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tagline` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telegram_file_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `the_movie_db_id` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vote_average` double NOT NULL,
  `vote_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `season`
--

CREATE TABLE `season` (
  `id` bigint(20) NOT NULL,
  `air_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `overview` varchar(1200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poster_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `season_id` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tv_show_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tvshow`
--

CREATE TABLE `tvshow` (
  `id` bigint(20) NOT NULL,
  `genres` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `original_language` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `original_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `overview` varchar(1200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `poster_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `the_movie_db_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vote_average` double NOT NULL,
  `vote_count` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `episode`
--
ALTER TABLE `episode`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr5ifuxa82mfaxrhgahps7iu2m` (`season_id`),
  ADD KEY `FKd4hxg1ylicasetiu1c4sq50vq` (`tv_show_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `season`
--
ALTER TABLE `season`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb6braiph26g3as5h1dvqbbg88` (`tv_show_id`);

--
-- Indexes for table `tvshow`
--
ALTER TABLE `tvshow`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `episode`
--
ALTER TABLE `episode`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `season`
--
ALTER TABLE `season`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tvshow`
--
ALTER TABLE `tvshow`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `episode`
--
ALTER TABLE `episode`
  ADD CONSTRAINT `FKd4hxg1ylicasetiu1c4sq50vq` FOREIGN KEY (`tv_show_id`) REFERENCES `tvshow` (`id`),
  ADD CONSTRAINT `FKr5ifuxa82mfaxrhgahps7iu2m` FOREIGN KEY (`season_id`) REFERENCES `season` (`id`);

--
-- Constraints for table `season`
--
ALTER TABLE `season`
  ADD CONSTRAINT `FKb6braiph26g3as5h1dvqbbg88` FOREIGN KEY (`tv_show_id`) REFERENCES `tvshow` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

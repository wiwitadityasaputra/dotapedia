-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jan 05, 2022 at 01:15 AM
-- Server version: 8.0.27
-- PHP Version: 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dotapedia`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `game_id` int NOT NULL,
  `series_id` int NOT NULL,
  `radiant_team_id` int NOT NULL,
  `dire_team_id` int NOT NULL,
  `match_date` bigint NOT NULL,
  `radiant_score` int NOT NULL,
  `dire_score` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hero`
--

CREATE TABLE `hero` (
  `hero_id` int NOT NULL,
  `name` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hero`
--

INSERT INTO `hero` (`hero_id`, `name`, `type`, `is_active`) VALUES
(1, 'abaddon', 'STRENGTH', 1),
(2, 'alchemist', 'STRENGTH', 1),
(3, 'ancient apparition', 'INTELLIGENCE', 1),
(4, 'anti-mage', 'AGILITY', 1),
(5, 'arc warden', 'AGILITY', 1);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `player_id` int NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `nick_name` varchar(25) NOT NULL,
  `roles` varchar(25) NOT NULL,
  `date_of_birth` bigint NOT NULL,
  `country` varchar(25) NOT NULL,
  `total_earnings` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `player_game`
--

CREATE TABLE `player_game` (
  `player_game_id` int NOT NULL,
  `game_id` int NOT NULL,
  `team_id` int NOT NULL,
  `player_id` int NOT NULL,
  `hero_id` int NOT NULL,
  `role_id` int NOT NULL,
  `player_game_date` bigint NOT NULL,
  `kda_kill` int NOT NULL,
  `kda_death` int NOT NULL,
  `kda_assist` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `player_role`
--

CREATE TABLE `player_role` (
  `player_role_id` int NOT NULL,
  `name` varchar(25) NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `player_role`
--

INSERT INTO `player_role` (`player_role_id`, `name`, `is_active`) VALUES
(1, 'coach', 1),
(2, 'carry', 1),
(3, 'mid', 1),
(4, 'offline', 1),
(5, 'roam', 1),
(6, 'support', 1);

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE `series` (
  `series_id` int NOT NULL,
  `team_id_a` int NOT NULL,
  `team_id_b` int NOT NULL,
  `format` varchar(25) NOT NULL,
  `team_a_series_score` int NOT NULL,
  `team_b_series_score` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `team_id` int NOT NULL,
  `region` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sponsors` varchar(50) NOT NULL,
  `total_earnings` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team_player`
--

CREATE TABLE `team_player` (
  `team_player_id` int NOT NULL,
  `team_id` int NOT NULL,
  `player_id` int NOT NULL,
  `player_role_id` int NOT NULL,
  `join_date` bigint NOT NULL,
  `leave_date` bigint NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `new_team_player_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE `tournament` (
  `tournament_id` int NOT NULL,
  `region` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `prize_pool` int NOT NULL,
  `start_date` bigint NOT NULL,
  `end_date` bigint NOT NULL,
  `total_dpc_points` int NOT NULL,
  `tournament_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tournament_bracket`
--

CREATE TABLE `tournament_bracket` (
  `tournament_bracket_id` int NOT NULL,
  `tournament_id` int NOT NULL,
  `series_id` int NOT NULL,
  `bracket_round` int NOT NULL,
  `round_index` int NOT NULL,
  `next_bracket_tournament_id` int DEFAULT NULL,
  `prev_bracket_tournament_id` int DEFAULT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tournament_roundrobin`
--

CREATE TABLE `tournament_roundrobin` (
  `tournament_roundrobin_id` int NOT NULL,
  `tournament_id` int NOT NULL,
  `series_id` int NOT NULL,
  `week_index` int NOT NULL,
  `day_of_week` bigint NOT NULL,
  `day_index` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tournament_team`
--

CREATE TABLE `tournament_team` (
  `tournament_team_id` int NOT NULL,
  `tournament_id` int NOT NULL,
  `team_id` int NOT NULL,
  `place` int NOT NULL,
  `price` int NOT NULL,
  `dpc_points` int NOT NULL,
  `seed` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`game_id`),
  ADD KEY `fk_game_series_id` (`series_id`),
  ADD KEY `fk_game_radiant_team_id` (`radiant_team_id`),
  ADD KEY `fk_game_dire_team_id` (`dire_team_id`);

--
-- Indexes for table `hero`
--
ALTER TABLE `hero`
  ADD PRIMARY KEY (`hero_id`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`player_id`);

--
-- Indexes for table `player_game`
--
ALTER TABLE `player_game`
  ADD PRIMARY KEY (`player_game_id`),
  ADD KEY `fk_player_game_game_id` (`game_id`),
  ADD KEY `fk_player_game_team_id` (`team_id`),
  ADD KEY `fk_player_game_player_id` (`player_id`),
  ADD KEY `fk_player_game_hero_id` (`hero_id`),
  ADD KEY `fk_player_game_role_id` (`role_id`);

--
-- Indexes for table `player_role`
--
ALTER TABLE `player_role`
  ADD PRIMARY KEY (`player_role_id`);

--
-- Indexes for table `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`series_id`),
  ADD KEY `fk_series_team_id_a` (`team_id_a`),
  ADD KEY `fk_series_team_id_b` (`team_id_b`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_id`);

--
-- Indexes for table `team_player`
--
ALTER TABLE `team_player`
  ADD PRIMARY KEY (`team_player_id`),
  ADD KEY `fk_team_player_player_role_id` (`player_role_id`),
  ADD KEY `fk_team_player_team_id` (`team_id`),
  ADD KEY `fk_team_player_id` (`new_team_player_id`);

--
-- Indexes for table `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`tournament_id`);

--
-- Indexes for table `tournament_bracket`
--
ALTER TABLE `tournament_bracket`
  ADD PRIMARY KEY (`tournament_bracket_id`),
  ADD KEY `fk_tournament_bracket_tournament_id` (`tournament_id`),
  ADD KEY `fk_tournament_bracket_series_id` (`series_id`),
  ADD KEY `fk_tournament_bracket_next_id` (`next_bracket_tournament_id`),
  ADD KEY `fk_tournament_bracket_prev` (`prev_bracket_tournament_id`);

--
-- Indexes for table `tournament_roundrobin`
--
ALTER TABLE `tournament_roundrobin`
  ADD PRIMARY KEY (`tournament_roundrobin_id`),
  ADD KEY `fk_tournament_roundrobin_series_id` (`series_id`);

--
-- Indexes for table `tournament_team`
--
ALTER TABLE `tournament_team`
  ADD PRIMARY KEY (`tournament_team_id`),
  ADD KEY `fk_tournament_team_tournament_id` (`tournament_id`),
  ADD KEY `fk_tournament_team_team_id` (`team_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `game_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hero`
--
ALTER TABLE `hero`
  MODIFY `hero_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `player_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `player_game`
--
ALTER TABLE `player_game`
  MODIFY `player_game_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `player_role`
--
ALTER TABLE `player_role`
  MODIFY `player_role_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `series`
--
ALTER TABLE `series`
  MODIFY `series_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team_player`
--
ALTER TABLE `team_player`
  MODIFY `team_player_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `tournament_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament_bracket`
--
ALTER TABLE `tournament_bracket`
  MODIFY `tournament_bracket_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament_roundrobin`
--
ALTER TABLE `tournament_roundrobin`
  MODIFY `tournament_roundrobin_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament_team`
--
ALTER TABLE `tournament_team`
  MODIFY `tournament_team_id` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `fk_game_dire_team_id` FOREIGN KEY (`dire_team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_game_radiant_team_id` FOREIGN KEY (`radiant_team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_game_series_id` FOREIGN KEY (`series_id`) REFERENCES `series` (`series_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `player_game`
--
ALTER TABLE `player_game`
  ADD CONSTRAINT `fk_player_game_game_id` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_player_game_hero_id` FOREIGN KEY (`hero_id`) REFERENCES `hero` (`hero_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_player_game_player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_player_game_role_id` FOREIGN KEY (`role_id`) REFERENCES `player_role` (`player_role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_player_game_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `series`
--
ALTER TABLE `series`
  ADD CONSTRAINT `fk_series_team_id_a` FOREIGN KEY (`team_id_a`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_series_team_id_b` FOREIGN KEY (`team_id_b`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `team_player`
--
ALTER TABLE `team_player`
  ADD CONSTRAINT `fk_player_id` FOREIGN KEY (`team_player_id`) REFERENCES `player` (`player_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `fk_team_player_id` FOREIGN KEY (`new_team_player_id`) REFERENCES `team_player` (`team_player_id`),
  ADD CONSTRAINT `fk_team_player_player_role_id` FOREIGN KEY (`player_role_id`) REFERENCES `player_role` (`player_role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_team_player_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_bracket`
--
ALTER TABLE `tournament_bracket`
  ADD CONSTRAINT `fk_tournament_bracket_next_id` FOREIGN KEY (`next_bracket_tournament_id`) REFERENCES `tournament_bracket` (`tournament_bracket_id`),
  ADD CONSTRAINT `fk_tournament_bracket_prev` FOREIGN KEY (`prev_bracket_tournament_id`) REFERENCES `tournament_bracket` (`tournament_bracket_id`),
  ADD CONSTRAINT `fk_tournament_bracket_series_id` FOREIGN KEY (`series_id`) REFERENCES `series` (`series_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tournament_bracket_tournament_id` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_roundrobin`
--
ALTER TABLE `tournament_roundrobin`
  ADD CONSTRAINT `fk_tournament_roundrobin_series_id` FOREIGN KEY (`series_id`) REFERENCES `series` (`series_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tournament_roundrobin_tournament_id` FOREIGN KEY (`tournament_roundrobin_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament_team`
--
ALTER TABLE `tournament_team`
  ADD CONSTRAINT `fk_tournament_team_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tournament_team_tournament_id` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

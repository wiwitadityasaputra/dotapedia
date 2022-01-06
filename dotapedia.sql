-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jan 06, 2022 at 02:21 AM
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
  `match_date` bigint DEFAULT NULL,
  `radiant_score` int DEFAULT NULL,
  `dire_score` int DEFAULT NULL,
  `winner` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`game_id`, `series_id`, `radiant_team_id`, `dire_team_id`, `match_date`, `radiant_score`, `dire_score`, `winner`) VALUES
(1, 1, 1, 5, 1638266400000, 12, 39, 'DIRE'),
(2, 1, 1, 5, 1638277200000, 14, 50, 'DIRE'),
(3, 2, 4, 6, 1638294900000, 9, 38, 'DIRE'),
(4, 2, 4, 6, 1638301860000, 14, 43, 'DIRE'),
(5, 3, 2, 8, 1638370440000, 30, 7, 'RADIANT'),
(6, 3, 8, 2, 1638374040000, 9, 30, 'DIRE'),
(7, 4, 7, 3, 1638630780000, 24, 14, 'RADIANT'),
(8, 4, 7, 3, 1638646020000, 38, 17, 'RADIANT'),
(9, 5, 4, 1, 1638651600000, 18, 16, 'RADIANT'),
(10, 5, 1, 4, 1638658800000, 1, 14, 'DIRE'),
(11, 6, 3, 5, 1638882000000, 6, 37, 'DIRE'),
(12, 6, 5, 3, 1638900000000, 43, 17, 'RADIANT'),
(13, 7, 2, 6, 1638903600000, 21, 35, 'RADIANT'),
(14, 7, 6, 2, 1638910800000, 5, 37, 'DIRE'),
(15, 7, 6, 2, 1638918000000, 28, 36, 'DIRE'),
(16, 8, 7, 8, 1638968400000, 24, 18, 'RADIANT'),
(17, 8, 7, 8, 1638975600000, 24, 8, 'RADIANT'),
(18, 9, 7, 2, 1638363600000, 26, 28, 'DIRE'),
(19, 9, 7, 2, 1638370800000, 21, 9, 'RADIANT'),
(20, 9, 7, 2, 1638378000000, 22, 36, 'DIRE'),
(21, 10, 4, 5, 1638385200000, 31, 36, 'DIRE'),
(22, 10, 5, 4, 1638392400000, 35, 34, 'DIRE'),
(23, 10, 5, 4, 1638399600000, 25, 36, 'DIRE');

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
(5, 'arc warden', 'AGILITY', 1),
(6, 'axe', 'STRENGTH', 1),
(7, 'bane', 'INTELLIGENCE', 1),
(8, 'batrider', 'INTELLIGENCE', 1),
(9, 'beastmaster', 'STRENGTH', 1),
(10, 'bloodseeker', 'AGILITY', 1),
(11, 'bounty hunter', 'AGILITY', 1),
(12, 'brew master', 'STRENGTH', 1),
(13, 'bristleback', 'STRENGTH', 1),
(14, 'broodmother', 'AGILITY', 1),
(15, 'centaur warrunner', 'STRENGTH', 1),
(16, 'chaos kinght', 'STRENGTH', 1),
(17, 'chen', 'INTELLIGENCE', 1),
(18, 'clinkz', 'AGILITY', 1),
(19, 'clockwerk', 'STRENGTH', 1),
(20, 'crystal mayden', 'INTELLIGENCE', 1),
(21, 'dark seeker', 'INTELLIGENCE', 1),
(22, 'dark willow', 'INTELLIGENCE', 1),
(23, 'dawnbreaker', 'STRENGTH', 1),
(24, 'dazzle', 'INTELLIGENCE', 1),
(25, 'death prophet', 'INTELLIGENCE', 1),
(26, 'disruptor', 'INTELLIGENCE', 1),
(27, 'doom', 'STRENGTH', 1),
(28, 'dragon knight', 'STRENGTH', 1),
(29, 'drow ranger', 'AGILITY', 1),
(30, 'earth spirit', 'STRENGTH', 1),
(31, 'earthshaker', 'STRENGTH', 1),
(32, 'elder titan', 'STRENGTH', 1),
(33, 'ember spirit', 'AGILITY', 1),
(34, 'enchantress', 'INTELLIGENCE', 1),
(35, 'enigma', 'INTELLIGENCE', 1),
(36, 'faceless void', 'AGILITY', 1),
(37, 'grimstroke', 'INTELLIGENCE', 1),
(38, 'gyrocopter', 'AGILITY', 1),
(39, 'hoodwink', 'AGILITY', 1),
(40, 'huskar', 'STRENGTH', 1),
(41, 'invoker', 'INTELLIGENCE', 1),
(42, 'io', 'STRENGTH', 1),
(43, 'jakiro', 'INTELLIGENCE', 1),
(44, 'juggernaut', 'AGILITY', 1),
(45, 'keeper of the light', 'INTELLIGENCE', 1),
(46, 'kunkka', 'STRENGTH', 1),
(47, 'legion commander', 'STRENGTH', 1),
(48, 'leshrac', 'INTELLIGENCE', 1),
(49, 'lich', 'INTELLIGENCE', 1),
(50, 'lifestealer', 'STRENGTH', 1),
(51, 'lina', 'INTELLIGENCE', 1),
(52, 'lion', 'INTELLIGENCE', 1),
(53, 'lode druid', 'AGILITY', 1),
(54, 'luna', 'AGILITY', 1),
(55, 'lycan', 'STRENGTH', 1),
(56, 'magnus', 'STRENGTH', 1),
(57, 'marci', 'STRENGTH', 1),
(58, 'mars', 'STRENGTH', 1),
(59, 'medusa', 'AGILITY', 1),
(60, 'meepo', 'AGILITY', 1),
(61, 'mirana', 'AGILITY', 1),
(62, 'monkey king', 'AGILITY', 1),
(63, 'morphling', 'AGILITY', 1),
(64, 'naga siren', 'AGILITY', 1),
(65, 'nature prophet', 'INTELLIGENCE', 1),
(66, 'nechropos', 'INTELLIGENCE', 1),
(67, 'night stalker', 'STRENGTH', 1),
(68, 'nyx assassin', 'AGILITY', 1),
(69, 'ogre magi', 'INTELLIGENCE', 1),
(70, 'omniknight', 'STRENGTH', 1),
(71, 'oracle', 'INTELLIGENCE', 1),
(72, 'outworld destroyer', 'INTELLIGENCE', 1),
(73, 'pangolier', 'AGILITY', 1),
(74, 'phantom assassin', 'AGILITY', 1),
(75, 'phantom lancher', 'AGILITY', 1),
(76, 'phoenix', 'STRENGTH', 1),
(77, 'puck', 'INTELLIGENCE', 1),
(78, 'pudge', 'STRENGTH', 1),
(79, 'pugna', 'INTELLIGENCE', 1),
(80, 'queen of pain', 'INTELLIGENCE', 1),
(81, 'razor', 'AGILITY', 1),
(82, 'riki', 'AGILITY', 1),
(83, 'rubick', 'INTELLIGENCE', 1),
(84, 'sand king', 'STRENGTH', 1),
(85, 'shadow demon', 'INTELLIGENCE', 1),
(86, 'shadow fiend', 'AGILITY', 1),
(87, 'shadow shaman', 'INTELLIGENCE', 1),
(88, 'silencer', 'INTELLIGENCE', 1),
(89, 'skywrath mage', 'INTELLIGENCE', 1),
(90, 'slardar', 'STRENGTH', 1),
(91, 'slark', 'AGILITY', 1),
(92, 'snapfire', 'STRENGTH', 1),
(93, 'sniper', 'AGILITY', 1),
(94, 'spectre', 'AGILITY', 1),
(95, 'spirit breaker', 'STRENGTH', 1),
(96, 'storm spirit', 'INTELLIGENCE', 1),
(97, 'sven', 'STRENGTH', 1),
(98, 'techies', 'INTELLIGENCE', 1),
(99, 'templar assassin', 'AGILITY', 1),
(100, 'terrorblade', 'AGILITY', 1),
(101, 'tidehunter', 'STRENGTH', 1),
(102, 'timbersaw', 'STRENGTH', 1),
(103, 'tinker', 'INTELLIGENCE', 1),
(104, 'tiny', 'STRENGTH', 1),
(105, 'treant protector', 'STRENGTH', 1),
(106, 'troll warlord', 'AGILITY', 1),
(107, 'tusk', 'STRENGTH', 1),
(108, 'underlord', 'STRENGTH', 1),
(109, 'undying', 'STRENGTH', 1),
(110, 'ursa', 'AGILITY', 1),
(111, 'vengeful spirit', 'AGILITY', 1),
(112, 'venomancer', 'AGILITY', 1),
(113, 'viper', 'AGILITY', 1),
(114, 'visage', 'INTELLIGENCE', 1),
(115, 'void spirit', 'INTELLIGENCE', 1),
(116, 'warlord', 'INTELLIGENCE', 1),
(117, 'weaver', 'AGILITY', 1),
(118, 'windranger', 'INTELLIGENCE', 1),
(119, 'winter wyvern', 'INTELLIGENCE', 1),
(120, 'witch doctor', 'INTELLIGENCE', 1),
(121, 'wraith king', 'STRENGTH', 1),
(122, 'zeus', 'INTELLIGENCE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `player_id` int NOT NULL,
  `nick_name` varchar(25) NOT NULL,
  `full_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `roles` varchar(25) NOT NULL,
  `date_of_birth` bigint NOT NULL,
  `country` varchar(25) NOT NULL,
  `total_earnings` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`player_id`, `nick_name`, `full_name`, `roles`, `date_of_birth`, `country`, `total_earnings`) VALUES
(1, 'Nikobaby', 'Nikolay Nikolov', 'Carry', 864691200000, 'Bulgaria', 444639),
(2, 'Supream^', 'Ondřej Štarha', 'Solo Middle, Carry', 1289347200, 'Czech Republic', 33686),
(3, 'Leslão', 'Rodrigo Lelis Santos', 'Offlaner', 848793600, 'Brazil', 282126),
(4, 'Aramis', 'Adam Moroz', 'Support', 962150400000, 'Israel', 72687),
(5, 'Handsken', 'Simon Rasmus Haag', 'Support, Captain', 767145600000, 'Sweden', 490979),
(6, 'MATUMBAMAN', 'Lasse Aukusti Urpalainen', 'Carry, Solo Middle', 794188800000, 'Finland', 4511587),
(7, 'miCKe', 'Michael Vu', 'Solo Middle, Carry', 932947200000, 'Sweden', 276666),
(8, 'zai', 'Ludwig Wåhlberg', 'Offlaner, Support', 870739200000, 'Sweden', 3254684),
(9, 'Boxi', 'Samuel Svahn', 'Support, Offlaner', 892166400000, 'Sweden', 283386),
(10, 'iNSaNiA', 'Aydin Sarkohi', 'Support, Captain', 771897600000, 'Sweden', 285985),
(11, 'iLTW', 'Igor Filatov', 'Carry, Solo Middle', 941155200000, 'Russia', 282358),
(12, 'Miracle-', 'Amer Al-Barkawi', 'Solo Middle, Carry', 866764800000, 'Jordan', 4812595),
(13, 'MinD_ContRoL', 'Ivan Borislavov Ivanov', 'Offlaner', 790560000000, 'Bulgaria', 4602248),
(14, 'GH', 'Maroun Merhej', 'Support', 803347200000, 'Lebanon', 4207104),
(15, 'KuroKy', 'Kuro Salehi Takhasomi', 'Support, Captain', 720230400000, 'Germany', 5220353),
(26, 'SumaiL', 'Syed Sumail Hassan', 'Solo Middle, Carry', 918864000000, 'Pakistan', 3823610),
(27, 'Nisha', 'Michał Jankowski', 'Carry, Solo Middle', 970099200000, 'Poland', 1681376),
(28, 'iceiceice', 'Daryl Koh Pei Xiang', 'Offlaner, Carry', 645580800000, 'Singapore', 1792148),
(29, 'YapzOr', 'Yazied Jaradat', 'Support', 782352000000, 'Jordan', 2283602),
(30, 'Puppey', 'Clement Ivanov', 'Support, Captain', 636681600000, 'Estonia', 3614587),
(31, 'skiter', 'Oliver Lepko', 'Carry', 905558400000, 'Slovakia', 131505),
(32, 'Nine', 'Leon Kirilin', 'Solo Middle', 894844800000, 'Germany', 112842),
(33, '33', 'Neta Shapira', 'Offlaner, Support', 861235200000, 'Israel', 541512),
(34, 'Sneyking', 'Jingjun Wu', 'Support, Offlaner', 799459200000, 'United States', 486355),
(35, 'Fata', 'Adrian Trinks', 'Support, Captain', 730512000000, 'Germany', 1387029),
(36, 'Yuragi', 'Artem Golubiev', 'Carry', 999907200000, 'Ukraine', 8542),
(37, 'bzm', 'Bozhidar Bogdanov', 'Solo Middle', 1114128000000, 'Bulgaria', 9368),
(38, 'ATF', 'Ammar Al-Assaf', 'Offlaner', 1112486400000, 'Jordan', 14301),
(39, 'Taiga', 'Tommy Le', 'Support', 899510400000, 'Norway', 285386),
(40, 'Misha', 'Михаил Агатов', 'Support, Coach', 869702400000, 'Russia', 38856),
(41, 'dyrachyo', 'Anton Shkredov', 'Carry', 999648000000, 'Russia', 27594),
(42, 'BOOM', 'Miroslav Bičan', 'Solo Middle', 957225600000, 'Czech Republic', 72130),
(43, 'Ace', 'Marcus Folke Hoelgaard Christensen', 'Offlaner, Carry', 758937600000, 'Denmark', 762672),
(44, 'tOfu', 'Erik Engel', 'Support', 839980800000, 'Germany', 27157),
(45, 'Seleri', 'Melchior Hillenkamp', 'Support, Captain', 930960000000, 'Netherlands', 75243),
(47, 'ThuG', 'Dimitris Plivouris', 'Solo Middle', 759542400000, 'Greece', 168541),
(48, 'No!ob', 'Tony Assaf', 'Solo Middle', 968198400000, 'Lebanon', 16078),
(49, 'Funn1k', 'Gleb Lipatnikov', 'Offlaner', 721872000000, 'Ukraine', 424387),
(50, 'OmaR', 'Omar Moughrabi', 'Support', 1038441600000, 'Lebanon', 3666),
(51, 'dnz', 'Dino Šavuk', 'Support', 788140800000, 'Croatia', 26753);

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
  `level` int DEFAULT NULL,
  `kda_kill` int DEFAULT NULL,
  `kda_death` int DEFAULT NULL,
  `kda_assist` int DEFAULT NULL,
  `networth` int DEFAULT NULL,
  `gold_per_minute` int DEFAULT NULL,
  `experience_per_minute` int DEFAULT NULL,
  `damage_hero` int DEFAULT NULL,
  `damage_building` int DEFAULT NULL,
  `healing` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `player_game`
--

INSERT INTO `player_game` (`player_game_id`, `game_id`, `team_id`, `player_id`, `hero_id`, `role_id`, `level`, `kda_kill`, `kda_death`, `kda_assist`, `networth`, `gold_per_minute`, `experience_per_minute`, `damage_hero`, `damage_building`, `healing`) VALUES
(45, 1, 1, 1, 121, 2, 20, 4, 8, 4, 14140, 508, 528, 16019, 478, 0),
(46, 1, 1, 4, 107, 5, 15, 0, 5, 7, 6395, 223, 350, 5490, 0, 110),
(47, 1, 1, 2, 86, 3, 20, 3, 7, 3, 14430, 457, 525, 19550, 0, 0),
(48, 1, 1, 3, 58, 4, 20, 3, 9, 5, 11170, 438, 566, 12902, 818, 110),
(49, 1, 1, 5, 52, 6, 17, 2, 10, 7, 6885, 245, 413, 7102, 0, 928),
(50, 1, 5, 34, 92, 5, 22, 9, 2, 23, 14985, 460, 681, 23893, 3116, 0),
(51, 1, 5, 35, 38, 6, 21, 5, 5, 17, 13020, 395, 586, 14865, 643, 0),
(52, 1, 5, 36, 36, 2, 23, 6, 2, 13, 16675, 559, 743, 17317, 2214, 0),
(53, 1, 5, 32, 30, 3, 23, 10, 3, 21, 13400, 468, 738, 20416, 1873, 362),
(54, 1, 5, 33, 27, 4, 25, 9, 0, 18, 24915, 795, 833, 24648, 1671, 0),
(55, 2, 1, 1, 121, 2, 25, 4, 6, 5, 22000, 628, 754, 25257, 1432, 0),
(56, 2, 1, 4, 117, 5, 18, 3, 8, 6, 8950, 290, 398, 9174, 21, 0),
(57, 2, 1, 5, 69, 6, 16, 1, 18, 5, 9745, 272, 315, 15301, 69, 656),
(58, 2, 1, 3, 58, 4, 18, 1, 9, 5, 10790, 354, 414, 9479, 333, 0),
(59, 2, 1, 2, 51, 3, 21, 2, 9, 5, 13790, 499, 540, 11622, 899, 0),
(60, 2, 5, 34, 92, 5, 24, 19, 2, 22, 17895, 442, 721, 28379, 3737, 0),
(61, 2, 5, 35, 38, 6, 20, 2, 10, 23, 11305, 371, 480, 16385, 368, 400),
(62, 2, 5, 36, 36, 2, 26, 14, 0, 16, 23950, 611, 848, 28484, 6022, 0),
(63, 2, 5, 32, 30, 3, 24, 6, 2, 22, 16850, 447, 694, 24253, 543, 240),
(64, 2, 5, 33, 27, 4, 26, 8, 0, 18, 27285, 760, 776, 28721, 1207, 0),
(65, 3, 4, 28, 119, 4, 17, 3, 8, 4, 11975, 319, 309, 25678, 704, 465),
(66, 3, 4, 30, 117, 6, 20, 1, 9, 8, 11790, 304, 398, 17186, 47, 0),
(67, 3, 4, 27, 100, 3, 21, 1, 4, 5, 29310, 697, 431, 12392, 1590, 0),
(68, 3, 4, 29, 78, 5, 14, 1, 10, 5, 9245, 190, 234, 3712, 0, 1587),
(69, 3, 4, 26, 37, 2, 20, 3, 7, 2, 12885, 361, 404, 15761, 0, 31),
(70, 3, 6, 38, 102, 4, 28, 13, 1, 18, 28850, 802, 871, 40659, 1460, 0),
(71, 3, 6, 36, 81, 2, 27, 8, 0, 13, 31665, 718, 731, 25714, 7287, 0),
(72, 3, 6, 39, 68, 5, 25, 6, 4, 16, 13490, 338, 621, 17760, 87, 0),
(73, 3, 6, 40, 43, 6, 19, 3, 4, 17, 11045, 275, 367, 8865, 1313, 668),
(74, 3, 6, 37, 41, 3, 27, 8, 0, 17, 26755, 646, 702, 30545, 9675, 0),
(75, 4, 4, 26, 115, 2, 18, 5, 8, 1, 11350, 341, 427, 12270, 0, 0),
(76, 4, 4, 27, 74, 3, 22, 4, 5, 3, 19945, 544, 637, 11435, 0, 0),
(77, 4, 4, 28, 73, 4, 19, 3, 5, 8, 12555, 369, 456, 12831, 904, 0),
(78, 4, 4, 29, 62, 5, 13, 1, 14, 5, 5555, 213, 240, 6887, 182, 754),
(79, 4, 4, 30, 3, 6, 15, 1, 11, 6, 7390, 273, 314, 11397, 0, 510),
(80, 4, 6, 36, 99, 2, 27, 20, 0, 9, 30945, 858, 959, 33796, 10620, 0),
(81, 4, 6, 40, 85, 6, 18, 2, 7, 24, 11255, 288, 423, 6078, 35, 1144),
(82, 4, 6, 38, 58, 4, 24, 10, 2, 14, 16200, 538, 719, 19904, 346, 0),
(83, 4, 6, 37, 33, 3, 23, 7, 1, 22, 17990, 520, 704, 29900, 639, 330),
(84, 4, 6, 39, 22, 5, 20, 4, 4, 19, 9205, 266, 502, 9900, 0, 660),
(85, 5, 2, 8, 78, 4, 18, 10, 2, 10, 14040, 561, 619, 18980, 977, 0),
(86, 5, 2, 6, 74, 2, 19, 6, 2, 9, 13800, 608, 643, 16294, 5915, 0),
(87, 5, 2, 7, 48, 3, 18, 10, 0, 9, 16210, 689, 631, 24970, 13487, 0),
(88, 5, 2, 9, 42, 5, 15, 3, 0, 18, 7615, 268, 438, 5838, 140, 13700),
(89, 5, 2, 10, 24, 6, 15, 1, 3, 12, 6640, 301, 429, 5552, 411, 5946),
(90, 5, 8, 47, 121, 2, 14, 3, 4, 2, 8500, 400, 397, 8804, 1284, 0),
(91, 5, 8, 49, 102, 4, 14, 3, 7, 1, 8490, 389, 411, 13248, 241, 0),
(92, 5, 8, 50, 92, 5, 11, 0, 4, 4, 4870, 176, 278, 6795, 0, 0),
(93, 5, 8, 51, 37, 6, 9, 1, 11, 5, 4540, 200, 181, 4946, 0, 800),
(94, 5, 8, 48, 27, 3, 16, 0, 5, 5, 11570, 478, 480, 10117, 0, 0),
(95, 6, 8, 50, 92, 5, 11, 0, 5, 5, 5345, 186, 297, 5911, 18, 800),
(96, 6, 8, 47, 46, 2, 16, 3, 6, 4, 11040, 462, 497, 7615, 0, 0),
(97, 6, 8, 48, 33, 3, 15, 3, 4, 4, 9270, 412, 445, 12420, 258, 0),
(98, 6, 8, 51, 26, 6, 9, 2, 10, 4, 5370, 193, 206, 7660, 0, 800),
(99, 6, 8, 49, 9, 4, 13, 0, 5, 2, 8365, 326, 347, 9537, 1032, 765),
(100, 6, 2, 7, 96, 3, 18, 13, 2, 7, 13595, 556, 642, 17607, 27, 0),
(101, 6, 2, 8, 95, 4, 18, 6, 3, 18, 12475, 446, 613, 16623, 76, 0),
(102, 6, 2, 6, 64, 2, 18, 4, 0, 12, 16950, 694, 610, 8471, 4588, 0),
(103, 6, 2, 9, 61, 5, 16, 4, 2, 18, 7620, 310, 506, 9979, 590, 1092),
(104, 6, 2, 10, 43, 6, 15, 2, 2, 8, 8200, 321, 447, 10032, 275, 430),
(105, 7, 7, 45, 109, 6, 14, 1, 3, 16, 7460, 291, 337, 5615, 365, 4220),
(106, 7, 7, 43, 101, 4, 19, 11, 2, 7, 16220, 576, 572, 14558, 2305, 0),
(107, 7, 7, 42, 86, 3, 21, 5, 2, 10, 17265, 609, 668, 16947, 19644, 110),
(108, 7, 7, 41, 46, 2, 22, 5, 3, 14, 18785, 632, 697, 20440, 5220, 571),
(109, 7, 7, 44, 7, 5, 15, 2, 5, 8, 6680, 262, 393, 10673, 929, 4),
(110, 7, 3, 13, 58, 4, 15, 4, 5, 2, 11580, 361, 385, 9425, 125, 0),
(111, 7, 3, 11, 54, 2, 17, 3, 4, 6, 16555, 523, 471, 16773, 1466, 0),
(112, 7, 3, 15, 26, 6, 11, 2, 6, 6, 4105, 171, 229, 8091, 153, 400),
(113, 7, 3, 12, 24, 3, 16, 1, 5, 8, 10145, 372, 405, 12143, 212, 2232),
(114, 7, 3, 14, 22, 5, 14, 2, 4, 8, 7675, 274, 332, 13629, 53, 1432),
(115, 8, 7, 45, 105, 6, 20, 2, 3, 15, 10245, 345, 560, 7129, 91, 14398),
(116, 8, 7, 42, 96, 3, 22, 11, 3, 15, 18260, 542, 708, 26383, 1033, 0),
(117, 8, 7, 44, 92, 5, 17, 6, 6, 16, 9695, 378, 442, 16918, 1183, 396),
(118, 8, 7, 41, 86, 2, 23, 8, 2, 8, 22075, 702, 769, 24142, 15425, 0),
(119, 8, 7, 43, 67, 4, 23, 11, 3, 12, 17545, 554, 731, 18569, 4928, 0),
(120, 8, 3, 15, 119, 6, 14, 2, 12, 8, 5630, 248, 301, 9875, 12, 881),
(121, 8, 3, 11, 100, 2, 20, 4, 6, 3, 14820, 542, 571, 24628, 369, 0),
(122, 8, 3, 14, 22, 5, 16, 1, 8, 10, 6765, 259, 406, 13432, 0, 0),
(123, 8, 3, 13, 9, 4, 19, 5, 7, 7, 11025, 412, 535, 19971, 2768, 2083),
(124, 8, 3, 12, 8, 3, 17, 5, 5, 8, 11920, 395, 449, 23944, 0, 0),
(125, 9, 4, 29, 89, 5, 19, 3, 3, 11, 8540, 287, 422, 10465, 0, 0),
(126, 9, 4, 27, 86, 3, 25, 5, 1, 7, 23275, 727, 730, 21627, 22330, 0),
(127, 9, 4, 28, 58, 4, 23, 2, 3, 9, 17495, 495, 608, 14992, 566, 0),
(128, 9, 4, 26, 48, 2, 23, 5, 4, 10, 20465, 556, 596, 22495, 4681, 110),
(129, 9, 4, 30, 1, 6, 19, 3, 5, 9, 8010, 270, 418, 3453, 0, 9092),
(130, 9, 1, 4, 62, 5, 18, 0, 7, 7, 9840, 271, 395, 7129, 33, 0),
(131, 9, 1, 1, 59, 2, 24, 2, 1, 7, 25120, 589, 673, 14054, 2414, 0),
(132, 9, 1, 2, 33, 3, 23, 9, 2, 3, 16640, 480, 594, 34357, 0, 0),
(133, 9, 1, 3, 27, 4, 22, 3, 5, 9, 22245, 598, 575, 21000, 645, 0),
(134, 9, 1, 5, 7, 6, 18, 1, 3, 12, 7685, 206, 392, 9461, 22, 516),
(135, 10, 1, 4, 117, 5, 11, 0, 3, 1, 5180, 265, 329, 3595, 0, 400),
(136, 10, 1, 2, 115, 3, 12, 1, 3, 0, 6660, 331, 347, 6433, 68, 0),
(137, 10, 1, 3, 101, 4, 13, 0, 2, 0, 7300, 353, 383, 1841, 437, 0),
(138, 10, 1, 1, 54, 2, 15, 0, 2, 0, 10760, 483, 499, 2660, 1501, 0),
(139, 10, 1, 5, 1, 6, 10, 0, 4, 1, 4125, 196, 245, 4265, 0, 1510),
(140, 10, 4, 27, 106, 3, 18, 4, 0, 5, 15590, 709, 688, 9463, 10991, 0),
(141, 10, 4, 29, 83, 5, 12, 0, 1, 11, 6355, 288, 372, 7835, 152, 392),
(142, 10, 4, 26, 72, 2, 17, 6, 0, 5, 13540, 578, 641, 13531, 1694, 0),
(143, 10, 4, 28, 58, 4, 15, 3, 0, 4, 9715, 449, 507, 6120, 731, 0),
(144, 10, 4, 30, 7, 6, 12, 1, 0, 7, 6205, 285, 334, 4058, 41, 400),
(160, 11, 3, 14, 117, 5, 13, 2, 5, 2, 6380, 259, 373, 9865, 85, 276),
(161, 11, 3, 15, 116, 6, 11, 1, 7, 1, 5820, 190, 269, 10032, 0, 3873),
(162, 11, 3, 11, 54, 2, 15, 0, 6, 4, 11375, 440, 463, 5072, 824, 0),
(163, 11, 3, 12, 51, 3, 14, 1, 10, 3, 8505, 391, 402, 8362, 1232, 0),
(164, 11, 3, 13, 9, 4, 11, 1, 9, 3, 6180, 296, 295, 8892, 511, 202),
(165, 11, 5, 32, 95, 3, 20, 5, 1, 19, 10740, 531, 763, 12974, 0, 0),
(166, 11, 5, 31, 74, 2, 22, 16, 0, 10, 15415, 706, 896, 24891, 535, 0),
(167, 11, 5, 34, 62, 5, 18, 6, 0, 11, 7485, 366, 651, 9263, 555, 0),
(168, 11, 5, 33, 21, 4, 19, 6, 1, 20, 15465, 614, 730, 11499, 852, 480),
(169, 11, 5, 35, 7, 6, 12, 3, 4, 14, 6440, 291, 327, 8283, 43, 792),
(190, 12, 5, 31, 110, 2, 28, 9, 1, 18, 21930, 670, 800, 29783, 12979, 0),
(191, 12, 5, 34, 95, 5, 25, 3, 5, 22, 17965, 460, 713, 15772, 1485, 0),
(192, 12, 5, 32, 80, 3, 28, 23, 1, 12, 31720, 845, 839, 49639, 11244, 0),
(193, 12, 5, 33, 72, 4, 24, 6, 5, 13, 15870, 476, 642, 26649, 6645, 0),
(194, 12, 5, 35, 38, 6, 22, 1, 5, 27, 13735, 394, 552, 16789, 841, 800),
(195, 12, 3, 14, 117, 5, 18, 5, 9, 7, 10250, 313, 390, 12242, 0, 0),
(196, 12, 3, 12, 101, 3, 21, 0, 9, 8, 14900, 385, 498, 11189, 75, 0),
(197, 12, 3, 13, 65, 4, 20, 5, 10, 7, 17980, 507, 472, 26284, 2256, 0),
(198, 12, 3, 11, 63, 2, 24, 5, 5, 6, 19730, 532, 676, 22241, 1958, 0),
(199, 12, 3, 15, 62, 6, 20, 2, 10, 8, 9830, 274, 465, 17469, 0, 400),
(200, 13, 2, 6, 106, 2, 26, 5, 5, 8, 27250, 664, 710, 18759, 1076, 0),
(201, 13, 2, 7, 96, 3, 22, 8, 7, 8, 14795, 433, 480, 25295, 0, 139),
(202, 13, 2, 8, 73, 4, 20, 4, 9, 10, 15495, 346, 417, 15784, 181, 0),
(203, 13, 2, 10, 52, 6, 14, 1, 6, 10, 8045, 192, 230, 5948, 149, 0),
(204, 13, 2, 9, 42, 5, 20, 3, 8, 13, 6740, 211, 428, 7505, 275, 11822),
(205, 13, 6, 36, 99, 2, 28, 9, 1, 16, 28040, 755, 788, 36476, 14374, 0),
(206, 13, 6, 39, 92, 5, 24, 6, 8, 20, 15320, 470, 632, 19205, 782, 249),
(207, 13, 6, 40, 85, 6, 20, 3, 9, 17, 8200, 272, 408, 8367, 269, 400),
(208, 13, 6, 37, 33, 3, 26, 10, 1, 20, 23740, 577, 702, 43796, 903, 220),
(209, 13, 6, 38, 28, 4, 26, 6, 3, 17, 20520, 485, 703, 19265, 5978, 0),
(210, 14, 6, 40, 101, 6, 12, 1, 9, 2, 5815, 197, 242, 6905, 0, 1292),
(211, 14, 6, 39, 92, 5, 15, 1, 6, 2, 7815, 314, 361, 6553, 0, 110),
(212, 14, 6, 38, 90, 4, 14, 1, 6, 3, 8525, 312, 313, 3325, 0, 0),
(213, 14, 6, 36, 86, 2, 16, 1, 3, 3, 11870, 406, 383, 14038, 237, 0),
(214, 14, 6, 37, 77, 3, 20, 1, 4, 4, 13895, 496, 587, 20837, 832, 110),
(215, 14, 2, 9, 117, 5, 17, 2, 1, 18, 9945, 317, 447, 15902, 0, 1284),
(216, 14, 2, 6, 81, 2, 23, 10, 1, 8, 21285, 704, 791, 23603, 9874, 0),
(217, 14, 2, 8, 56, 4, 18, 1, 1, 14, 11455, 355, 467, 9851, 344, 0),
(218, 14, 2, 7, 33, 3, 24, 13, 1, 6, 20915, 629, 821, 30164, 2046, 0),
(219, 14, 2, 10, 24, 6, 14, 0, 1, 14, 7480, 260, 334, 9268, 164, 4535),
(220, 15, 6, 38, 108, 4, 28, 5, 5, 4, 35300, 494, 660, 32106, 1209, 0),
(221, 15, 6, 36, 54, 2, 29, 8, 2, 5, 58920, 909, 739, 55377, 7726, 0),
(222, 15, 6, 37, 41, 3, 30, 10, 5, 14, 54195, 819, 735, 75117, 5231, 0),
(223, 15, 6, 39, 22, 5, 26, 2, 16, 14, 16745, 261, 445, 16834, 0, 400),
(224, 15, 6, 40, 7, 6, 21, 1, 10, 14, 13990, 225, 273, 11423, 0, 400),
(225, 15, 2, 6, 121, 2, 30, 9, 3, 8, 57460, 780, 625, 31938, 16891, 0),
(226, 15, 2, 9, 117, 5, 29, 4, 8, 18, 23740, 355, 551, 21112, 338, 240),
(227, 15, 2, 10, 92, 6, 26, 5, 7, 14, 20755, 347, 446, 16172, 1281, 700),
(228, 15, 2, 7, 46, 3, 30, 9, 3, 15, 46135, 709, 696, 32797, 1762, 110),
(229, 15, 2, 8, 35, 4, 29, 11, 5, 21, 37150, 704, 587, 61811, 13215, 0),
(230, 16, 8, 44, 111, 5, 13, 1, 8, 18, 7365, 245, 326, 8743, 169, 0),
(231, 16, 8, 45, 105, 6, 16, 5, 3, 18, 8385, 302, 435, 7823, 66, 8303),
(232, 16, 8, 43, 101, 4, 18, 3, 2, 10, 10730, 466, 571, 8392, 2594, 0),
(233, 16, 8, 41, 86, 2, 19, 7, 4, 10, 15810, 627, 592, 14335, 14146, 0),
(234, 16, 8, 42, 33, 3, 20, 8, 1, 9, 15290, 539, 666, 23575, 616, 0),
(235, 16, 7, 47, 99, 2, 18, 5, 7, 9, 12430, 512, 534, 14311, 116, 0),
(236, 16, 7, 48, 77, 3, 19, 1, 2, 9, 11595, 486, 577, 18170, 217, 110),
(237, 16, 7, 49, 58, 4, 16, 2, 4, 4, 11140, 394, 457, 11511, 581, 0),
(238, 16, 7, 51, 43, 6, 12, 5, 8, 12, 5595, 249, 285, 12304, 92, 510),
(239, 16, 7, 50, 39, 5, 13, 4, 3, 7, 5625, 256, 328, 13775, 0, 800),
(240, 17, 8, 41, 121, 2, 17, 4, 2, 6, 10695, 543, 615, 14579, 3425, 0),
(241, 17, 8, 44, 117, 5, 12, 1, 3, 17, 6165, 292, 363, 10832, 104, 0),
(242, 17, 8, 42, 41, 3, 17, 8, 1, 12, 10655, 494, 630, 15050, 451, 0),
(243, 17, 8, 45, 26, 6, 13, 4, 1, 18, 6215, 271, 411, 8491, 110, 400),
(244, 17, 8, 43, 9, 4, 15, 7, 1, 9, 9845, 460, 537, 8415, 1294, 2989),
(245, 17, 7, 48, 80, 3, 14, 3, 4, 1, 8005, 427, 459, 13552, 0, 110),
(246, 17, 7, 47, 54, 2, 15, 2, 3, 3, 10265, 446, 512, 6962, 0, 0),
(247, 17, 7, 50, 39, 5, 11, 2, 5, 5, 5360, 232, 307, 9705, 0, 400),
(248, 17, 7, 49, 15, 4, 13, 1, 5, 2, 8965, 387, 386, 8120, 1198, 0),
(249, 17, 7, 51, 7, 6, 10, 0, 7, 5, 3290, 187, 253, 5773, 0, 940),
(250, 18, 7, 45, 109, 6, 19, 4, 8, 18, 10285, 279, 376, 11018, 60, 5987),
(251, 18, 7, 44, 92, 5, 19, 2, 7, 16, 9625, 295, 370, 22216, 176, 1764),
(252, 18, 7, 42, 86, 3, 24, 6, 4, 7, 26265, 641, 597, 23062, 5048, 29),
(253, 18, 7, 43, 67, 4, 23, 8, 3, 7, 14490, 362, 564, 20855, 912, 0),
(254, 18, 7, 41, 46, 2, 26, 6, 7, 11, 22005, 617, 687, 30584, 1453, 0),
(255, 18, 2, 6, 81, 2, 26, 10, 5, 9, 25650, 652, 660, 48816, 10701, 0),
(256, 18, 2, 9, 61, 5, 24, 2, 3, 19, 13720, 363, 620, 13529, 1283, 0),
(257, 18, 2, 8, 58, 4, 26, 4, 6, 14, 17515, 567, 658, 25662, 7547, 0),
(258, 18, 2, 10, 24, 6, 20, 3, 8, 16, 11725, 272, 429, 11747, 736, 9132),
(259, 18, 2, 7, 8, 3, 23, 9, 4, 10, 17410, 467, 563, 36863, 1077, 0),
(260, 19, 7, 45, 105, 6, 10, 0, 3, 15, 4960, 249, 257, 4847, 696, 5855),
(261, 19, 7, 43, 101, 4, 15, 0, 1, 10, 11760, 443, 495, 6206, 2882, 0),
(262, 19, 7, 41, 74, 2, 19, 7, 0, 8, 13095, 643, 716, 16958, 6895, 0),
(263, 19, 7, 42, 72, 3, 17, 11, 1, 6, 14060, 585, 588, 21949, 7270, 0),
(264, 19, 7, 44, 26, 5, 11, 3, 4, 10, 5485, 262, 303, 7477, 741, 1844),
(265, 19, 2, 8, 102, 4, 13, 1, 6, 1, 8585, 334, 367, 8196, 65, 0),
(266, 19, 2, 7, 95, 3, 15, 3, 3, 5, 10440, 448, 512, 6935, 0, 0),
(267, 19, 2, 10, 92, 6, 8, 2, 5, 7, 6090, 237, 194, 8868, 252, 400),
(268, 19, 2, 9, 58, 5, 10, 2, 7, 3, 4495, 231, 253, 6405, 29, 748),
(269, 19, 2, 6, 44, 2, 18, 1, 1, 4, 12750, 577, 656, 10247, 6984, 2630),
(270, 20, 7, 45, 107, 6, 13, 4, 9, 11, 6455, 250, 315, 6956, 0, 304),
(271, 20, 7, 42, 96, 3, 15, 5, 6, 8, 11290, 471, 434, 17614, 73, 0),
(272, 20, 7, 41, 93, 2, 17, 7, 7, 5, 14325, 536, 499, 19592, 90, 0),
(273, 20, 7, 43, 67, 4, 14, 2, 7, 10, 8655, 356, 383, 5837, 0, 0),
(274, 20, 7, 44, 26, 5, 13, 3, 7, 9, 5210, 234, 351, 7796, 0, 220),
(275, 20, 2, 10, 109, 6, 14, 0, 6, 24, 8040, 332, 371, 7035, 150, 4262),
(276, 20, 2, 9, 92, 5, 15, 10, 4, 15, 8270, 376, 427, 10877, 2154, 884),
(277, 20, 2, 6, 54, 2, 19, 9, 6, 12, 16700, 613, 646, 14231, 15681, 0),
(278, 20, 2, 7, 33, 3, 21, 16, 2, 19, 15490, 594, 756, 34494, 3416, 0),
(279, 20, 2, 8, 9, 4, 18, 1, 4, 24, 11455, 473, 561, 9181, 6552, 2350),
(280, 17, 8, 41, 121, 2, 17, 4, 2, 6, 10695, 543, 615, 14579, 3425, 0),
(281, 21, 4, 29, 89, 5, 21, 10, 8, 9, 11430, 262, 438, 17666, 0, 348),
(282, 21, 4, 26, 72, 2, 24, 3, 6, 12, 18475, 488, 553, 16509, 3158, 0),
(283, 21, 4, 28, 69, 4, 24, 6, 10, 13, 20340, 497, 571, 26784, 144, 0),
(284, 21, 4, 27, 62, 3, 28, 8, 4, 9, 29220, 673, 746, 38033, 2060, 0),
(285, 21, 4, 30, 19, 6, 21, 4, 8, 11, 11145, 313, 426, 17396, 99, 0),
(286, 21, 5, 33, 102, 4, 28, 7, 2, 13, 24010, 560, 687, 28797, 1978, 0),
(287, 21, 5, 34, 92, 5, 26, 4, 6, 21, 15090, 383, 608, 19604, 1763, 0),
(288, 21, 5, 32, 80, 3, 28, 8, 5, 19, 25115, 665, 739, 26907, 3499, 12),
(289, 21, 5, 31, 36, 2, 29, 16, 3, 15, 25295, 651, 683, 33609, 7084, 0),
(290, 21, 5, 35, 7, 6, 21, 1, 15, 15, 9715, 274, 443, 6509, 396, 712),
(291, 22, 5, 35, 117, 6, 26, 5, 9, 15, 17605, 401, 589, 19858, 533, 0),
(292, 22, 5, 34, 62, 5, 24, 2, 11, 17, 15145, 292, 505, 16592, 262, 400),
(293, 22, 5, 32, 39, 3, 27, 12, 5, 14, 27815, 637, 596, 49093, 758, 0),
(294, 22, 5, 31, 36, 2, 27, 9, 5, 15, 26965, 593, 702, 25184, 2707, 0),
(295, 22, 5, 33, 9, 4, 26, 7, 4, 20, 22995, 506, 599, 25587, 1940, 3520),
(296, 22, 4, 27, 106, 3, 30, 7, 3, 13, 37055, 829, 819, 36040, 23722, 0),
(297, 22, 4, 29, 92, 5, 26, 6, 8, 18, 14195, 370, 548, 29253, 824, 260),
(298, 22, 4, 26, 77, 2, 28, 16, 5, 11, 37095, 658, 751, 42709, 962, 0),
(299, 22, 4, 28, 72, 4, 25, 5, 10, 10, 15305, 404, 535, 22078, 743, 0),
(300, 22, 4, 30, 7, 6, 22, 0, 9, 20, 12945, 288, 434, 13139, 0, 890),
(301, 23, 5, 33, 121, 4, 25, 4, 4, 11, 27215, 559, 542, 30213, 2209, 0),
(302, 23, 5, 34, 92, 5, 24, 5, 7, 12, 15930, 346, 486, 14820, 827, 486),
(303, 23, 5, 35, 19, 6, 18, 2, 14, 16, 10695, 265, 284, 16991, 59, 616),
(304, 23, 5, 31, 10, 2, 27, 5, 6, 12, 24850, 561, 618, 39544, 1061, 0),
(305, 23, 5, 32, 8, 3, 27, 9, 5, 9, 24415, 551, 641, 37336, 61, 0),
(306, 23, 4, 28, 102, 4, 29, 8, 4, 17, 28895, 615, 663, 39753, 614, 0),
(307, 23, 4, 26, 81, 2, 28, 11, 4, 13, 28445, 604, 687, 45726, 2117, 0),
(308, 23, 4, 29, 68, 5, 26, 3, 5, 24, 13770, 309, 538, 19692, 0, 348),
(309, 23, 4, 27, 64, 3, 27, 11, 3, 9, 47280, 938, 658, 64880, 19519, 0),
(310, 23, 4, 30, 7, 6, 21, 1, 9, 14, 12220, 286, 361, 11462, 158, 400);

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
  `format` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `team_a_series_score` int DEFAULT NULL,
  `team_b_series_score` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `series`
--

INSERT INTO `series` (`series_id`, `team_id_a`, `team_id_b`, `format`, `team_a_series_score`, `team_b_series_score`) VALUES
(1, 1, 5, 'BO_3', 0, 2),
(2, 4, 6, 'BO_3', 0, 2),
(3, 2, 8, 'BO_3', 2, 0),
(4, 3, 7, 'BO_3', 0, 2),
(5, 1, 4, 'BO_3', 0, 2),
(6, 5, 3, 'BO_3', 2, 0),
(7, 2, 6, 'BO_3', 2, 1),
(8, 8, 7, 'BO_3', 0, 2),
(9, 2, 7, 'BO_3', 2, 1),
(10, 4, 5, 'BO_3', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `team_id` int NOT NULL,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `region` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sponsors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `total_earnings` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `name`, `region`, `sponsors`, `total_earnings`) VALUES
(1, 'Alliance', 'western_europe', 'Monster Energy', 5762816),
(2, 'Team Liquid', 'western_europe', 'Alianware', 23038513),
(3, 'Nigma Galaxy', 'western_europe', 'Etihad Airways', 595414),
(4, 'Team Secret', 'western_europe', 'Secretlab', 15240459),
(5, 'Tundra Esports', 'western_europe', 'Noblechairs', 348100),
(6, 'OG', 'western_europe', 'BMW', 34880062),
(7, 'Team Tickles', 'western_europe', NULL, 0),
(8, 'Coolguys', 'western_europe', NULL, 0);

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
  `leave_date` bigint DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `new_team_player_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `team_player`
--

INSERT INTO `team_player` (`team_player_id`, `team_id`, `player_id`, `player_role_id`, `join_date`, `leave_date`, `is_active`, `new_team_player_id`) VALUES
(5, 1, 1, 2, 1570060800000, NULL, 1, NULL),
(6, 1, 2, 3, 1637193600000, NULL, 1, NULL),
(7, 1, 3, 4, 1637193600000, NULL, 1, NULL),
(8, 1, 4, 5, 1637193600000, NULL, 1, NULL),
(9, 1, 5, 6, 1570060800000, NULL, 1, NULL),
(10, 2, 6, 2, 1637107200000, NULL, 1, NULL),
(11, 2, 7, 3, 1569974400000, NULL, 1, NULL),
(12, 2, 8, 4, 1635897600000, NULL, 1, NULL),
(13, 2, 9, 5, 1569974400000, NULL, 1, NULL),
(14, 2, 10, 6, 1569974400000, NULL, 1, NULL),
(15, 3, 11, 2, 1618012800000, NULL, 1, NULL),
(16, 3, 12, 3, 1574640000000, NULL, 1, NULL),
(17, 3, 13, 4, 1574640000000, NULL, 1, NULL),
(18, 3, 14, 5, 1574640000000, NULL, 1, NULL),
(19, 3, 15, 6, 1574640000000, NULL, 1, NULL),
(25, 5, 31, 2, 1611532800000, NULL, 1, NULL),
(26, 5, 32, 3, 1611532800000, NULL, 1, NULL),
(27, 5, 33, 4, 1611532800000, NULL, 1, NULL),
(28, 5, 34, 5, 1619395200000, NULL, 1, NULL),
(29, 5, 35, 6, 1611532800000, NULL, 1, NULL),
(30, 6, 36, 2, 1637452800000, NULL, 1, NULL),
(31, 6, 37, 3, 1637452800000, NULL, 1, NULL),
(32, 6, 38, 4, 1637452800000, NULL, 1, NULL),
(33, 6, 39, 5, 1637452800000, NULL, 1, NULL),
(34, 6, 40, 6, 1637452800000, NULL, 1, NULL),
(35, 7, 41, 2, 1636588800000, NULL, 1, NULL),
(36, 7, 42, 3, 1636588800000, NULL, 1, NULL),
(37, 7, 43, 4, 1636588800000, NULL, 1, NULL),
(38, 7, 44, 5, 1636588800000, NULL, 1, NULL),
(39, 7, 45, 6, 1636588800000, NULL, 1, NULL),
(45, 8, 47, 2, 1636329600000, NULL, 1, NULL),
(46, 8, 48, 3, 1636329600000, NULL, 1, NULL),
(47, 8, 49, 4, 1636329600000, NULL, 1, NULL),
(48, 8, 50, 5, 1636329600000, NULL, 1, NULL),
(49, 8, 51, 6, 1636329600000, NULL, 1, NULL),
(50, 4, 26, 2, 1636329600000, NULL, 1, NULL),
(51, 4, 27, 3, 1536624000000, NULL, 1, NULL),
(52, 4, 28, 4, 1636329600000, NULL, 1, NULL),
(53, 4, 29, 5, 1493856000000, NULL, 1, NULL),
(54, 4, 30, 6, 1409097600000, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE `tournament` (
  `tournament_id` int NOT NULL,
  `region` varchar(25) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prize_pool` int NOT NULL,
  `start_date` bigint NOT NULL,
  `end_date` bigint NOT NULL,
  `total_dpc_points` int NOT NULL,
  `tournament_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`tournament_id`, `region`, `name`, `prize_pool`, `start_date`, `end_date`, `total_dpc_points`, `tournament_type`) VALUES
(1, 'WESTERN_EUROPE', 'DPC WEU 2021/22 Tour 1: Division I (DreamLeague Season 16)', 205000, 1638230400000, 1642550400000, 690, 'ROUND_ROBIN');

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
  `series_id` int DEFAULT NULL,
  `week_index` int NOT NULL,
  `day_of_week` bigint NOT NULL,
  `day_index` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tournament_roundrobin`
--

INSERT INTO `tournament_roundrobin` (`tournament_roundrobin_id`, `tournament_id`, `series_id`, `week_index`, `day_of_week`, `day_index`) VALUES
(1, 1, 1, 1, 1638230400000, 1),
(2, 1, 2, 1, 1638230400000, 2),
(3, 1, 3, 1, 1638316800000, 1),
(4, 1, 4, 1, 1638576000000, 1),
(5, 1, 5, 1, 1638576000000, 2),
(6, 1, 6, 1, 1638835200000, 1),
(7, 1, 7, 1, 1638835200000, 2),
(8, 1, 8, 1, 1638921600000, 1),
(9, 1, 9, 1, 1639180800000, 1),
(10, 1, 10, 1, 1639180800000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tournament_team`
--

CREATE TABLE `tournament_team` (
  `tournament_team_id` int NOT NULL,
  `tournament_id` int NOT NULL,
  `team_id` int NOT NULL,
  `place` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `dpc_points` int DEFAULT NULL,
  `seed` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tournament_team`
--

INSERT INTO `tournament_team` (`tournament_team_id`, `tournament_id`, `team_id`, `place`, `price`, `dpc_points`, `seed`) VALUES
(1, 1, 1, NULL, NULL, NULL, NULL),
(2, 1, 2, NULL, NULL, NULL, NULL),
(3, 1, 3, NULL, NULL, NULL, NULL),
(4, 1, 4, NULL, NULL, NULL, NULL),
(5, 1, 5, NULL, NULL, NULL, NULL),
(6, 1, 6, NULL, NULL, NULL, NULL),
(7, 1, 7, NULL, NULL, NULL, NULL),
(8, 1, 8, NULL, NULL, NULL, NULL);

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
  ADD KEY `fk_team_player_player_id` (`player_id`),
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
  ADD KEY `fk_tournament_roundrobin_series_id` (`series_id`),
  ADD KEY `fk_tournament_roundrobin_tournament_id` (`tournament_id`);

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
  MODIFY `game_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `hero`
--
ALTER TABLE `hero`
  MODIFY `hero_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=239;

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `player_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `player_game`
--
ALTER TABLE `player_game`
  MODIFY `player_game_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=311;

--
-- AUTO_INCREMENT for table `player_role`
--
ALTER TABLE `player_role`
  MODIFY `player_role_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `series`
--
ALTER TABLE `series`
  MODIFY `series_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `team_player`
--
ALTER TABLE `team_player`
  MODIFY `team_player_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `tournament_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tournament_bracket`
--
ALTER TABLE `tournament_bracket`
  MODIFY `tournament_bracket_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tournament_roundrobin`
--
ALTER TABLE `tournament_roundrobin`
  MODIFY `tournament_roundrobin_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tournament_team`
--
ALTER TABLE `tournament_team`
  MODIFY `tournament_team_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  ADD CONSTRAINT `fk_team_player_id` FOREIGN KEY (`new_team_player_id`) REFERENCES `team_player` (`team_player_id`),
  ADD CONSTRAINT `fk_team_player_player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON DELETE CASCADE ON UPDATE CASCADE,
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
  ADD CONSTRAINT `fk_tournament_roundrobin_tournament_id` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE;

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

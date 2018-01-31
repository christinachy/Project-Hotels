-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: localhost
-- Χρόνος δημιουργίας: 29 Ιαν 2018 στις 20:50:10
-- Έκδοση διακομιστή: 5.5.55-0+deb8u1
-- Έκδοση PHP: 5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `hotels_db`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `accounts`
--

CREATE TABLE `accounts` (
  `user` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(25) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `accounts`
--

INSERT INTO `accounts` (`user`, `password`) VALUES
('Owner', '123'),
('User', '321');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `Krathseis`
--

CREATE TABLE `Krathseis` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `room_id` bigint(20) NOT NULL,
  `hm_enarksis` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hm_lhkshs` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `onoma_krathshs` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `Krathseis`
--

INSERT INTO `Krathseis` (`id`, `room_id`, `hm_enarksis`, `hm_lhkshs`, `onoma_krathshs`) VALUES
(1, 2, '2018-01-30 22:00:00', '2018-02-02 22:00:00', 'diana'),
(2, 1, '2018-01-29 18:41:55', '2018-02-03 22:00:00', 'Xristina'),
(3, 2, '2018-02-03 22:00:00', '2018-02-11 22:00:00', 'giannhs'),
(4, 4, '2018-02-08 22:00:00', '2018-02-10 22:00:00', 'anna'),
(5, 3, '2018-02-01 22:00:00', '2018-02-08 22:00:00', 'Nikos'),
(6, 5, '2018-01-29 22:00:00', '2018-01-31 22:00:00', 'lefos'),
(7, 6, '2018-02-06 22:00:00', '2018-02-13 22:00:00', 'natalia '),
(8, 8, '2018-02-28 22:00:00', '2018-03-03 22:00:00', 'dimos'),
(9, 10, '2018-02-09 22:00:00', '2018-02-19 22:00:00', 'Spiros');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `rooms`
--

CREATE TABLE `rooms` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `room_number` int(11) NOT NULL,
  `timh` decimal(10,0) NOT NULL,
  `atoma` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Άδειασμα δεδομένων του πίνακα `rooms`
--

INSERT INTO `rooms` (`id`, `room_number`, `timh`, `atoma`) VALUES
(1, 1, 50, 2),
(2, 3, 50, 3),
(3, 2, 150, 2),
(4, 4, 200, 5),
(5, 5, 1000, 4),
(6, 6, 200, 3),
(7, 7, 600, 3),
(8, 8, 80, 2),
(9, 9, 700, 7),
(10, 10, 450, 4);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `Krathseis`
--
ALTER TABLE `Krathseis`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Ευρετήρια για πίνακα `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `Krathseis`
--
ALTER TABLE `Krathseis`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT για πίνακα `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

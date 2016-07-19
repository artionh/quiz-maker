-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2016 at 12:28 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quizmaker`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE IF NOT EXISTS `answer` (
  `false1` varchar(45) DEFAULT NULL,
  `false2` varchar(45) DEFAULT NULL,
  `false3` varchar(45) DEFAULT NULL,
  `question_id` int(11) NOT NULL,
  `true1` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_answer_question1_idx` (`question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`false1`, `false2`, `false3`, `question_id`, `true1`, `id`) VALUES
('Silver', 'Blue', 'Green', 26, 'Gold', 1),
('Madrid', 'Valencia', 'Seville', 27, 'Barcelona', 2),
('Vincent Van Gogh', 'Rembrandt', 'Michelangelo', 28, 'Leonardo Da Vinci', 3),
('Turkey', 'Gerymany', 'Albania', 29, 'Greece', 4),
('Nice', 'Lyon', 'Monaco', 30, 'Paris', 5),
('Duritz', 'Scott', 'Johnny ', 31, 'Aaron', 6),
('AC / DC', 'Metallica', 'Backstreet Boys', 32, 'The Beatles', 7),
('Johnny Logan', 'Madonna', 'Adam Duritz', 33, 'Michael Jackson', 8),
('Cyrus', 'Perry', 'Istrefi', 34, 'Fenty', 9),
('Tommy Lee', 'Max Roach', 'Neil Peart', 35, 'Lars Ulrich', 10),
('12', '13', '10', 36, '11', 11),
('Three movies', 'Four movies', 'One movie', 37, 'Two movies', 12),
('Number 741', 'Number 740', 'Number 743', 38, 'Number 742', 13),
('Tushu', 'Fushu', 'Gushu', 39, 'Mushu', 14),
('54', '55', '56', 40, '53', 15),
('1987', '1988', '1989', 41, '1986', 16),
('90 Minutes', '70 Minutes', '100 Minutes', 42, '80 Minutes', 17),
('Cyprus', 'Macedonia', 'Albania', 43, 'Greece', 18),
('Three plawers', 'Four players', 'Five players', 44, 'Two players', 19),
('Two', 'Three', 'Four', 45, 'Only one', 20),
('Aerium', 'Burj Khalifa', 'CITIC Plaza', 46, 'Pentagon', 21),
('China', 'South Korea', 'South Africa', 47, 'Switzerland', 22),
('In Germany', 'In Paris', 'In Tirana', 48, 'In London', 23),
('Peru', 'Colombia', 'Chile', 49, 'Brazil', 24),
('Naira', 'Kes', 'Lek', 50, 'Rupee', 25);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Art'),
(2, 'Music'),
(3, 'Film / TV'),
(4, 'Sports'),
(5, 'Economy');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_user1_idx` (`user_id`),
  KEY `fk_question_category1_idx` (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=51 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `name`, `date`, `user_id`, `category_id`, `image`) VALUES
(26, 'What color are often the domes of churches in Russia?', '2016-07-13', 3, 1, 'rusia.jpg'),
(27, 'In which Spanish city did the Joan Miro museum open in 1975?', '2016-07-13', 3, 1, 'spain-museums.jpg'),
(28, 'Who did the Mona Lisa paint?', '2016-07-13', 3, 1, 'mona-lisa.jpg'),
(29, 'In which country was the famous painter El Greco born?', '2016-07-13', 3, 1, 'el_greco.jpg'),
(30, 'In which city is the composer Frédéric Chopin buried?', '2016-07-13', 3, 1, 'frederic.jpg'),
(31, 'What is Elvis Presley s middle name?', '2016-07-13', 3, 2, 'elvis-presley.jpg'),
(32, 'Which famous group was once known as The Quarrymen?', '2016-07-13', 3, 2, NULL),
(33, 'Who did win the most Grammy Awards in the 80?', '2016-07-13', 3, 2, 'Grammy-Awards.jpg'),
(34, 'What is the surname of the singer Rihanna?', '2016-07-13', 3, 2, 'Rihanna.jpg'),
(35, 'Who is the drummer of Metallica?', '2016-07-13', 3, 2, 'Metallica.jpg'),
(36, 'How many oscars did the Titanic movie got?', '2016-07-13', 3, 3, 'titanic.jpg'),
(37, 'How many Tomb Raider movies were made?', '2016-07-13', 3, 3, 'Tomb-Raider.jpg'),
(38, 'What is the house number of the Simpsons?', '2016-07-13', 3, 3, 'Simpsons-house.jpg'),
(39, 'What is the name of the little dragon in the animated movie Mulan?', '2016-07-13', 3, 3, 'mushu.jpg'),
(40, 'What number is on Herbie the beatle?', '2016-07-13', 3, 3, NULL),
(41, 'In which year did Maradona score a goal with his hand?', '2016-07-13', 3, 4, NULL),
(42, 'How many minutes is a rugby match?', '2016-07-13', 3, 4, NULL),
(43, 'In which country were the first Olympic Games held?', '2016-07-13', 3, 4, 'Olympic-Games.png'),
(44, 'How many players are on each side of the net in beach volleyball?', '2016-07-13', 3, 4, NULL),
(45, 'How matches did Mohammed Ali lose in his career?', '2016-07-13', 3, 4, 'Mohammed-Ali.jpg'),
(46, 'What is the world s largest office building?', '2016-07-13', 3, 5, 'office-building.png'),
(47, 'Where does a car with the letters CH come from?', '2016-07-13', 3, 5, NULL),
(48, 'Where was built the first subway?', '2016-07-13', 3, 5, 'subway.png'),
(49, 'In which country is Varig Airlines based?', '2016-07-13', 3, 5, 'Varig-Airlines.jpg'),
(50, 'What is the official currency in Nepal?', '2016-07-13', 3, 5, 'Nepal.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role1_idx` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role_id`) VALUES
(3, 'romina', '1234', 1),
(4, 'greti', '1234', 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `fk_answer_question1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `fk_question_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_question_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

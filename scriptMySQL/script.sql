-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 23-Ago-2021 às 01:46
-- Versão do servidor: 10.1.40-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_trabalho3`
--
CREATE DATABASE IF NOT EXISTS `java_trabalho3` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `java_trabalho3`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `tipo` varchar(8) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `matricula` bigint(20) NOT NULL,
  `salario` double DEFAULT NULL,
  `totalHoras` int(11) DEFAULT NULL,
  `valorHora` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id`, `tipo`, `nome`, `matricula`, `salario`, `totalHoras`, `valorHora`) VALUES
(1, 'efetivo', 'Luciane Santini', 2145, 21500, NULL, NULL),
(2, 'efetivo', 'Antonio Paulo Serpa Antunes', 2134, 18500, NULL, NULL),
(9, 'efetivo', 'João Pedro', 12, 9600.23, NULL, NULL),
(11, 'efetivo', 'Pedro', 123, 13400, NULL, NULL),
(14, 'horista', 'Marcelo Monteiro', 34, NULL, 80, 78),
(38, 'efetivo', 'Marcelo Moreno', 2313, 15600, NULL, NULL),
(39, 'efetivo', 'Ângela Cairu', 2222, 32445, NULL, NULL),
(40, 'horista', 'Roberta Souza', 1234, NULL, 80, 58),
(41, 'efetivo', 'Pedro Rocha', 6789, 4678, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `senha`) VALUES
(1, 'silvia', 'jsp2021'),
(2, 'paulo', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2022 a las 20:32:46
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_financiero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_cuenta`
--

CREATE TABLE `tb_cuenta` (
  `id_cuenta` bigint(20) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `tipo_cuenta` varchar(100) NOT NULL,
  `estado_linea` bit(1) DEFAULT b'1',
  `fecha_creacion` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_cuenta`
--

INSERT INTO `tb_cuenta` (`id_cuenta`, `id_persona`, `tipo_cuenta`, `estado_linea`, `fecha_creacion`) VALUES
(1, 1, 'Corriente', b'1', '2022-06-20 16:58:40'),
(2, 4, 'Nomina', b'1', '2022-06-21 08:30:38'),
(3, 5, 'Corriente', b'1', '2022-06-21 08:45:41'),
(4, 6, 'Corriente', b'1', '2022-06-21 09:09:28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_movimientos_cuenta`
--

CREATE TABLE `tb_movimientos_cuenta` (
  `id_movimiento` bigint(20) NOT NULL,
  `id_cuenta` bigint(20) NOT NULL,
  `tipo_transaccion` varchar(50) NOT NULL,
  `debe` double NOT NULL,
  `haber` double DEFAULT NULL,
  `estado_linea` bit(1) NOT NULL DEFAULT b'1',
  `fecha_creacion` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_movimientos_cuenta`
--

INSERT INTO `tb_movimientos_cuenta` (`id_movimiento`, `id_cuenta`, `tipo_transaccion`, `debe`, `haber`, `estado_linea`, `fecha_creacion`) VALUES
(1, 1, 'Consignacion', 100000.99, 0, b'1', '2022-06-20 17:21:28'),
(2, 1, 'Consignacion', 200000.99, 0, b'1', '2022-06-20 17:23:21'),
(3, 1, 'Consignacion', 239876.99, 0, b'1', '2022-06-20 17:24:04'),
(4, 1, 'Retiro', 0, 239876.99, b'1', '2022-06-20 17:26:27'),
(5, 1, 'Retiro', 0, 4569, b'1', '2022-06-20 17:27:36'),
(6, 1, 'Retiro', 0, 4569, b'1', '2022-06-20 17:29:19'),
(7, 1, 'Retiro', 0, 67543, b'1', '2022-06-20 17:31:10'),
(8, 1, 'Retiro', 0, 2123, b'1', '2022-06-20 17:31:58'),
(9, 1, 'Retiro', 0, 342, b'1', '2022-06-20 17:32:38'),
(10, 1, 'Retiro', 0, 342, b'1', '2022-06-20 17:33:48'),
(11, 1, 'Retiro', 0, 342, b'1', '2022-06-20 17:34:48'),
(12, 1, 'Consignacion', 167000, 0, b'1', '2022-06-20 20:35:51'),
(13, 1, 'Retiro', 0, 25000, b'1', '2022-06-21 10:37:49'),
(14, 1, 'Consignacion', 150201, 0, b'1', '2022-06-21 11:43:15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_persona`
--

CREATE TABLE `tb_persona` (
  `id_persona` int(10) NOT NULL,
  `tipo_documento` varchar(50) NOT NULL,
  `numero_documento` varchar(30) NOT NULL,
  `primer_nombre` varchar(100) NOT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `estado_linea` bit(1) NOT NULL DEFAULT b'1',
  `fecha_creacion` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_persona`
--

INSERT INTO `tb_persona` (`id_persona`, `tipo_documento`, `numero_documento`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `fecha_nacimiento`, `direccion`, `telefono`, `estado_linea`, `fecha_creacion`) VALUES
(1, 'CC - CEDULA DE CIUDADANIA', '1075651850', 'Diana', 'Carolina', 'Miranda', '', '1986-06-20', 'Carrera 4a # 2f - 38', '3132666401', b'1', '2022-06-19 22:57:23'),
(2, 'CC', '1075651851', 'Diana', 'Carolina', 'Miranda', 'Molina', '1986-06-22', 'Carrera 4a # 2f - 38', '3132666401', b'0', '2022-06-19 23:01:42'),
(3, 'CC', '1075651852', 'Diana', 'Carolina', 'Miranda', 'Molina', '1986-06-22', 'Carrera 4a # 2f - 38', '3132666401', b'0', '2022-06-19 23:03:22'),
(4, 'CC - CEDULA DE CIUDADANIA', '123456789', 'LUIS', '', 'MOLINA', '', '1986-06-22', 'COGUA', '3214564545', b'1', '2022-06-21 08:17:52'),
(5, 'CC - CEDULA DE CIUDADANIA', '10754125251', 'Carlos', '', 'Castro', '', '1991-01-04', 'Bogota', '3132666401', b'1', '2022-06-21 08:45:41'),
(6, 'CC - CEDULA DE CIUDADANIA', '20450340', 'CECILIA', '', 'MOLINA', '', '1982-03-18', 'CARRERA 5A # 2F 38', '3201584212', b'1', '2022-06-21 09:09:28');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_cuenta`
--
ALTER TABLE `tb_cuenta`
  ADD PRIMARY KEY (`id_cuenta`);

--
-- Indices de la tabla `tb_movimientos_cuenta`
--
ALTER TABLE `tb_movimientos_cuenta`
  ADD PRIMARY KEY (`id_movimiento`);

--
-- Indices de la tabla `tb_persona`
--
ALTER TABLE `tb_persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_cuenta`
--
ALTER TABLE `tb_cuenta`
  MODIFY `id_cuenta` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tb_movimientos_cuenta`
--
ALTER TABLE `tb_movimientos_cuenta`
  MODIFY `id_movimiento` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tb_persona`
--
ALTER TABLE `tb_persona`
  MODIFY `id_persona` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema loja
--

CREATE DATABASE IF NOT EXISTS loja;
USE loja;

--
-- Definition of table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `idperfil` int(10) NOT NULL auto_increment,
  `perfil` varchar(30) default NULL,
  `dscPerfil` varchar(30) default NULL,
  PRIMARY KEY  (`idperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perfil`
--

/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`idperfil`,`perfil`,`dscPerfil`) VALUES 
 (1,'Admin','Administrador'),
 (2,'Alteracoa','Alteração'),
 (3,'Inclusao','Inclusão');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


--
-- Definition of table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE `produtos` (
  `idProduto` int(10) NOT NULL auto_increment,
  `nameProd` varchar(250) default NULL,
  `descriptionProd` varchar(250) default NULL,
  `commentProd` varchar(250) default NULL,
  `imageProd` varchar(250) default NULL,
  `linkVideo` varchar(250) default NULL,
  `whatsApp` varchar(250) default NULL,
  `email` varchar(250) default NULL,
  `comprarLink` varchar(250) default NULL,
  `idusuario` int(10) default NULL,
  `idstatus` int(10) default NULL,
  PRIMARY KEY  (`idProduto`),
  KEY `idusuario` (`idusuario`),
  KEY `idstatus` (`idstatus`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`idstatus`) REFERENCES `tipostatus` (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produtos`
--

/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;


--
-- Definition of table `tipostatus`
--

DROP TABLE IF EXISTS `tipostatus`;
CREATE TABLE `tipostatus` (
  `idstatus` int(6) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `dscStatus` varchar(30) NOT NULL,
  PRIMARY KEY  (`idstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipostatus`
--

/*!40000 ALTER TABLE `tipostatus` DISABLE KEYS */;
INSERT INTO `tipostatus` (`idstatus`,`name`,`dscStatus`) VALUES 
 (1,'Ativo','Ativo'),
 (2,'Excluido','Excluido'),
 (3,'Editada','Editada'),
 (4,'Desativado','Desativado');
/*!40000 ALTER TABLE `tipostatus` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(6) NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `email` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `regdate` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `lastacess` timestamp NOT NULL default '0000-00-00 00:00:00',
  `idperfil` int(10) default NULL,
  `idstatus` int(10) default NULL,
  PRIMARY KEY  (`idUsuario`),
  KEY `idperfil` (`idperfil`),
  KEY `idstatus` (`idstatus`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idperfil`) REFERENCES `perfil` (`idperfil`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idstatus`) REFERENCES `tipostatus` (`idstatus`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`,`name`,`lastName`,`email`,`password`,`regdate`,`lastacess`,`idperfil`,`idstatus`) VALUES 
 (1,'eduardo','sa','nofrereis@gmail.com','123senha','2018-12-04 23:36:08','2018-11-10 19:32:43',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

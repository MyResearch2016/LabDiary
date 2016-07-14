
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_webdiary
--

CREATE DATABASE IF NOT EXISTS db_webdiary;
USE db_webdiary;

--
-- Definition of table `tb_diary`
--

DROP TABLE IF EXISTS `tb_diary`;
CREATE TABLE `tb_diary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(100) NOT NULL COMMENT '日记内容',
  `writeTime` varchar(30) NOT NULL COMMENT '写入时间',
  `userid` int(10) unsigned NOT NULL COMMENT '用户ID',
  `username` varchar(50) unsigned NOT NULL COMMENT '用户名',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_diary`
--

/*!40000 ALTER TABLE `tb_diary` DISABLE KEYS */;
INSERT INTO `tb_diary` (`id`,`text`,`writeTime`,`userid`,`username`) VALUES 
 (1,'日记本测试文本','2016-03-23 20:20:26',1,'admin'),
 (2,'日记本测试文本','2016-03-23 20:21:26',2,'test'),
 (3,'日记本测试文本','2016-03-23 20:22:26',2,'test'),
 (4,'日记本测试文本','2016-03-23 20:23:26',2,'test'),
 (5,'日记本测试文本','2016-03-23 20:24:26',2,'test'),
 (6,'日记本测试文本','2016-03-23 20:25:26',2,'test'),
 (7,'日记本测试文本','2016-03-23 20:21:26',2,'test'),
 (8,'日记本测试文本','2016-03-23 20:22:26',2,'test'),
 (9,'日记本测试文本','2016-03-23 20:23:26',2,'test'),
 (10,'日记本测试文本','2016-03-23 20:24:26',3,'叛逆的鲁鲁修'),
 (11,'日记本测试文本','2016-03-23 20:25:26',3,'叛逆的鲁鲁修'),
 (12,'日记本测试文本','2016-03-23 20:21:26',3,'叛逆的鲁鲁修'),
 (13,'日记本测试文本','2016-03-23 20:22:26',3,'叛逆的鲁鲁修'),
 (14,'日记本测试文本','2016-03-23 20:23:26',3,'叛逆的鲁鲁修'),
 (15,'日记本测试文本','2016-03-23 20:24:26',3,'叛逆的鲁鲁修'),
 (16,'日记本测试文本','2016-03-23 20:25:26',3,'叛逆的鲁鲁修');
 
/*!40000 ALTER TABLE `tb_diary` ENABLE KEYS */;


--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `pwd` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`username`,`pwd`) VALUES 
 (1,'admin','123456'),
 (2,'Test','123456'),
 (3,'叛逆的鲁鲁修','luluxiu'),
 (4,'Xueyan','xueyan'),
 (5,'雪龑','xueyan'),
 (6,'yuanyuanwang','yuanyuanwang'),
 (7,'cuicuiqian','cuicuiqian'),
 (8,'huchen','huchen'),
 (9,'fuhaoli','fuhaoli'),
 (10,'leizhao','leizhao'),
 (11,'deyunzhang','deyunzhang'),
 (12,'genli','genli'),
 (13,'chengyangli','chengyangli'),
 (14,'feiguo','feiguo'),
 (15,'mengxueyao','mengxueyao'),
 (16,'huiwang','huiwang'),
 (17,'sipeima','sipeima'),
 (18,'bolizhang','bolizhang'),
 (19,'jianhualv','jianhualv');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_event`;
CREATE TABLE `tb_event` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `times` varchar(50) DEFAULT NULL COMMENT '时间',
  `place` varchar(50) DEFAULT NULL COMMENT '地点',
  `activity` varchar(50) DEFAULT NULL COMMENT '活动',
  `state` varchar(50) DEFAULT NULL COMMENT '客体',
  `userid` int(10) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`times`,`place`,`activity`,`state`,`userid`) VALUES 
 (1,'时间','地点','活动','状态','用户ID');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

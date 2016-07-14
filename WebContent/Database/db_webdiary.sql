
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
  `text` varchar(100) NOT NULL COMMENT '�ռ�����',
  `writeTime` varchar(30) NOT NULL COMMENT 'д��ʱ��',
  `userid` int(10) unsigned NOT NULL COMMENT '�û�ID',
  `username` varchar(50) unsigned NOT NULL COMMENT '�û���',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_diary`
--

/*!40000 ALTER TABLE `tb_diary` DISABLE KEYS */;
INSERT INTO `tb_diary` (`id`,`text`,`writeTime`,`userid`,`username`) VALUES 
 (1,'�ռǱ������ı�','2016-03-23 20:20:26',1,'admin'),
 (2,'�ռǱ������ı�','2016-03-23 20:21:26',2,'test'),
 (3,'�ռǱ������ı�','2016-03-23 20:22:26',2,'test'),
 (4,'�ռǱ������ı�','2016-03-23 20:23:26',2,'test'),
 (5,'�ռǱ������ı�','2016-03-23 20:24:26',2,'test'),
 (6,'�ռǱ������ı�','2016-03-23 20:25:26',2,'test'),
 (7,'�ռǱ������ı�','2016-03-23 20:21:26',2,'test'),
 (8,'�ռǱ������ı�','2016-03-23 20:22:26',2,'test'),
 (9,'�ռǱ������ı�','2016-03-23 20:23:26',2,'test'),
 (10,'�ռǱ������ı�','2016-03-23 20:24:26',3,'�����³³��'),
 (11,'�ռǱ������ı�','2016-03-23 20:25:26',3,'�����³³��'),
 (12,'�ռǱ������ı�','2016-03-23 20:21:26',3,'�����³³��'),
 (13,'�ռǱ������ı�','2016-03-23 20:22:26',3,'�����³³��'),
 (14,'�ռǱ������ı�','2016-03-23 20:23:26',3,'�����³³��'),
 (15,'�ռǱ������ı�','2016-03-23 20:24:26',3,'�����³³��'),
 (16,'�ռǱ������ı�','2016-03-23 20:25:26',3,'�����³³��');
 
/*!40000 ALTER TABLE `tb_diary` ENABLE KEYS */;


--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '�û���',
  `pwd` varchar(50) NOT NULL COMMENT '����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`username`,`pwd`) VALUES 
 (1,'admin','123456'),
 (2,'Test','123456'),
 (3,'�����³³��','luluxiu'),
 (4,'Xueyan','xueyan'),
 (5,'ѩ��','xueyan'),
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
  `times` varchar(50) DEFAULT NULL COMMENT 'ʱ��',
  `place` varchar(50) DEFAULT NULL COMMENT '�ص�',
  `activity` varchar(50) DEFAULT NULL COMMENT '�',
  `state` varchar(50) DEFAULT NULL COMMENT '����',
  `userid` int(10) NOT NULL COMMENT '�û�ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_user`
--

/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`id`,`times`,`place`,`activity`,`state`,`userid`) VALUES 
 (1,'ʱ��','�ص�','�','״̬','�û�ID');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

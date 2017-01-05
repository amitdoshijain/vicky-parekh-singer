CREATE DATABASE `vickydparekh_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `assets` (
  `id` int(11) NOT NULL,
  `category` mediumtext,
  `description` mediumtext,
  `url` mediumtext,
  `uploadedby` mediumtext,
  `updatedon` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `description` mediumtext,
  `postedby` mediumtext,
  `deleted` tinyint(1) DEFAULT NULL,
  `postedon` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `eventimages` (
  `id` int(11) NOT NULL,
  `eventid` int(11) DEFAULT NULL,
  `imageurl` blob,
  `description` mediumtext,
  `updatedon` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `name` mediumtext,
  `description` mediumtext,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `eventtime` time DEFAULT NULL,
  `location` mediumtext,
  `city` int(11) NOT NULL,
  `updatedon` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `productenquiry` (
  `id` int(11) NOT NULL,
  `productid` int(11) DEFAULT NULL,
  `description` mediumtext,
  `email` mediumtext,
  `duedate` date DEFAULT NULL,
  `updatedon` date DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` mediumtext,
  `description` mediumtext,
  `cost` int(11) NOT NULL,
  `imageurl` mediumtext,
  `updatedon` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` mediumtext,
  `password` mediumtext,
  `sessionid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


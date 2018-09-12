# TechTalks

## A small application using servlets,jsp

# Database Schema - techtonics

Users
```
CREATE TABLE `users` (
  `empid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `userscol` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `isAdmin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
```

Techtalks
```
CREATE TABLE `techtalks` (
  `techtalksid` int(11) NOT NULL AUTO_INCREMENT,
  `presenteeName` varchar(45) DEFAULT NULL,
  `topic` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `when` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`techtalksid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1
```

requests
```
CREATE TABLE `requests` (
  `requestid` int(11) NOT NULL AUTO_INCREMENT,
  `presentee` varchar(45) DEFAULT NULL,
  `topic` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `empid` varchar(45) DEFAULT NULL,
  `when` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`requestid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1
```

attendee
```
CREATE TABLE `attendee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empid` varchar(45) DEFAULT NULL,
  `techtalksid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1
```

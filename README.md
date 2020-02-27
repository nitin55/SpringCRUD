# SpringCRUD

#Database: springdb

#table: Employee

CREATE TABLE `Employee` (
  `id` int(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1


#AccessURL: http://localhost:8080/example/employees

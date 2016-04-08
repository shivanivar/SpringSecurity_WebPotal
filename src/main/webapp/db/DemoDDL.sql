CREATE TABLE `employment` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(11) DEFAULT NULL,
  `company_name` varchar(45) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employment_1_idx` (`user_id`),
  CONSTRAINT `fk_employment_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `qualification` (
  `id` bigint(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `qualification_id` bigint(20) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `university` varchar(45) NOT NULL,
  `percentage` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `qualification_master` (
  `id` bigint(11) NOT NULL,
  `qualification_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` bigint(11) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `admin` char(1) DEFAULT 'N',
  `created_date` datetime DEFAULT NULL,
  `mobile` varchar(20) NOT NULL,
  `permanent_address` varchar(100) DEFAULT NULL,
  `current_address` varchar(100) DEFAULT NULL,
  `gender` varchar(45) DEFAULT 'Unknown',
  `dob` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO  `qualification_master` (`qualification_name`) VALUES ('SSC'), ('HSC'), ('Graduation'), ('Other');
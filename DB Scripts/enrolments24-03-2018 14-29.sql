#
# TABLE STRUCTURE FOR: enrolments
#

DROP TABLE IF EXISTS enrolments;

CREATE TABLE `enrolments` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `requeste_date` date NOT NULL,
  `accepted` tinyint(1) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `courses_enrolments_fk` (`course_id`),
  CONSTRAINT `courses_enrolments_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `students_enrolments_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (1, 0, '2008-11-04', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (1, 8, '1972-10-23', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (2, 7, '2017-11-15', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (2, 9, '2014-10-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (3, 0, '1989-02-22', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (3, 1, '1979-10-07', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (3, 4, '1984-04-13', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (4, 1, '1970-02-16', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (4, 2, '2016-09-04', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (4, 8, '1981-10-31', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (6, 1, '1988-07-17', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (6, 2, '1982-12-30', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (6, 3, '2012-03-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (6, 6, '1984-06-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (6, 8, '2003-10-25', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (7, 5, '2016-04-27', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (7, 6, '1991-03-26', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (7, 8, '2017-12-12', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (8, 0, '1992-11-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (8, 3, '1981-09-24', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (8, 9, '1982-07-13', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (9, 2, '1972-09-26', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (9, 6, '1989-05-15', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (10, 1, '2015-11-01', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (10, 2, '1989-10-13', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (10, 6, '2003-02-14', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (10, 7, '2009-08-15', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (10, 8, '1979-03-07', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (11, 3, '2000-07-05', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (11, 5, '1987-01-04', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (12, 2, '1979-07-27', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (12, 3, '2014-06-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (12, 4, '1983-10-10', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (12, 9, '1994-12-06', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (13, 2, '1996-11-12', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (13, 6, '1984-11-04', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (14, 0, '1984-02-22', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (14, 2, '2017-04-02', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (14, 8, '1993-12-07', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (14, 9, '1972-01-08', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (15, 0, '1996-12-17', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (15, 2, '1977-12-16', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (15, 4, '1977-11-28', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (15, 7, '1987-02-26', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (15, 8, '2008-10-05', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (16, 3, '1995-10-06', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (16, 6, '1992-03-17', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (16, 8, '2017-05-02', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (16, 9, '2001-08-20', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (17, 5, '1999-09-28', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (17, 6, '1976-12-06', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (17, 8, '2005-08-29', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (18, 2, '2006-04-17', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (18, 3, '1986-02-04', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (18, 8, '1971-04-24', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (19, 1, '2013-11-05', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (19, 2, '1979-11-21', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (19, 3, '1981-02-16', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (19, 5, '1992-10-18', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (19, 9, '1971-12-27', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (20, 1, '1979-11-15', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (20, 2, '2001-06-23', 0);
INSERT INTO enrolments (`student_id`, `course_id`, `requeste_date`, `accepted`) VALUES (20, 4, '1998-04-30', 0);



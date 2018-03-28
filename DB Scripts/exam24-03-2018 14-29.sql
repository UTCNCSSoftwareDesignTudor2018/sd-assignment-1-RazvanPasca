#
# TABLE STRUCTURE FOR: exam
#

DROP TABLE IF EXISTS exam;

CREATE TABLE `exam` (
  `course_id` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`course_id`),
  CONSTRAINT `courses_exam_fk` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO exam (`course_id`, `date`) VALUES (0, '1996-10-07');
INSERT INTO exam (`course_id`, `date`) VALUES (1, '1978-02-25');
INSERT INTO exam (`course_id`, `date`) VALUES (2, '1987-11-30');
INSERT INTO exam (`course_id`, `date`) VALUES (3, '2008-03-21');
INSERT INTO exam (`course_id`, `date`) VALUES (4, '2014-06-20');
INSERT INTO exam (`course_id`, `date`) VALUES (5, '1999-11-13');
INSERT INTO exam (`course_id`, `date`) VALUES (6, '1975-12-23');
INSERT INTO exam (`course_id`, `date`) VALUES (7, '2014-01-22');
INSERT INTO exam (`course_id`, `date`) VALUES (9, '1973-07-22');



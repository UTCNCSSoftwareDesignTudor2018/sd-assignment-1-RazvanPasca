#
# TABLE STRUCTURE FOR: grades
#

DROP TABLE IF EXISTS grades;

CREATE TABLE `grades` (
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`course_id`),
  KEY `exam_grades_fk` (`course_id`),
  CONSTRAINT `exam_grades_fk` FOREIGN KEY (`course_id`) REFERENCES `exam` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `students_grades_fk` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (1, 1, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (1, 5, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (2, 1, 6);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (2, 6, 5);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (4, 5, 5);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (5, 4, 7);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (5, 6, 9);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (6, 3, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (6, 7, 8);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (7, 6, 8);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (8, 0, 5);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (8, 5, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (8, 6, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (9, 2, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (9, 3, 2);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (9, 4, 7);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (9, 5, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (10, 1, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (10, 3, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (11, 0, 10);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (11, 3, 7);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (11, 5, 10);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (11, 6, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (11, 9, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (13, 6, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (14, 0, 2);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (14, 5, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (14, 9, 10);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (15, 2, 6);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (15, 4, 7);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (15, 5, 7);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (16, 0, 3);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (16, 3, 9);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (16, 5, 2);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (16, 9, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (17, 1, 6);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (17, 4, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (18, 2, 10);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (19, 0, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (19, 9, 1);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (20, 1, 4);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (20, 4, 10);
INSERT INTO grades (`student_id`, `course_id`, `grade`) VALUES (20, 6, 1);



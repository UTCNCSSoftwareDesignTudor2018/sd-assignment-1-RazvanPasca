#
# TABLE STRUCTURE FOR: courses
#

DROP TABLE IF EXISTS courses;

CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prof_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `teachers_courses_fk` (`prof_id`),
  CONSTRAINT `teachers_courses_fk` FOREIGN KEY (`prof_id`) REFERENCES `teachers` (`teacher_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (0, 'error', 40156, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (1, 'fugit', 544148132, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (2, 'corporis', 859735132, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (3, 'maxime', 18, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (4, 'rem', 926, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (5, 'minus', 20, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (6, 'qui', 976008, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (7, 'voluptatem', 926, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (8, 'omnis', 409084, 0);
INSERT INTO courses (`course_id`, `name`, `prof_id`, `exam_id`) VALUES (9, 'molestias', 544148132, 0);



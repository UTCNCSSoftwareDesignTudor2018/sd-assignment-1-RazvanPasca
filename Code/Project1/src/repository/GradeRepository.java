package repository;

import model.Grade;

import java.util.List;

public interface GradeRepository {
    List<Grade> findAll();

    List<Grade> findByStudentId(long id);

    List<Grade> findByCourseId(long id);

    boolean saveGrade(Grade grade);

    boolean updateGrade(Grade grade);
}

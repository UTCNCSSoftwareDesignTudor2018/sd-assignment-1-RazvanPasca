package repository;

import model.Grade;

import java.util.List;

public interface GradeRepository {
    List<Grade> findAll();

    List<Grade> findByStudentId(Long id);

    List<Grade> findByCourseId(Long id);

    boolean saveGrade(Grade grade);

    boolean updateGrade(Grade grade);
}

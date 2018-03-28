package repository;

import model.Grade;
import model.RegisterEntry;

import java.util.List;

public interface GradeRepository {
    List<Grade> findAll();

    List<RegisterEntry> findByStudentId(long id);

    List<RegisterEntry> findByTeacherId(long id);

    List<Grade> findByCourseId(long id);

    boolean saveGrade(Grade grade);

    boolean updateGrade(Grade grade);
}

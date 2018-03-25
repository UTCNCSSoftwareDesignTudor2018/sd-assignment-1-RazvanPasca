package repository;

import model.Exam;

import java.sql.Date;
import java.util.List;

public interface ExamRepository {
    List<Exam> findAll();

    List<Exam> findByDate(Date date);

    Exam findById(long id);

    boolean saveExam(Exam exam);
}

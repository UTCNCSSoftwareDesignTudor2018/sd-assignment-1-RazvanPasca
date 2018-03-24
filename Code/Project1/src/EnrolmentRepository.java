package repository;

import model.Enrolment;

import java.sql.Date;
import java.util.List;

public interface EnrolmentRepository {
    List<Enrolment> findAll();

    List<Enrolment> findByStudentId(Long id);

    List<Enrolment> findByCourseId(Long id);

    List<Enrolment> findByStatus(Boolean status);

    List<Enrolment> findByDate(Date date);

    boolean saveEnrolment(Enrolment enrolment);

    boolean updateEnrolment(Enrolment enrolment);
}

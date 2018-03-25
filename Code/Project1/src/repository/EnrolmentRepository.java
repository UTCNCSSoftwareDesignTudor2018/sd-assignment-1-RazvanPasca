package repository;

import model.Enrolment;

import java.sql.Date;
import java.util.List;

public interface EnrolmentRepository {
    List<Enrolment> findAll();

    List<Enrolment> findByStudentId(long id);

    List<Enrolment> findByCourseId(long id);

    List<Enrolment> findByStatus(Boolean status);

    List<Enrolment> findByDate(Date date);

    boolean saveEnrolment(Enrolment enrolment);

    boolean updateEnrolment(Enrolment enrolment);
}

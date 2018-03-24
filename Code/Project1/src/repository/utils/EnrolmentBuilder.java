package repository.utils;

import model.Enrolment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrolmentBuilder {
    public static Enrolment createEnrolment(ResultSet rs) throws SQLException {

        Enrolment enrolment = new Enrolment();
        enrolment.setCourseId(rs.getLong("course_id"));
        enrolment.setRequestDate(rs.getDate("request_date"));
        enrolment.setStatus(rs.getBoolean("status"));
        enrolment.setStudentId(rs.getLong("student_id"));
        return enrolment;
    }

    public static List<Enrolment> createEnrolments(ResultSet rs) throws SQLException {
        List<Enrolment> enrolments = new ArrayList<Enrolment>(100);
        while (rs.next()) {
            Enrolment enrolment = createEnrolment(rs);
            enrolments.add(enrolment);
        }
        return enrolments;
    }
}

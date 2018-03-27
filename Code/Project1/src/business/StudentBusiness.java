package business;

import model.*;

import java.util.List;
import java.util.Map;

public interface StudentBusiness {

    boolean login(String email, String password);

    boolean updateProfile(Student student);

    User viewProfile();

    Map<Course, Teacher> viewCourses();

    public List<RegisterEntry> viewGrades();

    boolean enroll(long courseId);
}

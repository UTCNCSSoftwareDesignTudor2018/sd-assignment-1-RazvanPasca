package model;

import java.sql.Date;

public class Exam {
    @Override
    public String toString() {
        return "Exam{" +
                "courseId=" + courseId +
                ", examDate=" + examDate +
                '}';
    }

    private long courseId;
    private Date examDate;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}

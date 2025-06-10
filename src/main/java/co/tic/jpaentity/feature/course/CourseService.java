package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import co.tic.jpaentity.feature.course.dto.CourseRequest;
import co.tic.jpaentity.feature.course.dto.CourseRespond;

import java.util.List;

public interface CourseService {

    void CreateCourse(CourseRequest courseRequest);
    void updateCourse(String uuid, CourseRequest courseRequest);
    List<CourseRespond> getAllCourses();
}

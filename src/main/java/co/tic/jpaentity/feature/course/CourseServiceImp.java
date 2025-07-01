package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import co.tic.jpaentity.domain.Teacher;
import co.tic.jpaentity.feature.course.dto.CourseRequest;
import co.tic.jpaentity.feature.course.dto.CourseRespond;
import co.tic.jpaentity.feature.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final TeacherRepository teacherRepository;

    @Override
    public void CreateCourse(CourseRequest courseRequest) {
        Course course = courseMapper.toCourse(courseRequest);

        Teacher teacher = teacherRepository.findByName(courseRequest.teacherName()).orElseThrow(
                () -> new NoSuchElementException("Teacher not found")
        );
        course.setUuid(UUID.randomUUID().toString());
        course.setName(courseRequest.name());
        course.setDescription(courseRequest.description());
        course.setTeacher(teacher);

        courseRepository.save(course);
    }



    @Override
    public void updateCourse(String uuid, CourseRequest courseRequest) {
        Course course=courseRepository.findByUuid(uuid);
        course.setName(courseRequest.name());
        course.setDescription(courseRequest.description());

        courseRepository.save(course);
    }

    @Override
    public List<CourseRespond> getAllCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses.stream()
                .map(courseMapper::toCourseResponse)
                .toList();
    }

    @Override
    public Page<Course> getAllCourse(int page, int size) {
        Page<Course> courses = courseRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size));
        return courses;
    }
}

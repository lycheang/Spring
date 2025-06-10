package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.domain.Course;
import co.tic.jpaentity.feature.course.dto.CourseRequest;
import co.tic.jpaentity.feature.course.dto.CourseRespond;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacherName", source = "teacher.name")
    CourseRespond toCourseResponse(Course course);

    Course toCourse(CourseRequest courseRequest);
}

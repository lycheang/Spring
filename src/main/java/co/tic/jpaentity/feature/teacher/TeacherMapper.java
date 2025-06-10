package co.tic.jpaentity.feature.teacher;

import co.tic.jpaentity.domain.Teacher;
import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import co.tic.jpaentity.feature.teacher.dto.TeacherRespond;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherRespond teacherToTeacherResponse(Teacher teacher);
    Teacher toTeacher(TeacherRequest teacherRequest);
}

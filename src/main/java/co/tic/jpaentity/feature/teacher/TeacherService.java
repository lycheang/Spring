package co.tic.jpaentity.feature.teacher;

import co.tic.jpaentity.domain.Teacher;
import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import co.tic.jpaentity.feature.teacher.dto.TeacherRespond;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherRequest teacherRequest);
    void updateTeacher( String uuid,TeacherRequest teacherRequest);
    void deleteTeacher(String uuid);
    TeacherRespond getTeacher(String uuid);
    List<TeacherRespond> getTeachers();
}

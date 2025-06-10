package co.tic.jpaentity.feature.teacher;

import co.tic.jpaentity.domain.Teacher;
import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import co.tic.jpaentity.feature.teacher.dto.TeacherRespond;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    @Override
    public void createTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = teacherMapper.toTeacher(teacherRequest);
        teacher.setUuid(UUID.randomUUID().toString());
        teacher.setName(teacherRequest.name());
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(String uuid, TeacherRequest teacherRequest) {
        Teacher teacher=teacherRepository.findByUuid(uuid).orElseThrow(()-> new NoSuchElementException("Teacher not found"));
        teacher.setName(teacherRequest.name());
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(String uuid) {
        Teacher teacher =teacherRepository.findByUuid(uuid).orElseThrow(()-> new NoSuchElementException("Teacher not found"));
        teacherRepository.delete(teacher);
    }

    @Override
    public TeacherRespond getTeacher(String uuid) {
        Teacher teacher= teacherRepository.findByUuid(uuid).orElseThrow(()-> new NoSuchElementException("Teacher not found"));
        return teacherMapper.teacherToTeacherResponse(teacher);
    }

    @Override
    public List<TeacherRespond> getTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacherMapper::teacherToTeacherResponse).collect(Collectors.toList());
    }
}

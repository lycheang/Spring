package co.tic.jpaentity.feature.teacher;

import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import co.tic.jpaentity.feature.teacher.dto.TeacherRespond;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List<TeacherRespond>> getAllTeachers() {

        return ResponseEntity.ok(teacherService.getTeachers());
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<TeacherRespond> getTeacherByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(teacherService.getTeacher(uuid));
    }
    @PostMapping
    public ResponseEntity<String>createTeacher( @RequestBody TeacherRequest teacherRequest) {
        teacherService.createTeacher(teacherRequest);
        return ResponseEntity.ok("Teacher created");
    }
    @PatchMapping("/{uuid}")
    public ResponseEntity<String> updateTeacher(@PathVariable String uuid, @RequestBody TeacherRequest teacherRequest) {
        teacherService.updateTeacher(uuid, teacherRequest);
        return ResponseEntity.ok("Teacher updated");
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String uuid) {
        teacherService.deleteTeacher(uuid);
        return ResponseEntity.ok("Teacher deleted");
    }
}

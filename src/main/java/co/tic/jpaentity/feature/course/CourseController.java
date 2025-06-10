package co.tic.jpaentity.feature.course;

import co.tic.jpaentity.feature.course.dto.CourseRequest;
import co.tic.jpaentity.feature.course.dto.CourseRespond;
import co.tic.jpaentity.feature.teacher.dto.TeacherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @GetMapping
    public ResponseEntity<List<CourseRespond>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.CreateCourse(courseRequest);
        return ResponseEntity.ok("Course created");
    }
    @PatchMapping("/{uuid}")
    public ResponseEntity<String> updateCourse(@PathVariable String uuid, @RequestBody CourseRequest courseRequest) {
        courseService.updateCourse(uuid, courseRequest);
        return ResponseEntity.ok("Course updated");
    }
}
